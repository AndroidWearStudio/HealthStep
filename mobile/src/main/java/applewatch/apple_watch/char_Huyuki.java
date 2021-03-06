package applewatch.apple_watch;

import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;

/**
 * Created by KOUHO on 2014/10/28.
 */
public class char_Huyuki extends CharacterSprite {

    public char_Huyuki(GameView gv, int posX, int posY, float scale, boolean anim_flg) {
        super( gv, posX, posY, R.drawable.char206_huyuki1, scale, anim_flg);
        m_CharacterKind = CharacterKind.KIND_BOY;
        m_iCharacterID = menu_Character.CHAR_HUYUKI_ID;

        if(anim_flg){
            addImg( R.drawable.char206_huyuki4 );    // closing eyes in between animation
            addImg( R.drawable.char206_huyuki2 );    // closed eye
            addImg( R.drawable.char206_huyuki3 );    // speaking
            addImg( R.drawable.char206_huyuki5 );    // speaking in between animation
        }

        // set Strings
        m_StrHello = "おはよう！";
        m_StrWhether = "いい天気だな！";
        m_StrYell = "今日も元気にいこうか。";

        // set voices
        m_CharVoiceHello = new GameSound( SoundKind.SOUND_VOICE, m_GameView, R.raw.huyuki_hello_yokkorasyo);
        m_CharVoiceWhether = new GameSound( SoundKind.SOUND_VOICE, m_GameView, R.raw.huyuki_whether_yokkorasyo);
        m_CharVoiceYell = new GameSound( SoundKind.SOUND_VOICE, m_GameView, R.raw.huyuki_yell_yokkorasyo);

        //set wait
        m_iHelloWait = 0;
        m_iWhetherWait = 15;
        m_iYellWait =10;
    }
}
