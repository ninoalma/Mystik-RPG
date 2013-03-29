/*    */ package mystik;
/*    */ 
/*    */ import java.awt.Image;
/*    */ 
/*    */ public class Player
/*    */ {
/*    */   public String username;
/*    */   public String command;
/*    */   public int currentMap;
/*    */   public int x;
/*    */   public int y;
/* 11 */   public Image playerImage = null;
/*    */ 
/*    */   public String getUsername() {
/* 14 */     return this.username;
/*    */   }
/*    */ 
/*    */   public String getCommand() {
/* 18 */     return this.command;
/*    */   }
/*    */ 
/*    */   public void setCommand(String command) {
/* 22 */     this.command = command;
/*    */   }
/*    */ 
/*    */   public void setUsername(String username) {
/* 26 */     this.username = username;
/*    */   }
/*    */ 
/*    */   public int getX() {
/* 30 */     return this.x;
/*    */   }
/*    */ 
/*    */   public Image getPlayerImage() {
/* 34 */     return this.playerImage;
/*    */   }
/*    */ 
/*    */   public void setPlayerImage(Image playerImage) {
/* 38 */     this.playerImage = playerImage;
/*    */   }
/*    */ 
/*    */   public int getMap() {
/* 42 */     return this.currentMap;
/*    */   }
/*    */ 
/*    */   public void setMap(int currentMap) {
/* 46 */     this.currentMap = currentMap;
/*    */   }
/*    */ 
/*    */   public void setX(int x) {
/* 50 */     this.x = x;
/*    */   }
/*    */ 
/*    */   public int getY() {
/* 54 */     return this.y;
/*    */   }
/*    */ 
/*    */   public void setY(int y) {
/* 58 */     this.y = y;
/*    */   }
/*    */ }

/* Location:           C:\wamp\www\mystikv2\
 * Qualified Name:     mystik.Player
 * JD-Core Version:    0.6.2
 */