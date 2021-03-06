package applewatch.apple_watch;

import android.app.AlertDialog;
import android.app.Notification;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.speech.RecognizerIntent;
import android.text.InputType;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.Spinner;
import android.widget.Toast;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

/**
 * Created by KOUHO on 2014/11/16.
 */
public class scene_PlayerInput extends Task{

    private boolean m_bMove;
    private GameView m_GameView;
    private menu_Character m_MsgCaracter;

    // game sprites
    private GameSprite m_OK;
    private GameSprite m_Balloon;

    // game text
    private GameText m_InputMsg;

    // message strings
    private String m_StrMsg = "はじめに君の名前と、君が住む都道府県を教えて欲しいコン。名前と都道府県が入力出来たら、ＯＫを押して欲しいコン。";

    // define sprite position
    private final int BALLON_X = 150;
    private final int BALLON_Y = 85;
    private final int OK_X = 450;
    private final int OK_Y = 450;

    // define text pos
    private final int IN_MSG_X = 200;
    private final int IN_MSG_Y  = 130;
    private final int CH_X = -70;
    private final int CH_Y = -70;

    // define text area width
    private final int IN_MSG_WIDTH = 400;
    private final int IN_MSG_LINE_HEIGHT = 10;

    // relation to Edit Text
    private EditText m_PlayerEdit;

    // relation to Spinner
    private Spinner m_PrefectureSpinner;

    // game sound
//    private GameSound m_SeYes;

    // prefectures list
    private CharSequence[] m_PreList={
            "北海道","青森県","岩手県",
            "宮城県","秋田県","山形県",
            "福島県","茨城県","栃木県",
            "群馬県","埼玉県","千葉県",
            "東京都","神奈川県","新潟県",
            "富山県","石川県","福井県",
            "山梨県","長野県","岐阜県",
            "静岡県","愛知県","三重県",
            "滋賀県","京都府","大阪府",
            "兵庫県","奈良県","和歌山県",
            "鳥取県","島根県","岡山県",
            "広島県","山口県","徳島県",
            "香川県","愛媛県","高知県",
            "福岡県","佐賀県","長崎県",
            "熊本県","大分県","宮崎県",
            "鹿児島県","沖縄県"

    };

    //--------------------------
    // test sound recognization
    //--------------------------
    private static final int REQUEST_CODE = 100;

    // constract
    public scene_PlayerInput(GameView gv, int prio){
        super(prio);
        m_GameView = gv;
        m_OK = new GameSprite(gv, OK_X, OK_Y, R.drawable.ok);
        m_Balloon = new GameSprite( gv, BALLON_X , BALLON_Y , R.drawable.hukidashi_yoko );
        m_InputMsg = new GameText(gv,m_StrMsg.toCharArray(),IN_MSG_X,IN_MSG_Y);
        m_MsgCaracter = new menu_Character(gv,CH_X,CH_Y,menu_Character.CHAR_KONSUKE_ID);

        PlayerData.getInstance().setPlayerName("");
        //　Draw TextView over SurfaceView
        m_PlayerEdit = new EditText(gv.getRootView().getContext());
        FrameLayout.LayoutParams pe_params = new FrameLayout.LayoutParams( ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT );  // important!
        pe_params.topMargin = (int) (gv.getHeight() * 0.3);
        pe_params.leftMargin = (int) (gv.getWidth() * 0.1);
        m_PlayerEdit.setLayoutParams(pe_params);
        m_PlayerEdit.setHint("ここに名前を入力して下さい");
        m_PlayerEdit.setMaxEms(32);     // max chars
        m_PlayerEdit.setWidth((int) (gv.getWidth() * 0.8));
        m_PlayerEdit.setMaxHeight(80);
        m_PlayerEdit.setTextColor(Color.BLACK);
        m_PlayerEdit.setBackgroundColor(Color.WHITE);
        m_PlayerEdit.setInputType(InputType.TYPE_CLASS_TEXT);   // neglect enter key
        m_PlayerEdit.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int key_code, KeyEvent keyEvent) {
                if( keyEvent.getAction() == KeyEvent.ACTION_DOWN ){
                  // enter key
                  if( key_code == KeyEvent.KEYCODE_ENTER ){
                      m_GameView.playSE(R.raw.se_yes );;
                      hideKeyBoard();
                  }
                }
                return false;
            }
        });
        MobileActivity ma = (MobileActivity)gv.getContext();
        ma.getFrame().addView(m_PlayerEdit);

        // use spinner in select box
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(gv.getContext(),android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(gv.getContext(),
                R.array.prefecture_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        m_PrefectureSpinner = new Spinner(gv.getContext());

        // set adapter
        m_PrefectureSpinner.setAdapter(adapter);
        // call back listener when spinner on click
        m_PrefectureSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                Spinner spinner = (Spinner) parent;
                // get selecting item
                String item = (String) spinner.getSelectedItem();
                if( position != 0 ) {
                    PlayerData.getInstance().setPrefecture(item);
                }else{
                    m_GameView.playSE(R.raw.se_yes );
                    PlayerData.getInstance().setPrefecture("");
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        });
        FrameLayout.LayoutParams ps_params = new FrameLayout.LayoutParams( ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT );
        ps_params.topMargin = (int) (gv.getHeight() * 0.4);
        ps_params.leftMargin = (int) (gv.getWidth() * 0.05);
        m_PrefectureSpinner.setLayoutParams(ps_params);
        ma.getFrame().addView(m_PrefectureSpinner);
        reset();
    }

    @Override
    public void update(){
        if( m_OK != null ){
//            m_OK.update();
            // if m_PlayerEdit isn't focused, hide window
        }
        if( m_InputMsg != null){
            m_InputMsg.update();
        }
        if( m_bMove ){
            new scene_Menu( m_GameView, 25);
        }
    }

    @Override
    public void    reset(){
        m_bMove = false;

        setTouchable( true );
//        PlayerData.getInstance().setUnlockCharacter(0,true);
//        PlayerData.getInstance().setSelectCharacter( menu_Character.CHAR_AKEMI_ID );
        Log.d("TEST", "New PlayerInput Class");
    }

    @Override
    // go to next scene
    public boolean move(){
        return m_bMove;
    }

    @Override
    // draw
    public void    draw(Canvas c){
        if( m_OK != null ){
            m_OK.draw(c);
        }
        if( m_MsgCaracter != null ){
            m_MsgCaracter.draw(c);
        }
        if( m_Balloon != null ){
            m_Balloon.draw(c);
        }
        if( m_InputMsg != null ){
            m_InputMsg.multiline_draw(c,IN_MSG_WIDTH,IN_MSG_LINE_HEIGHT);
        }
    }

    public void onButtonClick(){
        /*
        // create intent
        try{
            Intent intent = new Intent(
                    RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
            intent.putExtra(
                    RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                    RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
            intent.putExtra(
                    RecognizerIntent.EXTRA_PROMPT,
                    "VoiceRecognitionStart");



            // result of intent
            //startActivityForResult(intent, REQUEST_CODE);
        }catch( ActivityNotFoundException e){
            // if activity doesn't install
            Toast.makeText( m_GameView.getContext(), "AcivityNotFoundException",Toast.LENGTH_LONG).show();
        }
        */

    }

    @Override
    // touch event
    public void    touch(MotionEvent event){
        if( getTouchable() ) {
            if( m_OK != null ){
                m_OK.touch(event);
                if( m_OK.getTouch() ){
                    m_GameView.playSE(R.raw.se_yes );
                    String name = m_PlayerEdit.getText().toString().trim();
                    PlayerData.getInstance().setPlayerName( name );
                    onButtonClick();
                    if( checkInput() ) {
                        m_bMove = true;
                        // delete input space
                        MobileActivity ma = (MobileActivity) m_GameView.getContext();
                        ma.getFrame().removeView(m_PlayerEdit);
                        ma.getFrame().removeView(m_PrefectureSpinner);
                        hideKeyBoard();
                        new scene_PartnerSelect(m_GameView, 24);
                    }
                }
            }
            /*
            if( m_OK != null ) {
                m_OK.touch(event);
                if (m_OK.getTouch()) {
                    showList();
                }
            }
            */
        }
    }

    // hide keyboard
    public void hideKeyBoard(){
        // hide keyboard
        InputMethodManager imm = (InputMethodManager)m_GameView.getContext().getSystemService( m_GameView.getContext().INPUT_METHOD_SERVICE );
        imm.hideSoftInputFromWindow( m_PlayerEdit.getWindowToken() , InputMethodManager.HIDE_NOT_ALWAYS );
    }

    // item listener
    DialogInterface.OnClickListener mItemListener = new DialogInterface.OnClickListener() {
        public void onClick(DialogInterface dialog, int which) {
            PlayerData.getInstance().setPrefecture( m_PreList[which].toString() );
//            Log.d("test",String.valueOf(get));
        }
    };

    // show list dialog
    public void showList(){
        AlertDialog.Builder builder = new AlertDialog.Builder(m_GameView.getContext());
        builder.setTitle("都道府県");
        builder.setItems(m_PreList, mItemListener );
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    // check input
    public boolean checkInput(){
        if( PlayerData.getInstance().getPlayerName().isEmpty() ){
            m_InputMsg.setText("名前が入力されていないコン。確認して欲しいコン。");
            return false;
        }else if( PlayerData.getInstance().getPrefecture() == ""){
            m_InputMsg.setText("都道府県が選択されていないコン。確認して欲しいコン。");
            return false;
        }else{
            return true;
        }
    }
}