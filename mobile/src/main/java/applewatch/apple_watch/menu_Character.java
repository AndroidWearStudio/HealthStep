package applewatch.apple_watch;

import android.graphics.Canvas;
import android.view.MotionEvent;

/**
 * Created by KOUHO on 2014/10/15.
 */

public class menu_Character{
    // selecting char ID
    public int CharacterID;

    // define scale value
    static final float SCALE_NO = 1.5f;
    static final float SCALE_BUTTON = 0.5f;
    static final float SCALE_INBUTTON = 0.35f;
    static final float SCALE_DETAIL = 1.1f;

    // define animation flag
    static boolean ANIM_OK = true;
    static boolean ANIM_NO = false;

    // define character ID
    static final int CHAR_UNKNOWN_ID = 999;
    // girls
    static final int CHAR_AKEMI_ID = 100;
    static final int CHAR_URARA_ID = 101;
    static final int CHAR_SIZUKU_ID = 102;
    static final int CHAR_NEKOKO_ID = 103;
    static final int CHAR_MIKI_ID = 104;
    static final int CHAR_MOMOKA_ID = 105;
    static final int CHAR_RIMIKA_ID = 106;
    static final int CHAR_RIN_ID = 107;
    // boys
    static final int CHAR_YUKITO_ID = 200;
    static final int CHAR_KAITO_ID = 201;
    static final int CHAR_SYU_ID = 202;
    static final int CHAR_SHOUTA_ID = 203;
    static final int CHAR_BANJYO_ID = 204;
    static final int CHAR_HIBIKI_ID = 205;
    static final int CHAR_HUYUKI_ID = 206;
    static final int CHAR_ROKUROU_ID = 207;
    // beasts
    static final int CHAR_KONSUKE_ID = 300;
    static final int CHAR_DONTA_ID = 301;
    static final int CHAR_MINMI_ID = 302;
    static final int CHAR_RYU_ID = 303;

    private CharacterSprite m_Character;

    private boolean m_bFlg;

    // constract
    menu_Character(GameView gv, int posX, int posY){
        CharacterID = PlayerData.getInstance().getSelectCharacter();
        m_bFlg = false;
        switch(CharacterID){
            // girls(100-199)
            case CHAR_AKEMI_ID:
                if(!m_bFlg) {
                    m_Character = new char_Akemi(gv, posX, posY, SCALE_NO , ANIM_OK);
                    m_bFlg = true;
                }
                break;

            case CHAR_URARA_ID:
                if(!m_bFlg) {
                    m_Character = new char_Urara(gv, posX, posY, SCALE_NO ,ANIM_OK);
                    m_bFlg = true;
                }
                break;

            case CHAR_SIZUKU_ID:
                if(!m_bFlg) {
                    m_Character = new char_Sizuku(gv, posX, posY, SCALE_NO, ANIM_OK);
                    m_bFlg = true;
                }
                break;

            case CHAR_NEKOKO_ID:
                if(!m_bFlg) {
                    m_Character = new char_Nekoko(gv, posX, posY, SCALE_NO, ANIM_OK);
                    m_bFlg = true;
                }
                break;

            case CHAR_MIKI_ID:
                if(!m_bFlg) {
                    m_Character = new char_Miki(gv, posX, posY, SCALE_NO, ANIM_OK);
                    m_bFlg = true;
                }
                break;

            case CHAR_MOMOKA_ID:
                if(!m_bFlg) {
                    m_Character = new char_Momoka(gv, posX, posY, SCALE_NO, ANIM_OK);
                    m_bFlg = true;
                }
                break;

            case CHAR_RIMIKA_ID:
                if(!m_bFlg) {
                    m_Character = new char_Rimika(gv, posX, posY, SCALE_NO, ANIM_OK);
                    m_bFlg = true;
                }
                break;

            case CHAR_RIN_ID:
                if(!m_bFlg) {
                    m_Character = new char_Rin(gv, posX, posY, SCALE_NO, ANIM_OK);
                    m_bFlg = true;
                }
                break;

            // boys(200-299)
            case CHAR_YUKITO_ID:
                if(!m_bFlg) {
                    m_Character = new char_Yukito(gv, posX, posY, SCALE_NO, ANIM_OK);
                    m_bFlg = true;
                }
                break;

            case CHAR_KAITO_ID:
                if(!m_bFlg) {
                    m_Character = new char_Kaito(gv, posX, posY, SCALE_NO, ANIM_OK);
                    m_bFlg = true;
                }
                break;

            case CHAR_SYU_ID:
                if(!m_bFlg) {
                    m_Character = new char_Syu(gv, posX, posY, SCALE_NO, ANIM_OK);
                    m_bFlg = true;
                }
                break;

            case CHAR_SHOUTA_ID:
                if(!m_bFlg) {
                    m_Character = new char_Shouta(gv, posX, posY, SCALE_NO, ANIM_OK);
                    m_bFlg = true;
                }
                break;

            case CHAR_BANJYO_ID:
                if(!m_bFlg) {
                    m_Character = new char_Banjyo(gv, posX, posY, SCALE_NO, ANIM_OK);
                    m_bFlg = true;
                }
                break;

            case CHAR_HIBIKI_ID:
                if(!m_bFlg) {
                    m_Character = new char_Hibiki(gv, posX, posY, SCALE_NO, ANIM_OK);
                    m_bFlg = true;
                }
                break;

            case CHAR_HUYUKI_ID:
                if(!m_bFlg) {
                    m_Character = new char_Huyuki(gv, posX, posY, SCALE_NO, ANIM_OK);
                    m_bFlg = true;
                }
                break;

            case CHAR_ROKUROU_ID:
                if(!m_bFlg) {
                    m_Character = new char_Rokurou(gv, posX, posY, SCALE_NO, ANIM_OK);
                    m_bFlg = true;
                }
                break;

            // beasts(300-399)
            case CHAR_KONSUKE_ID:
                if(!m_bFlg) {
                    m_Character = new char_Konsuke(gv, posX, posY, SCALE_NO, ANIM_OK) ;
                    m_bFlg = true;
                }
                break;

            case CHAR_DONTA_ID:
                if(!m_bFlg) {
                    m_Character = new char_Donta(gv, posX, posY, SCALE_NO, ANIM_OK) ;
                    m_bFlg = true;
                }
                break;

            case CHAR_MINMI_ID:
                if(!m_bFlg) {
                    m_Character = new char_Minmi(gv, posX, posY, SCALE_NO, ANIM_OK) ;
                    m_bFlg = true;
                }
                break;

            case CHAR_RYU_ID:
                if(!m_bFlg) {
                    m_Character = new char_Ryu(gv, posX, posY, SCALE_NO, ANIM_OK) ;
                    m_bFlg = true;
                }
                break;
        }
    }

    // constructor using in scene_Detail
    menu_Character(GameView gv, int posX, int posY, int character_id ){
        CharacterID = character_id;
        m_bFlg = false;
        switch(CharacterID){
            // girls(100-199)
            case CHAR_AKEMI_ID:
                if(!m_bFlg) {
                    m_Character = new char_Akemi(gv, posX, posY, SCALE_DETAIL , ANIM_OK);
                    m_bFlg = true;
                }
                break;

            case CHAR_URARA_ID:
                if(!m_bFlg) {
                    m_Character = new char_Urara(gv, posX, posY, SCALE_DETAIL ,ANIM_OK);
                    m_bFlg = true;
                }
                break;

            case CHAR_SIZUKU_ID:
                if(!m_bFlg) {
                    m_Character = new char_Sizuku(gv, posX, posY, SCALE_DETAIL, ANIM_OK);
                    m_bFlg = true;
                }
                break;

            case CHAR_NEKOKO_ID:
                if(!m_bFlg) {
                    m_Character = new char_Nekoko(gv, posX, posY, SCALE_DETAIL, ANIM_OK);
                    m_bFlg = true;
                }
                break;

            case CHAR_MIKI_ID:
                if(!m_bFlg) {
                    m_Character = new char_Miki(gv, posX, posY, SCALE_DETAIL, ANIM_OK);
                    m_bFlg = true;
                }
                break;

            case CHAR_MOMOKA_ID:
                if(!m_bFlg) {
                    m_Character = new char_Momoka(gv, posX, posY, SCALE_DETAIL, ANIM_OK);
                    m_bFlg = true;
                }
                break;

            case CHAR_RIMIKA_ID:
                if(!m_bFlg) {
                    m_Character = new char_Rimika(gv, posX, posY, SCALE_DETAIL, ANIM_OK);
                    m_bFlg = true;
                }
                break;

            case CHAR_RIN_ID:
                if(!m_bFlg) {
                    m_Character = new char_Rin(gv, posX, posY, SCALE_DETAIL, ANIM_OK);
                    m_bFlg = true;
                }
                break;

            // boys(200-299)
            case CHAR_YUKITO_ID:
                if(!m_bFlg) {
                    m_Character = new char_Yukito(gv, posX, posY, SCALE_DETAIL, ANIM_OK);
                    m_bFlg = true;
                }
                break;

            case CHAR_KAITO_ID:
                if(!m_bFlg) {
                    m_Character = new char_Kaito(gv, posX, posY, SCALE_NO, ANIM_OK);
                    m_bFlg = true;
                }
                break;

            case CHAR_SYU_ID:
                if(!m_bFlg) {
                    m_Character = new char_Syu(gv, posX, posY, SCALE_DETAIL, ANIM_OK);
                    m_bFlg = true;
                }
                break;

            case CHAR_SHOUTA_ID:
                if(!m_bFlg) {
                    m_Character = new char_Shouta(gv, posX, posY, SCALE_DETAIL, ANIM_OK);
                    m_bFlg = true;
                }
                break;

            case CHAR_BANJYO_ID:
                if(!m_bFlg) {
                    m_Character = new char_Banjyo(gv, posX, posY, SCALE_DETAIL, ANIM_OK);
                    m_bFlg = true;
                }
                break;

            case CHAR_HIBIKI_ID:
                if(!m_bFlg) {
                    m_Character = new char_Hibiki(gv, posX, posY, SCALE_DETAIL, ANIM_OK);
                    m_bFlg = true;
                }
                break;

            case CHAR_HUYUKI_ID:
                if(!m_bFlg) {
                    m_Character = new char_Huyuki(gv, posX, posY, SCALE_DETAIL, ANIM_OK);
                    m_bFlg = true;
                }
                break;

            case CHAR_ROKUROU_ID:
                if(!m_bFlg) {
                    m_Character = new char_Rokurou(gv, posX, posY, SCALE_DETAIL, ANIM_OK);
                    m_bFlg = true;
                }
                break;

            // beasts(300-399)
            case CHAR_KONSUKE_ID:
                if(!m_bFlg) {
                    m_Character = new char_Konsuke(gv, posX, posY, SCALE_DETAIL, ANIM_OK) ;
                    m_bFlg = true;
                }
                break;

            case CHAR_DONTA_ID:
                if(!m_bFlg) {
                    m_Character = new char_Donta(gv, posX, posY, SCALE_DETAIL, ANIM_OK) ;
                    m_bFlg = true;
                }
                break;

            case CHAR_MINMI_ID:
                if(!m_bFlg) {
                    m_Character = new char_Minmi(gv, posX, posY, SCALE_DETAIL, ANIM_OK) ;
                    m_bFlg = true;
                }
                break;

            case CHAR_RYU_ID:
                if(!m_bFlg) {
                    m_Character = new char_Ryu(gv, posX, posY, SCALE_DETAIL, ANIM_OK) ;
                    m_bFlg = true;
                }
                break;
        }
    }

    public boolean touch(MotionEvent event){
        if( m_Character != null ){
            m_Character.touch(event);
            if( m_Character.getTouch() ){
                return true;
            }
        }
        return false;
    }

    // update
    public void update(){
        if(m_Character != null){
            m_Character.update();
        }
    }

    // draw
    public void draw(Canvas c){
        if(m_Character != null){
            m_Character.draw(c);
        }
    }

    static int numToID(int num){
        switch(num){
            case  0: return CHAR_AKEMI_ID;
            case  1: return CHAR_URARA_ID;
            case  2: return CHAR_SIZUKU_ID;
            case  3: return CHAR_NEKOKO_ID;
            case  4: return CHAR_MIKI_ID;
            case  5: return CHAR_MOMOKA_ID;
            case  6: return CHAR_RIMIKA_ID;
            case  7: return CHAR_RIN_ID;
            case  8: return CHAR_YUKITO_ID;
            case  9: return CHAR_KAITO_ID;
            case 10: return CHAR_SYU_ID;
            case 11: return CHAR_SHOUTA_ID;
            case 12: return CHAR_BANJYO_ID;
            case 13: return CHAR_HIBIKI_ID;
            case 14: return CHAR_HUYUKI_ID;
            case 15: return CHAR_ROKUROU_ID;
            case 16: return CHAR_KONSUKE_ID;
            case 17: return CHAR_DONTA_ID;
            case 18: return CHAR_MINMI_ID;
            case 19: return CHAR_RYU_ID;
            default: return CHAR_UNKNOWN_ID;
        }
    }

    // getter
    public CharacterSprite getCharacter(){
        return m_Character;
    }
 }
