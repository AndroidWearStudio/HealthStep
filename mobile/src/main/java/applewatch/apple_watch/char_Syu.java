package applewatch.apple_watch;

import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;

/**
 * Created by KOUHO on 2014/10/28.
 */
public class char_Syu extends CharacterSprite {

    public char_Syu(GameView gv, int posX, int posY, float scale, boolean anim_flg){
        super( gv, posX, posY, R.drawable.char202_syu1, scale, anim_flg);
        m_CharacterKind = CharacterKind.KIND_BOY;
        m_iCharacterID = menu_Character.CHAR_SYU_ID;

        if(anim_flg){
            addImg( R.drawable.char202_syu4 );   // closing eyes in between animation
            addImg( R.drawable.char202_syu2 );   // closed eye
            addImg( R.drawable.char202_syu3 );   // speaking
            addImg( R.drawable.char202_syu5 );   // speaking in between animation
        }

        // set Strings
        m_StrHello = "おはよう！";
        m_StrWhether = "いい天気だな！";
        m_StrYell = "今日も元気にいこうか。";
    }
}
