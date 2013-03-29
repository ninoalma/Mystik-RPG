/*    */ package mystik;
/*    */ 
/*    */ public class NumberLoad
/*    */ {
/*    */   public int currentID;
/*    */   public int leftMap;
/*    */   public int rightMap;
/*    */   public int upMap;
/*    */   public int downMap;
/*    */ 
/*    */   public int getCurrentMap()
/*    */   {
/* 10 */     return this.currentID; } 
/* 11 */   public int getLeftMap() { return this.leftMap; } 
/* 12 */   public int getRightMap() { return this.rightMap; } 
/* 13 */   public int getUpMap() { return this.upMap; } 
/* 14 */   public int getDownMap() { return this.downMap; } 
/*    */   public void setRightMap(int rightMap) {
/* 16 */     this.rightMap = rightMap; } 
/* 17 */   public void setLeftMap(int leftMap) { this.leftMap = leftMap; } 
/* 18 */   public void setUpMap(int upMap) { this.upMap = upMap; } 
/* 19 */   public void setDownMap(int downMap) { this.downMap = downMap; } 
/* 20 */   public void setMapID(int currentID) { this.currentID = currentID; }
/*    */ 
/*    */ }

/* Location:           C:\wamp\www\mystikv2\
 * Qualified Name:     mystik.NumberLoad
 * JD-Core Version:    0.6.2
 */