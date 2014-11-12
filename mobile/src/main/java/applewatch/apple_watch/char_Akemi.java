package applewatch.apple_watch;

import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;

/**
 * Created by KOUHO on 2014/10/16.
 */
public class char_Akemi implements CharacterBase {
    private final BitmapDrawable[] m_CharResource;
    private BitmapDrawable m_CharNowImage;

    private int	m_iCharWidth;
    private int 	m_iCharHeight;

    private int m_iPosX;
    private int m_iPosY;

    // for animation
    private int m_iTimer;
    private int m_iIndex;
    private boolean m_bAnimFlg;

    private CharacterKind m_CharacterKind;

    public char_Akemi(GameView gv, int posX, int posY, float scale, boolean anim_flg){
        m_CharacterKind = CharacterKind.KIND_GIRL;
        m_iIndex = 0;
        m_iTimer = 0;

        m_iPosX = posX;
        m_iPosY = posY;
        m_bAnimFlg = anim_flg;

        m_CharResource = new BitmapDrawable[4];
        m_CharResource[0] =(BitmapDrawable)gv.getResources().getDrawable(R.drawable.char100_akemi1);
        m_CharResource[1] =(BitmapDrawable)gv.getResources().getDrawable(R.drawable.char100_akemi4);
        m_CharResource[2] =(BitmapDrawable)gv.getResources().getDrawable(R.drawable.char100_akemi2);
        m_CharResource[3] =(BitmapDrawable)gv.getResources().getDrawable(R.drawable.char100_akemi3);
        m_CharNowImage = m_CharResource[0];

        //　image size
        m_iCharWidth  = (int)((m_CharResource[0].getIntrinsicWidth()) * scale);
        m_iCharHeight = (int)((m_CharResource[0].getIntrinsicHeight()) * scale);

        //　image resize
        m_iCharWidth 	 *= gv.getGamePerWidth();
        m_iCharHeight   *= gv.getGamePerHeight();

        m_iPosX *= gv.getGamePerWidth();
        m_iPosY *= gv.getGamePerHeight();
    }

    @Override
    public void doAnim(){
        if(m_bAnimFlg){
            m_iTimer++;
            // this animation code might be inefficient, but use this way provisionally
            if(m_iTimer >= 30) {
                m_iIndex = 1;
                m_CharNowImage = m_CharResource[m_iIndex];
                if(m_iTimer >= 31){
                    m_iIndex = 2;
                    m_CharNowImage = m_CharResource[m_iIndex];
                }
                if(m_iTimer >= 32){
                    m_iIndex = 1;
                    m_CharNowImage = m_CharResource[m_iIndex];
                }
                if(m_iTimer >= 33){
                    m_iIndex = 2;
                    m_CharNowImage = m_CharResource[m_iIndex];
                }
                if(m_iTimer >= 34){
                    m_iIndex = 1;
                    m_CharNowImage = m_CharResource[m_iIndex];
                }
                if(m_iTimer >= 35){
                    m_iIndex = 0;
                    m_CharNowImage = m_CharResource[m_iIndex];
                    m_iTimer = 0;
                }
            }
        }
    }

    @Override
    public void draw(Canvas c) {
        if (m_CharNowImage != null){
            doAnim();
            m_CharNowImage.setBounds(m_iPosX, m_iPosY, m_iPosX+m_iCharWidth, m_iPosY+m_iCharHeight);
            m_CharNowImage.draw(c);
        }
    }

    @Override
    public int characterID(){
        return menu_Character.CHAR_AKEMI_ID;
    }

}