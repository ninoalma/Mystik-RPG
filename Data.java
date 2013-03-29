/*    */ package mystik;
/*    */ 
/*    */ import java.util.List;
/*    */ 
/*    */ public class Data
/*    */ {
/*    */   public static String MapTitle;
/*    */   public static Data data;
/*    */   public static ItemLoad item;
/*    */   public static MonsterLoad monster;
/*    */   public static EntranceLoad entrance;
/*    */   public static TeleportLoad teleport;
/*    */   public static SignLoad sign;
/*    */   public static NumberLoad id;
/*    */   public static String dan;
/*    */   public static int number;
/*    */   public static int tile;
/*    */   public static String[] wepN;
/*    */   private String title;
/*    */   private List<ItemLoad> items;
/*    */   private List<MonsterLoad> monsters;
/*    */   private List<EntranceLoad> entrances;
/*    */   private List<TeleportLoad> teleports;
/*    */   private List<NumberLoad> ids;
/*    */   private List<SignLoad> signs;
/*    */   private int[][] map;
/*    */ 
/*    */   public String getTitle()
/*    */   {
/* 30 */     return this.title; } 
/* 31 */   public List<ItemLoad> getItems() { return this.items; } 
/* 32 */   public List<MonsterLoad> getMonsters() { return this.monsters; } 
/* 33 */   public List<EntranceLoad> getEntrances() { return this.entrances; } 
/* 34 */   public List<TeleportLoad> getTeleports() { return this.teleports; } 
/* 35 */   public List<NumberLoad> getIDS() { return this.ids; } 
/* 36 */   public List<SignLoad> getSigns() { return this.signs; } 
/* 37 */   public int[][] getMap() { return this.map; } 
/*    */   public void setTitle(String title) {
/* 39 */     this.title = title; } 
/* 40 */   public void setItems(List<ItemLoad> items) { this.items = items; } 
/* 41 */   public void setMonsters(List<MonsterLoad> monsters) { this.monsters = monsters; } 
/* 42 */   public void setEntrances(List<EntranceLoad> entrances) { this.entrances = entrances; } 
/* 43 */   public void setTeleports(List<TeleportLoad> teleports) { this.teleports = teleports; } 
/* 44 */   public void setIDs(List<NumberLoad> ids) { this.ids = ids; } 
/* 45 */   public void setSigns(List<SignLoad> signs) { this.signs = signs; } 
/* 46 */   public void setMap(int[][] map) { this.map = map; }
/*    */ 
/*    */ }

/* Location:           C:\wamp\www\mystikv2\
 * Qualified Name:     mystik.Data
 * JD-Core Version:    0.6.2
 */