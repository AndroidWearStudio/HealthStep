package applewatch.apple_watch;

import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;

/**
 * Created by KOUHO on 2014/10/28.
 */
public class char_Nekoko extends CharacterSprite {

    public char_Nekoko(GameView gv, int posX, int posY, float scale, boolean anim_flg){
        super( gv, posX, posY, R.drawable.char103_nekoko1, scale, anim_flg);
        m_CharacterKind = CharacterKind.KIND_GIRL;
        m_iCharacterID = menu_Character.CHAR_NEKOKO_ID;

        if(anim_flg){
            addImg( R.drawable.char103_nekoko4 );   // closing eyes in between animation
            addImg( R.drawable.char103_nekoko2 );   // closed eye
            addImg( R.drawable.char103_nekoko3 );   // speaking
            addImg( R.drawable.char103_nekoko5 );   // speaking in between animation
        }

        // set Strings
        m_StrHello = "おはよう！";
        m_StrWhether = "いい天気だね！";
        m_StrYell = "今日も元気にいこう。";
    }
}
