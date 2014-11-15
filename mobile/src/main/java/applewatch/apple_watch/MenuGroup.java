package applewatch.apple_watch;

import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.util.Log;
import android.view.MotionEvent;

/**
 * Created by KOUHO on 2014/11/13.
 */
public class MenuGroup {
    // image resources
    private BitmapDrawable m_ButtonBase;

    private btn_Ranking m_btn_Ranking;
    private btn_Gallery m_btn_Gallery;
    private btn_Gacha   m_btn_Gacha;
    private btn_MyPage  m_btn_MyPage;

    private boolean m_bMove;
    private GameView m_GameView;

    // constract
    public MenuGroup(GameView gv){

        m_GameView = gv;

        // button background resource
        m_ButtonBase = (BitmapDrawable)gv.getResources().getDrawable(R.drawable.button_base);

        int w = gv.getGameWidth();
        int h = gv.getGameHeight();

        m_btn_MyPage = new btn_MyPage(gv, 0, h-(w>>4)*3);
        m_btn_Gallery = new btn_Gallery(gv, w>>2, h-(w>>4)*3);
        m_btn_Gacha = new btn_Gacha(gv, (w>>2)*2,  h-(w>>4)*3);
        m_btn_Ranking = new btn_Ranking(gv, (w>>2)*3, h-(w>>4)*3);
        reset();
    }

    public void update(){
    }

    public void    reset(){
        m_bMove = false;
//        Log.d("TEST", "New MenuGroup Class");
    }

    // go to next scene
    public boolean move(){
        return m_bMove;
    }

    // draw
    public void    draw(Canvas c){
        int w = m_GameView.getWidth();
        int h = m_GameView.getHeight();

        if (m_ButtonBase != null) {
            m_ButtonBase.setBounds(0, h - (w >> 4) * 3, w, h);
            m_ButtonBase.draw(c);
        }
        if (m_btn_MyPage != null) {
            m_btn_MyPage.draw(c);
        }
        if (m_btn_Ranking != null) {
            m_btn_Ranking.draw(c);
        }
        if (m_btn_Gallery != null) {
            m_btn_Gallery.draw(c);
        }
        if (m_btn_Gacha != null) {
            m_btn_Gacha.draw(c);
        }
    }

    // touch event
    public void    touch(MotionEvent event){
        if(m_btn_MyPage != null){
            m_btn_MyPage.touch(event);
            if(m_btn_MyPage.isTouched()){
                new scene_Menu(m_GameView, 21);
                m_bMove = true;
            }
        }
        if(m_btn_Ranking != null){
            m_btn_Ranking.touch(event);
            if(m_btn_Ranking.isTouched()){
                new scene_Ranking(m_GameView, 22);
                m_bMove = true;
            }
        }
        if(m_btn_Gallery != null){
            m_btn_Gallery.touch(event);
            if(m_btn_Gallery.isTouched()){
                new scene_Gallery(m_GameView, 23);
                m_bMove = true;
            }
        }
        if(m_btn_Gacha != null){
            m_btn_Gacha.touch(event);
            if(m_btn_Gacha.isTouched()){
                new scene_Gacha(m_GameView, 24);
                m_bMove = true;
            }
        }
    }
}
