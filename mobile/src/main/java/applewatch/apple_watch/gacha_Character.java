package applewatch.apple_watch;

import android.graphics.Canvas;

/**
 * Created by KOUHO on 2014/11/14.
 */
public class gacha_Character {
    // selecting char ID
    private int CharacterID;
    private GameView m_GameView;
    private CharacterSprite m_Character;

    private boolean m_bFlg;

    // define zoom center position
    private final int ZOOM_CX = 350;
    private final int ZOOM_CY = 500;

    // define zoom animation
    private final double ZOOM_IN_SPEED = 0.2;
    private final double ZOOM_IN_MAX = 2.0;

    // construct
    gacha_Character(GameView gv, scene_Gacha sg, int posX, int posY){
        m_GameView = gv;
        m_bFlg = false;

        switch(sg.getGachaCharacter()){
            // girls(100-199)
            case 0:
                if(!m_bFlg) {
                    m_Character = new char_Akemi(gv, posX, posY, menu_Character.SCALE_NO , menu_Character.ANIM_OK);
                    m_bFlg = true;
                }
                break;

            case 1:
                if(!m_bFlg) {
                    m_Character = new char_Urara(gv, posX, posY, menu_Character.SCALE_NO ,menu_Character.ANIM_OK);
                    m_bFlg = true;
                }
                break;

            case 2:
                if(!m_bFlg) {
                    m_Character = new char_Sizuku(gv, posX, posY, menu_Character.SCALE_NO, menu_Character.ANIM_OK);
                    m_bFlg = true;
                }
                break;

            case 3:
                if(!m_bFlg) {
                    m_Character = new char_Nekoko(gv, posX, posY, menu_Character.SCALE_NO, menu_Character.ANIM_OK);
                    m_bFlg = true;
                }
                break;

            case 4:
                if(!m_bFlg) {
                    m_Character = new char_Miki(gv, posX, posY, menu_Character.SCALE_NO, menu_Character.ANIM_OK);
                    m_bFlg = true;
                }
                break;

            case 5:
                if(!m_bFlg) {
                    m_Character = new char_Momoka(gv, posX, posY, menu_Character.SCALE_NO,menu_Character. ANIM_OK);
                    m_bFlg = true;
                }
                break;

            case 6:
                if(!m_bFlg) {
                    m_Character = new char_Rimika(gv, posX, posY, menu_Character.SCALE_NO, menu_Character.ANIM_OK);
                    m_bFlg = true;
                }
                break;

            case 7:
                if(!m_bFlg) {
                    m_Character = new char_Rin(gv, posX, posY, menu_Character.SCALE_NO, menu_Character.ANIM_OK);
                    m_bFlg = true;
                }
                break;

            // boys(200-299)
            case 8:
                if(!m_bFlg) {
                    m_Character = new char_Yukito(gv, posX, posY, menu_Character.SCALE_NO, menu_Character.ANIM_OK);
                    m_bFlg = true;
                }
                break;

            case 9:
                if(!m_bFlg) {
                    m_Character = new char_Kaito(gv, posX, posY, menu_Character.SCALE_NO, menu_Character.ANIM_OK);
                    m_bFlg = true;
                }
                break;

            case 10:
                if(!m_bFlg) {
                    m_Character = new char_Syu(gv, posX, posY, menu_Character.SCALE_NO, menu_Character.ANIM_OK);
                    m_bFlg = true;
                }
                break;

            case 11:
                if(!m_bFlg) {
                    m_Character = new char_Shouta(gv, posX, posY, menu_Character.SCALE_NO, menu_Character.ANIM_OK);
                    m_bFlg = true;
                }
                break;

            case 12:
                if(!m_bFlg) {
                    m_Character = new char_Banjyo(gv, posX, posY, menu_Character.SCALE_NO, menu_Character.ANIM_OK);
                    m_bFlg = true;
                }
                break;

            case 13:
                if(!m_bFlg) {
                    m_Character = new char_Hibiki(gv, posX, posY, menu_Character.SCALE_NO, menu_Character.ANIM_OK);
                    m_bFlg = true;
                }
                break;

            case 14:
                if(!m_bFlg) {
                    m_Character = new char_Huyuki(gv, posX, posY, menu_Character.SCALE_NO, menu_Character.ANIM_OK);
                    m_bFlg = true;
                }
                break;

            case 15:
                if(!m_bFlg) {
                    m_Character = new char_Rokurou(gv, posX, posY, menu_Character.SCALE_NO, menu_Character.ANIM_OK);
                    m_bFlg = true;
                }
                break;

            // beasts(300-399)
            case 16:
                if(!m_bFlg) {
                    m_Character = new char_Konsuke(gv, posX, posY, menu_Character.SCALE_NO, menu_Character.ANIM_OK) ;
                    m_bFlg = true;
                }
                break;

            case 17:
                if(!m_bFlg) {
                    m_Character = new char_Donta(gv, posX, posY, menu_Character.SCALE_NO, menu_Character.ANIM_OK) ;
                    m_bFlg = true;
                }
                break;

            case 18:
                if(!m_bFlg) {
                    m_Character = new char_Minmi(gv, posX, posY, menu_Character.SCALE_NO, menu_Character.ANIM_OK) ;
                    m_bFlg = true;
                }
                break;

            case 19:
                if(!m_bFlg) {
                    m_Character = new char_Ryu(gv, posX, posY, menu_Character.SCALE_NO, menu_Character.ANIM_OK) ;
                    m_bFlg = true;
                }
                break;

            default:
                if(!m_bFlg) {
                    m_Character = new char_Unknown(gv, posX, posY, menu_Character.SCALE_NO, menu_Character.ANIM_OK) ;
                    m_bFlg = true;
                }
                break;
        }
        m_Character.setScaleX(0);
        m_Character.setScaleY(0);
    }

    public void update(){
        if( m_Character != null ){
            m_Character.update();
            m_Character.zoom( ZOOM_IN_SPEED , ZOOM_IN_MAX );
        }
    }

    // draw
    public void draw(Canvas c){
        if( m_Character != null ){
            m_Character.draw( c, ZOOM_CX, ZOOM_CY );
        }
    }
}