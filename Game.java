/*      */ package mystik;
/*      */ 
/*      */ import com.google.gson.Gson;
/*      */ import java.applet.AppletContext;
/*      */ import java.awt.BorderLayout;
/*      */ import java.awt.Color;
/*      */ import java.awt.Container;
/*      */ import java.awt.Dimension;
/*      */ import java.awt.Font;
/*      */ import java.awt.Graphics;
/*      */ import java.awt.GridBagConstraints;
/*      */ import java.awt.GridBagLayout;
/*      */ import java.awt.GridLayout;
/*      */ import java.awt.Image;
/*      */ import java.awt.Insets;
/*      */ import java.awt.Rectangle;
/*      */ import java.awt.Toolkit;
/*      */ import java.awt.event.ActionEvent;
/*      */ import java.awt.event.ActionListener;
/*      */ import java.awt.event.KeyEvent;
/*      */ import java.awt.event.KeyListener;
/*      */ import java.awt.event.MouseAdapter;
/*      */ import java.awt.event.MouseEvent;
/*      */ import java.awt.event.MouseListener;
/*      */ import java.awt.image.BufferedImage;
/*      */ import java.awt.image.RasterFormatException;
/*      */ import java.io.BufferedReader;
/*      */ import java.io.BufferedWriter;
/*      */ import java.io.File;
/*      */ import java.io.FileNotFoundException;
/*      */ import java.io.FileReader;
/*      */ import java.io.FileWriter;
/*      */ import java.io.IOException;
/*      */ import java.io.InputStreamReader;
/*      */ import java.io.PrintStream;
/*      */ import java.net.MalformedURLException;
/*      */ import java.net.Socket;
/*      */ import java.net.URL;
/*      */ import java.util.ArrayList;
/*      */ import java.util.Arrays;
/*      */ import java.util.HashMap;
/*      */ import java.util.HashSet;
/*      */ import java.util.Iterator;
/*      */ import java.util.List;
/*      */ import java.util.Map;
/*      */ import java.util.Random;
/*      */ import javax.imageio.ImageIO;
/*      */ import javax.swing.BorderFactory;
/*      */ import javax.swing.DefaultListModel;
/*      */ import javax.swing.ImageIcon;
/*      */ import javax.swing.JApplet;
/*      */ import javax.swing.JButton;
/*      */ import javax.swing.JLabel;
/*      */ import javax.swing.JList;
/*      */ import javax.swing.JMenuItem;
/*      */ import javax.swing.JOptionPane;
/*      */ import javax.swing.JPanel;
/*      */ import javax.swing.JPopupMenu;
/*      */ import javax.swing.JProgressBar;
/*      */ import javax.swing.JScrollBar;
/*      */ import javax.swing.JScrollPane;
/*      */ import javax.swing.JTextArea;
/*      */ import javax.swing.JTextField;
/*      */ import javax.swing.ListModel;
/*      */ import javax.swing.SwingUtilities;
/*      */ import javax.swing.UIManager;
/*      */ import javax.swing.border.Border;
/*      */ import javax.swing.border.LineBorder;
/*      */ import javax.swing.plaf.basic.BasicScrollBarUI;
/*      */ import javax.swing.text.Document;
/*      */ 
/*      */ public class Game extends JApplet
/*      */   implements KeyListener, MouseListener, ActionListener
/*      */ {
/*      */   Image[] tiles;
/*      */   Image[] weapon;
/*      */   Image[] monster;
/*      */   Image[] other;
/*      */   String username;
/*      */   JLabel theUser;
/*      */   String[] user;
/*      */   String[] itemsDropped;
/*      */   Boolean[] monsterRight;
/*      */   Boolean[] monsterLeft;
/*      */   Boolean moveUp;
/*      */   Boolean moveDown;
/*      */   Boolean moveLeft;
/*      */   Boolean moveRight;
/*      */   Boolean beingAttacked;
/*      */   JPanel pnPanel0;
/*      */   JPanel pnPanel3;
/*      */   JPanel pnHeadInfoPanel;
/*      */   JButton btHeadIcon;
/*      */   JLabel lbLabel0;
/*      */   JPanel pnBodyInfoPanel;
/*      */   JButton btBodyIcon;
/*      */   JPanel pnLeftArmInfoPanel;
/*      */   JButton btLeftArmIcon;
/*      */   JPanel pnRightArmInfoPanel;
/*      */   JButton btRightArmIcon;
/*      */   JPanel pnLegsInfoPanel;
/*      */   JButton btLegsIcon;
/*      */   JProgressBar pbExpBar;
/*      */   JPanel pnPanel12;
/*      */   JLabel lbLabel2;
/*      */   JLabel lbLabel3;
/*      */   JLabel lbLabel4;
/*      */   JLabel lbLabel5;
/*      */   JLabel lbLabel6;
/*      */   JLabel lbLabel7;
/*      */   JLabel lbLabel8;
/*      */   JLabel lbLevelInfoLabel;
/*      */   JLabel lbExpInfoLabel;
/*      */   JLabel lbExpLeftInfoLabel;
/*      */   JLabel lbGoldInfoLabel;
/*      */   JLabel lbStepsInfoLabel;
/*      */   JLabel lbKillsInfoLabel;
/*      */   JLabel lbDeathsInfoLabel;
/*      */   JButton btInfoOK;
/*      */   int headWear;
/*      */   int leftArmWear;
/*      */   int rightArmWear;
/*      */   int bodyWear;
/*      */   int legWear;
/*      */   int x;
/*      */   int y;
/*      */   int px;
/*      */   int py;
/*      */   int tx;
/*      */   int ty;
/*      */   boolean left;
/*      */   boolean right;
/*      */   boolean down;
/*      */   boolean up;
/*      */   boolean canMove;
/*      */   boolean respawn;
/*      */   boolean drawFlail;
/*      */   boolean drawBattleaxe;
/*      */   boolean drawSword;
/*      */   public int[][] board;
/*      */   public int[][] pushBoard;
/*      */   boolean[] weaponPicked;
/*      */   JLabel lx;
/*      */   JLabel ly;
/*      */   int r1;
/*      */   int r2;
/*      */   int u1;
/*      */   int u2;
/*      */   int l1;
/*      */   int l2;
/*      */   int d1;
/*      */   int d2;
/*      */   int spawnX;
/*      */   int spawnY;
/*      */   int rightSide;
/*      */   int downSide;
/*      */   int NUM_TILES = 523;
/*      */   int NUM_WEAPS = 7;
/*      */   int NUM_MONS = 18;
/*      */   int NUM_OTHS = 1;
/*      */   int mapX;
/*      */   int mapY;
/*      */   String txtLastFX;
/*      */   String txtLastFY;
/*      */   boolean boolRC;
/*      */   boolean boolLC;
/*      */   boolean boolUC;
/*      */   boolean boolDC;
/*      */   int leftMap;
/*      */   int upMap;
/*      */   int rightMap;
/*      */   int downMap;
/*      */   int currentMap;
/*      */   int map;
/*  180 */   public static JTextArea c = new JTextArea();
/*      */   public JTextArea stats;
/*      */   public JTextArea testDan;
/*      */   public String newline;
/*      */   public static JApplet applet;
/*      */   public Font TimesR;
/*      */   public static ArrayList<String> arr;
/*      */   public Game anItem;
/*      */   public boolean firstpush;
/*      */   String name;
/*      */   String desc;
/*      */   String typeOf;
/*      */   String attackAdd;
/*      */   String defenseAdd;
/*      */   String canSell;
/*      */   String canEat;
/*      */   String earnedCoins;
/*      */   String canEquip;
/*      */   public int blkStr;
/*      */   public Random roll;
/*      */   public int[] userPX;
/*      */   public int[] userPY;
/*      */   public Map<String, Player> players;
/*      */   private ArrayList<String> droppedItems;
/*      */   private ArrayList<String> maplist;
/*      */   private ArrayList<String> monstersActive;
/*      */   private ArrayList<String> entrances;
/*      */   private ArrayList<String> teleports;
/*      */   private ArrayList<String> signs;
/*      */   public String[] tokens;
/*      */   public String[] temp;
/*      */   public boolean isResp;
/*      */   public String myCommand;
/*      */   public JScrollPane sp;
/*      */   public Player me;
/*      */   public boolean chatOne;
/*      */   public int red;
/*  214 */   public static JTextField say = new JTextField();
/*      */   public GamePanel game;
/*      */   int xpos;
/*      */   int ypos;
/*      */   int rect1xco;
/*      */   int rect1yco;
/*      */   int rect1width;
/*      */   int rect1height;
/*      */   boolean gameClicked;
/*      */   public DefaultListModel model;
/*      */   public JLabel usersOn;
/*      */   public JLabel labelX;
/*      */   public JLabel labelY;
/*      */   public JLabel labelRoom;
/*      */   public JLabel labelStatus;
/*      */   public JLabel introLabel;
/*      */   public JLabel introLabel_two;
/*      */   public JLabel lName;
/*      */   public JLabel lHealth;
/*      */   public JLabel lExp;
/*      */   public JLabel lAttack;
/*      */   public JLabel lDefence;
/*      */   public JLabel lLevel;
/*      */   public JLabel labelUser;
/*      */   public JLabel lN2;
/*      */   public JLabel lH2;
/*      */   public JLabel lL2;
/*      */   public JLabel lE2;
/*      */   public JLabel lA2;
/*      */   public JLabel lD2;
/*      */   public JLabel signLabel;
/*      */   public JLabel extraSpace1;
/*      */   public JLabel extraSpace2;
/*      */   public JLabel extraSpace3;
/*      */   public JLabel extraSpace4;
/*      */   public JLabel extraSpace5;
/*      */   public JLabel extraSpace6;
/*      */   public JLabel charInfo;
/*      */   public int count;
/*      */   public JOptionPane introDuct;
/*      */   public JList list;
/*      */   public String currentItem;
/*      */   public String draw;
/*      */   public String htmlx;
/*      */   public String beforeCheck;
/*      */   public JPanel userPanel;
/*      */   public JPanel xPanel;
/*      */   public JPanel yPanel;
/*      */   public JPanel titlePanel;
/*      */   public JPanel roomPanel;
/*      */   public JPanel introPanel;
/*      */   public JPanel statusPanel;
/*      */   public JPanel invOne;
/*      */   public JPanel main;
/*      */   public JPanel rightside;
/*      */   public JPanel gameOn;
/*      */   public JPanel statsNow;
/*      */   public JPanel statsPanel;
/*      */   public JPanel charPanel;
/*      */   public JPanel signPanel;
/*      */   public String roomName;
/*      */   public String signhtml;
/*      */   public String itemIDdropped;
/*      */   public boolean pressedG;
/*      */   public boolean tele;
/*      */   public boolean FLP;
/*      */   public boolean FUP;
/*      */   public boolean FDP;
/*      */   public boolean FRP;
/*      */   public boolean charOpen;
/*      */   public int mapLoadNow;
/*      */   public String attackedBy;
/*      */   public boolean isInBattle;
/*      */   public int lastPushed;
/*      */   int lTile;
/*      */   int theTile;
/*      */   int qepe;
/*      */   Boolean spotted;
/*      */   Boolean battleFinished;
/*      */   String attacker;
/*      */   Boolean attackUp;
/*      */   Boolean attackDown;
/*      */   Boolean attackLeft;
/*      */   Boolean attackRight;
/*      */   Boolean monMove;
/*      */   int stepsTill;
/*      */   public int check_down_Y;
/*      */   public int check_up_Y;
/*      */   public int checkX;
/*      */   public int checkY;
/*      */   public int check_left_X;
/*      */   public int check_right_X;
/*      */   public boolean firstStrike;
/*      */   public int newMonHp;
/*      */   public int yourHit;
/*      */   public static Rectangle clip;
/*      */   public JPopupMenu popup;
/*      */   public JPopupMenu leftArmPopup;
/*      */   public JMenuItem item;
/*      */   public JMenuItem cancelMenuItem;
/*      */   public JMenuItem useMenuItem;
/*      */   public JMenuItem dropMenuItem;
/*      */   public JMenuItem equipMenuItem;
/*      */   public JMenuItem wearMenuItem;
/*      */   public JMenuItem unequipMenuItem;
/*      */   public JPopupMenu useCancelPopup;
/*      */   public JPopupMenu useDropPopup;
/*      */   public JPopupMenu useUsePopup;
/*      */   public JPopupMenu useEquipPopup;
/*      */   public JPopupMenu useWearPopup;
/*      */   public JPopupMenu useUnequipPopup;
/*      */   public JButton headIcon;
/*      */   public JLabel head;
/*      */   public JLabel titleChar;
/*      */   public JPanel leftx;
/*      */   public JPanel rightx;
/*      */   public static String MapTitle;
/*      */   public static Data data;
/*      */   public static Data dataNow;
/*      */   public static Data dataMap;
/*      */   public static Data dataLeft;
/*      */   public static Data[] dataArray;
/*      */   public static ItemLoad itemLoad;
/*      */   public static MonsterLoad monsterLoad;
/*      */   public static EntranceLoad entranceLoad;
/*      */   public static TeleportLoad teleportLoad;
/*      */   public static NumberLoad numberLoad;
/*      */   public static SignLoad signLoad;
/*      */   public static String dan;
/*      */   public static FileReader fr;
/*      */   public static int number;
/*      */   public static int tile;
/*      */   public static String fileNow;
/*      */   public static String[] wepN;
/*      */   public static String[] mapStr;
/*      */   public int leftFileLoad;
/*      */   public PrintStream os;
/*      */   Socket clientSocket;
/*      */   BufferedReader in;
/*      */   boolean closed;
/*      */   int lastX;
/*      */   int lastY;
/*      */   int row;
/*      */   int col;
/*      */   int prow;
/*      */   int pcol;
/*      */   JLabel lbl1;
/*      */   JLabel lbl2;
/*      */   JLabel p1;
/*      */   JLabel p2;
/*      */   JLabel lblRC;
/*      */   int attack;
/*      */   int defense;
/*      */   int gold;
/*      */   int level;
/*      */   int exp;
/*      */   int currhp;
/*      */   int maxhp;
/*      */   private final HashSet<Integer> PUSHABLE_TILES;
/*      */   private final HashSet<Integer> BLOCKED_TILES;
/*      */ 
/*      */   public Game()
/*      */   {
/*  107 */     this.moveUp = Boolean.valueOf(true);
/*  108 */     this.moveDown = Boolean.valueOf(true);
/*  109 */     this.moveLeft = Boolean.valueOf(true);
/*  110 */     this.moveRight = Boolean.valueOf(true);
/*  111 */     this.beingAttacked = Boolean.valueOf(false);
/*      */ 
/*  164 */     this.rightSide = 480;
/*  165 */     this.downSide = 320;
/*      */ 
/*  171 */     this.NUM_TILES = 523;
/*  172 */     this.NUM_WEAPS = 7;
/*  173 */     this.NUM_MONS = 18;
/*  174 */     this.NUM_OTHS = 1;
/*  175 */     this.mapX = 15;
/*  176 */     this.mapY = 10;
/*      */ 
/*  181 */     this.stats = new JTextArea();
/*  182 */     this.testDan = new JTextArea();
/*      */ 
/*  188 */     this.TimesR = new Font("MonoSpaced", 1, 15);
/*      */ 
/*  191 */     this.firstpush = false;
/*      */ 
/*  195 */     this.roll = new Random();
/*      */ 
/*  199 */     this.players = new HashMap();
/*  200 */     this.droppedItems = new ArrayList();
/*  201 */     this.maplist = new ArrayList();
/*  202 */     this.monstersActive = new ArrayList();
/*  203 */     this.entrances = new ArrayList();
/*  204 */     this.teleports = new ArrayList();
/*  205 */     this.signs = new ArrayList();
/*      */ 
/*  208 */     this.isResp = false;
/*  209 */     this.myCommand = "move";
/*      */ 
/*  212 */     this.chatOne = false;
/*  213 */     this.red = 0;
/*      */ 
/*  215 */     this.game = new GamePanel();
/*      */ 
/*  219 */     this.model = new DefaultListModel();
/*      */ 
/*  225 */     this.count = 0;
/*      */ 
/*  236 */     this.FLP = true;
/*  237 */     this.FUP = true;
/*  238 */     this.FDP = true;
/*  239 */     this.FRP = true;
/*  240 */     this.charOpen = false;
/*  241 */     this.mapLoadNow = 1;
/*      */ 
/*  243 */     this.isInBattle = false;
/*  244 */     this.lastPushed = 0;
/*  245 */     this.lTile = 15;
/*  246 */     this.theTile = 0;
/*  247 */     this.qepe = 0;
/*  248 */     this.spotted = Boolean.valueOf(false);
/*  249 */     this.battleFinished = Boolean.valueOf(false);
/*  250 */     this.attacker = "";
/*  251 */     this.attackUp = Boolean.valueOf(false);
/*  252 */     this.attackDown = Boolean.valueOf(false);
/*  253 */     this.attackLeft = Boolean.valueOf(false);
/*  254 */     this.attackRight = Boolean.valueOf(false);
/*  255 */     this.monMove = Boolean.valueOf(true);
/*  256 */     this.stepsTill = 0;
/*      */ 
/*  258 */     this.firstStrike = false;
/*      */ 
/*  295 */     this.leftFileLoad = 0;
/*      */ 
/*  299 */     this.os = null;
/*  300 */     this.clientSocket = null;
/*      */ 
/* 2100 */     this.PUSHABLE_TILES = new HashSet();
/*      */ 
/* 2102 */     this.PUSHABLE_TILES.add(Integer.valueOf(163));
/* 2103 */     this.PUSHABLE_TILES.add(Integer.valueOf(133));
/* 2104 */     this.PUSHABLE_TILES.add(Integer.valueOf(145));
/*      */ 
/* 2170 */     this.BLOCKED_TILES = new HashSet();
/*      */ 
/* 2173 */     this.BLOCKED_TILES.add(Integer.valueOf(1));
/* 2174 */     this.BLOCKED_TILES.add(Integer.valueOf(2));
/* 2175 */     this.BLOCKED_TILES.add(Integer.valueOf(3));
/* 2176 */     this.BLOCKED_TILES.add(Integer.valueOf(4));
/* 2177 */     this.BLOCKED_TILES.add(Integer.valueOf(5));
/* 2178 */     this.BLOCKED_TILES.add(Integer.valueOf(6));
/* 2179 */     this.BLOCKED_TILES.add(Integer.valueOf(7));
/* 2180 */     this.BLOCKED_TILES.add(Integer.valueOf(8));
/* 2181 */     this.BLOCKED_TILES.add(Integer.valueOf(9));
/* 2182 */     this.BLOCKED_TILES.add(Integer.valueOf(19));
/* 2183 */     this.BLOCKED_TILES.add(Integer.valueOf(20));
/* 2184 */     this.BLOCKED_TILES.add(Integer.valueOf(21));
/* 2185 */     this.BLOCKED_TILES.add(Integer.valueOf(22));
/* 2186 */     this.BLOCKED_TILES.add(Integer.valueOf(23));
/* 2187 */     this.BLOCKED_TILES.add(Integer.valueOf(24));
/* 2188 */     this.BLOCKED_TILES.add(Integer.valueOf(25));
/* 2189 */     this.BLOCKED_TILES.add(Integer.valueOf(26));
/* 2190 */     this.BLOCKED_TILES.add(Integer.valueOf(27));
/* 2191 */     this.BLOCKED_TILES.add(Integer.valueOf(28));
/* 2192 */     this.BLOCKED_TILES.add(Integer.valueOf(29));
/* 2193 */     this.BLOCKED_TILES.add(Integer.valueOf(30));
/* 2194 */     this.BLOCKED_TILES.add(Integer.valueOf(37));
/* 2195 */     this.BLOCKED_TILES.add(Integer.valueOf(39));
/* 2196 */     this.BLOCKED_TILES.add(Integer.valueOf(41));
/* 2197 */     this.BLOCKED_TILES.add(Integer.valueOf(43));
/* 2198 */     this.BLOCKED_TILES.add(Integer.valueOf(45));
/* 2199 */     this.BLOCKED_TILES.add(Integer.valueOf(55));
/* 2200 */     this.BLOCKED_TILES.add(Integer.valueOf(56));
/* 2201 */     this.BLOCKED_TILES.add(Integer.valueOf(57));
/* 2202 */     this.BLOCKED_TILES.add(Integer.valueOf(58));
/* 2203 */     this.BLOCKED_TILES.add(Integer.valueOf(59));
/* 2204 */     this.BLOCKED_TILES.add(Integer.valueOf(60));
/* 2205 */     this.BLOCKED_TILES.add(Integer.valueOf(61));
/* 2206 */     this.BLOCKED_TILES.add(Integer.valueOf(62));
/* 2207 */     this.BLOCKED_TILES.add(Integer.valueOf(63));
/* 2208 */     this.BLOCKED_TILES.add(Integer.valueOf(64));
/* 2209 */     this.BLOCKED_TILES.add(Integer.valueOf(65));
/* 2210 */     this.BLOCKED_TILES.add(Integer.valueOf(66));
/* 2211 */     this.BLOCKED_TILES.add(Integer.valueOf(67));
/* 2212 */     this.BLOCKED_TILES.add(Integer.valueOf(68));
/* 2213 */     this.BLOCKED_TILES.add(Integer.valueOf(69));
/* 2214 */     this.BLOCKED_TILES.add(Integer.valueOf(70));
/* 2215 */     this.BLOCKED_TILES.add(Integer.valueOf(71));
/* 2216 */     this.BLOCKED_TILES.add(Integer.valueOf(72));
/* 2217 */     this.BLOCKED_TILES.add(Integer.valueOf(73));
/* 2218 */     this.BLOCKED_TILES.add(Integer.valueOf(76));
/* 2219 */     this.BLOCKED_TILES.add(Integer.valueOf(79));
/* 2220 */     this.BLOCKED_TILES.add(Integer.valueOf(81));
/* 2221 */     this.BLOCKED_TILES.add(Integer.valueOf(90));
/* 2222 */     this.BLOCKED_TILES.add(Integer.valueOf(91));
/* 2223 */     this.BLOCKED_TILES.add(Integer.valueOf(92));
/* 2224 */     this.BLOCKED_TILES.add(Integer.valueOf(93));
/* 2225 */     this.BLOCKED_TILES.add(Integer.valueOf(94));
/* 2226 */     this.BLOCKED_TILES.add(Integer.valueOf(95));
/* 2227 */     this.BLOCKED_TILES.add(Integer.valueOf(96));
/* 2228 */     this.BLOCKED_TILES.add(Integer.valueOf(97));
/* 2229 */     this.BLOCKED_TILES.add(Integer.valueOf(98));
/* 2230 */     this.BLOCKED_TILES.add(Integer.valueOf(99));
/* 2231 */     this.BLOCKED_TILES.add(Integer.valueOf(106));
/* 2232 */     this.BLOCKED_TILES.add(Integer.valueOf(107));
/* 2233 */     this.BLOCKED_TILES.add(Integer.valueOf(108));
/* 2234 */     this.BLOCKED_TILES.add(Integer.valueOf(115));
/* 2235 */     this.BLOCKED_TILES.add(Integer.valueOf(116));
/* 2236 */     this.BLOCKED_TILES.add(Integer.valueOf(117));
/* 2237 */     this.BLOCKED_TILES.add(Integer.valueOf(118));
/* 2238 */     this.BLOCKED_TILES.add(Integer.valueOf(119));
/* 2239 */     this.BLOCKED_TILES.add(Integer.valueOf(120));
/* 2240 */     this.BLOCKED_TILES.add(Integer.valueOf(121));
/* 2241 */     this.BLOCKED_TILES.add(Integer.valueOf(122));
/* 2242 */     this.BLOCKED_TILES.add(Integer.valueOf(123));
/* 2243 */     this.BLOCKED_TILES.add(Integer.valueOf(124));
/* 2244 */     this.BLOCKED_TILES.add(Integer.valueOf(125));
/* 2245 */     this.BLOCKED_TILES.add(Integer.valueOf(126));
/* 2246 */     this.BLOCKED_TILES.add(Integer.valueOf(127));
/* 2247 */     this.BLOCKED_TILES.add(Integer.valueOf(128));
/* 2248 */     this.BLOCKED_TILES.add(Integer.valueOf(129));
/* 2249 */     this.BLOCKED_TILES.add(Integer.valueOf(130));
/* 2250 */     this.BLOCKED_TILES.add(Integer.valueOf(131));
/* 2251 */     this.BLOCKED_TILES.add(Integer.valueOf(132));
/* 2252 */     this.BLOCKED_TILES.add(Integer.valueOf(133));
/* 2253 */     this.BLOCKED_TILES.add(Integer.valueOf(134));
/* 2254 */     this.BLOCKED_TILES.add(Integer.valueOf(135));
/* 2255 */     this.BLOCKED_TILES.add(Integer.valueOf(136));
/* 2256 */     this.BLOCKED_TILES.add(Integer.valueOf(139));
/* 2257 */     this.BLOCKED_TILES.add(Integer.valueOf(140));
/* 2258 */     this.BLOCKED_TILES.add(Integer.valueOf(141));
/* 2259 */     this.BLOCKED_TILES.add(Integer.valueOf(142));
/* 2260 */     this.BLOCKED_TILES.add(Integer.valueOf(143));
/* 2261 */     this.BLOCKED_TILES.add(Integer.valueOf(144));
/* 2262 */     this.BLOCKED_TILES.add(Integer.valueOf(145));
/* 2263 */     this.BLOCKED_TILES.add(Integer.valueOf(146));
/* 2264 */     this.BLOCKED_TILES.add(Integer.valueOf(147));
/* 2265 */     this.BLOCKED_TILES.add(Integer.valueOf(148));
/* 2266 */     this.BLOCKED_TILES.add(Integer.valueOf(149));
/* 2267 */     this.BLOCKED_TILES.add(Integer.valueOf(150));
/* 2268 */     this.BLOCKED_TILES.add(Integer.valueOf(151));
/* 2269 */     this.BLOCKED_TILES.add(Integer.valueOf(152));
/* 2270 */     this.BLOCKED_TILES.add(Integer.valueOf(153));
/* 2271 */     this.BLOCKED_TILES.add(Integer.valueOf(154));
/* 2272 */     this.BLOCKED_TILES.add(Integer.valueOf(155));
/* 2273 */     this.BLOCKED_TILES.add(Integer.valueOf(156));
/* 2274 */     this.BLOCKED_TILES.add(Integer.valueOf(157));
/* 2275 */     this.BLOCKED_TILES.add(Integer.valueOf(158));
/* 2276 */     this.BLOCKED_TILES.add(Integer.valueOf(159));
/* 2277 */     this.BLOCKED_TILES.add(Integer.valueOf(160));
/* 2278 */     this.BLOCKED_TILES.add(Integer.valueOf(161));
/* 2279 */     this.BLOCKED_TILES.add(Integer.valueOf(162));
/* 2280 */     this.BLOCKED_TILES.add(Integer.valueOf(163));
/* 2281 */     this.BLOCKED_TILES.add(Integer.valueOf(164));
/* 2282 */     this.BLOCKED_TILES.add(Integer.valueOf(165));
/* 2283 */     this.BLOCKED_TILES.add(Integer.valueOf(169));
/* 2284 */     this.BLOCKED_TILES.add(Integer.valueOf(170));
/* 2285 */     this.BLOCKED_TILES.add(Integer.valueOf(171));
/* 2286 */     this.BLOCKED_TILES.add(Integer.valueOf(172));
/* 2287 */     this.BLOCKED_TILES.add(Integer.valueOf(173));
/* 2288 */     this.BLOCKED_TILES.add(Integer.valueOf(174));
/* 2289 */     this.BLOCKED_TILES.add(Integer.valueOf(175));
/* 2290 */     this.BLOCKED_TILES.add(Integer.valueOf(176));
/* 2291 */     this.BLOCKED_TILES.add(Integer.valueOf(177));
/* 2292 */     this.BLOCKED_TILES.add(Integer.valueOf(178));
/* 2293 */     this.BLOCKED_TILES.add(Integer.valueOf(179));
/* 2294 */     this.BLOCKED_TILES.add(Integer.valueOf(180));
/* 2295 */     this.BLOCKED_TILES.add(Integer.valueOf(181));
/* 2296 */     this.BLOCKED_TILES.add(Integer.valueOf(183));
/* 2297 */     this.BLOCKED_TILES.add(Integer.valueOf(185));
/* 2298 */     this.BLOCKED_TILES.add(Integer.valueOf(187));
/* 2299 */     this.BLOCKED_TILES.add(Integer.valueOf(190));
/* 2300 */     this.BLOCKED_TILES.add(Integer.valueOf(191));
/* 2301 */     this.BLOCKED_TILES.add(Integer.valueOf(192));
/* 2302 */     this.BLOCKED_TILES.add(Integer.valueOf(196));
/* 2303 */     this.BLOCKED_TILES.add(Integer.valueOf(197));
/* 2304 */     this.BLOCKED_TILES.add(Integer.valueOf(198));
/* 2305 */     this.BLOCKED_TILES.add(Integer.valueOf(199));
/* 2306 */     this.BLOCKED_TILES.add(Integer.valueOf(200));
/* 2307 */     this.BLOCKED_TILES.add(Integer.valueOf(201));
/* 2308 */     this.BLOCKED_TILES.add(Integer.valueOf(202));
/* 2309 */     this.BLOCKED_TILES.add(Integer.valueOf(203));
/* 2310 */     this.BLOCKED_TILES.add(Integer.valueOf(204));
/* 2311 */     this.BLOCKED_TILES.add(Integer.valueOf(205));
/* 2312 */     this.BLOCKED_TILES.add(Integer.valueOf(206));
/* 2313 */     this.BLOCKED_TILES.add(Integer.valueOf(207));
/* 2314 */     this.BLOCKED_TILES.add(Integer.valueOf(211));
/* 2315 */     this.BLOCKED_TILES.add(Integer.valueOf(212));
/* 2316 */     this.BLOCKED_TILES.add(Integer.valueOf(213));
/* 2317 */     this.BLOCKED_TILES.add(Integer.valueOf(214));
/* 2318 */     this.BLOCKED_TILES.add(Integer.valueOf(217));
/* 2319 */     this.BLOCKED_TILES.add(Integer.valueOf(220));
/* 2320 */     this.BLOCKED_TILES.add(Integer.valueOf(222));
/* 2321 */     this.BLOCKED_TILES.add(Integer.valueOf(223));
/* 2322 */     this.BLOCKED_TILES.add(Integer.valueOf(225));
/* 2323 */     this.BLOCKED_TILES.add(Integer.valueOf(226));
/* 2324 */     this.BLOCKED_TILES.add(Integer.valueOf(227));
/* 2325 */     this.BLOCKED_TILES.add(Integer.valueOf(228));
/* 2326 */     this.BLOCKED_TILES.add(Integer.valueOf(232));
/* 2327 */     this.BLOCKED_TILES.add(Integer.valueOf(233));
/* 2328 */     this.BLOCKED_TILES.add(Integer.valueOf(234));
/* 2329 */     this.BLOCKED_TILES.add(Integer.valueOf(235));
/* 2330 */     this.BLOCKED_TILES.add(Integer.valueOf(236));
/* 2331 */     this.BLOCKED_TILES.add(Integer.valueOf(237));
/* 2332 */     this.BLOCKED_TILES.add(Integer.valueOf(238));
/* 2333 */     this.BLOCKED_TILES.add(Integer.valueOf(239));
/* 2334 */     this.BLOCKED_TILES.add(Integer.valueOf(240));
/* 2335 */     this.BLOCKED_TILES.add(Integer.valueOf(241));
/* 2336 */     this.BLOCKED_TILES.add(Integer.valueOf(242));
/* 2337 */     this.BLOCKED_TILES.add(Integer.valueOf(243));
/* 2338 */     this.BLOCKED_TILES.add(Integer.valueOf(244));
/* 2339 */     this.BLOCKED_TILES.add(Integer.valueOf(246));
/* 2340 */     this.BLOCKED_TILES.add(Integer.valueOf(247));
/* 2341 */     this.BLOCKED_TILES.add(Integer.valueOf(249));
/* 2342 */     this.BLOCKED_TILES.add(Integer.valueOf(250));
/* 2343 */     this.BLOCKED_TILES.add(Integer.valueOf(252));
/* 2344 */     this.BLOCKED_TILES.add(Integer.valueOf(259));
/* 2345 */     this.BLOCKED_TILES.add(Integer.valueOf(260));
/* 2346 */     this.BLOCKED_TILES.add(Integer.valueOf(261));
/* 2347 */     this.BLOCKED_TILES.add(Integer.valueOf(262));
/* 2348 */     this.BLOCKED_TILES.add(Integer.valueOf(263));
/* 2349 */     this.BLOCKED_TILES.add(Integer.valueOf(264));
/* 2350 */     this.BLOCKED_TILES.add(Integer.valueOf(271));
/* 2351 */     this.BLOCKED_TILES.add(Integer.valueOf(272));
/* 2352 */     this.BLOCKED_TILES.add(Integer.valueOf(273));
/* 2353 */     this.BLOCKED_TILES.add(Integer.valueOf(274));
/* 2354 */     this.BLOCKED_TILES.add(Integer.valueOf(275));
/* 2355 */     this.BLOCKED_TILES.add(Integer.valueOf(276));
/* 2356 */     this.BLOCKED_TILES.add(Integer.valueOf(277));
/* 2357 */     this.BLOCKED_TILES.add(Integer.valueOf(278));
/* 2358 */     this.BLOCKED_TILES.add(Integer.valueOf(279));
/* 2359 */     this.BLOCKED_TILES.add(Integer.valueOf(280));
/* 2360 */     this.BLOCKED_TILES.add(Integer.valueOf(283));
/* 2361 */     this.BLOCKED_TILES.add(Integer.valueOf(285));
/* 2362 */     this.BLOCKED_TILES.add(Integer.valueOf(288));
/* 2363 */     this.BLOCKED_TILES.add(Integer.valueOf(319));
/* 2364 */     this.BLOCKED_TILES.add(Integer.valueOf(320));
/* 2365 */     this.BLOCKED_TILES.add(Integer.valueOf(321));
/* 2366 */     this.BLOCKED_TILES.add(Integer.valueOf(322));
/* 2367 */     this.BLOCKED_TILES.add(Integer.valueOf(328));
/* 2368 */     this.BLOCKED_TILES.add(Integer.valueOf(329));
/* 2369 */     this.BLOCKED_TILES.add(Integer.valueOf(330));
/* 2370 */     this.BLOCKED_TILES.add(Integer.valueOf(331));
/* 2371 */     this.BLOCKED_TILES.add(Integer.valueOf(332));
/* 2372 */     this.BLOCKED_TILES.add(Integer.valueOf(333));
/* 2373 */     this.BLOCKED_TILES.add(Integer.valueOf(334));
/* 2374 */     this.BLOCKED_TILES.add(Integer.valueOf(335));
/* 2375 */     this.BLOCKED_TILES.add(Integer.valueOf(336));
/* 2376 */     this.BLOCKED_TILES.add(Integer.valueOf(337));
/* 2377 */     this.BLOCKED_TILES.add(Integer.valueOf(338));
/* 2378 */     this.BLOCKED_TILES.add(Integer.valueOf(339));
/* 2379 */     this.BLOCKED_TILES.add(Integer.valueOf(340));
/* 2380 */     this.BLOCKED_TILES.add(Integer.valueOf(341));
/* 2381 */     this.BLOCKED_TILES.add(Integer.valueOf(342));
/* 2382 */     this.BLOCKED_TILES.add(Integer.valueOf(349));
/* 2383 */     this.BLOCKED_TILES.add(Integer.valueOf(350));
/* 2384 */     this.BLOCKED_TILES.add(Integer.valueOf(351));
/* 2385 */     this.BLOCKED_TILES.add(Integer.valueOf(352));
/* 2386 */     this.BLOCKED_TILES.add(Integer.valueOf(353));
/* 2387 */     this.BLOCKED_TILES.add(Integer.valueOf(354));
/* 2388 */     this.BLOCKED_TILES.add(Integer.valueOf(355));
/* 2389 */     this.BLOCKED_TILES.add(Integer.valueOf(361));
/* 2390 */     this.BLOCKED_TILES.add(Integer.valueOf(362));
/* 2391 */     this.BLOCKED_TILES.add(Integer.valueOf(363));
/* 2392 */     this.BLOCKED_TILES.add(Integer.valueOf(364));
/* 2393 */     this.BLOCKED_TILES.add(Integer.valueOf(365));
/* 2394 */     this.BLOCKED_TILES.add(Integer.valueOf(366));
/* 2395 */     this.BLOCKED_TILES.add(Integer.valueOf(367));
/* 2396 */     this.BLOCKED_TILES.add(Integer.valueOf(368));
/* 2397 */     this.BLOCKED_TILES.add(Integer.valueOf(369));
/* 2398 */     this.BLOCKED_TILES.add(Integer.valueOf(370));
/* 2399 */     this.BLOCKED_TILES.add(Integer.valueOf(371));
/* 2400 */     this.BLOCKED_TILES.add(Integer.valueOf(372));
/* 2401 */     this.BLOCKED_TILES.add(Integer.valueOf(373));
/* 2402 */     this.BLOCKED_TILES.add(Integer.valueOf(374));
/* 2403 */     this.BLOCKED_TILES.add(Integer.valueOf(375));
/* 2404 */     this.BLOCKED_TILES.add(Integer.valueOf(376));
/* 2405 */     this.BLOCKED_TILES.add(Integer.valueOf(377));
/* 2406 */     this.BLOCKED_TILES.add(Integer.valueOf(378));
/* 2407 */     this.BLOCKED_TILES.add(Integer.valueOf(379));
/* 2408 */     this.BLOCKED_TILES.add(Integer.valueOf(380));
/* 2409 */     this.BLOCKED_TILES.add(Integer.valueOf(381));
/* 2410 */     this.BLOCKED_TILES.add(Integer.valueOf(388));
/* 2411 */     this.BLOCKED_TILES.add(Integer.valueOf(389));
/* 2412 */     this.BLOCKED_TILES.add(Integer.valueOf(390));
/* 2413 */     this.BLOCKED_TILES.add(Integer.valueOf(391));
/* 2414 */     this.BLOCKED_TILES.add(Integer.valueOf(392));
/* 2415 */     this.BLOCKED_TILES.add(Integer.valueOf(393));
/* 2416 */     this.BLOCKED_TILES.add(Integer.valueOf(394));
/* 2417 */     this.BLOCKED_TILES.add(Integer.valueOf(397));
/* 2418 */     this.BLOCKED_TILES.add(Integer.valueOf(398));
/* 2419 */     this.BLOCKED_TILES.add(Integer.valueOf(399));
/* 2420 */     this.BLOCKED_TILES.add(Integer.valueOf(400));
/* 2421 */     this.BLOCKED_TILES.add(Integer.valueOf(401));
/* 2422 */     this.BLOCKED_TILES.add(Integer.valueOf(402));
/* 2423 */     this.BLOCKED_TILES.add(Integer.valueOf(403));
/* 2424 */     this.BLOCKED_TILES.add(Integer.valueOf(404));
/* 2425 */     this.BLOCKED_TILES.add(Integer.valueOf(405));
/* 2426 */     this.BLOCKED_TILES.add(Integer.valueOf(406));
/* 2427 */     this.BLOCKED_TILES.add(Integer.valueOf(407));
/* 2428 */     this.BLOCKED_TILES.add(Integer.valueOf(408));
/* 2429 */     this.BLOCKED_TILES.add(Integer.valueOf(409));
/* 2430 */     this.BLOCKED_TILES.add(Integer.valueOf(410));
/* 2431 */     this.BLOCKED_TILES.add(Integer.valueOf(411));
/* 2432 */     this.BLOCKED_TILES.add(Integer.valueOf(412));
/* 2433 */     this.BLOCKED_TILES.add(Integer.valueOf(413));
/* 2434 */     this.BLOCKED_TILES.add(Integer.valueOf(414));
/* 2435 */     this.BLOCKED_TILES.add(Integer.valueOf(415));
/* 2436 */     this.BLOCKED_TILES.add(Integer.valueOf(416));
/* 2437 */     this.BLOCKED_TILES.add(Integer.valueOf(417));
/* 2438 */     this.BLOCKED_TILES.add(Integer.valueOf(418));
/* 2439 */     this.BLOCKED_TILES.add(Integer.valueOf(419));
/* 2440 */     this.BLOCKED_TILES.add(Integer.valueOf(420));
/* 2441 */     this.BLOCKED_TILES.add(Integer.valueOf(421));
/* 2442 */     this.BLOCKED_TILES.add(Integer.valueOf(422));
/* 2443 */     this.BLOCKED_TILES.add(Integer.valueOf(423));
/* 2444 */     this.BLOCKED_TILES.add(Integer.valueOf(430));
/* 2445 */     this.BLOCKED_TILES.add(Integer.valueOf(431));
/* 2446 */     this.BLOCKED_TILES.add(Integer.valueOf(432));
/* 2447 */     this.BLOCKED_TILES.add(Integer.valueOf(433));
/* 2448 */     this.BLOCKED_TILES.add(Integer.valueOf(434));
/* 2449 */     this.BLOCKED_TILES.add(Integer.valueOf(435));
/* 2450 */     this.BLOCKED_TILES.add(Integer.valueOf(436));
/* 2451 */     this.BLOCKED_TILES.add(Integer.valueOf(437));
/* 2452 */     this.BLOCKED_TILES.add(Integer.valueOf(438));
/* 2453 */     this.BLOCKED_TILES.add(Integer.valueOf(439));
/* 2454 */     this.BLOCKED_TILES.add(Integer.valueOf(440));
/* 2455 */     this.BLOCKED_TILES.add(Integer.valueOf(441));
/* 2456 */     this.BLOCKED_TILES.add(Integer.valueOf(442));
/* 2457 */     this.BLOCKED_TILES.add(Integer.valueOf(443));
/* 2458 */     this.BLOCKED_TILES.add(Integer.valueOf(444));
/* 2459 */     this.BLOCKED_TILES.add(Integer.valueOf(445));
/* 2460 */     this.BLOCKED_TILES.add(Integer.valueOf(446));
/* 2461 */     this.BLOCKED_TILES.add(Integer.valueOf(447));
/* 2462 */     this.BLOCKED_TILES.add(Integer.valueOf(448));
/* 2463 */     this.BLOCKED_TILES.add(Integer.valueOf(449));
/* 2464 */     this.BLOCKED_TILES.add(Integer.valueOf(450));
/* 2465 */     this.BLOCKED_TILES.add(Integer.valueOf(451));
/* 2466 */     this.BLOCKED_TILES.add(Integer.valueOf(452));
/* 2467 */     this.BLOCKED_TILES.add(Integer.valueOf(453));
/* 2468 */     this.BLOCKED_TILES.add(Integer.valueOf(454));
/* 2469 */     this.BLOCKED_TILES.add(Integer.valueOf(455));
/* 2470 */     this.BLOCKED_TILES.add(Integer.valueOf(456));
/* 2471 */     this.BLOCKED_TILES.add(Integer.valueOf(469));
/* 2472 */     this.BLOCKED_TILES.add(Integer.valueOf(470));
/* 2473 */     this.BLOCKED_TILES.add(Integer.valueOf(471));
/* 2474 */     this.BLOCKED_TILES.add(Integer.valueOf(472));
/* 2475 */     this.BLOCKED_TILES.add(Integer.valueOf(473));
/* 2476 */     this.BLOCKED_TILES.add(Integer.valueOf(474));
/* 2477 */     this.BLOCKED_TILES.add(Integer.valueOf(475));
/* 2478 */     this.BLOCKED_TILES.add(Integer.valueOf(476));
/* 2479 */     this.BLOCKED_TILES.add(Integer.valueOf(477));
/* 2480 */     this.BLOCKED_TILES.add(Integer.valueOf(478));
/* 2481 */     this.BLOCKED_TILES.add(Integer.valueOf(479));
/* 2482 */     this.BLOCKED_TILES.add(Integer.valueOf(480));
/* 2483 */     this.BLOCKED_TILES.add(Integer.valueOf(481));
/* 2484 */     this.BLOCKED_TILES.add(Integer.valueOf(482));
/* 2485 */     this.BLOCKED_TILES.add(Integer.valueOf(483));
/* 2486 */     this.BLOCKED_TILES.add(Integer.valueOf(484));
/* 2487 */     this.BLOCKED_TILES.add(Integer.valueOf(485));
/* 2488 */     this.BLOCKED_TILES.add(Integer.valueOf(486));
/* 2489 */     this.BLOCKED_TILES.add(Integer.valueOf(487));
/* 2490 */     this.BLOCKED_TILES.add(Integer.valueOf(488));
/* 2491 */     this.BLOCKED_TILES.add(Integer.valueOf(489));
/* 2492 */     this.BLOCKED_TILES.add(Integer.valueOf(490));
/* 2493 */     this.BLOCKED_TILES.add(Integer.valueOf(491));
/* 2494 */     this.BLOCKED_TILES.add(Integer.valueOf(492));
/* 2495 */     this.BLOCKED_TILES.add(Integer.valueOf(493));
/* 2496 */     this.BLOCKED_TILES.add(Integer.valueOf(494));
/* 2497 */     this.BLOCKED_TILES.add(Integer.valueOf(495));
/* 2498 */     this.BLOCKED_TILES.add(Integer.valueOf(496));
/* 2499 */     this.BLOCKED_TILES.add(Integer.valueOf(499));
/* 2500 */     this.BLOCKED_TILES.add(Integer.valueOf(500));
/* 2501 */     this.BLOCKED_TILES.add(Integer.valueOf(501));
/* 2502 */     this.BLOCKED_TILES.add(Integer.valueOf(502));
/* 2503 */     this.BLOCKED_TILES.add(Integer.valueOf(503));
/* 2504 */     this.BLOCKED_TILES.add(Integer.valueOf(504));
/* 2505 */     this.BLOCKED_TILES.add(Integer.valueOf(505));
/* 2506 */     this.BLOCKED_TILES.add(Integer.valueOf(506));
/* 2507 */     this.BLOCKED_TILES.add(Integer.valueOf(507));
/* 2508 */     this.BLOCKED_TILES.add(Integer.valueOf(508));
/* 2509 */     this.BLOCKED_TILES.add(Integer.valueOf(509));
/* 2510 */     this.BLOCKED_TILES.add(Integer.valueOf(510));
/* 2511 */     this.BLOCKED_TILES.add(Integer.valueOf(511));
/* 2512 */     this.BLOCKED_TILES.add(Integer.valueOf(512));
/* 2513 */     this.BLOCKED_TILES.add(Integer.valueOf(513));
/*      */   }
/*      */ 
/*      */   public void showInventory(ArrayList<String> theList)
/*      */   {
/*  313 */     for (int i = 0; i < theList.size(); i++);
/*      */   }
/*      */ 
/*      */   public void init()
/*      */   {
/*  320 */     setLayout(new BorderLayout());
/*  321 */     this.invOne = new JPanel();
/*  322 */     new Exception();
/*      */ 
/*  324 */     mapStr = new String[100];
/*  325 */     dataArray = new Data[100];
/*      */ 
/*  331 */     this.main = new JPanel(new BorderLayout());
/*  332 */     this.main.setPreferredSize(new Dimension(631, 521));
/*  333 */     this.rightside = new JPanel(new GridLayout(2, 1));
/*  334 */     this.charPanel = new JPanel();
/*  335 */     this.statsPanel = new JPanel(new GridLayout(6, 1));
/*  336 */     this.rightside.setPreferredSize(new Dimension(118, 342));
/*  337 */     this.statsNow = new JPanel(new GridLayout(18, 1));
/*  338 */     this.sp = new JScrollPane(c);
/*      */ 
/*  340 */     this.main.add(this.game, "Center");
/*  341 */     this.game.setPreferredSize(new Dimension(512, 352));
/*  342 */     this.main.add(this.sp, "South");
/*  343 */     add(this.main, "Center");
/*  344 */     add(say, "South");
/*      */ 
/*  354 */     ActionListener menuListener = new ActionListener()
/*      */     {
/*      */       public void actionPerformed(ActionEvent event)
/*      */       {
/*  359 */         String invAction = event.getActionCommand();
/*      */ 
/*  362 */         int itemSelect = Game.this.list.getSelectedIndex();
/*  363 */         Object actItem = Game.this.list.getModel().getElementAt(itemSelect);
/*      */ 
/*  365 */         String rightclickDrop = Game.this.getItem(actItem.toString())[8];
/*      */ 
/*  370 */         boolean isDropping = invAction.startsWith("Drop");
/*  371 */         boolean isEquipping = invAction.startsWith("Equip");
/*      */ 
/*  373 */         int rightStrDrop = Integer.parseInt(rightclickDrop);
/*      */ 
/*  375 */         if (isDropping) {
/*  376 */           Game.c.append("\nYou dropped a " + Game.this.getItem(actItem.toString())[0] + ".");
/*  377 */           Game.this.model.remove(Game.this.list.getSelectedIndex());
/*  378 */           Game.this.dropItemNow(rightStrDrop, Game.this.spawnX, Game.this.spawnY);
/*  379 */           Game.this.repaint();
/*      */         }
/*      */ 
/*  382 */         if (isEquipping)
/*      */         {
/*  386 */           if (Game.this.getItem(actItem.toString())[2] == "3") {
/*  387 */             if (Game.this.bodyWear == 0)
/*      */             {
/*  389 */               Game.c.append("\nYou equipped a " + Game.this.getItem(actItem.toString())[0] + ".");
/*  390 */               int newWepId = Integer.parseInt(Game.this.getItem(actItem.toString())[8]) - 1;
/*  391 */               Game.this.btBodyIcon.setIcon(new ImageIcon(Game.this.weapon[newWepId]));
/*  392 */               Game.this.btBodyIcon.setToolTipText(Game.this.getItem(actItem.toString())[0]);
/*  393 */               Game.this.bodyWear = newWepId;
/*  394 */               Game.this.model.remove(Game.this.list.getSelectedIndex());
/*      */             } else {
/*  396 */               Game.c.append("\nYou are already wielding something.");
/*      */             }
/*      */ 
/*      */           }
/*      */ 
/*  401 */           if (Game.this.getItem(actItem.toString())[2] == "2") {
/*  402 */             if (Game.this.leftArmWear == 0)
/*      */             {
/*  404 */               Game.c.append("\nYou equipped a " + Game.this.getItem(actItem.toString())[0] + ".");
/*  405 */               int newWepId = Integer.parseInt(Game.this.getItem(actItem.toString())[8]) - 1;
/*  406 */               Game.this.btLeftArmIcon.setIcon(new ImageIcon(Game.this.weapon[newWepId]));
/*  407 */               Game.this.btLeftArmIcon.setToolTipText(Game.this.getItem(actItem.toString())[0]);
/*  408 */               Game.this.addAttack(Integer.parseInt(Game.this.getItem(actItem.toString())[3]));
/*  409 */               Game.this.leftArmWear = newWepId;
/*  410 */               Game.this.model.remove(Game.this.list.getSelectedIndex());
/*      */             } else {
/*  412 */               Game.c.append("\nYou are already wielding something.");
/*      */             }
/*      */ 
/*      */           }
/*      */ 
/*  419 */           Game.this.repaint();
/*      */         }
/*      */       }
/*      */     };
/*  426 */     this.useUsePopup = new JPopupMenu();
/*  427 */     this.useDropPopup = new JPopupMenu();
/*  428 */     this.useCancelPopup = new JPopupMenu();
/*  429 */     this.useEquipPopup = new JPopupMenu();
/*  430 */     this.useWearPopup = new JPopupMenu();
/*      */ 
/*  432 */     this.popup = new JPopupMenu();
/*      */ 
/*  434 */     this.useMenuItem = new JMenuItem("Use");
/*  435 */     this.useMenuItem.addActionListener(menuListener);
/*      */ 
/*  437 */     this.dropMenuItem = new JMenuItem("Drop");
/*  438 */     this.dropMenuItem.addActionListener(menuListener);
/*      */ 
/*  440 */     this.equipMenuItem = new JMenuItem("Equip");
/*  441 */     this.equipMenuItem.addActionListener(menuListener);
/*      */ 
/*  443 */     this.wearMenuItem = new JMenuItem("Wear");
/*  444 */     this.wearMenuItem.addActionListener(menuListener);
/*      */ 
/*  446 */     this.cancelMenuItem = new JMenuItem("Cancel");
/*  447 */     this.cancelMenuItem.addActionListener(menuListener);
/*      */ 
/*  450 */     this.list = new JList(this.model);
/*  451 */     this.list.setSelectionMode(0);
/*      */ 
/*  453 */     this.list.addMouseListener(new MouseAdapter()
/*      */     {
/*      */       public void mousePressed(MouseEvent e)
/*      */       {
/*  457 */         if (SwingUtilities.isRightMouseButton(e))
/*      */         {
/*  459 */           System.out.println("Row: " + Game.this.list.locationToIndex(e.getPoint()));
/*  460 */           Game.this.list.setSelectedIndex(Game.this.list.locationToIndex(e.getPoint()));
/*      */         }
/*      */       }
/*      */ 
/*      */       public void mouseReleased(MouseEvent ex)
/*      */       {
/*  466 */         if (SwingUtilities.isRightMouseButton(ex))
/*      */         {
/*  468 */           Game.this.popup.removeAll();
/*  469 */           System.out.println("All items removed.");
/*      */         }
/*      */       }
/*      */     });
/*  476 */     this.list.addMouseListener(new MousePopupListener());
/*      */ 
/*  481 */     say.addKeyListener(this);
/*      */ 
/*  483 */     this.list.setVisible(true);
/*      */ 
/*  485 */     this.list.setFocusable(false);
/*      */ 
/*  488 */     c.setBackground(Color.white);
/*  489 */     c.setForeground(Color.black);
/*  490 */     c.setFont(this.TimesR);
/*  491 */     c.setEditable(true);
/*      */ 
/*  493 */     c.setLineWrap(true);
/*      */ 
/*  496 */     UIManager.put("ScrollBar.background", Color.BLACK);
/*  497 */     UIManager.put("ScrollBar.darkShadow", Color.BLACK);
/*  498 */     UIManager.put("ScrollBar.foreground", Color.WHITE);
/*  499 */     UIManager.put("ScrollBar.highlight", Color.BLACK);
/*  500 */     UIManager.put("ScrollBar.shadow", Color.red);
/*  501 */     UIManager.put("ScrollBar.thumb", Color.BLACK);
/*  502 */     UIManager.put("ScrollBar.thumbDarkShadow", Color.BLACK);
/*  503 */     UIManager.put("ScrollBar.thumbHighlight", Color.BLACK);
/*  504 */     UIManager.put("ScrollBar.thumbShadow", Color.BLACK);
/*  505 */     UIManager.put("ScrollBar.track", Color.WHITE);
/*  506 */     UIManager.put("ScrollBar.trackHighlight", Color.BLUE);
/*  507 */     this.sp.setVerticalScrollBarPolicy(22);
/*  508 */     this.sp.getVerticalScrollBar().setUI(new BasicScrollBarUI());
/*  509 */     this.sp.setPreferredSize(new Dimension(520, 150));
/*      */ 
/*  511 */     this.list.setBorder(new LineBorder(Color.BLACK, 4));
/*      */ 
/*  519 */     this.main.add(this.rightside, "East");
/*      */ 
/*  521 */     this.rightside.add(this.list);
/*  522 */     this.rightside.add(this.statsPanel);
/*      */ 
/*  528 */     this.attack = 2;
/*  529 */     this.defense = 2;
/*  530 */     this.gold = 0;
/*  531 */     this.exp = 52;
/*  532 */     this.level = getLevels(this.exp);
/*  533 */     c.append("\nI am level: " + getLevels(this.exp));
/*  534 */     this.currhp = 10;
/*  535 */     this.maxhp = 10;
/*      */ 
/*  537 */     int mapToLoad = 1;
/*      */ 
/*  540 */     this.board = loadBoard(1);
/*  541 */     this.pushBoard = loadPush(1);
/*      */ 
/*  543 */     String TempMystik = System.getenv("APPDATA") + "\\.mystik";
/*  544 */     String TempMystikTiles = System.getenv("APPDATA") + "\\.mystik\\tiles";
/*  545 */     String TempMystikMaps = System.getenv("APPDATA") + "\\.mystik\\maps";
/*  546 */     new File(TempMystik).mkdir();
/*      */ 
/*  549 */     new File(TempMystikMaps).mkdir();
/*      */ 
/*  551 */     File file = new File(System.getenv("APPDATA") + "\\.mystik\\maps\\main.txt");
/*      */ 
/*  555 */     File fileReadMe = new File(System.getenv("APPDATA") + "\\.mystik\\readme.txt");
/*  556 */     boolean Readexists = fileReadMe.exists();
/*      */ 
/*  558 */     if (!Readexists)
/*      */       try
/*      */       {
/*  561 */         URL readURL = new URL("http://mystikrpg.com/readme.txt");
/*  562 */         BufferedReader xin = new BufferedReader(new InputStreamReader(readURL.openStream()));
/*      */ 
/*  564 */         BufferedWriter xout = new BufferedWriter(new FileWriter(TempMystik + "\\readme.txt"));
/*      */         String str;
/*  565 */         while ((str = xin.readLine()) != null)
/*      */         {
/*      */           String str1 = null;
/*  566 */           xout.write(str1);
/*  567 */           xout.newLine();
/*      */         }
/*      */ 
/*  570 */         xout.close();
/*  571 */         xin.close();
/*      */       }
/*      */       catch (MalformedURLException localMalformedURLException)
/*      */       {
/*      */       }
/*      */       catch (IOException localIOException1)
/*      */       {
/*      */       }
/*  579 */     boolean exists = file.exists();
/*      */ 
/*  607 */     if (!exists)
/*      */     {
/*  609 */       this.currentMap = 1;
/*  610 */       c.append("main.txt not found. Creating map...");
/*      */       try
/*      */       {
/*  614 */         System.out.println("Downloading items...");
/*  615 */         File outputFileLocation = new File(System.getenv("APPDATA") + "\\.mystik\\items.gif");
/*  616 */         String imgURL = "http://mystikrpg.com/items.gif";
/*  617 */         URL urlItem = new URL(imgURL);
/*  618 */         Image imageBR = ImageIO.read(urlItem);
/*  619 */         BufferedImage cpimg = (BufferedImage)imageBR;
/*  620 */         ImageIO.write(cpimg, "gif", outputFileLocation);
/*  621 */         System.out.println("Items downloaded!");
/*      */ 
/*  624 */         System.out.println("Downloading monsters...");
/*  625 */         outputFileLocation = new File(System.getenv("APPDATA") + "\\.mystik\\monsters.gif");
/*  626 */         imgURL = "http://mystikrpg.com/monsters.gif";
/*  627 */         urlItem = new URL(imgURL);
/*  628 */         imageBR = ImageIO.read(urlItem);
/*  629 */         cpimg = (BufferedImage)imageBR;
/*  630 */         ImageIO.write(cpimg, "gif", outputFileLocation);
/*  631 */         System.out.println("Monsters downloaded!");
/*      */ 
/*  634 */         URL url = new URL("http://mystikrpg.com/main.txt");
/*      */ 
/*  636 */         BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
/*      */ 
/*  638 */         BufferedWriter out = new BufferedWriter(new FileWriter(TempMystik + "\\maps\\main.txt"));
/*      */         String strx;
/*  639 */         while ((strx = in.readLine()) != null)
/*      */         {
/*      */           String strx1 = null;
/*  640 */           out.write(strx1);
/*  641 */           out.newLine();
/*      */         }
/*      */ 
/*  644 */         out.close();
/*  645 */         in.close();
/*      */       }
/*      */       catch (MalformedURLException localMalformedURLException1)
/*      */       {
/*      */       }
/*      */       catch (IOException localIOException2)
/*      */       {
/*      */       }
/*      */ 
/*  665 */       c.append("\nMap created!");
/*      */     }
/*      */     else
/*      */     {
/*      */       try {
/*  670 */         fr = new FileReader(System.getenv("APPDATA") + "\\.mystik\\maps\\main.txt");
/*      */       } catch (FileNotFoundException fne) {
/*  672 */         fne.printStackTrace();
/*      */       }
/*      */ 
/*  676 */       File directory = new File(System.getenv("APPDATA") + "\\.mystik\\maps");
/*  677 */       String[] filename = directory.list();
/*      */ 
/*  680 */       int howManyFiles = 0;
/*  681 */       for (int qi = 0; qi < filename.length; qi++) {
/*  682 */         String listFilenames = System.getenv("APPDATA") + "\\.mystik\\maps\\" + filename[qi];
/*      */         try
/*      */         {
/*  685 */           fr = new FileReader(listFilenames);
/*      */         } catch (FileNotFoundException fne) {
/*  687 */           fne.printStackTrace();
/*      */         }
/*  689 */         StringBuffer sb = new StringBuffer();
/*  690 */         char[] b = new char[1000];
/*  691 */         int n = 0;
/*      */         try {
/*  693 */           while ((n = fr.read(b)) > 0)
/*  694 */             sb.append(b, 0, n);
/*      */         }
/*      */         catch (IOException rex) {
/*  697 */           rex.printStackTrace();
/*      */         }
/*  699 */         String fileString = sb.toString();
/*      */         try
/*      */         {
/*  703 */           dataArray[qi] = ((Data)new Gson().fromJson(fileString, Data.class));
/*      */         } catch (Exception er) {
/*  705 */           er.printStackTrace();
/*      */         }
/*      */ 
/*  713 */         howManyFiles++;
/*      */         try
/*      */         {
/*  718 */           data = (Data)new Gson().fromJson(fileString, Data.class);
/*      */         } catch (Exception er) {
/*  720 */           er.printStackTrace();
/*      */         }
/*      */ 
/*  728 */         this.maplist.add(Integer.toString(((NumberLoad)data.getIDS().get(0)).getCurrentMap()));
/*      */         try
/*      */         {
/*  731 */           String mapToMatch = System.getenv("APPDATA") + "\\.mystik\\maps\\main.txt";
/*      */ 
/*  733 */           if (mapToMatch.equals(listFilenames))
/*  734 */             fileNow = fileString;
/*      */         }
/*      */         catch (Exception erxx) {
/*  737 */           erxx.printStackTrace();
/*      */         }
/*      */ 
/*  742 */         String[] wepN = new String[100];
/*  743 */         String[] wepX = new String[100];
/*  744 */         String[] wepY = new String[100];
/*      */ 
/*  746 */         int[] tile = new int[256];
/*      */ 
/*  750 */         int wepQty = 0;
/*      */         try
/*      */         {
/*  753 */           for (int ci = 0; ci < wepN.length; ci++)
/*      */           {
/*  755 */             if ((((ItemLoad)data.getItems().get(ci)).getID() == null) || ("".equals(((ItemLoad)data.getItems().get(ci)).getID()))) {
/*  756 */               System.out.println("There was an error processing ITEMS");
/*  757 */               break;
/*      */             }
/*      */ 
/*  760 */             wepN[ci] = ((ItemLoad)data.getItems().get(ci)).getID();
/*  761 */             wepX[ci] = Integer.toString(((ItemLoad)data.getItems().get(ci)).getX());
/*  762 */             wepY[ci] = Integer.toString(((ItemLoad)data.getItems().get(ci)).getY());
/*      */ 
/*  765 */             wepQty++;
/*      */           }
/*      */ 
/*      */         }
/*      */         catch (Exception localException1)
/*      */         {
/*      */         }
/*      */ 
/*  773 */         String[] monN = new String[100];
/*  774 */         String[] monX = new String[100];
/*  775 */         String[] monY = new String[100];
/*      */ 
/*  778 */         int monQty = 0;
/*      */         try
/*      */         {
/*  781 */           for (int moni = 0; moni < monN.length; moni++) {
/*  782 */             if ((((MonsterLoad)data.getMonsters().get(moni)).getID() == null) || ("".equals(((MonsterLoad)data.getMonsters().get(moni)).getID()))) {
/*  783 */               System.out.println("There was an error processing MONSTERS");
/*  784 */               break;
/*      */             }
/*      */ 
/*  787 */             monN[moni] = ((MonsterLoad)data.getMonsters().get(moni)).getID();
/*  788 */             monX[moni] = Integer.toString(((MonsterLoad)data.getMonsters().get(moni)).getX());
/*  789 */             monY[moni] = Integer.toString(((MonsterLoad)data.getMonsters().get(moni)).getY());
/*      */ 
/*  791 */             monQty++;
/*      */           }
/*      */         }
/*      */         catch (Exception localException2)
/*      */         {
/*      */         }
/*  797 */         String[] signY = new String[100];
/*  798 */         String[] signX = new String[100];
/*  799 */         String[] signText = new String[100];
/*  800 */         String[] signMap = new String[100];
/*      */ 
/*  802 */         int signQty = 0;
/*      */         try
/*      */         {
/*  805 */           for (int signI = 0; signI < signX.length; signI++)
/*      */           {
/*  807 */             signX[signI] = Integer.toString(((SignLoad)data.getSigns().get(signI)).getSignX());
/*  808 */             signY[signI] = Integer.toString(((SignLoad)data.getSigns().get(signI)).getSignY());
/*  809 */             signText[signI] = ((SignLoad)data.getSigns().get(signI)).getSignText();
/*      */ 
/*  813 */             signQty++;
/*      */           }
/*      */         }
/*      */         catch (Exception localException3)
/*      */         {
/*      */         }
/*  819 */         String[] entY = new String[100];
/*  820 */         String[] entX = new String[100];
/*  821 */         String[] tile_after_ent = new String[100];
/*  822 */         String[] entItemReq = new String[100];
/*      */ 
/*  825 */         int entQty = 0;
/*      */         try
/*      */         {
/*  828 */           for (int enti = 0; enti < entY.length; enti++)
/*      */           {
/*  830 */             entX[enti] = Integer.toString(((EntranceLoad)data.getEntrances().get(enti)).getEntX());
/*  831 */             entY[enti] = Integer.toString(((EntranceLoad)data.getEntrances().get(enti)).getEntY());
/*  832 */             tile_after_ent[enti] = Integer.toString(((EntranceLoad)data.getEntrances().get(enti)).getTileAfter());
/*  833 */             entItemReq[enti] = Integer.toString(((EntranceLoad)data.getEntrances().get(enti)).getItemReq_ent());
/*      */ 
/*  836 */             entQty++;
/*      */           }
/*      */         }
/*      */         catch (Exception localException4)
/*      */         {
/*      */         }
/*      */ 
/*  843 */         String[] toY = new String[100];
/*  844 */         String[] toX = new String[100];
/*  845 */         String[] toMap = new String[100];
/*  846 */         String[] fromY = new String[100];
/*  847 */         String[] fromX = new String[100];
/*  848 */         String[] fromMap = new String[100];
/*  849 */         String[] item_req = new String[100];
/*      */ 
/*  851 */         int teleQty = 0;
/*      */         try
/*      */         {
/*  854 */           for (int teleI = 0; teleI < entY.length; teleI++)
/*      */           {
/*  856 */             toX[teleI] = Integer.toString(((TeleportLoad)data.getTeleports().get(teleI)).getToX());
/*  857 */             toY[teleI] = Integer.toString(((TeleportLoad)data.getTeleports().get(teleI)).getToY());
/*  858 */             toMap[teleI] = Integer.toString(((TeleportLoad)data.getTeleports().get(teleI)).getToMap());
/*  859 */             fromY[teleI] = Integer.toString(((TeleportLoad)data.getTeleports().get(teleI)).getFromY());
/*  860 */             fromX[teleI] = Integer.toString(((TeleportLoad)data.getTeleports().get(teleI)).getFromX());
/*  861 */             fromMap[teleI] = Integer.toString(((TeleportLoad)data.getTeleports().get(teleI)).getFromMap());
/*  862 */             item_req[teleI] = Integer.toString(((TeleportLoad)data.getTeleports().get(teleI)).getItemReq());
/*      */ 
/*  864 */             teleQty++;
/*      */           }
/*      */ 
/*      */         }
/*      */         catch (Exception localException5)
/*      */         {
/*      */         }
/*      */ 
/*  875 */         for (int ai = 0; ai < signQty; ai++)
/*      */         {
/*  877 */           addSignNow(Integer.parseInt(signX[ai]), Integer.parseInt(signY[ai]), signText[ai], ((NumberLoad)data.getIDS().get(0)).getCurrentMap());
/*      */         }
/*      */ 
/*  888 */         for (int bi = 0; bi < wepQty; bi++)
/*      */         {
/*  890 */           dropItem(Integer.parseInt(wepN[bi]), Integer.parseInt(wepX[bi]), Integer.parseInt(wepY[bi]), ((NumberLoad)data.getIDS().get(0)).getCurrentMap());
/*      */         }
/*      */ 
/*  898 */         for (int mi = 0; mi < monQty; mi++) {
/*  899 */           addMonster(Integer.parseInt(monN[mi]), Integer.parseInt(monX[mi]), Integer.parseInt(monY[mi]), ((NumberLoad)data.getIDS().get(0)).getCurrentMap());
/*      */         }
/*      */ 
/*  908 */         for (int ei = 0; ei < entQty; ei++)
/*      */         {
/*  911 */           if (entItemReq[ei].equals("0"))
/*      */           {
/*  913 */             addEntrance(Integer.parseInt(entX[ei]), Integer.parseInt(entY[ei]), Integer.parseInt(tile_after_ent[ei]));
/*      */           }
/*  915 */           else addEntranceItem(Integer.parseInt(entX[ei]), Integer.parseInt(entY[ei]), Integer.parseInt(tile_after_ent[ei]), Integer.parseInt(entItemReq[ei]));
/*      */ 
/*      */         }
/*      */ 
/*  925 */         for (int ti = 0; ti < teleQty; ti++)
/*      */         {
/*  930 */           if (item_req[ti].equals("0"))
/*  931 */             addTeleport(Integer.parseInt(fromX[ti]), Integer.parseInt(fromY[ti]), Integer.parseInt(fromMap[ti]), Integer.parseInt(toX[ti]), Integer.parseInt(toY[ti]), Integer.parseInt(toMap[ti]));
/*      */           else {
/*  933 */             addTeleportItem(Integer.parseInt(fromX[ti]), Integer.parseInt(fromY[ti]), Integer.parseInt(fromMap[ti]), Integer.parseInt(toX[ti]), Integer.parseInt(toY[ti]), Integer.parseInt(toMap[ti]), Integer.parseInt(item_req[ti]));
/*      */           }
/*      */ 
/*      */         }
/*      */ 
/*      */       }
/*      */ 
/*  944 */       ActionListener leftArmListener = new ActionListener()
/*      */       {
/*      */         public void actionPerformed(ActionEvent event)
/*      */         {
/*  949 */           String invAction = event.getActionCommand();
/*      */ 
/*  952 */           Game.c.append("\nClicking on... " + invAction);
/*      */ 
/*  954 */           Object actItem = Integer.valueOf(Game.this.leftArmWear + 1);
/*      */ 
/*  956 */           boolean isDropping = invAction.startsWith("Drop");
/*  957 */           boolean isUnequipping = invAction.startsWith("Unequip");
/*      */ 
/*  959 */           String rightclickDrop = Game.this.getItem(actItem.toString())[8];
/*      */ 
/*  961 */           int rightStrDrop = Integer.parseInt(rightclickDrop);
/*      */ 
/*  963 */           if (isDropping) {
/*  964 */             Game.c.append("\nYou unequipped and dropped a " + Game.this.getItem(actItem.toString())[0] + ".");
/*  965 */             Game.this.dropItemNow(rightStrDrop, Game.this.spawnX, Game.this.spawnY);
/*  966 */             Game.this.btLeftArmIcon.setIcon(new ImageIcon(Game.this.other[0]));
/*  967 */             Game.this.btLeftArmIcon.setToolTipText("N/A");
/*  968 */             Game.this.subAttack(Integer.parseInt(Game.this.getItem(actItem.toString())[3]));
/*  969 */             Game.this.leftArmWear = 0;
/*  970 */             Game.this.repaint();
/*      */           }
/*      */ 
/*  973 */           if (isUnequipping) {
/*  974 */             Game.c.append("\nYou unequipped your " + Game.this.getItem(actItem.toString())[0] + ".");
/*  975 */             Game.this.btLeftArmIcon.setIcon(new ImageIcon(Game.this.other[0]));
/*  976 */             Game.this.btLeftArmIcon.setToolTipText("N/A");
/*  977 */             Game.this.model.addElement(Game.this.getItem(actItem.toString())[0]);
/*  978 */             Game.this.subAttack(Integer.parseInt(Game.this.getItem(actItem.toString())[3]));
/*  979 */             Game.this.leftArmWear = 0;
/*  980 */             Game.this.repaint();
/*      */           }
/*      */         }
/*      */       };
/*  988 */       this.useUsePopup = new JPopupMenu();
/*  989 */       this.useDropPopup = new JPopupMenu();
/*  990 */       this.useCancelPopup = new JPopupMenu();
/*  991 */       this.useUnequipPopup = new JPopupMenu();
/*  992 */       this.useWearPopup = new JPopupMenu();
/*      */ 
/*  994 */       this.leftArmPopup = new JPopupMenu();
/*      */ 
/*  996 */       this.useMenuItem = new JMenuItem("Use");
/*  997 */       this.useMenuItem.addActionListener(leftArmListener);
/*      */ 
/*  999 */       this.unequipMenuItem = new JMenuItem("Unequip");
/* 1000 */       this.unequipMenuItem.addActionListener(leftArmListener);
/*      */ 
/* 1002 */       this.dropMenuItem = new JMenuItem("Drop");
/* 1003 */       this.dropMenuItem.addActionListener(leftArmListener);
/*      */ 
/* 1005 */       this.cancelMenuItem = new JMenuItem("Cancel");
/* 1006 */       this.cancelMenuItem.addActionListener(leftArmListener);
/*      */       try
/*      */       {
/* 1011 */         dataNow = (Data)new Gson().fromJson(fileNow, Data.class);
/*      */       } catch (Exception er) {
/* 1013 */         er.printStackTrace();
/*      */       }
/*      */ 
/* 1016 */       String inputFileLocation = System.getenv("APPDATA") + "\\.mystik\\items.gif";
/* 1017 */       BufferedImage originalImage = readImage(inputFileLocation);
/* 1018 */       this.other = new Image[1];
/*      */       try
/*      */       {
/* 1021 */         for (int xi = 0; xi < 1; xi++) {
/* 1022 */           int cropHeight = 32;
/* 1023 */           int cropWidth = 32;
/* 1024 */           int cropStartX = xi * 32;
/* 1025 */           int cropStartY = 32;
/*      */ 
/* 1027 */           BufferedImage processedImage = cropMyImage(originalImage, cropWidth, cropHeight, cropStartX, cropStartY);
/* 1028 */           this.other[xi] = processedImage;
/*      */         }
/*      */       } catch (Exception loadCrop) {
/* 1031 */         loadCrop.printStackTrace();
/*      */       }
/*      */ 
/* 1034 */       this.pnPanel0 = new JPanel();
/* 1035 */       this.pnPanel0.setBackground(Color.RED);
/* 1036 */       this.pnPanel0.setOpaque(false);
/* 1037 */       GridBagLayout gbPanel0 = new GridBagLayout();
/*      */ 
/* 1039 */       GridBagConstraints gbcPanel0 = new GridBagConstraints();
/* 1040 */       this.pnPanel0.setLayout(gbPanel0);
/*      */ 
/* 1045 */       this.pnPanel3 = new JPanel();
/* 1046 */       this.pnPanel3.setBackground(Color.YELLOW);
/* 1047 */       this.pnPanel3.setOpaque(false);
/* 1048 */       GridBagLayout gbPanel3 = new GridBagLayout();
/* 1049 */       GridBagConstraints gbcPanel3 = new GridBagConstraints();
/* 1050 */       this.pnPanel3.setLayout(gbPanel3);
/*      */ 
/* 1052 */       this.pnHeadInfoPanel = new JPanel();
/* 1053 */       this.pnHeadInfoPanel.setBorder(BorderFactory.createTitledBorder("Head"));
/* 1054 */       this.pnHeadInfoPanel.setOpaque(false);
/*      */ 
/* 1056 */       GridBagLayout gbHeadInfoPanel = new GridBagLayout();
/* 1057 */       GridBagConstraints gbcHeadInfoPanel = new GridBagConstraints();
/* 1058 */       gbcHeadInfoPanel.weightx = 11.0D;
/* 1059 */       gbcHeadInfoPanel.weighty = 11.0D;
/* 1060 */       this.pnHeadInfoPanel.setLayout(gbHeadInfoPanel);
/*      */ 
/* 1062 */       this.btHeadIcon = new JButton("");
/* 1063 */       this.btHeadIcon.setIcon(new ImageIcon(this.other[0]));
/* 1064 */       this.btHeadIcon.setToolTipText("N/A");
/* 1065 */       this.btHeadIcon.setBorderPainted(false);
/* 1066 */       this.btHeadIcon.setDefaultCapable(false);
/* 1067 */       this.btHeadIcon.setDoubleBuffered(true);
/* 1068 */       this.btHeadIcon.setFocusPainted(false);
/* 1069 */       this.btHeadIcon.setIconTextGap(0);
/* 1070 */       this.btHeadIcon.setBackground(Color.white);
/* 1071 */       gbcHeadInfoPanel.gridx = 0;
/* 1072 */       gbcHeadInfoPanel.gridy = 0;
/* 1073 */       gbcHeadInfoPanel.gridwidth = 3;
/* 1074 */       gbcHeadInfoPanel.gridheight = 3;
/* 1075 */       gbcHeadInfoPanel.fill = 1;
/* 1076 */       gbcHeadInfoPanel.weightx = 1.0D;
/* 1077 */       gbcHeadInfoPanel.weighty = 0.0D;
/* 1078 */       gbcHeadInfoPanel.anchor = 11;
/* 1079 */       gbHeadInfoPanel.setConstraints(this.btHeadIcon, gbcHeadInfoPanel);
/* 1080 */       this.pnHeadInfoPanel.add(this.btHeadIcon);
/* 1081 */       gbcPanel3.gridx = 1;
/* 1082 */       gbcPanel3.gridy = 4;
/* 1083 */       gbcPanel3.gridwidth = 3;
/* 1084 */       gbcPanel3.gridheight = 3;
/* 1085 */       gbcPanel3.fill = 1;
/* 1086 */       gbcPanel3.weightx = 1.0D;
/* 1087 */       gbcPanel3.weighty = 0.0D;
/* 1088 */       gbcPanel3.insets = new Insets(0, 5, 5, 5);
/* 1089 */       gbcPanel3.anchor = 11;
/* 1090 */       gbPanel3.setConstraints(this.pnHeadInfoPanel, gbcPanel3);
/* 1091 */       this.pnPanel3.add(this.pnHeadInfoPanel);
/*      */ 
/* 1093 */       this.lbLabel0 = new JLabel("Character Information", 0);
/* 1094 */       gbcPanel3.gridx = 1;
/* 1095 */       gbcPanel3.gridy = 1;
/* 1096 */       gbcPanel3.gridwidth = 18;
/* 1097 */       gbcPanel3.gridheight = 2;
/* 1098 */       gbcPanel3.fill = 1;
/* 1099 */       gbcPanel3.weightx = 1.0D;
/* 1100 */       gbcPanel3.weighty = 1.0D;
/* 1101 */       gbcPanel3.anchor = 10;
/* 1102 */       gbPanel3.setConstraints(this.lbLabel0, gbcPanel3);
/* 1103 */       this.pnPanel3.add(this.lbLabel0);
/*      */ 
/* 1105 */       this.pnBodyInfoPanel = new JPanel();
/* 1106 */       this.pnBodyInfoPanel.setBorder(BorderFactory.createTitledBorder("Body"));
/* 1107 */       this.pnBodyInfoPanel.setOpaque(false);
/* 1108 */       GridBagLayout gbBodyInfoPanel = new GridBagLayout();
/* 1109 */       GridBagConstraints gbcBodyInfoPanel = new GridBagConstraints();
/* 1110 */       this.pnBodyInfoPanel.setLayout(gbBodyInfoPanel);
/*      */ 
/* 1112 */       this.btBodyIcon = new JButton("");
/* 1113 */       this.btBodyIcon.setIcon(new ImageIcon(this.other[0]));
/* 1114 */       this.btBodyIcon.setToolTipText("N/A");
/* 1115 */       this.btBodyIcon.setBorderPainted(false);
/* 1116 */       this.btBodyIcon.setDefaultCapable(false);
/* 1117 */       this.btBodyIcon.setDoubleBuffered(true);
/* 1118 */       this.btBodyIcon.setFocusPainted(false);
/* 1119 */       this.btBodyIcon.setIconTextGap(0);
/* 1120 */       this.btBodyIcon.setBackground(Color.white);
/* 1121 */       gbcBodyInfoPanel.gridx = 0;
/* 1122 */       gbcBodyInfoPanel.gridy = 0;
/* 1123 */       gbcBodyInfoPanel.gridwidth = 3;
/* 1124 */       gbcBodyInfoPanel.gridheight = 3;
/* 1125 */       gbcBodyInfoPanel.fill = 1;
/* 1126 */       gbcBodyInfoPanel.weightx = 1.0D;
/* 1127 */       gbcBodyInfoPanel.weighty = 0.0D;
/* 1128 */       gbcBodyInfoPanel.anchor = 11;
/* 1129 */       gbBodyInfoPanel.setConstraints(this.btBodyIcon, gbcBodyInfoPanel);
/* 1130 */       this.pnBodyInfoPanel.add(this.btBodyIcon);
/* 1131 */       gbcPanel3.gridx = 1;
/* 1132 */       gbcPanel3.gridy = 8;
/* 1133 */       gbcPanel3.gridwidth = 3;
/* 1134 */       gbcPanel3.gridheight = 3;
/* 1135 */       gbcPanel3.fill = 1;
/* 1136 */       gbcPanel3.weightx = 1.0D;
/* 1137 */       gbcPanel3.weighty = 0.0D;
/* 1138 */       gbcPanel3.anchor = 11;
/* 1139 */       gbPanel3.setConstraints(this.pnBodyInfoPanel, gbcPanel3);
/* 1140 */       this.pnPanel3.add(this.pnBodyInfoPanel);
/*      */ 
/* 1142 */       this.pnLeftArmInfoPanel = new JPanel();
/* 1143 */       this.pnLeftArmInfoPanel.setBorder(BorderFactory.createTitledBorder("Left Arm"));
/* 1144 */       this.pnLeftArmInfoPanel.setOpaque(false);
/* 1145 */       GridBagLayout gbLeftArmInfoPanel = new GridBagLayout();
/* 1146 */       GridBagConstraints gbcLeftArmInfoPanel = new GridBagConstraints();
/* 1147 */       this.pnLeftArmInfoPanel.setLayout(gbLeftArmInfoPanel);
/*      */ 
/* 1149 */       this.btLeftArmIcon = new JButton("");
/* 1150 */       this.btLeftArmIcon.setIcon(new ImageIcon(this.other[0]));
/* 1151 */       this.btLeftArmIcon.setToolTipText("N/A");
/* 1152 */       this.btLeftArmIcon.setBorderPainted(false);
/* 1153 */       this.btLeftArmIcon.setDefaultCapable(false);
/* 1154 */       this.btLeftArmIcon.setDoubleBuffered(true);
/* 1155 */       this.btLeftArmIcon.setFocusPainted(false);
/* 1156 */       this.btLeftArmIcon.setIconTextGap(0);
/* 1157 */       this.btLeftArmIcon.setBackground(Color.white);
/* 1158 */       this.btLeftArmIcon.addMouseListener(new LeftArmListener());
/* 1159 */       gbcLeftArmInfoPanel.gridx = 0;
/* 1160 */       gbcLeftArmInfoPanel.gridy = 0;
/* 1161 */       gbcLeftArmInfoPanel.gridwidth = 3;
/* 1162 */       gbcLeftArmInfoPanel.gridheight = 3;
/* 1163 */       gbcLeftArmInfoPanel.fill = 1;
/* 1164 */       gbcLeftArmInfoPanel.weightx = 1.0D;
/* 1165 */       gbcLeftArmInfoPanel.weighty = 0.0D;
/* 1166 */       gbcLeftArmInfoPanel.anchor = 11;
/* 1167 */       gbLeftArmInfoPanel.setConstraints(this.btLeftArmIcon, gbcLeftArmInfoPanel);
/* 1168 */       this.pnLeftArmInfoPanel.add(this.btLeftArmIcon);
/* 1169 */       gbcPanel3.gridx = 5;
/* 1170 */       gbcPanel3.gridy = 8;
/* 1171 */       gbcPanel3.gridwidth = 3;
/* 1172 */       gbcPanel3.gridheight = 3;
/* 1173 */       gbcPanel3.fill = 1;
/* 1174 */       gbcPanel3.weightx = 1.0D;
/* 1175 */       gbcPanel3.weighty = 0.0D;
/* 1176 */       gbcPanel3.anchor = 11;
/* 1177 */       gbPanel3.setConstraints(this.pnLeftArmInfoPanel, gbcPanel3);
/* 1178 */       this.pnPanel3.add(this.pnLeftArmInfoPanel);
/*      */ 
/* 1180 */       this.pnRightArmInfoPanel = new JPanel();
/* 1181 */       this.pnRightArmInfoPanel.setBorder(BorderFactory.createTitledBorder("Right Arm"));
/* 1182 */       this.pnRightArmInfoPanel.setOpaque(false);
/* 1183 */       GridBagLayout gbRightArmInfoPanel = new GridBagLayout();
/* 1184 */       GridBagConstraints gbcRightArmInfoPanel = new GridBagConstraints();
/* 1185 */       this.pnRightArmInfoPanel.setLayout(gbRightArmInfoPanel);
/*      */ 
/* 1187 */       this.btRightArmIcon = new JButton("");
/* 1188 */       this.btRightArmIcon.setIcon(new ImageIcon(this.other[0]));
/* 1189 */       this.btRightArmIcon.setToolTipText("N/A");
/* 1190 */       this.btRightArmIcon.setBorderPainted(false);
/* 1191 */       this.btRightArmIcon.setDefaultCapable(false);
/* 1192 */       this.btRightArmIcon.setDoubleBuffered(true);
/* 1193 */       this.btRightArmIcon.setFocusPainted(false);
/* 1194 */       this.btRightArmIcon.setIconTextGap(0);
/* 1195 */       this.btRightArmIcon.setBackground(Color.white);
/* 1196 */       gbcRightArmInfoPanel.gridx = 0;
/* 1197 */       gbcRightArmInfoPanel.gridy = 0;
/* 1198 */       gbcRightArmInfoPanel.gridwidth = 3;
/* 1199 */       gbcRightArmInfoPanel.gridheight = 3;
/* 1200 */       gbcRightArmInfoPanel.fill = 1;
/* 1201 */       gbcRightArmInfoPanel.weightx = 1.0D;
/* 1202 */       gbcRightArmInfoPanel.weighty = 0.0D;
/* 1203 */       gbcRightArmInfoPanel.anchor = 11;
/* 1204 */       gbRightArmInfoPanel.setConstraints(this.btRightArmIcon, gbcRightArmInfoPanel);
/* 1205 */       this.pnRightArmInfoPanel.add(this.btRightArmIcon);
/* 1206 */       gbcPanel3.gridx = 5;
/* 1207 */       gbcPanel3.gridy = 12;
/* 1208 */       gbcPanel3.gridwidth = 3;
/* 1209 */       gbcPanel3.gridheight = 3;
/* 1210 */       gbcPanel3.fill = 1;
/* 1211 */       gbcPanel3.weightx = 1.0D;
/* 1212 */       gbcPanel3.weighty = 0.0D;
/* 1213 */       gbcPanel3.anchor = 11;
/* 1214 */       gbPanel3.setConstraints(this.pnRightArmInfoPanel, gbcPanel3);
/* 1215 */       this.pnPanel3.add(this.pnRightArmInfoPanel);
/*      */ 
/* 1217 */       this.pnLegsInfoPanel = new JPanel();
/* 1218 */       this.pnLegsInfoPanel.setBorder(BorderFactory.createTitledBorder("Legs"));
/* 1219 */       this.pnLegsInfoPanel.setOpaque(false);
/* 1220 */       GridBagLayout gbLegsInfoPanel = new GridBagLayout();
/* 1221 */       GridBagConstraints gbcLegsInfoPanel = new GridBagConstraints();
/* 1222 */       this.pnLegsInfoPanel.setLayout(gbLegsInfoPanel);
/*      */ 
/* 1224 */       this.btLegsIcon = new JButton("");
/* 1225 */       this.btLegsIcon.setIcon(new ImageIcon(this.other[0]));
/* 1226 */       this.btLegsIcon.setToolTipText("derp");
/* 1227 */       this.btLegsIcon.setBorderPainted(false);
/* 1228 */       this.btLegsIcon.setDefaultCapable(false);
/* 1229 */       this.btLegsIcon.setDoubleBuffered(true);
/* 1230 */       this.btLegsIcon.setFocusPainted(false);
/* 1231 */       this.btLegsIcon.setIconTextGap(0);
/* 1232 */       this.btLegsIcon.setBackground(Color.white);
/* 1233 */       gbcLegsInfoPanel.gridx = 0;
/* 1234 */       gbcLegsInfoPanel.gridy = 0;
/* 1235 */       gbcLegsInfoPanel.gridwidth = 3;
/* 1236 */       gbcLegsInfoPanel.gridheight = 3;
/* 1237 */       gbcLegsInfoPanel.fill = 1;
/* 1238 */       gbcLegsInfoPanel.weightx = 1.0D;
/* 1239 */       gbcLegsInfoPanel.weighty = 0.0D;
/* 1240 */       gbcLegsInfoPanel.anchor = 11;
/* 1241 */       gbLegsInfoPanel.setConstraints(this.btLegsIcon, gbcLegsInfoPanel);
/* 1242 */       this.pnLegsInfoPanel.add(this.btLegsIcon);
/* 1243 */       gbcPanel3.gridx = 1;
/* 1244 */       gbcPanel3.gridy = 12;
/* 1245 */       gbcPanel3.gridwidth = 3;
/* 1246 */       gbcPanel3.gridheight = 3;
/* 1247 */       gbcPanel3.fill = 1;
/* 1248 */       gbcPanel3.weightx = 1.0D;
/* 1249 */       gbcPanel3.weighty = 0.0D;
/* 1250 */       gbcPanel3.anchor = 11;
/* 1251 */       gbPanel3.setConstraints(this.pnLegsInfoPanel, gbcPanel3);
/* 1252 */       this.pnPanel3.add(this.pnLegsInfoPanel);
/*      */ 
/* 1254 */       this.pbExpBar = new JProgressBar();
/* 1255 */       this.pbExpBar.setValue(90);
/* 1256 */       this.pbExpBar.setStringPainted(true);
/* 1257 */       gbcPanel3.gridx = 1;
/* 1258 */       gbcPanel3.gridy = 17;
/* 1259 */       gbcPanel3.gridwidth = 13;
/* 1260 */       gbcPanel3.gridheight = 2;
/* 1261 */       gbcPanel3.fill = 1;
/* 1262 */       gbcPanel3.weightx = 1.0D;
/* 1263 */       gbcPanel3.weighty = 0.0D;
/* 1264 */       gbcPanel3.anchor = 11;
/* 1265 */       gbPanel3.setConstraints(this.pbExpBar, gbcPanel3);
/* 1266 */       this.pnPanel3.add(this.pbExpBar);
/*      */ 
/* 1268 */       this.pnPanel12 = new JPanel();
/* 1269 */       this.pnPanel12.setPreferredSize(new Dimension(115, 200));
/* 1270 */       this.pnPanel12.setBorder(BorderFactory.createTitledBorder("Information"));
/* 1271 */       this.pnPanel12.setOpaque(false);
/* 1272 */       GridBagLayout gbPanel12 = new GridBagLayout();
/* 1273 */       GridBagConstraints gbcPanel12 = new GridBagConstraints();
/* 1274 */       this.pnPanel12.setLayout(gbPanel12);
/*      */ 
/* 1276 */       this.lbLabel2 = new JLabel("Level:");
/* 1277 */       gbcPanel12.gridx = 1;
/* 1278 */       gbcPanel12.gridy = 1;
/* 1279 */       gbcPanel12.gridwidth = 3;
/* 1280 */       gbcPanel12.gridheight = 1;
/* 1281 */       gbcPanel12.fill = 1;
/* 1282 */       gbcPanel12.weightx = 1.0D;
/* 1283 */       gbcPanel12.weighty = 1.0D;
/* 1284 */       gbcPanel12.anchor = 11;
/* 1285 */       gbPanel12.setConstraints(this.lbLabel2, gbcPanel12);
/* 1286 */       this.pnPanel12.add(this.lbLabel2);
/*      */ 
/* 1288 */       this.lbLabel3 = new JLabel("EXP:");
/* 1289 */       gbcPanel12.gridx = 1;
/* 1290 */       gbcPanel12.gridy = 2;
/* 1291 */       gbcPanel12.gridwidth = 3;
/* 1292 */       gbcPanel12.gridheight = 1;
/* 1293 */       gbcPanel12.fill = 1;
/* 1294 */       gbcPanel12.weightx = 1.0D;
/* 1295 */       gbcPanel12.weighty = 1.0D;
/* 1296 */       gbcPanel12.anchor = 11;
/* 1297 */       gbPanel12.setConstraints(this.lbLabel3, gbcPanel12);
/* 1298 */       this.pnPanel12.add(this.lbLabel3);
/*      */ 
/* 1300 */       this.lbLabel4 = new JLabel("EXP left:    ");
/* 1301 */       gbcPanel12.gridx = 1;
/* 1302 */       gbcPanel12.gridy = 3;
/* 1303 */       gbcPanel12.gridwidth = 3;
/* 1304 */       gbcPanel12.gridheight = 1;
/* 1305 */       gbcPanel12.fill = 1;
/* 1306 */       gbcPanel12.weightx = 1.0D;
/* 1307 */       gbcPanel12.weighty = 1.0D;
/* 1308 */       gbcPanel12.anchor = 11;
/* 1309 */       gbPanel12.setConstraints(this.lbLabel4, gbcPanel12);
/* 1310 */       this.pnPanel12.add(this.lbLabel4);
/*      */ 
/* 1312 */       this.lbLabel5 = new JLabel("Gold:");
/* 1313 */       gbcPanel12.gridx = 1;
/* 1314 */       gbcPanel12.gridy = 5;
/* 1315 */       gbcPanel12.gridwidth = 3;
/* 1316 */       gbcPanel12.gridheight = 1;
/* 1317 */       gbcPanel12.fill = 1;
/* 1318 */       gbcPanel12.weightx = 1.0D;
/* 1319 */       gbcPanel12.weighty = 1.0D;
/* 1320 */       gbcPanel12.anchor = 11;
/* 1321 */       gbPanel12.setConstraints(this.lbLabel5, gbcPanel12);
/* 1322 */       this.pnPanel12.add(this.lbLabel5);
/*      */ 
/* 1324 */       this.lbLabel6 = new JLabel("Steps:");
/* 1325 */       gbcPanel12.gridx = 1;
/* 1326 */       gbcPanel12.gridy = 6;
/* 1327 */       gbcPanel12.gridwidth = 3;
/* 1328 */       gbcPanel12.gridheight = 1;
/* 1329 */       gbcPanel12.fill = 1;
/* 1330 */       gbcPanel12.weightx = 1.0D;
/* 1331 */       gbcPanel12.weighty = 1.0D;
/* 1332 */       gbcPanel12.anchor = 11;
/* 1333 */       gbPanel12.setConstraints(this.lbLabel6, gbcPanel12);
/* 1334 */       this.pnPanel12.add(this.lbLabel6);
/*      */ 
/* 1336 */       this.lbLabel7 = new JLabel("Kills:");
/* 1337 */       gbcPanel12.gridx = 1;
/* 1338 */       gbcPanel12.gridy = 8;
/* 1339 */       gbcPanel12.gridwidth = 3;
/* 1340 */       gbcPanel12.gridheight = 1;
/* 1341 */       gbcPanel12.fill = 1;
/* 1342 */       gbcPanel12.weightx = 1.0D;
/* 1343 */       gbcPanel12.weighty = 1.0D;
/* 1344 */       gbcPanel12.anchor = 11;
/* 1345 */       gbPanel12.setConstraints(this.lbLabel7, gbcPanel12);
/* 1346 */       this.pnPanel12.add(this.lbLabel7);
/*      */ 
/* 1348 */       this.lbLabel8 = new JLabel("Deaths:");
/* 1349 */       gbcPanel12.gridx = 1;
/* 1350 */       gbcPanel12.gridy = 9;
/* 1351 */       gbcPanel12.gridwidth = 3;
/* 1352 */       gbcPanel12.gridheight = 1;
/* 1353 */       gbcPanel12.fill = 1;
/* 1354 */       gbcPanel12.weightx = 1.0D;
/* 1355 */       gbcPanel12.weighty = 1.0D;
/* 1356 */       gbcPanel12.anchor = 11;
/* 1357 */       gbPanel12.setConstraints(this.lbLabel8, gbcPanel12);
/* 1358 */       this.pnPanel12.add(this.lbLabel8);
/*      */ 
/* 1360 */       this.lbLevelInfoLabel = new JLabel("0");
/* 1361 */       gbcPanel12.gridx = 4;
/* 1362 */       gbcPanel12.gridy = 1;
/* 1363 */       gbcPanel12.gridwidth = 5;
/* 1364 */       gbcPanel12.gridheight = 1;
/* 1365 */       gbcPanel12.fill = 1;
/* 1366 */       gbcPanel12.weightx = 1.0D;
/* 1367 */       gbcPanel12.weighty = 1.0D;
/* 1368 */       gbcPanel12.anchor = 11;
/* 1369 */       gbPanel12.setConstraints(this.lbLevelInfoLabel, gbcPanel12);
/* 1370 */       this.pnPanel12.add(this.lbLevelInfoLabel);
/*      */ 
/* 1372 */       this.lbExpInfoLabel = new JLabel("0");
/* 1373 */       gbcPanel12.gridx = 4;
/* 1374 */       gbcPanel12.gridy = 2;
/* 1375 */       gbcPanel12.gridwidth = 5;
/* 1376 */       gbcPanel12.gridheight = 1;
/* 1377 */       gbcPanel12.fill = 1;
/* 1378 */       gbcPanel12.weightx = 1.0D;
/* 1379 */       gbcPanel12.weighty = 1.0D;
/* 1380 */       gbcPanel12.anchor = 11;
/* 1381 */       gbPanel12.setConstraints(this.lbExpInfoLabel, gbcPanel12);
/* 1382 */       this.pnPanel12.add(this.lbExpInfoLabel);
/*      */ 
/* 1384 */       this.lbExpLeftInfoLabel = new JLabel("0");
/* 1385 */       gbcPanel12.gridx = 4;
/* 1386 */       gbcPanel12.gridy = 3;
/* 1387 */       gbcPanel12.gridwidth = 5;
/* 1388 */       gbcPanel12.gridheight = 1;
/* 1389 */       gbcPanel12.fill = 1;
/* 1390 */       gbcPanel12.weightx = 1.0D;
/* 1391 */       gbcPanel12.weighty = 1.0D;
/* 1392 */       gbcPanel12.anchor = 11;
/* 1393 */       gbPanel12.setConstraints(this.lbExpLeftInfoLabel, gbcPanel12);
/* 1394 */       this.pnPanel12.add(this.lbExpLeftInfoLabel);
/*      */ 
/* 1396 */       this.lbGoldInfoLabel = new JLabel("0");
/* 1397 */       gbcPanel12.gridx = 4;
/* 1398 */       gbcPanel12.gridy = 5;
/* 1399 */       gbcPanel12.gridwidth = 5;
/* 1400 */       gbcPanel12.gridheight = 1;
/* 1401 */       gbcPanel12.fill = 1;
/* 1402 */       gbcPanel12.weightx = 1.0D;
/* 1403 */       gbcPanel12.weighty = 1.0D;
/* 1404 */       gbcPanel12.anchor = 11;
/* 1405 */       gbPanel12.setConstraints(this.lbGoldInfoLabel, gbcPanel12);
/* 1406 */       this.pnPanel12.add(this.lbGoldInfoLabel);
/*      */ 
/* 1408 */       this.lbStepsInfoLabel = new JLabel("0");
/* 1409 */       gbcPanel12.gridx = 4;
/* 1410 */       gbcPanel12.gridy = 6;
/* 1411 */       gbcPanel12.gridwidth = 5;
/* 1412 */       gbcPanel12.gridheight = 1;
/* 1413 */       gbcPanel12.fill = 1;
/* 1414 */       gbcPanel12.weightx = 1.0D;
/* 1415 */       gbcPanel12.weighty = 1.0D;
/* 1416 */       gbcPanel12.anchor = 11;
/* 1417 */       gbPanel12.setConstraints(this.lbStepsInfoLabel, gbcPanel12);
/* 1418 */       this.pnPanel12.add(this.lbStepsInfoLabel);
/*      */ 
/* 1420 */       this.lbKillsInfoLabel = new JLabel("0");
/* 1421 */       gbcPanel12.gridx = 4;
/* 1422 */       gbcPanel12.gridy = 8;
/* 1423 */       gbcPanel12.gridwidth = 5;
/* 1424 */       gbcPanel12.gridheight = 1;
/* 1425 */       gbcPanel12.fill = 1;
/* 1426 */       gbcPanel12.weightx = 1.0D;
/* 1427 */       gbcPanel12.weighty = 1.0D;
/* 1428 */       gbcPanel12.anchor = 11;
/* 1429 */       gbPanel12.setConstraints(this.lbKillsInfoLabel, gbcPanel12);
/* 1430 */       this.pnPanel12.add(this.lbKillsInfoLabel);
/*      */ 
/* 1432 */       this.lbDeathsInfoLabel = new JLabel("0");
/* 1433 */       gbcPanel12.gridx = 4;
/* 1434 */       gbcPanel12.gridy = 9;
/* 1435 */       gbcPanel12.gridwidth = 5;
/* 1436 */       gbcPanel12.gridheight = 1;
/* 1437 */       gbcPanel12.fill = 1;
/* 1438 */       gbcPanel12.weightx = 1.0D;
/* 1439 */       gbcPanel12.weighty = 1.0D;
/* 1440 */       gbcPanel12.anchor = 11;
/* 1441 */       gbPanel12.setConstraints(this.lbDeathsInfoLabel, gbcPanel12);
/* 1442 */       this.pnPanel12.add(this.lbDeathsInfoLabel);
/* 1443 */       gbcPanel3.gridx = 9;
/* 1444 */       gbcPanel3.gridy = 4;
/* 1445 */       gbcPanel3.gridwidth = 10;
/* 1446 */       gbcPanel3.gridheight = 11;
/* 1447 */       gbcPanel3.fill = 1;
/* 1448 */       gbcPanel3.weightx = 1.0D;
/* 1449 */       gbcPanel3.weighty = 0.0D;
/* 1450 */       gbcPanel3.anchor = 11;
/* 1451 */       gbPanel3.setConstraints(this.pnPanel12, gbcPanel3);
/* 1452 */       this.pnPanel3.add(this.pnPanel12);
/*      */ 
/* 1454 */       this.btInfoOK = new JButton("OK");
/* 1455 */       gbcPanel3.gridx = 15;
/* 1456 */       gbcPanel3.gridy = 17;
/* 1457 */       gbcPanel3.gridwidth = 4;
/* 1458 */       gbcPanel3.gridheight = 2;
/* 1459 */       gbcPanel3.fill = 1;
/* 1460 */       gbcPanel3.weightx = 1.0D;
/* 1461 */       gbcPanel3.weighty = 0.0D;
/* 1462 */       gbcPanel3.anchor = 11;
/* 1463 */       gbPanel3.setConstraints(this.btInfoOK, gbcPanel3);
/* 1464 */       this.pnPanel3.add(this.btInfoOK);
/* 1465 */       gbcPanel0.gridx = 0;
/* 1466 */       gbcPanel0.gridy = 0;
/* 1467 */       gbcPanel0.gridwidth = 20;
/* 1468 */       gbcPanel0.gridheight = 20;
/* 1469 */       gbcPanel0.fill = 1;
/* 1470 */       gbcPanel0.weightx = 1.0D;
/* 1471 */       gbcPanel0.weighty = 0.0D;
/* 1472 */       gbcPanel0.anchor = 11;
/* 1473 */       gbPanel0.setConstraints(this.pnPanel3, gbcPanel0);
/* 1474 */       this.pnPanel0.add(this.pnPanel3);
/*      */ 
/* 1479 */       this.headIcon = new JButton();
/* 1480 */       JButton closedChar = new JButton("Close Character Sheet");
/* 1481 */       this.head = new JLabel("Head");
/* 1482 */       this.titleChar = new JLabel("Character Information");
/*      */ 
/* 1484 */       this.pnPanel0.setPreferredSize(new Dimension(300, 285));
/* 1485 */       this.charPanel.add(this.pnPanel0);
/*      */ 
/* 1488 */       closedChar.addActionListener(new ActionListener()
/*      */       {
/*      */         public void actionPerformed(ActionEvent e)
/*      */         {
/* 1492 */           Game.c.append("\nYou closed the Character Sheet.");
/* 1493 */           Game.this.charPanel.setVisible(false);
/* 1494 */           Game.this.charOpen = false;
/*      */         }
/*      */       });
/* 1498 */       this.charPanel.setPreferredSize(new Dimension(360, 300));
/* 1499 */       this.charPanel.setBackground(Color.WHITE);
/* 1500 */       this.charPanel.setVisible(false);
/*      */ 
/* 1505 */       for (int ji = 0; ji < howManyFiles; ji++)
/*      */       {
/* 1510 */         if (filename[ji].equals("main.txt")) {
/* 1511 */           System.out.println("Main detected....");
/* 1512 */           c.append("main.txt detected! Loading game bundle... ");
/*      */ 
/* 1514 */           mapToLoad = ((NumberLoad)dataNow.getIDS().get(0)).getCurrentMap();
/*      */ 
/* 1516 */           data.setTitle(dataNow.getTitle());
/* 1517 */           ((NumberLoad)data.getIDS().get(0)).setMapID(((NumberLoad)dataNow.getIDS().get(0)).getCurrentMap());
/*      */           try
/*      */           {
/* 1528 */             for (int row = 0; row < dataNow.getMap().length; row++)
/*      */             {
/* 1530 */               for (int col = 0; col < dataNow.getMap()[row].length; col++)
/*      */               {
/* 1532 */                 int index = dataNow.getMap()[row][col];
/*      */ 
/* 1537 */                 this.board[row][col] = index;
/*      */               }
/*      */ 
/*      */             }
/*      */ 
/*      */           }
/*      */           catch (Exception rere)
/*      */           {
/* 1545 */             rere.printStackTrace();
/*      */           }
/*      */ 
/*      */         }
/*      */ 
/*      */       }
/*      */ 
/*      */     }
/*      */ 
/* 1571 */     this.currentMap = mapToLoad;
/* 1572 */     this.spawnY = 7;
/* 1573 */     this.spawnX = 2;
/*      */ 
/* 1575 */     this.username = "Guest";
/*      */ 
/* 1580 */     this.extraSpace1 = new JLabel("--------", 2);
/* 1581 */     this.extraSpace2 = new JLabel("--------", 2);
/* 1582 */     this.extraSpace3 = new JLabel("--------", 2);
/* 1583 */     this.extraSpace4 = new JLabel("--------", 2);
/* 1584 */     this.extraSpace5 = new JLabel("--------", 2);
/* 1585 */     this.extraSpace6 = new JLabel("--------", 2);
/*      */ 
/* 1587 */     Border emptyBorder = BorderFactory.createEmptyBorder(5, 5, 0, 0);
/* 1588 */     this.statsPanel.setBorder(emptyBorder);
/*      */ 
/* 1591 */     this.lName = new JLabel("[" + this.username + "]", 0);
/* 1592 */     this.lHealth = new JLabel("Health [" + this.currhp + "/" + this.maxhp + "]", 2);
/* 1593 */     this.lLevel = new JLabel("Level [" + this.level + "]", 2);
/* 1594 */     this.lExp = new JLabel("EXP [" + this.exp + "]", 2);
/* 1595 */     this.lAttack = new JLabel("Attack [" + this.attack + "]", 2);
/* 1596 */     this.lDefence = new JLabel("Defense [" + this.defense + "]", 2);
/*      */ 
/* 1598 */     this.statsPanel.add(this.lName);
/*      */ 
/* 1600 */     this.statsPanel.add(this.lHealth);
/*      */ 
/* 1602 */     this.statsPanel.add(this.lLevel);
/*      */ 
/* 1604 */     this.statsPanel.add(this.lExp);
/*      */ 
/* 1606 */     this.statsPanel.add(this.lAttack);
/*      */ 
/* 1608 */     this.statsPanel.add(this.lDefence);
/*      */ 
/* 1650 */     this.game.setOpaque(false);
/*      */ 
/* 1654 */     c.append("\nWelcome to Mystik, " + this.username + "!");
				System.out.println("\nWelcome to Mystik, " + this.username + "!");
/*      */ 
/* 1658 */     addMouseListener(this);
/*      */     try
/*      */     {
/* 1661 */       this.tiles = new Image[523];
/* 1662 */       File[] filea = new File[523];
/*      */ 
/* 1688 */       for (int i = 0; i < 523; i++) {
/* 1689 */         Toolkit tk = getToolkit();
/* 1690 */         this.tiles[i] = tk.getImage(getClass().getResource(String.format("tiles/t%d.png", new Object[] { Integer.valueOf(i) })));
/*      */       }
/*      */ 
/* 1693 */       this.weapon = new Image[7];
/*      */ 
/* 1701 */       String inputFileLocation = System.getenv("APPDATA") + "\\.mystik\\items.gif";
/* 1702 */       BufferedImage originalImage = readImage(inputFileLocation);
/*      */ 
/* 1708 */       for (int xi = 0; xi < 7; xi++) {
/* 1709 */         int cropHeight = 32;
/* 1710 */         int cropWidth = 32;
/* 1711 */         int cropStartX = xi * 32;
/* 1712 */         int cropStartY = 0;
/*      */ 
/* 1714 */         BufferedImage processedImage = cropMyImage(originalImage, cropWidth, cropHeight, cropStartX, cropStartY);
/* 1715 */         this.weapon[xi] = processedImage;
/*      */       }
/*      */ 
/* 1724 */       inputFileLocation = System.getenv("APPDATA") + "\\.mystik\\monsters.gif";
/* 1725 */       originalImage = readImage(inputFileLocation);
/*      */ 
/* 1729 */       this.monster = new Image[18];
/*      */ 
/* 1731 */       for (int xi = 0; xi < 18; xi++) {
/* 1732 */         int cropHeight = 32;
/* 1733 */         int cropWidth = 32;
/* 1734 */         int cropStartX = xi * 32;
/* 1735 */         int cropStartY = 0;
/*      */ 
/* 1737 */         BufferedImage processedImage = cropMyImage(originalImage, cropWidth, cropHeight, cropStartX, cropStartY);
/* 1738 */         this.monster[xi] = processedImage;
/*      */       }
/*      */     }
/*      */     catch (Exception ex) {
/* 1742 */       ex.printStackTrace();
/*      */     }
/*      */ 
/* 1747 */     this.game.addKeyListener(this);
/* 1748 */     this.canMove = true;
/*      */ 
/* 1753 */     this.py = (this.spawnY * 32);
/* 1754 */     this.px = (this.spawnX * 32);
/*      */ 
/* 1756 */     this.lastY = this.spawnY;
/* 1757 */     this.lastX = this.spawnX;
/*      */ 
/* 1763 */     this.invOne.setVisible(true);
/*      */ 
/* 1769 */     this.labelStatus = new JLabel("Sorry, the game crashed!");
/*      */ 
/* 1771 */     this.labelStatus.setForeground(Color.WHITE.brighter());
/* 1772 */     this.statusPanel = new JPanel();
/* 1773 */     this.statusPanel.setBackground(Color.RED.darker());
/* 1774 */     this.statusPanel.add(this.labelStatus);
/* 1775 */     this.statusPanel.setPreferredSize(new Dimension(611, 511));
/* 1776 */     this.statusPanel.setOpaque(false);
/* 1777 */     this.labelStatus.setVisible(false);
/*      */ 
/* 1782 */     this.labelUser = new JLabel("Guest");
/* 1783 */     this.labelX = new JLabel("X: 10");
/* 1784 */     this.labelY = new JLabel("Y: 6");
/*      */     String loadMapText;
/* 1789 */     if (exists) {
/* 1790 */       this.labelRoom = new JLabel(data.getTitle());
/* 1791 */       loadMapText = "Map successfully loaded via <br />" + System.getenv("APPDATA") + "\\.mystik\\maps\\main.txt";
/*      */     } else {
/* 1793 */       this.labelRoom = new JLabel("Main");
/* 1794 */       loadMapText = "Map successfully created at <br />" + System.getenv("APPDATA") + "\\.mystik\\maps\\main.txt";
/*      */     }
/*      */ 
/* 1797 */     String html = "<html><h1 style='font: 15pt verdana;font-weight:bold; color:yellow;'>Welcome to Mystik, Guest!</h1>Thanks to <span style='color:yellow;font;weight:bold;'>David E Gervais</span> for his all-mighty graphics. He has made<br />pretty much everything you see, from tiles to weapons to monsters!<br /><br />Thanks to everyone on <span style='color:yellow;font;weight:bold;'>reddit</span> who've given me constructive <br />criticism and <span style='color:yellow;font;weight:bold;'>Stack Overflow</span> who've answered all of my questions.<br /><br />v2.1 brings multiple map support, bug fixes, signs, and more! <br />Read blog for more details. http://blog.mystikrpg.com<br /><br />" + 
/* 1803 */       loadMapText + 
/* 1804 */       "<br /><br />Press any arrow key to continue!</html>";
/* 1805 */     this.introLabel = new JLabel(html);
/* 1806 */     this.signLabel = new JLabel(this.signhtml);
/*      */ 
/* 1811 */     this.labelUser.setForeground(Color.WHITE);
/* 1812 */     this.userPanel = new JPanel();
/* 1813 */     this.userPanel.setBackground(Color.GREEN.darker());
/* 1814 */     this.userPanel.add(this.labelUser);
/* 1815 */     this.game.add(this.userPanel);
/*      */ 
/* 1817 */     this.labelX.setForeground(Color.BLACK);
/* 1818 */     this.xPanel = new JPanel();
/* 1819 */     this.xPanel.setBackground(Color.YELLOW.darker());
/* 1820 */     this.xPanel.add(this.labelX);
/* 1821 */     this.game.add(this.xPanel);
/*      */ 
/* 1823 */     this.labelY.setForeground(Color.RED.darker());
/* 1824 */     this.yPanel = new JPanel();
/* 1825 */     this.yPanel.setBackground(Color.WHITE);
/* 1826 */     this.yPanel.add(this.labelY);
/* 1827 */     this.game.add(this.yPanel);
/*      */ 
/* 1829 */     this.labelRoom.setForeground(Color.WHITE.brighter());
/* 1830 */     this.roomPanel = new JPanel();
/* 1831 */     this.roomPanel.setBackground(Color.BLACK.brighter());
/* 1832 */     this.roomPanel.add(this.labelRoom);
/* 1833 */     this.game.add(this.roomPanel);
/*      */ 
/* 1835 */     this.game.add(this.charPanel);
/*      */ 
/* 1837 */     this.signPanel = new JPanel();
/* 1838 */     this.signLabel.setForeground(Color.WHITE.brighter());
/*      */ 
/* 1841 */     this.signPanel.setBackground(new Color(0, 0, 0, 95));
/* 1842 */     this.signPanel.add(this.signLabel);
/*      */ 
/* 1845 */     this.signPanel.setPreferredSize(new Dimension(400, 240));
/* 1846 */     this.game.add(this.signPanel);
/* 1847 */     this.signPanel.setVisible(false);
/*      */ 
/* 1849 */     this.introPanel = new JPanel();
/* 1850 */     this.introLabel.setForeground(Color.WHITE.brighter());
/*      */ 
/* 1853 */     this.introPanel.setBackground(new Color(0, 0, 0, 95));
/* 1854 */     this.introPanel.add(this.introLabel);
/*      */ 
/* 1857 */     this.introPanel.setPreferredSize(new Dimension(400, 240));
/* 1858 */     this.game.add(this.introPanel);
/* 1859 */     this.introPanel.setVisible(true);
/*      */ 
/* 1861 */     this.gameOn = new JPanel();
/* 1862 */     this.gameOn.setBackground(Color.BLACK.brighter());
/* 1863 */     this.htmlx = "";
/* 1864 */     this.theUser = new JLabel(this.htmlx);
/* 1865 */     this.gameOn.setPreferredSize(new Dimension(390, 200));
/* 1866 */     this.gameOn.add(this.theUser);
/* 1867 */     this.game.add(this.gameOn);
/* 1868 */     this.gameOn.setOpaque(false);
/* 1869 */     this.theUser.setVisible(false);
/*      */ 
/* 1872 */     this.game.requestFocusInWindow();
/*      */ 
/* 1875 */     addtoInv("4");
/* 1876 */     addtoInv("6");
/*      */ 
/* 1882 */     repaint();
/*      */     try {
/* 1884 */       playerLogin(); 
} catch (IOException test) {
/* 1885 */       test.printStackTrace();
/* 1886 */     }repaint();
/*      */   }
/*      */ 
/*      */   public void start()
/*      */   {
/*      */   }
/*      */ 
/*      */   public static BufferedImage cropMyImage(BufferedImage img, int cropWidth, int cropHeight, int cropStartX, int cropStartY)
/*      */     throws Exception
/*      */   {
/* 1898 */     BufferedImage clipped = null;
/* 1899 */     Dimension size = new Dimension(cropWidth, cropHeight);
/*      */ 
/* 1901 */     createClip(img, size, cropStartX, cropStartY);
/*      */     try
/*      */     {
/* 1904 */       int w = clip.width;
/* 1905 */       int h = clip.height;
/*      */ 
/* 1911 */       clipped = img.getSubimage(clip.x, clip.y, w, h);
/*      */     }
/*      */     catch (RasterFormatException rfe)
/*      */     {
/* 1915 */       System.out.println("Raster format error: " + rfe.getMessage());
/* 1916 */       return null;
/*      */     }
/* 1918 */     return clipped;
/*      */   }
/*      */ 
/*      */   public void playerLogin()
/*      */     throws IOException
/*      */   {
/*      */     try
/*      */     {

/* 1927 */       this.me = new Player();
/*      */ 
/* 1929 */       me.setUsername("Guest");
/* 1930 */       this.me.setPlayerImage(ImageIO.read(getClass().getResource("me.gif")));
/* 1931 */       this.me.setX(224);
/* 1932 */       this.me.setY(352);
/* 1933 */       this.me.setMap(1);
/* 1934 */       this.me.setCommand("move");

/* 1935 */       this.players.put(this.me.getUsername(), this.me);
System.out.println("Trying to logun");
/* 1937 */       repaint();
/*      */ 
/* 1940 */       this.os.println(this.me.getUsername() + "|" + this.me.getX() + "|" + this.me.getY() + "|" + 
/* 1941 */         this.me.getMap() + "|" + this.me.getCommand());

System.out.println("Player DONE!!!");
/*      */     }
/*      */     catch (Exception localException)
/*      */     {
/*      */     }
/*      */   }
/*      */ 
/*      */   public void mousePressed(MouseEvent e)
/*      */   {
/*      */   }
/*      */ 
/*      */   public void mouseReleased(MouseEvent e)
/*      */   {
/*      */   }
/*      */ 
/*      */   public void mouseEntered(MouseEvent e)
/*      */   {
/*      */   }
/*      */ 
/*      */   public void mouseExited(MouseEvent e)
/*      */   {
/*      */   }
/*      */ 
/*      */   public void mouseClicked(MouseEvent e)
/*      */   {
/*      */   }
/*      */ 
/*      */   private static void createClip(BufferedImage img, Dimension size, int clipX, int clipY)
/*      */     throws Exception
/*      */   {
/* 2110 */     boolean isClipAreaAdjusted = false;
/*      */ 
/* 2113 */     if (clipX < 0) {
/* 2114 */       clipX = 0;
/* 2115 */       isClipAreaAdjusted = true;
/*      */     }
/*      */ 
/* 2118 */     if (clipY < 0) {
/* 2119 */       clipY = 0;
/* 2120 */       isClipAreaAdjusted = true;
/*      */     }
/*      */ 
/* 2124 */     if ((size.width + clipX <= img.getWidth()) && 
/* 2125 */       (size.height + clipY <= img.getHeight()))
/*      */     {
/* 2127 */       clip = new Rectangle(size);
/* 2128 */       clip.x = clipX;
/* 2129 */       clip.y = clipY;
/*      */     }
/*      */     else
/*      */     {
/* 2136 */       if (size.width + clipX > img.getWidth()) {
/* 2137 */         size.width = (img.getWidth() - clipX);
/*      */       }
/*      */ 
/* 2143 */       if (size.height + clipY > img.getHeight()) {
/* 2144 */         size.height = (img.getHeight() - clipY);
/*      */       }
/*      */ 
/* 2147 */       clip = new Rectangle(size);
/* 2148 */       clip.x = clipX;
/* 2149 */       clip.y = clipY;
/*      */ 
/* 2151 */       isClipAreaAdjusted = true;
/*      */     }
/*      */ 
/* 2154 */     if (isClipAreaAdjusted)
/* 2155 */       System.out.println("Crop Area Lied Outside The Image. Adjusted The Clip Rectangle\n");
/*      */   }
/*      */ 
/*      */   public static BufferedImage readImage(String fileLocation)
/*      */   {
/* 2160 */     BufferedImage img = null;
/*      */     try {
/* 2162 */       img = ImageIO.read(new File(fileLocation));
/*      */     }
/*      */     catch (IOException e) {
/* 2165 */       e.printStackTrace();
/*      */     }
/* 2167 */     return img;
/*      */   }
/*      */ 
/*      */   public void actionPerformed(ActionEvent actionevent)
/*      */   {
/* 2522 */     c.setCaretPosition(c.getDocument().getLength());
/*      */   }
/*      */ 
/*      */   public Player getPlayer(String username) {
/* 2526 */     return (Player)this.players.get(username);
/*      */   }
/*      */ 
/*      */   public void destroy()
/*      */   {
/*      */   }
/*      */ 
/*      */   public boolean hasItem(String e)
/*      */   {
/* 2539 */     if (this.model.contains(e)) {
/* 2540 */       return true;
/*      */     }
/* 2542 */     return false;
/*      */   }
/*      */ 
/*      */   public boolean isInteger(String input)
/*      */   {
/*      */     try
/*      */     {
/* 2550 */       Integer.parseInt(input);
/* 2551 */       return true;
/*      */     }
/*      */     catch (Exception x) {
/*      */     }
/* 2555 */     return false;
/*      */   }
/*      */ 
/*      */   public void pickItem()
/*      */   {
/* 2561 */     for (int i = 0; i < this.droppedItems.size(); i++)
/*      */     {
/* 2563 */       String[] pickingUp = ((String)this.droppedItems.get(i)).split("\\|");
/*      */ 
/* 2565 */       if ((this.currentMap == Integer.parseInt(pickingUp[3])) && (this.spawnX == Integer.parseInt(pickingUp[1])) && (this.spawnY == Integer.parseInt(pickingUp[2])))
/*      */       {
/* 2573 */         repaint();
/*      */       }
/*      */     }
/*      */   }
/*      */ 
/*      */   public boolean com(String e)
/*      */   {
/* 2588 */     if (say.getText().indexOf(e) > -1) {
/* 2589 */       return true;
/*      */     }
/* 2591 */     return false;
/*      */   }
/*      */ 
/*      */   public void doCommand(String e, String who)
/*      */   {
/* 2597 */     if (e.equals("/item"))
/*      */     {
/* 2599 */       String[] itemSpawn = who.split(",");
/*      */ 
/* 2601 */       if (!getItem(itemSpawn[0])[0].equals("Null")) {
/* 2602 */         c.append("\nYou spawned a " + getItem(itemSpawn[0])[0] + " underneath you.");
/* 2603 */         dropItemNow(Integer.parseInt(getItem(itemSpawn[0])[8]), this.spawnX, this.spawnY);
/*      */       } else {
/* 2605 */         c.append("\nInvalid item ID.");
/*      */       }
/*      */     }
/*      */ 
/* 2609 */     if (e.equals("/tele"))
/*      */     {
/* 2611 */       String[] teleTo = who.split(",");
/*      */ 
/* 2613 */       int teleX = Integer.parseInt(teleTo[0]) * 32;
/* 2614 */       int teleY = Integer.parseInt(teleTo[1]) * 32;
/*      */ 
/* 2616 */       if (blocked(Integer.parseInt(teleTo[0]), Integer.parseInt(teleTo[1]))) {
/* 2617 */         c.append("\nSorry, the block X: " + teleTo[0] + ", Y: " + teleTo[1] + " is blocked!");
/*      */       }
/*      */       else
/*      */       {
/* 2622 */         this.me.setX(teleX);
/* 2623 */         this.me.setY(teleY);
/* 2624 */         this.spawnX = Integer.parseInt(teleTo[0]);
/* 2625 */         this.spawnY = Integer.parseInt(teleTo[1]);
/* 2626 */         this.px = teleX;
/* 2627 */         this.py = teleY;
/* 2628 */         this.lastX = Integer.parseInt(teleTo[0]);
/* 2629 */         this.lastY = Integer.parseInt(teleTo[1]);
/* 2630 */         c.append("\nTeleported to X: " + teleTo[0] + ", Y: " + teleTo[1]);
/* 2631 */         this.tele = true;
/*      */       }
/*      */     }
/*      */   }
/*      */ 
/*      */   public void addMonsterNow(int dMonsterID, int monX, int monY)
/*      */   {
/* 2642 */     this.monstersActive.add(Integer.toString(dMonsterID) + "|" + Integer.toString(monX) + "|" + Integer.toString(monY) + "|" + this.currentMap + "|nothing");
/*      */   }
/*      */ 
/*      */   public void addMonster(int dMonsterID, int monX, int monY, int monMap)
/*      */   {
/* 2648 */     this.monstersActive.add(Integer.toString(dMonsterID) + "|" + Integer.toString(monX) + "|" + Integer.toString(monY) + "|" + Integer.toString(monMap) + "|nothing");
/*      */   }
/*      */ 
/*      */   public void addSign(int signX, int signY, String signSays)
/*      */   {
/* 2654 */     this.signs.add(Integer.toString(signX) + "|" + Integer.toString(signY) + "|" + signSays + "|" + this.currentMap);
/* 2655 */     this.droppedItems.add("7|" + Integer.toString(signX) + "|" + Integer.toString(signY) + "|" + this.currentMap + "|drop|Guest|yes");
/*      */   }
/*      */ 
/*      */   public void addSignNow(int signX, int signY, String signSays, int signMap)
/*      */   {
/* 2661 */     this.signs.add(Integer.toString(signX) + "|" + Integer.toString(signY) + "|" + signSays + "|" + signMap);
/* 2662 */     this.droppedItems.add("7|" + Integer.toString(signX) + "|" + Integer.toString(signY) + "|" + Integer.toString(signMap) + "|drop|Guest|yes");
/*      */   }
/*      */ 
/*      */   public void addTeleport(int fromX, int fromY, int fromMap, int toX, int toY, int toMap)
/*      */   {
/* 2667 */     this.teleports.add(Integer.toString(fromX) + "|" + Integer.toString(fromY) + "|" + Integer.toString(fromMap) + "|" + Integer.toString(toX) + "|" + Integer.toString(toY) + "|" + Integer.toString(toMap) + "|0");
/*      */   }
/*      */ 
/*      */   public void addTeleportItem(int fromX, int fromY, int fromMap, int toX, int toY, int toMap, int item_req) {
/* 2671 */     this.teleports.add(Integer.toString(fromX) + "|" + Integer.toString(fromY) + "|" + Integer.toString(fromMap) + "|" + Integer.toString(toX) + "|" + Integer.toString(toY) + "|" + Integer.toString(toMap) + "|" + Integer.toString(item_req));
/*      */   }
/*      */ 
/*      */   public void addEntrance(int entX, int entY, int tileAfter)
/*      */   {
/* 2676 */     this.entrances.add(Integer.toString(entX) + "|" + Integer.toString(entY) + "|" + Integer.toString(tileAfter) + "|" + this.currentMap + "|0");
/*      */   }
/*      */ 
/*      */   public void addEntranceItem(int entX, int entY, int tileAfter, int itemReq) {
/* 2680 */     this.entrances.add(Integer.toString(entX) + "|" + Integer.toString(entY) + "|" + Integer.toString(tileAfter) + "|" + this.currentMap + "|" + Integer.toString(itemReq));
/*      */   }
/*      */ 
/*      */   public void dropItem(int dropId, int dropX, int dropY, int dropMap) {
/* 2684 */     this.droppedItems.add(Integer.toString(dropId) + "|" + Integer.toString(dropX) + "|" + Integer.toString(dropY) + "|" + Integer.toString(dropMap) + "|drop|Guest|yes");
/*      */   }
/*      */ 
/*      */   public void dropItemNow(int dropId, int dropX, int dropYX)
/*      */   {
/*      */     try
/*      */     {
/* 2691 */       this.droppedItems.add(Integer.toString(dropId) + "|" + Integer.toString(dropX) + "|" + Integer.toString(dropYX) + "|" + this.currentMap + "|drop|Guest|yes"); } catch (Exception herp) {
/* 2692 */       herp.printStackTrace();
/*      */     }
/*      */   }
/*      */ 
/*      */   public void checkCommand() {
/* 2697 */     List dan = Arrays.asList(new String[] { "/item", "/tele" });
/*      */ 
/* 2699 */     String[] whoKick = say.getText().split(" ");
/*      */ 
/* 2702 */     boolean contains = dan.contains(whoKick[0]);
/* 2703 */     if (whoKick[0].indexOf("/") > -1) {
/* 2704 */       if (contains)
/* 2705 */         doCommand(whoKick[0], whoKick[1]);
/*      */       else {
/* 2707 */         c.append("\nInvalid command: " + whoKick[0]);
/*      */       }
/*      */     }
/*      */ 
/* 2711 */     say.setText("");
/* 2712 */     c.setCaretPosition(c.getDocument().getLength());
/*      */   }
/*      */ 
/*      */   public void doBattle(int e, int monster_id, String monFull)
/*      */   {
/* 2722 */     String strMonID = Integer.toString(monster_id);
/*      */ 
/* 2724 */     if (!this.firstStrike)
/*      */     {
/* 2726 */       this.attacker = (e + "|" + getMonster(strMonID)[6] + "|" + getMonster(strMonID)[1]);
/*      */     }
/*      */ 
/* 2729 */     this.firstStrike = true;
/*      */ 
/* 2731 */     String[] attackingMe = this.attacker.split("\\|");
/*      */ 
/* 2733 */     String[] monNow = monFull.split("\\|");
/*      */ 
/* 2735 */     this.spotted = Boolean.valueOf(true);
/* 2736 */     this.isInBattle = true;
/* 2737 */     this.beingAttacked = Boolean.valueOf(true);
/*      */ 
/* 2739 */     this.monstersActive.set(e, monNow[0] + "|" + monNow[1] + "|" + monNow[2] + "|" + monNow[3] + "|attacking");
/*      */ 
/* 2741 */     this.yourHit = monsterFormula(this.level, this.attack, this.defense);
/* 2742 */     this.newMonHp = (Integer.parseInt(attackingMe[2]) - this.yourHit);
/*      */ 
/* 2745 */     this.qepe += 1;
/*      */ 
/* 2748 */     if (this.newMonHp < 0) {
/*      */       try {
/* 2750 */         c.append("\nYou killed a Level " + getMonster(monNow[0])[7] + " " + getMonster(monNow[0])[0] + ".");
/* 2751 */         c.append("\nYou gained " + getMonster(monNow[0])[4] + " EXP and " + getMonster(monNow[0])[3] + " gold!");
/* 2752 */         this.exp += Integer.parseInt(getMonster(monNow[0])[4]);
/* 2753 */         this.gold += Integer.parseInt(getMonster(monNow[0])[3]);
/* 2754 */         this.firstStrike = false;
/*      */ 
/* 2756 */         int commas = 1;
/* 2757 */         for (int i = 0; i < getMonster(monNow[0])[5].length(); i++) {
/* 2758 */           if (getMonster(monNow[0])[5].charAt(i) == ',') commas++;
/*      */         }
/*      */ 
/* 2761 */         int rewardDrop = this.roll.nextInt(commas);
/*      */ 
/* 2764 */         dropItemNow(Integer.parseInt(getItem(this.itemsDropped[rewardDrop])[8]), Integer.parseInt(monNow[1]), Integer.parseInt(monNow[2]));
/*      */ 
/* 2767 */         this.lExp.setText("EXP: " + this.exp);
/* 2768 */         System.out.println("MONSTER DEAD");
/* 2769 */         for (String mons : this.monstersActive) {
/* 2770 */           System.out.println(mons);
/*      */         }
/*      */ 
/* 2774 */         this.monstersActive.remove(e);
/*      */ 
/* 2778 */         repaint();
/* 2779 */         this.qepe = 0;
/* 2780 */         this.beingAttacked = Boolean.valueOf(false);
/* 2781 */         this.attacker = "";
/* 2782 */         this.isInBattle = false;
/* 2783 */         this.moveDown = Boolean.valueOf(true);
/* 2784 */         this.moveRight = Boolean.valueOf(true);
/* 2785 */         this.moveLeft = Boolean.valueOf(true);
/* 2786 */         this.moveUp = Boolean.valueOf(true);
/*      */       } catch (Exception herpa) {
/* 2788 */         herpa.printStackTrace();
/*      */       }
/*      */ 
/*      */     }
/*      */     else
/*      */     {
/*      */       try
/*      */       {
/* 2797 */         this.attacker = (e + "|" + getMonster(strMonID)[6] + "|" + this.newMonHp);
/*      */ 
/* 2807 */         c.append("\nYou hit for " + this.yourHit + "\nYour HP: " + this.currhp + " / Monster's HP: " + attackingMe[2]);
/*      */       }
/*      */       catch (Exception herpx)
/*      */       {
/* 2820 */         herpx.printStackTrace();
/*      */       }
/*      */     }
/*      */   }
/*      */ 
/*      */   public static int monsterFormula(int e, int myAttack, int myDefense)
/*      */   {
/* 2832 */     int xTotal = 0;
/* 2833 */     for (int i = 1; i < e; i++) {
/* 2834 */       xTotal += (int)Math.floor(i + myAttack * Math.pow(myDefense, i / 42.0D));
/*      */     }
/* 2836 */     return (int)Math.floor(xTotal / 8.0D);
/*      */   }
/*      */ 
/*      */   public void keyPressed(KeyEvent e)
/*      */   {
/* 2841 */     for (int i = 0; i < this.signs.size(); i++) {
/* 2842 */       String[] signDrop = ((String)this.signs.get(i)).split("\\|");
/* 2843 */       if ((Integer.parseInt(signDrop[0]) != this.spawnX) || (Integer.parseInt(signDrop[1]) != this.spawnY)) {
/* 2844 */         this.signPanel.setVisible(false);
/*      */       }
/*      */ 
/*      */     }
/*      */ 
/* 2849 */     if (this.introPanel.isVisible()) this.introPanel.setVisible(false);
/*      */ 
/* 2852 */     this.tele = false;
/*      */ 
/* 2854 */     this.myCommand = "move";
/*      */ 
/* 2865 */     if (this.stepsTill > 3) {
/* 2866 */       this.monMove = Boolean.valueOf(true);
/* 2867 */       this.stepsTill = 0;
/*      */     } else {
/* 2869 */       this.monMove = Boolean.valueOf(false);
/*      */     }
/*      */ 
/* 2873 */     int qx = 0;
/*      */     try
/*      */     {
/* 2877 */       for (String mons : this.monstersActive)
/*      */       {
/* 2879 */         String[] monCheck = mons.split("\\|");
/*      */ 
/* 2882 */         String[] checkDrop = mons.split("\\|");
/*      */ 
/* 2885 */         this.itemsDropped = getMonster(checkDrop[0])[5].split(",");
/*      */ 
/* 2888 */         if (this.currentMap == Integer.parseInt(monCheck[3]))
/*      */         {
/* 2894 */           int whichWay = this.roll.nextInt(2);
/* 2895 */           int whichDirection = this.roll.nextInt(2);
/* 2896 */           int newDirMove = 0;
/*      */ 
/* 2900 */           if (this.beingAttacked.booleanValue()) this.spotted = Boolean.valueOf(true);
/*      */ 
/* 2902 */           if (!this.beingAttacked.booleanValue()) {
/* 2903 */             this.monstersActive.set(qx, monCheck[0] + "|" + monCheck[1] + "|" + monCheck[2] + "|" + monCheck[3] + "|nothing");
/*      */           }
/*      */ 
/*      */           try
/*      */           {
/* 2908 */             if (whichWay > 0)
/*      */             {
/* 2910 */               if (whichDirection > 0) {
/* 2911 */                 newDirMove = Integer.parseInt(monCheck[1]) + 1;
/*      */               }
/*      */               else {
/* 2914 */                 newDirMove = Integer.parseInt(monCheck[1]) - 1;
/*      */               }
/*      */ 
/* 2917 */               if ((!blocked(newDirMove, Integer.parseInt(monCheck[2]))) && 
/* 2918 */                 (this.monMove.booleanValue())) this.monstersActive.set(qx, monCheck[0] + "|" + newDirMove + "|" + monCheck[2] + "|" + monCheck[3] + "|" + monCheck[4]); 
/*      */             }
/*      */             else
/*      */             {
/* 2921 */               if (whichDirection > 0)
/* 2922 */                 newDirMove = Integer.parseInt(monCheck[2]) + 1;
/*      */               else {
/* 2924 */                 newDirMove = Integer.parseInt(monCheck[2]) - 1;
/*      */               }
/* 2926 */               if (!blocked(Integer.parseInt(monCheck[1]), newDirMove))
/*      */               {
/* 2928 */                 if (this.monMove.booleanValue()) this.monstersActive.set(qx, monCheck[0] + "|" + monCheck[1] + "|" + newDirMove + "|" + monCheck[3] + "|" + monCheck[4]); 
/*      */               }
/*      */             }
/*      */           }
/* 2932 */           catch (Exception ere) { System.out.println("Haha, error!"); }
/*      */ 
/* 2934 */           this.check_down_Y = (this.spawnY - 1);
/* 2935 */           this.check_up_Y = (this.spawnY + 1);
/* 2936 */           this.check_left_X = (this.spawnX - 1);
/* 2937 */           this.check_right_X = (this.spawnX + 1);
/* 2938 */           this.checkX = this.spawnX;
/* 2939 */           this.checkY = this.spawnY;
/*      */ 
/* 2944 */           if ((Integer.parseInt(monCheck[2]) == this.check_down_Y) && (Integer.parseInt(monCheck[1]) == this.checkX) && (e.getKeyCode() == 38)) {
/* 2945 */             this.moveUp = Boolean.valueOf(false);
/* 2946 */             this.attackDown = Boolean.valueOf(true);
/* 2947 */             this.beingAttacked = Boolean.valueOf(true);
/* 2948 */             doBattle(qx, Integer.parseInt(monCheck[0]), mons);
/* 2949 */             this.spotted = Boolean.valueOf(true);
/* 2950 */             this.attackedBy = monCheck[0];
/* 2951 */           } else if (!this.spotted.booleanValue()) {
/* 2952 */             this.moveUp = Boolean.valueOf(true);
/* 2953 */             this.beingAttacked = Boolean.valueOf(false);
/* 2954 */             this.attacker = "";
/* 2955 */             this.isInBattle = false;
/*      */           }
/*      */ 
/* 2963 */           if ((Integer.parseInt(monCheck[2]) == this.check_up_Y) && (Integer.parseInt(monCheck[1]) == this.checkX) && (e.getKeyCode() == 40)) {
/* 2964 */             this.moveDown = Boolean.valueOf(false);
/* 2965 */             this.attackUp = Boolean.valueOf(true);
/* 2966 */             doBattle(qx, Integer.parseInt(monCheck[0]), mons);
/* 2967 */             this.spotted = Boolean.valueOf(true);
/* 2968 */             this.attackedBy = monCheck[0];
/* 2969 */           } else if (!this.spotted.booleanValue()) {
/* 2970 */             this.moveDown = Boolean.valueOf(true);
/* 2971 */             this.beingAttacked = Boolean.valueOf(false);
/* 2972 */             this.attacker = "";
/*      */           }
/*      */ 
/* 2977 */           if ((Integer.parseInt(monCheck[1]) == this.check_right_X) && (Integer.parseInt(monCheck[2]) == this.checkY) && (e.getKeyCode() == 39)) {
/* 2978 */             this.moveRight = Boolean.valueOf(false);
/* 2979 */             this.attackLeft = Boolean.valueOf(true);
/* 2980 */             doBattle(qx, Integer.parseInt(monCheck[0]), mons);
/* 2981 */             this.spotted = Boolean.valueOf(true);
/* 2982 */             this.attackedBy = monCheck[0];
/* 2983 */           } else if (!this.spotted.booleanValue()) {
/* 2984 */             this.moveRight = Boolean.valueOf(true);
/* 2985 */             this.beingAttacked = Boolean.valueOf(false);
/* 2986 */             this.attacker = "";
/*      */           }
/*      */ 
/* 2991 */           if ((Integer.parseInt(monCheck[1]) == this.check_left_X) && (Integer.parseInt(monCheck[2]) == this.checkY) && (e.getKeyCode() == 37)) {
/* 2992 */             this.moveLeft = Boolean.valueOf(false);
/* 2993 */             this.attackRight = Boolean.valueOf(true);
/* 2994 */             doBattle(qx, Integer.parseInt(monCheck[0]), mons);
/* 2995 */             this.spotted = Boolean.valueOf(true);
/* 2996 */             this.attackedBy = monCheck[0];
/* 2997 */           } else if (!this.spotted.booleanValue()) {
/* 2998 */             this.moveLeft = Boolean.valueOf(true);
/* 2999 */             this.beingAttacked = Boolean.valueOf(false);
/* 3000 */             this.attacker = "";
/*      */           }
/*      */ 
/* 3011 */           if (monCheck[0].equals(this.attackedBy))
/*      */           {
/* 3013 */             if (((this.beingAttacked.booleanValue()) && (!this.moveUp.booleanValue()) && (e.getKeyCode() == 37) && (this.isInBattle)) || ((this.beingAttacked.booleanValue()) && (!this.moveUp.booleanValue()) && (e.getKeyCode() == 40) && (this.isInBattle)) || ((this.beingAttacked.booleanValue()) && (!this.moveUp.booleanValue()) && (e.getKeyCode() == 39) && (this.isInBattle))) {
/* 3014 */               c.append("\nYou flee from the battle!");
/*      */ 
/* 3016 */               this.moveUp = Boolean.valueOf(true);
/* 3017 */               this.spotted = Boolean.valueOf(false);
/* 3018 */               this.beingAttacked = Boolean.valueOf(false);
/* 3019 */               this.firstStrike = false;
/*      */             }
/*      */ 
/* 3023 */             if (((this.beingAttacked.booleanValue()) && (!this.moveDown.booleanValue()) && (e.getKeyCode() == 37) && (this.isInBattle)) || ((this.beingAttacked.booleanValue()) && (!this.moveDown.booleanValue()) && (e.getKeyCode() == 38) && (this.isInBattle)) || ((this.beingAttacked.booleanValue()) && (!this.moveDown.booleanValue()) && (e.getKeyCode() == 39) && (this.isInBattle))) {
/* 3024 */               c.append("\nYou flee from the battle!");
/*      */ 
/* 3026 */               this.moveDown = Boolean.valueOf(true);
/* 3027 */               this.spotted = Boolean.valueOf(false);
/* 3028 */               this.beingAttacked = Boolean.valueOf(false);
/* 3029 */               this.firstStrike = false;
/*      */             }
/*      */ 
/* 3033 */             if (((this.beingAttacked.booleanValue()) && (!this.moveLeft.booleanValue()) && (e.getKeyCode() == 38) && (this.isInBattle)) || ((this.beingAttacked.booleanValue()) && (!this.moveLeft.booleanValue()) && (e.getKeyCode() == 40) && (this.isInBattle)) || ((this.beingAttacked.booleanValue()) && (!this.moveLeft.booleanValue()) && (e.getKeyCode() == 39) && (this.isInBattle))) {
/* 3034 */               c.append("\nYou flee from the battle!");
/*      */ 
/* 3036 */               this.moveLeft = Boolean.valueOf(true);
/* 3037 */               this.spotted = Boolean.valueOf(false);
/* 3038 */               this.beingAttacked = Boolean.valueOf(false);
/* 3039 */               this.firstStrike = false;
/*      */             }
/*      */ 
/* 3043 */             if (((this.beingAttacked.booleanValue()) && (!this.moveRight.booleanValue()) && (e.getKeyCode() == 37) && (this.isInBattle)) || ((this.beingAttacked.booleanValue()) && (!this.moveRight.booleanValue()) && (e.getKeyCode() == 40) && (this.isInBattle)) || ((this.beingAttacked.booleanValue()) && (!this.moveRight.booleanValue()) && (e.getKeyCode() == 38) && (this.isInBattle))) {
/* 3044 */               c.append("\nYou flee from the battle!");
/*      */ 
/* 3046 */               this.moveRight = Boolean.valueOf(true);
/* 3047 */               this.spotted = Boolean.valueOf(false);
/* 3048 */               this.beingAttacked = Boolean.valueOf(false);
/* 3049 */               this.firstStrike = false;
/*      */             }
/*      */ 
/*      */           }
/*      */ 
/*      */         }
/*      */ 
/* 3066 */         qx++;
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (Exception localException1)
/*      */     {
/*      */     }
/*      */ 
/* 3083 */     isInBound(this.lastX, this.lastY);
/*      */ 
/* 3087 */     this.right = true;
/* 3088 */     this.left = true;
/* 3089 */     this.up = true;
/* 3090 */     this.down = true;
/*      */     int upBlock;
/*      */     try
/*      */     {
/* 3103 */       int downBlock = this.spawnY + 2;
/* 3104 */       upBlock = this.spawnY - 2;
/* 3105 */       int leftBlock = this.spawnX - 2;
/* 3106 */       int rightBlock = this.spawnX + 2;
/*      */ 
/* 3113 */       if (e.isShiftDown())
/*      */       {
/* 3116 */         for (int i = 0; i < this.signs.size(); i++) {
/* 3117 */           String[] signDrop = ((String)this.signs.get(i)).split("\\|");
/*      */ 
/* 3119 */           if ((Integer.parseInt(signDrop[0]) == this.spawnX) && (Integer.parseInt(signDrop[1]) == this.spawnY))
/*      */           {
/* 3121 */             this.signhtml = ("<html>" + signDrop[2] + "</html>");
/*      */ 
/* 3126 */             this.signLabel.setText(this.signhtml);
/*      */ 
/* 3128 */             if (!this.signPanel.isVisible()) {
/* 3129 */               this.signPanel.setVisible(true);
/* 3130 */               c.append("\nSign opened...");
/*      */             } else {
/* 3132 */               this.signPanel.setVisible(false);
/* 3133 */               c.append("\nSign closed...");
/*      */             }
/*      */ 
/*      */           }
/*      */ 
/*      */         }
/*      */ 
/*      */       }
/*      */ 
/* 3142 */       if ((e.isShiftDown()) && (e.getKeyCode() == 39))
/*      */       {
/* 3144 */         if ((!hasItem("Big Hammer")) && (this.pushBoard[this.spawnY][(this.spawnX + 1)] == 163)) {
/* 3145 */           c.append("\nYou need a hammer to move a boulder this strong!");
/*      */         }
/* 3149 */         else if ((!blocked(rightBlock, this.spawnY)) && (!pushable(this.pushBoard[this.spawnY][rightBlock])))
/*      */         {
/* 3151 */           this.pushBoard[this.spawnY][(this.spawnX + 2)] = this.pushBoard[this.spawnY][(this.spawnX + 1)];
/* 3152 */           this.pushBoard[this.spawnY][(this.spawnX + 1)] = this.pushBoard[this.spawnY][this.spawnX];
/*      */         }
/*      */ 
/*      */       }
/*      */ 
/* 3157 */       if ((e.isShiftDown()) && (e.getKeyCode() == 40))
/*      */       {
/* 3159 */         if ((!blocked(this.spawnX, downBlock)) && (!pushable(this.pushBoard[downBlock][this.spawnX]))) {
/* 3160 */           this.pushBoard[(this.spawnY + 2)][this.spawnX] = this.pushBoard[(this.spawnY + 1)][this.spawnX];
/* 3161 */           this.pushBoard[(this.spawnY + 1)][this.spawnX] = this.pushBoard[this.spawnY][this.spawnX];
/*      */         }
/*      */ 
/*      */       }
/*      */ 
/* 3166 */       if ((e.isShiftDown()) && (e.getKeyCode() == 37))
/*      */       {
/* 3170 */         if ((!blocked(leftBlock, this.spawnY)) && (!pushable(this.pushBoard[this.spawnY][leftBlock])))
/*      */         {
/* 3172 */           this.pushBoard[this.spawnY][(this.spawnX - 2)] = this.pushBoard[this.spawnY][(this.spawnX - 1)];
/* 3173 */           this.pushBoard[this.spawnY][(this.spawnX - 1)] = this.pushBoard[this.spawnY][this.spawnX];
/*      */         }
/*      */ 
/*      */       }
/*      */ 
/* 3178 */       if ((e.isShiftDown()) && (e.getKeyCode() == 38))
/*      */       {
/* 3180 */         if ((!blocked(this.spawnX, upBlock)) && (!pushable(this.pushBoard[upBlock][this.spawnX]))) {
/* 3181 */           this.pushBoard[(this.spawnY - 2)][this.spawnX] = this.pushBoard[(this.spawnY - 1)][this.spawnX];
/* 3182 */           this.pushBoard[(this.spawnY - 1)][this.spawnX] = this.pushBoard[this.spawnY][this.spawnX];
/*      */         }
/*      */       }
/*      */ 
/* 3186 */       repaint();
/*      */     }
/*      */     catch (ArrayIndexOutOfBoundsException localArrayIndexOutOfBoundsException)
/*      */     {
/*      */     }
/*      */ 
/* 3194 */     if (e.isControlDown())
/*      */     {
/* 3197 */       if (this.userPanel.isOpaque()) {
/* 3198 */         this.userPanel.setOpaque(false);
/* 3199 */         this.labelUser.setVisible(false);
/* 3200 */         this.labelY.setVisible(false);
/* 3201 */         this.labelX.setVisible(false);
/* 3202 */         this.xPanel.setOpaque(false);
/* 3203 */         this.yPanel.setOpaque(false);
/* 3204 */         this.roomPanel.setOpaque(false);
/* 3205 */         this.labelRoom.setVisible(false);
/* 3206 */         c.append("\nStatistics are now hidden.");
/* 3207 */       } else if (!this.userPanel.isOpaque()) {
/* 3208 */         this.userPanel.setOpaque(true);
/* 3209 */         this.labelUser.setVisible(true);
/* 3210 */         this.labelY.setVisible(true);
/* 3211 */         this.labelX.setVisible(true);
/* 3212 */         this.xPanel.setOpaque(true);
/* 3213 */         this.yPanel.setOpaque(true);
/* 3214 */         this.roomPanel.setOpaque(true);
/* 3215 */         this.labelRoom.setVisible(true);
/* 3216 */         c.append("\nStatistics are now displaying.");
/*      */       }
/*      */ 
/* 3219 */       this.game.requestFocusInWindow();
/*      */     }
/*      */ 
/* 3222 */     if (e.getKeyCode() == 53) {
/* 3223 */       for (String s : this.maplist) {
/* 3224 */         System.out.println(s);
/*      */       }
/*      */ 
/*      */     }
/*      */ 
/* 3229 */     if (e.getKeyCode() == 49)
/*      */     {
/* 3232 */       System.out.println("\n\nXXXXXXXXXXXXXXXXXXX\n\n");
/*      */ 
/* 3234 */       for (int i = 0; i < this.droppedItems.size(); i++) {
/* 3235 */         System.out.println((String)this.droppedItems.get(i));
/*      */       }
/*      */ 
/* 3240 */       System.out.println("\n\nXXXXXXXXXXXXXXXXXXX\n\n");
/*      */     }
/*      */ 
/* 3243 */     if (e.getKeyCode() == 52) {
/* 3244 */       c.append("\nMap refreshed!");
/*      */ 
/* 3246 */       getAppletContext().showDocument(getDocumentBase(), "_self");
/*      */     }
/*      */ 
/* 3250 */     if (e.getKeyCode() == 51) {
/* 3251 */       System.out.println("\n======================\n SIGNS ON MAP");
/*      */ 
/* 3253 */       for (int i = 0; i < this.signs.size(); i++) {
/* 3254 */         System.out.println((String)this.signs.get(i));
/*      */       }
/*      */ 
/*      */     }
/*      */ 
/* 3259 */     if (e.getKeyCode() == 50)
/*      */     {
/* 3261 */       System.out.println("STATS qepe: " + this.qepe + " | qx: " + qx + " | moveUp: " + this.moveUp);
/*      */ 
/* 3264 */       System.out.println("\n======================\n MONSTERS ON CURRENT MAP");
/*      */ 
/* 3266 */       for (int i = 0; i < this.monstersActive.size(); i++) {
/* 3267 */         String[] checkDrop = ((String)this.monstersActive.get(i)).split("\\|");
/* 3268 */         this.itemsDropped = getMonster(checkDrop[0])[5].split(",");
/*      */ 
/* 3270 */         if (this.currentMap == Integer.parseInt(checkDrop[3]))
/*      */         {
/* 3272 */           System.out.println("\n--------------------\n" + (String)this.monstersActive.get(i) + "\n------\n");
/* 3273 */           System.out.println("Name: " + getMonster(checkDrop[0])[0] + " (ID: " + getMonster(checkDrop[0])[6] + ")\n");
/* 3274 */           System.out.println("Coords: [X: " + checkDrop[1] + ", Y: " + checkDrop[2] + "]\n");
/* 3275 */           System.out.println("Mapped on: " + setRoom(Integer.parseInt(checkDrop[3])) + " (Map ID: " + checkDrop[3] + ")\n");
/* 3276 */           System.out.println("HP: " + getMonster(checkDrop[0])[1] + " | Gold drop: " + getMonster(checkDrop[0])[3] + " | EXP worth: " + getMonster(checkDrop[0])[4] + "\n");
/* 3277 */           System.out.println("Currently doing: " + checkDrop[4]);
/* 3278 */           System.out.print("Loot: ");
/*      */ 
/* 3280 */           for (int itemsOnMon = 0; itemsOnMon < getMonster(checkDrop[0])[5].length(); itemsOnMon++) {
/*      */             try {
/* 3282 */               System.out.print("[" + getItem(this.itemsDropped[itemsOnMon])[0] + "] ");
/*      */             }
/*      */             catch (ArrayIndexOutOfBoundsException localArrayIndexOutOfBoundsException1)
/*      */             {
/*      */             }
/*      */           }
/*      */         }
/*      */       }
/* 3290 */       System.out.println("\n======================\n");
/*      */     }
/*      */ 
/* 3295 */     if (e.getKeyCode() == 67)
/*      */     {
/* 3297 */       if (!this.charOpen) {
/* 3298 */         c.append("\nYou opened the Character Sheet.");
/* 3299 */         this.charPanel.setVisible(true);
/* 3300 */         this.charOpen = true;
/*      */       } else {
/* 3302 */         c.append("\nYou closed the Character Sheet.");
/* 3303 */         this.charPanel.setVisible(false);
/* 3304 */         this.charOpen = false;
/*      */       }
/*      */ 
/*      */     }
/*      */ 
/* 3311 */     if ((!this.list.isSelectionEmpty()) && 
/* 3312 */       (e.getKeyCode() == 88))
/*      */     {
/* 3314 */       int listID = this.list.getSelectedIndex();
/* 3315 */       Object droppedItem = this.list.getModel().getElementAt(listID);
/*      */ 
/* 3317 */       this.itemIDdropped = getItem(droppedItem.toString())[8];
/*      */ 
/* 3319 */       c.append("\nYou dropped a " + getItem(droppedItem.toString())[0] + ".");
/* 3320 */       this.myCommand = "drop";
/*      */ 
/* 3323 */       this.model.remove(this.list.getSelectedIndex());
/* 3324 */       int d_itemID = Integer.parseInt(this.itemIDdropped);
/* 3325 */       dropItemNow(d_itemID, this.spawnX, this.spawnY);
/*      */     }
/*      */     int replacement;
/* 3363 */     if (e.getKeyCode() == 83) {
/* 3364 */       int numToReplace = 0;
/* 3365 */       replacement = 7;
/*      */ 
/* 3367 */       for (int i = 0; i < this.board.length; i++)
/*      */       {
/* 3369 */         for (int j = 0; j < this.board[i].length; j++) {
/* 3370 */           if (this.board[i][j] == numToReplace) {
/* 3371 */             this.board[i][j] = replacement;
/*      */           }
/*      */ 
/*      */         }
/*      */ 
/*      */       }
/*      */ 
/*      */     }
/*      */ 
/* 3382 */     if ((e.isShiftDown()) && (e.getKeyCode() == 40))
/*      */     {
/* 3385 */       for (String s : this.entrances) {
/* 3386 */         String[] entranceCheck = s.split("\\|");
/*      */ 
/* 3388 */         int nowMap = this.currentMap;
/* 3389 */         int tileNow = Integer.parseInt(entranceCheck[2]);
/* 3390 */         int nowX = Integer.parseInt(entranceCheck[0]);
/* 3391 */         int nowY = Integer.parseInt(entranceCheck[1]);
/* 3392 */         int downY = Integer.parseInt(entranceCheck[1]) - 1;
/*      */ 
/* 3394 */         if (!entranceCheck[4].equals("0"))
/*      */         {
/* 3396 */           String itemReq = entranceCheck[4];
/* 3397 */           if ((this.currentMap == nowMap) && (this.spawnX == nowX) && (this.spawnY == downY)) {
/* 3398 */             if (hasItem(getItem(itemReq)[0])) {
/* 3399 */               c.append("\nYou unlock with help from an item.");
/* 3400 */               this.board[nowY][nowX] = tileNow;
/*      */             } else {
/* 3402 */               c.append("\nYou need a " + getItem(itemReq)[0] + " to open.");
/*      */             }
/*      */           }
/*      */ 
/*      */         }
/* 3407 */         else if ((this.currentMap == nowMap) && (this.spawnX == nowX) && (this.spawnY == downY))
/*      */         {
/* 3409 */           c.append("\nYou unlock it.");
/* 3410 */           this.board[nowY][nowX] = tileNow;
/*      */         }
/*      */ 
/*      */       }
/*      */ 
/*      */     }
/*      */ 
/* 3419 */     if ((e.isShiftDown()) && (e.getKeyCode() == 39))
/*      */     {
/* 3422 */       for (String s : this.entrances) {
/* 3423 */         String[] entranceCheck = s.split("\\|");
/* 3424 */         int nowMap = this.currentMap;
/* 3425 */         int tileNow = Integer.parseInt(entranceCheck[2]);
/* 3426 */         int nowX = Integer.parseInt(entranceCheck[0]);
/* 3427 */         int nowY = Integer.parseInt(entranceCheck[1]);
/* 3428 */         int leftX = Integer.parseInt(entranceCheck[0]) - 1;
/*      */ 
/* 3430 */         if (!entranceCheck[4].equals("0"))
/*      */         {
/* 3432 */           String itemReq = entranceCheck[4];
/* 3433 */           if ((this.currentMap == nowMap) && (this.spawnX == leftX) && (this.spawnY == nowY)) {
/* 3434 */             if (hasItem(getItem(itemReq)[0])) {
/* 3435 */               c.append("\nYou unlock  with help from an item.");
/* 3436 */               this.board[nowY][nowX] = tileNow;
/*      */             } else {
/* 3438 */               c.append("\nYou need a " + getItem(itemReq)[0] + " to open.");
/*      */             }
/*      */           }
/*      */ 
/*      */         }
/* 3443 */         else if ((this.currentMap == nowMap) && (this.spawnX == leftX) && (this.spawnY == nowY))
/*      */         {
/* 3445 */           c.append("\nYou unlock it.");
/* 3446 */           this.board[nowY][nowX] = tileNow;
/*      */         }
/*      */ 
/*      */       }
/*      */ 
/*      */     }
/*      */ 
/* 3454 */     if ((e.isShiftDown()) && (e.getKeyCode() == 37))
/*      */     {
/* 3457 */       for (String s : this.entrances) {
/* 3458 */         String[] entranceCheck = s.split("\\|");
/* 3459 */         int nowMap = this.currentMap;
/* 3460 */         int tileNow = Integer.parseInt(entranceCheck[2]);
/* 3461 */         int nowX = Integer.parseInt(entranceCheck[0]);
/* 3462 */         int nowY = Integer.parseInt(entranceCheck[1]);
/* 3463 */         int leftX = Integer.parseInt(entranceCheck[0]) + 1;
/*      */ 
/* 3465 */         if (!entranceCheck[4].equals("0"))
/*      */         {
/* 3467 */           String itemReq = entranceCheck[4];
/* 3468 */           if ((this.currentMap == nowMap) && (this.spawnX == leftX) && (this.spawnY == nowY)) {
/* 3469 */             if (hasItem(getItem(itemReq)[0])) {
/* 3470 */               c.append("\nYou unlock  with help from an item.");
/* 3471 */               this.board[nowY][nowX] = tileNow;
/*      */             } else {
/* 3473 */               c.append("\nYou need a " + getItem(itemReq)[0] + " to open.");
/*      */             }
/*      */           }
/*      */ 
/*      */         }
/* 3478 */         else if ((this.currentMap == nowMap) && (this.spawnX == leftX) && (this.spawnY == nowY))
/*      */         {
/* 3480 */           c.append("\nYou unlock it.");
/* 3481 */           this.board[nowY][nowX] = tileNow;
/*      */         }
/*      */ 
/*      */       }
/*      */ 
/*      */     }
/*      */ 
/* 3491 */     if ((e.isShiftDown()) && (e.getKeyCode() == 38))
/*      */     {
/* 3494 */       for (String s : this.entrances) {
/* 3495 */         String[] entranceCheck = s.split("\\|");
/* 3496 */         int nowMap = this.currentMap;
/* 3497 */         int tileNow = Integer.parseInt(entranceCheck[2]);
/* 3498 */         int nowX = Integer.parseInt(entranceCheck[0]);
/* 3499 */         int nowY = Integer.parseInt(entranceCheck[1]);
/* 3500 */         int downY = Integer.parseInt(entranceCheck[1]) + 1;
/*      */ 
/* 3502 */         if (!entranceCheck[4].equals("0"))
/*      */         {
/* 3504 */           String itemReq = entranceCheck[4];
/* 3505 */           if ((this.currentMap == nowMap) && (this.spawnX == nowX) && (this.spawnY == downY)) {
/* 3506 */             if (hasItem(getItem(itemReq)[0])) {
/* 3507 */               c.append("\nYou unlock with help from an item.");
/* 3508 */               this.board[nowY][nowX] = tileNow;
/*      */             } else {
/* 3510 */               c.append("\nYou need a " + getItem(itemReq)[0] + " to open.");
/*      */             }
/*      */           }
/*      */ 
/*      */         }
/* 3515 */         else if ((this.currentMap == nowMap) && (this.spawnX == nowX) && (this.spawnY == downY))
/*      */         {
/* 3517 */           c.append("\nYou unlock it.");
/* 3518 */           this.board[nowY][nowX] = tileNow;
/*      */         }
/*      */ 
/*      */       }
/*      */ 
/*      */     }
/*      */ 
/* 3526 */     if (e.getKeyCode() == 90)
/*      */     {
/* 3528 */       this.pressedG = true;
/*      */ 
/* 3534 */       boolean onceNow = false;
/*      */ 
/* 3536 */       for (int i = 0; i < this.droppedItems.size(); i++)
/*      */       {
/* 3538 */         if (!onceNow)
/*      */         {
/* 3540 */           String[] checkDrop = ((String)this.droppedItems.get(i)).split("\\|");
/*      */ 
/* 3543 */           if (!checkDrop[0].equals("7"))
/*      */           {
/* 3546 */             if ((this.currentMap == Integer.parseInt(checkDrop[3])) && (this.spawnX == Integer.parseInt(checkDrop[1])) && (this.spawnY == Integer.parseInt(checkDrop[2])))
/*      */             {
/* 3548 */               c.append("\nYou picked up a " + getItem(checkDrop[0])[0] + ".");
/* 3549 */               this.myCommand = "pickup";
/* 3550 */               this.itemIDdropped = getItem(checkDrop[0])[8];
/* 3551 */               onceNow = true;
/*      */             }
/*      */ 
/*      */           }
/*      */ 
/*      */         }
/*      */ 
/*      */       }
/*      */ 
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/* 3593 */       if ((blocked(this.spawnX + 1, this.spawnY)) || (this.pushBoard[this.spawnY][(this.spawnX + 1)] != 0)) {
/* 3594 */         this.right = false;
/*      */       }
/*      */     }
/*      */     catch (ArrayIndexOutOfBoundsException localArrayIndexOutOfBoundsException2)
/*      */     {
/*      */     }
/*      */     try
/*      */     {
/* 3602 */       if ((blocked(this.spawnX - 1, this.spawnY)) || (this.pushBoard[this.spawnY][(this.spawnX - 1)] != 0))
/* 3603 */         this.left = false;
/*      */     }
/*      */     catch (ArrayIndexOutOfBoundsException localArrayIndexOutOfBoundsException3)
/*      */     {
/*      */     }
/*      */     try {
/* 3609 */       if ((blocked(this.spawnX, this.spawnY + 1)) || (this.pushBoard[(this.spawnY + 1)][this.spawnX] != 0))
/* 3610 */         this.down = false;
/*      */     }
/*      */     catch (ArrayIndexOutOfBoundsException localArrayIndexOutOfBoundsException4)
/*      */     {
/*      */     }
/*      */     try {
/* 3616 */       if ((blocked(this.spawnX, this.spawnY - 1)) || (this.pushBoard[(this.spawnY - 1)][this.spawnX] != 0)) {
/* 3617 */         this.up = false;
/*      */       }
/*      */     }
/*      */     catch (ArrayIndexOutOfBoundsException localArrayIndexOutOfBoundsException5)
/*      */     {
/*      */     }
/*      */ 
/* 3624 */     if ((blocked(12, 7)) && (this.spawnX == this.mapX) && (this.spawnY - 1 == 1 - this.mapX)) {
/* 3625 */       this.up = false;
/*      */     }
/*      */ 
/* 3628 */     int r1 = this.lastX + 1;
/* 3629 */     if (this.lastX > 0)
/* 3630 */       r1 = this.lastX + 1;
/*      */     else {
/* 3632 */       r1 = 0;
/*      */     }
/* 3634 */     int r2 = this.lastY;
/*      */ 
/* 3636 */     int u1 = this.lastX;
/*      */     int u2;
/* 3638 */     if (this.lastY > 0)
/* 3639 */       u2 = this.lastY - 1;
/*      */     else
/* 3641 */       u2 = 0;
/*      */     int l1;
/* 3645 */     if (this.spawnX > 0)
/* 3646 */       l1 = this.lastX - 1;
/*      */     else {
/* 3648 */       l1 = 0;
/*      */     }
/* 3650 */     int l2 = this.spawnY;
/*      */ 
/* 3652 */     int d1 = this.lastX;
/*      */     int d2;
/* 3654 */     if (this.lastY > 0)
/* 3655 */       d2 = this.lastY + 1;
/*      */     else {
/* 3657 */       d2 = 0;
/*      */     }
/*      */     try
/*      */     {
/* 3661 */       if ((blocked(r1, r2)) || (this.pushBoard[this.spawnY][(this.spawnX + 1)] != 0)) {
/* 3662 */         this.right = false;
/*      */       }
/* 3664 */       if ((blocked(u1, u2)) || (this.pushBoard[(this.spawnY - 1)][this.spawnX] != 0))
/* 3665 */         this.up = false;
/* 3666 */       if ((blocked(l1, l2)) || (this.pushBoard[this.spawnY][(this.spawnX - 1)] != 0)) {
/* 3667 */         this.left = false;
/*      */       }
/*      */ 
/* 3670 */       if ((blocked(d1, d2)) || (this.pushBoard[(this.spawnY + 1)][this.spawnX] != 0)) {
/* 3671 */         this.down = false;
/*      */       }
/*      */     }
/*      */     catch (ArrayIndexOutOfBoundsException localArrayIndexOutOfBoundsException6)
/*      */     {
/*      */     }
/* 3677 */     this.leftMap = 0;
/* 3678 */     this.upMap = 0;
/* 3679 */     this.rightMap = 0;
/* 3680 */     this.downMap = 0;
/*      */ 
/* 3682 */     this.boolRC = false;
/* 3683 */     this.boolLC = false;
/* 3684 */     this.boolUC = false;
/* 3685 */     this.boolDC = false;
/*      */ 
/* 3688 */     if ((this.spawnX == this.mapX) && (e.getKeyCode() == 39) && (this.moveRight.booleanValue())) {
/* 3689 */       this.boolRC = true;
/*      */     }
/*      */ 
/* 3692 */     if ((this.spawnX == 0) && (e.getKeyCode() == 37) && (this.moveLeft.booleanValue())) {
/* 3693 */       this.boolLC = true;
/*      */     }
/*      */ 
/* 3696 */     if ((this.spawnY == 0) && (e.getKeyCode() == 38) && (this.moveUp.booleanValue())) {
/* 3697 */       this.boolUC = true;
/*      */     }
/*      */ 
/* 3700 */     if ((this.spawnY == this.mapY) && (e.getKeyCode() == 40) && (this.moveDown.booleanValue())) {
/* 3701 */       this.boolDC = true;
/*      */     }
/*      */ 
/* 3714 */     for (String s : this.maplist)
/*      */     {
/* 3716 */       if (Integer.parseInt(s) == this.currentMap)
/*      */       {
/* 3723 */         if (this.boolLC)
/*      */         {
/* 3725 */           this.leftMap = ((NumberLoad)dataNow.getIDS().get(0)).getLeftMap();
/* 3726 */           this.rightMap = ((NumberLoad)data.getIDS().get(0)).getRightMap();
/* 3727 */         } else if (this.boolRC) {
/* 3728 */           this.leftMap = ((NumberLoad)data.getIDS().get(0)).getLeftMap();
/* 3729 */           this.rightMap = ((NumberLoad)dataNow.getIDS().get(0)).getRightMap();
/*      */         }
/*      */ 
/* 3732 */         if (this.boolDC)
/*      */         {
/* 3734 */           this.downMap = ((NumberLoad)dataNow.getIDS().get(0)).getDownMap();
/* 3735 */           this.upMap = ((NumberLoad)data.getIDS().get(0)).getUpMap();
/* 3736 */         } else if (this.boolUC) {
/* 3737 */           this.downMap = ((NumberLoad)data.getIDS().get(0)).getDownMap();
/* 3738 */           this.upMap = ((NumberLoad)dataNow.getIDS().get(0)).getUpMap();
/*      */         }
/*      */ 
/*      */       }
/*      */ 
/*      */     }
/*      */ 
/* 3745 */     if ((this.leftMap == 0) && (this.spawnX == 0)) {
/* 3746 */       this.left = false;
/*      */     }
/* 3748 */     if ((this.rightMap == 0) && (this.spawnX == this.mapX)) {
/* 3749 */       this.right = false;
/*      */     }
/* 3751 */     if ((this.downMap == 0) && (this.spawnY == this.mapY))
/* 3752 */       this.down = false;
/* 3753 */     if ((this.upMap == 0) && (this.spawnY == 0)) {
/* 3754 */       this.up = false;
/*      */     }
/* 3756 */     if ((e.getKeyCode() == 38) && (this.up) && (this.moveUp.booleanValue())) {
/* 3757 */       this.spawnY -= 1;
/* 3758 */       this.stepsTill += 1;
/*      */     }
/*      */ 
/* 3761 */     if ((e.getKeyCode() == 40) && (this.down) && (this.moveDown.booleanValue())) {
/* 3762 */       this.spawnY += 1;
/* 3763 */       this.stepsTill += 1;
/*      */     }
/*      */ 
/* 3766 */     if ((e.getKeyCode() == 39) && (this.right) && (this.moveRight.booleanValue())) {
/* 3767 */       this.spawnX += 1;
/* 3768 */       this.stepsTill += 1;
/*      */     }
/*      */ 
/* 3771 */     if ((e.getKeyCode() == 37) && (this.left) && (this.moveLeft.booleanValue())) {
/* 3772 */       this.spawnX -= 1;
/* 3773 */       this.stepsTill += 1;
/*      */     }
/*      */ 
/* 3778 */     if ((this.boolRC) && (this.right)) {
/* 3779 */       this.spawnX = 0;
/* 3780 */       this.lastX = this.spawnX;
/*      */ 
/* 3782 */       this.board = loadBoard(this.rightMap);
/* 3783 */       this.pushBoard = loadPush(1);
/* 3784 */       this.px = 0;
/*      */ 
/* 3786 */       int currMapToLoad = this.currentMap;
/* 3787 */       this.currentMap = ((NumberLoad)dataNow.getIDS().get(0)).getRightMap();
/*      */ 
/* 3789 */       File directory = new File(System.getenv("APPDATA") + "\\.mystik\\maps");
/* 3790 */       String[] filename = directory.list();
/* 3791 */       this.leftFileLoad = 0;
/* 3792 */       for (int qi = 0; qi < filename.length; qi++)
/*      */       {
					System.out.println("HELLO MOM.");
/* 3794 */         String listFilenames = System.getenv("APPDATA") + "\\.mystik\\maps\\" + filename[qi];
/*      */ 
/* 3797 */         if (((NumberLoad)dataNow.getIDS().get(0)).getRightMap() == this.currentMap)
/*      */         {
/*      */           try {
/* 3800 */             fr = new FileReader(listFilenames);
/*      */           } catch (FileNotFoundException fne) {
/* 3802 */             fne.printStackTrace();
/*      */           }
/* 3804 */           StringBuffer sb = new StringBuffer();
/* 3805 */           char[] b = new char[1000];
/* 3806 */           int n = 0;
/*      */           try {
/* 3808 */             while ((n = fr.read(b)) > 0)
/* 3809 */               sb.append(b, 0, n);
/*      */           }
/*      */           catch (IOException rex) {
/* 3812 */             rex.printStackTrace();
/*      */           }
/* 3814 */           String fileStringxT = sb.toString();
/*      */           try
/*      */           {
/* 3817 */             dataMap = (Data)new Gson().fromJson(fileStringxT, Data.class);
/*      */           } catch (Exception er) {
/* 3819 */             er.printStackTrace();
/*      */           }
/*      */ 
/* 3822 */           if (currMapToLoad == ((NumberLoad)dataArray[qi].getIDS().get(0)).getLeftMap())
/*      */           {
/*      */             try
/*      */             {
/* 3826 */               for (int row = 0; row < dataArray[qi].getMap().length; row++)
/* 3827 */                 for (int col = 0; col < dataArray[qi].getMap()[row].length; col++)
/*      */                 {
/* 3829 */                   int index = dataArray[qi].getMap()[row][col];
/* 3830 */                   this.board[row][col] = index;
/*      */                 }
/*      */             } catch (Exception rere) {
/* 3833 */               rere.printStackTrace();
/*      */             }
/* 3835 */             ((NumberLoad)dataNow.getIDS().get(0)).setRightMap(((NumberLoad)dataArray[qi].getIDS().get(0)).getRightMap());
/* 3836 */             ((NumberLoad)dataNow.getIDS().get(0)).setLeftMap(currMapToLoad);
/*      */ 
/* 3838 */             ((NumberLoad)dataNow.getIDS().get(0)).setUpMap(((NumberLoad)dataArray[qi].getIDS().get(0)).getUpMap());
/* 3839 */             ((NumberLoad)dataNow.getIDS().get(0)).setDownMap(((NumberLoad)dataArray[qi].getIDS().get(0)).getDownMap());
/* 3840 */             this.roomName = dataArray[qi].getTitle();
/*      */           }
/*      */ 
/*      */         }
/*      */ 
/* 3845 */         this.leftFileLoad = qi;
/*      */       }
/*      */ 
/* 3850 */       currMapToLoad = ((NumberLoad)dataNow.getIDS().get(0)).getRightMap();
/*      */     }
/*      */ 
/* 3858 */     if ((this.boolLC) && (this.left))
/*      */     {
/* 3861 */       this.spawnX = this.mapX;
/* 3862 */       this.lastX = this.spawnX;
/*      */ 
/* 3866 */       this.pushBoard = loadPush(1);
/* 3867 */       this.px = this.rightSide;
/*      */ 
/* 3869 */       int currMapToLoad = this.currentMap;
/* 3870 */       this.currentMap = ((NumberLoad)dataNow.getIDS().get(0)).getLeftMap();
/*      */ 
/* 3872 */       File directory = new File(System.getenv("APPDATA") + "\\.mystik\\maps");
/* 3873 */       String[] filename = directory.list();
/* 3874 */       this.leftFileLoad = 0;
/* 3875 */       for (int qi = 0; qi < filename.length; qi++)
/*      */       {
/* 3877 */         String listFilenames = System.getenv("APPDATA") + "\\.mystik\\maps\\" + filename[qi];
/*      */ 
/* 3880 */         if (((NumberLoad)dataNow.getIDS().get(0)).getLeftMap() == this.currentMap)
/*      */         {
/*      */           try {
/* 3883 */             fr = new FileReader(listFilenames);
/*      */           } catch (FileNotFoundException fne) {
/* 3885 */             fne.printStackTrace();
/*      */           }
/* 3887 */           StringBuffer sb = new StringBuffer();
/* 3888 */           char[] b = new char[1000];
/* 3889 */           int n = 0;
/*      */           try {
/* 3891 */             while ((n = fr.read(b)) > 0)
/* 3892 */               sb.append(b, 0, n);
/*      */           }
/*      */           catch (IOException rex) {
/* 3895 */             rex.printStackTrace();
/*      */           }
/* 3897 */           String fileStringxT = sb.toString();
/* 3898 */           System.out.println(fileStringxT);
/*      */           try {
/* 3900 */             dataMap = (Data)new Gson().fromJson(fileStringxT, Data.class);
/*      */           } catch (Exception er) {
/* 3902 */             er.printStackTrace();
/*      */           }
/*      */ 
/* 3905 */           if (currMapToLoad == ((NumberLoad)dataArray[qi].getIDS().get(0)).getRightMap())
/*      */           {
/*      */             try
/*      */             {
/* 3909 */               for (int row = 0; row < dataArray[qi].getMap().length; row++)
/* 3910 */                 for (int col = 0; col < dataArray[qi].getMap()[row].length; col++)
/*      */                 {
/* 3912 */                   int index = dataArray[qi].getMap()[row][col];
/* 3913 */                   this.board[row][col] = index;
/*      */                 }
/*      */             } catch (Exception rere) {
/* 3916 */               rere.printStackTrace();
/* 3917 */             }((NumberLoad)dataNow.getIDS().get(0)).setRightMap(currMapToLoad);
/* 3918 */             ((NumberLoad)dataNow.getIDS().get(0)).setLeftMap(((NumberLoad)dataArray[qi].getIDS().get(0)).getLeftMap());
/*      */ 
/* 3920 */             ((NumberLoad)dataNow.getIDS().get(0)).setUpMap(((NumberLoad)dataArray[qi].getIDS().get(0)).getUpMap());
/* 3921 */             ((NumberLoad)dataNow.getIDS().get(0)).setDownMap(((NumberLoad)dataArray[qi].getIDS().get(0)).getDownMap());
/* 3922 */             this.roomName = dataArray[qi].getTitle();
/*      */           }
/*      */ 
/*      */         }
/*      */ 
/* 3928 */         this.leftFileLoad = qi;
/*      */       }
/*      */ 
/* 3933 */       currMapToLoad = ((NumberLoad)dataNow.getIDS().get(0)).getLeftMap();
/*      */     }
/*      */ 
/* 3938 */     if ((this.boolUC) && (this.up)) {
/* 3939 */       this.spawnY = this.mapY;
/* 3940 */       this.lastY = this.spawnY;
/*      */ 
/* 3942 */       this.board = loadBoard(this.upMap);
/* 3943 */       this.pushBoard = loadPush(1);
/*      */ 
/* 3945 */       this.py = this.downSide;
/*      */ 
/* 3947 */       int currMapToLoad = this.currentMap;
/* 3948 */       this.currentMap = ((NumberLoad)dataNow.getIDS().get(0)).getUpMap();
/*      */ 
/* 3950 */       File directory = new File(System.getenv("APPDATA") + "\\.mystik\\maps");
/* 3951 */       String[] filename = directory.list();
/* 3952 */       this.leftFileLoad = 0;
/* 3953 */       for (int qi = 0; qi < filename.length; qi++)
/*      */       {
/* 3955 */         String listFilenames = System.getenv("APPDATA") + "\\.mystik\\maps\\" + filename[qi];
/*      */ 
/* 3959 */         if (((NumberLoad)dataNow.getIDS().get(0)).getUpMap() == this.currentMap)
/*      */         {
/*      */           try {
/* 3962 */             fr = new FileReader(listFilenames);
/*      */           } catch (FileNotFoundException fne) {
/* 3964 */             fne.printStackTrace();
/*      */           }
/* 3966 */           StringBuffer sb = new StringBuffer();
/* 3967 */           char[] b = new char[1000];
/* 3968 */           int n = 0;
/*      */           try {
/* 3970 */             while ((n = fr.read(b)) > 0)
/* 3971 */               sb.append(b, 0, n);
/*      */           }
/*      */           catch (IOException rex) {
/* 3974 */             rex.printStackTrace();
/*      */           }
/* 3976 */           String fileStringxT = sb.toString();
/* 3977 */           System.out.println(fileStringxT);
/*      */           try {
/* 3979 */             dataMap = (Data)new Gson().fromJson(fileStringxT, Data.class);
/*      */           } catch (Exception er) {
/* 3981 */             er.printStackTrace();
/*      */           }
/*      */ 
/* 3984 */           if (currMapToLoad == ((NumberLoad)dataArray[qi].getIDS().get(0)).getDownMap())
/*      */           {
/*      */             try
/*      */             {
/* 3988 */               for (int row = 0; row < dataArray[qi].getMap().length; row++)
/* 3989 */                 for (int col = 0; col < dataArray[qi].getMap()[row].length; col++)
/*      */                 {
/* 3991 */                   int index = dataArray[qi].getMap()[row][col];
/* 3992 */                   this.board[row][col] = index;
/*      */                 }
/*      */             } catch (Exception rere) {
/* 3995 */               rere.printStackTrace();
/*      */             }
/* 3997 */             ((NumberLoad)dataNow.getIDS().get(0)).setUpMap(((NumberLoad)dataArray[qi].getIDS().get(0)).getUpMap());
/* 3998 */             ((NumberLoad)dataNow.getIDS().get(0)).setDownMap(currMapToLoad);
/*      */ 
/* 4000 */             ((NumberLoad)dataNow.getIDS().get(0)).setRightMap(((NumberLoad)dataArray[qi].getIDS().get(0)).getRightMap());
/* 4001 */             ((NumberLoad)dataNow.getIDS().get(0)).setLeftMap(((NumberLoad)dataArray[qi].getIDS().get(0)).getLeftMap());
/* 4002 */             this.roomName = dataArray[qi].getTitle();
/*      */           }
/*      */         }
/*      */ 
/* 4006 */         this.leftFileLoad = qi;
/*      */       }
/*      */ 
/* 4011 */       currMapToLoad = ((NumberLoad)dataNow.getIDS().get(0)).getUpMap();
/*      */     }
/*      */ 
/* 4015 */     if ((this.boolDC) && (this.down)) {
/* 4016 */       this.spawnY = 0;
/* 4017 */       this.lastY = this.spawnY;
/*      */ 
/* 4019 */       this.board = loadBoard(this.downMap);
/* 4020 */       this.pushBoard = loadPush(this.downMap);
/*      */ 
/* 4022 */       this.py = 0;
/*      */ 
/* 4024 */       int currMapToLoad = this.currentMap;
/* 4025 */       this.currentMap = ((NumberLoad)dataNow.getIDS().get(0)).getDownMap();
/*      */ 
/* 4027 */       File directory = new File(System.getenv("APPDATA") + "\\.mystik\\maps");
/* 4028 */       String[] filename = ((File)directory).list();
/* 4029 */       this.leftFileLoad = 0;
/* 4030 */       for (int qi = 0; qi < filename.length; qi++)
/*      */       {
/* 4032 */         String listFilenames = System.getenv("APPDATA") + "\\.mystik\\maps\\" + filename[qi];
/*      */ 
/* 4036 */         if (((NumberLoad)dataNow.getIDS().get(0)).getDownMap() == this.currentMap)
/*      */         {
/*      */           try {
/* 4039 */             fr = new FileReader(listFilenames);
/*      */           } catch (FileNotFoundException fne) {
/* 4041 */             fne.printStackTrace();
/*      */           }
/* 4043 */           StringBuffer sb = new StringBuffer();
/* 4044 */           char[] b = new char[1000];
/* 4045 */           int n = 0;
/*      */           try {
/* 4047 */             while ((n = fr.read(b)) > 0)
/* 4048 */               sb.append(b, 0, n);
/*      */           }
/*      */           catch (IOException rex) {
/* 4051 */             rex.printStackTrace();
/*      */           }
/* 4053 */           String fileStringxT = sb.toString();
/* 4054 */           System.out.println(fileStringxT);
/*      */           try {
/* 4056 */             dataMap = (Data)new Gson().fromJson(fileStringxT, Data.class);
/*      */           } catch (Exception er) {
/* 4058 */             er.printStackTrace();
/*      */           }
/*      */ 
/* 4061 */           if (currMapToLoad == ((NumberLoad)dataArray[qi].getIDS().get(0)).getUpMap())
/*      */           {
/*      */             try
/*      */             {
/* 4065 */               for (int row = 0; row < dataArray[qi].getMap().length; row++)
/* 4066 */                 for (int col = 0; col < dataArray[qi].getMap()[row].length; col++)
/*      */                 {
/* 4068 */                   int index = dataArray[qi].getMap()[row][col];
/* 4069 */                   this.board[row][col] = index;
/*      */                 }
/*      */             } catch (Exception rere) {
/* 4072 */               rere.printStackTrace();
/* 4073 */             }c.append("\nYou're on " + dataArray[qi].getTitle() + "!");
/* 4074 */             ((NumberLoad)dataNow.getIDS().get(0)).setDownMap(((NumberLoad)dataArray[qi].getIDS().get(0)).getDownMap());
/* 4075 */             ((NumberLoad)dataNow.getIDS().get(0)).setUpMap(currMapToLoad);
/*      */ 
/* 4077 */             ((NumberLoad)dataNow.getIDS().get(0)).setRightMap(((NumberLoad)dataArray[qi].getIDS().get(0)).getRightMap());
/* 4078 */             ((NumberLoad)dataNow.getIDS().get(0)).setLeftMap(((NumberLoad)dataArray[qi].getIDS().get(0)).getLeftMap());
/* 4079 */             this.roomName = dataArray[qi].getTitle();
/*      */           }
/*      */ 
/*      */         }
/*      */ 
/* 4084 */         this.leftFileLoad = qi;
/*      */       }
/*      */ 
/* 4089 */       currMapToLoad = ((NumberLoad)dataNow.getIDS().get(0)).getDownMap();
/*      */     }
/*      */ 
/* 4105 */     if (!this.boolLC) {
/* 4106 */       if ((this.left) && 
/* 4107 */         (e.getKeyCode() == 37) && (this.moveLeft.booleanValue())) {
/* 4108 */         this.left = true;
/* 4109 */         this.px -= 32;
/* 4110 */         this.lastX -= 1;
/*      */       }
/*      */ 
/*      */     }
/* 4114 */     else if (this.leftMap > 0) {
/* 4115 */       this.px = this.rightSide;
/*      */     }
/*      */ 
/* 4118 */     if (!this.boolRC) {
/* 4119 */       if ((this.right) && 
/* 4120 */         (e.getKeyCode() == 39) && (this.moveRight.booleanValue())) {
/* 4121 */         this.right = true;
/* 4122 */         this.px += 32;
/* 4123 */         this.lastX += 1;
/*      */       }
/*      */ 
/*      */     }
/* 4127 */     else if (this.rightMap > 0) {
/* 4128 */       this.px = 0;
/*      */     }
/*      */ 
/* 4131 */     if (!this.boolDC)
/*      */     {
/* 4133 */       if ((this.down) && 
/* 4134 */         (e.getKeyCode() == 40) && (this.moveDown.booleanValue())) {
/* 4135 */         this.down = true;
/* 4136 */         this.py += 32;
/* 4137 */         this.lastY += 1;
/*      */       }
/*      */ 
/*      */     }
/* 4142 */     else if (this.downMap > 0) {
/* 4143 */       this.py = 0;
/*      */     }
/*      */ 
/* 4147 */     if (!this.boolUC) {
/* 4148 */       if (this.up)
/*      */       {
/* 4150 */         if ((e.getKeyCode() == 38) && (this.moveUp.booleanValue())) {
/* 4151 */           this.up = true;
/* 4152 */           this.py -= 32;
/* 4153 */           this.lastY -= 1;
/*      */         }
/*      */       }
/*      */     }
/* 4157 */     else if (this.upMap > 0) {
/* 4158 */       this.py = this.downSide;
/*      */     }
/*      */ 
/* 4164 */     for (Object directory = this.teleports.iterator(); ((Iterator)directory).hasNext(); ) { String q = (String)((Iterator)directory).next();
/*      */ 
/* 4171 */       System.out.println(q);
/*      */ 
/* 4173 */       String[] teleportCheck = q.split("\\|");
/*      */ 
/* 4175 */       if (Integer.parseInt(teleportCheck[2]) == this.currentMap)
/*      */       {
/* 4177 */         if ((this.spawnX == Integer.parseInt(teleportCheck[0])) && (this.spawnY == Integer.parseInt(teleportCheck[1])))
/*      */         {
/* 4181 */           if (!teleportCheck[6].equals("0")) {
/* 4182 */             String itemReqTele = teleportCheck[6];
/* 4183 */             if (hasItem(getItem(itemReqTele)[0])) {
/* 4184 */               this.board = loadBoard(Integer.parseInt(teleportCheck[5]));
/* 4185 */               this.pushBoard = loadPush(Integer.parseInt(teleportCheck[5]));
/* 4186 */               this.px = (Integer.parseInt(teleportCheck[3]) * 32);
/* 4187 */               this.py = (Integer.parseInt(teleportCheck[4]) * 32);
/* 4188 */               this.currentMap = Integer.parseInt(teleportCheck[5]);
/* 4189 */               this.spawnX = Integer.parseInt(teleportCheck[3]);
/* 4190 */               this.spawnY = Integer.parseInt(teleportCheck[4]);
/* 4191 */               this.lastX = this.spawnX;
/* 4192 */               this.lastY = this.spawnY;
/* 4193 */               repaint();
/*      */             } else {
/* 4195 */               c.append("\nYou need a " + getItem(itemReqTele)[0] + " before you can go through...");
/*      */             }
/*      */           }
/*      */           else
/*      */           {
/* 4200 */             this.board = loadBoard(Integer.parseInt(teleportCheck[5]));
/* 4201 */             this.pushBoard = loadPush(Integer.parseInt(teleportCheck[5]));
/* 4202 */             this.px = (Integer.parseInt(teleportCheck[3]) * 32);
/* 4203 */             this.py = (Integer.parseInt(teleportCheck[4]) * 32);
/* 4204 */             this.currentMap = Integer.parseInt(teleportCheck[5]);
/* 4205 */             this.spawnX = Integer.parseInt(teleportCheck[3]);
/* 4206 */             this.spawnY = Integer.parseInt(teleportCheck[4]);
/* 4207 */             this.lastX = this.spawnX;
/* 4208 */             this.lastY = this.spawnY;
/* 4209 */             repaint();
/*      */           }
/*      */         }
/*      */ 
/*      */       }
/*      */ 
/*      */     }
/*      */ 
/* 4217 */    me = ((Player)players.get(me.getUsername()));
/*      */ 
/* 4219 */     if (e.getKeyCode() == 10)
/*      */     {
/* 4221 */       this.myCommand = "chat";
/*      */ 
/* 4223 */       this.myCommand = "chat";
/*      */ 
/* 4225 */       c.append("\n" + this.me.getUsername() + ": " + say.getText());
/* 4226 */       say.setText("");
/*      */ 
/* 4228 */       checkCommand();
/*      */     }
/*      */ 
/* 4232 */     repaint();

/* 4235 */     me.setX(this.px);
/* 4236 */     me.setY(this.py);
/* 4237 */     me.setMap(this.currentMap);
/*      */ 
/* 4243 */     if (this.myCommand == "pickup")
/*      */     {
/* 4245 */       this.beforeCheck = "yes";
/*      */ 
/* 4249 */       for (int i = 0; i < this.droppedItems.size(); i++) {
/* 4250 */         String[] clientUp = ((String)this.droppedItems.get(i)).split("\\|");
/*      */ 
/* 4252 */         if ((this.currentMap == Integer.parseInt(clientUp[3])) && (this.spawnX == Integer.parseInt(clientUp[1])) && (this.spawnY == Integer.parseInt(clientUp[2])))
/*      */         {
/* 4254 */           this.droppedItems.remove(clientUp[0] + "|" + clientUp[1] + "|" + clientUp[2] + "|" + clientUp[3] + "|drop|" + clientUp[5] + "|" + clientUp[6]);
/* 4255 */           this.model.addElement(getItem(clientUp[0])[0]);
/*      */         }
/*      */ 
/*      */       }
/*      */ 
/*      */     }
/*      */ 
/* 4267 */     this.me.setCommand(this.myCommand);
/*      */ 
/* 4271 */     this.labelY.setText("Y: " + this.spawnY);
/* 4272 */     this.labelX.setText("X: " + this.spawnX);
/*      */ 
/* 4274 */     System.out.println("Y: " + this.spawnY + " | X: " + this.spawnX + "\n============");
/*      */ 
/* 4276 */     File filea = new File(System.getenv("APPDATA") + "\\.mystik\\main.txt");
/*      */     try
/*      */     {
/* 4279 */       if (this.roomName == null)
/* 4280 */         this.labelRoom.setText(dataNow.getTitle());
/*      */       else {
/* 4282 */         this.labelRoom.setText(this.roomName);
/*      */       }
/*      */     }
/*      */     catch (Exception localException3)
/*      */     {
/*      */     }
/*      */ 
/* 4289 */     c.setCaretPosition(c.getDocument().getLength());
/*      */ 
/* 4296 */     repaint();
/*      */   }
/*      */ 
/*      */   public String setRoom(int e)
/*      */   {
/* 4302 */     if (e == 1) this.roomName = "Respawn Point";
/* 4303 */     if (e == 2) this.roomName = "Stoney Trail";
/* 4304 */     if (e == 3) this.roomName = "Mapacide";
/* 4305 */     if (e == 4) this.roomName = "Pushapolis";
/*      */ 
/* 4307 */     return this.roomName;
/*      */   }
/*      */ 
/*      */   public void keyReleased(KeyEvent e)
/*      */   {
/*      */   }
/*      */ 
/*      */   public void keyTyped(KeyEvent e)
/*      */   {
/*      */   }
/*      */ 
/*      */   public void addtoInv(String e) {
/* 4319 */     this.model.addElement(getItem(e)[0]);
/*      */   }
/*      */ 
/*      */   public void addInv(String e)
/*      */   {
/* 4327 */     c.append("\nxYou picked up a " + getItem(e)[0] + ".");
/*      */ 
/* 4329 */     this.model.addElement(getItem(e)[0]);
/*      */   }
/*      */ 
/*      */   public String[] getMonster(String q)
/*      */   {
/* 4335 */     String mName = "Null";
/* 4336 */     String mHP = "1";
/* 4337 */     String mDesc = "None.";
/* 4338 */     String mGold = "1";
/* 4339 */     String mExp = "1";
/* 4340 */     String mItems = "0";
/* 4341 */     String monsterID = "0";
/* 4342 */     String mLevel = "0";
/*      */ 
/* 4344 */     if ((q.equals("1")) || (q.equals("Goblin")))
/*      */     {
/* 4346 */       mName = "Goblin";
/* 4347 */       mHP = "10";
/* 4348 */       mDesc = "Ugly greedy, usually green, creaters.";
/* 4349 */       mGold = "6";
/* 4350 */       mExp = "6";
/* 4351 */       mItems = "1,2,3,4";
/* 4352 */       monsterID = "1";
/* 4353 */       mLevel = "4";
/*      */     }
/*      */ 
/* 4357 */     if ((q.equals("2")) || (q.equals("Arachnid")))
/*      */     {
/* 4359 */       mName = "Arachnid";
/* 4360 */       mHP = "3";
/* 4361 */       mDesc = "A giant creepy arachnid";
/* 4362 */       mGold = "2";
/* 4363 */       mExp = "2";
/* 4364 */       mItems = "1,2,3,4";
/* 4365 */       monsterID = "2";
/* 4366 */       mLevel = "1";
/*      */     }
/*      */ 
/* 4370 */     if ((q.equals("3")) || (q.equals("Eagle")))
/*      */     {
/* 4372 */       mName = "Eagle";
/* 4373 */       mHP = "20";
/* 4374 */       mDesc = "A giant creepy arachnid";
/* 4375 */       mGold = "15";
/* 4376 */       mExp = "13";
/* 4377 */       mItems = "1,2,3,4,1,2,3,4,1,6";
/* 4378 */       monsterID = "3";
/* 4379 */       mLevel = "9";
/*      */     }
/*      */ 
/* 4383 */     if ((q.equals("4")) || (q.equals("Orc Chieftan")))
/*      */     {
/* 4385 */       mName = "Orc Chieftan";
/* 4386 */       mHP = "10";
/* 4387 */       mDesc = "A deadly purple Orc waiting to strike.";
/* 4388 */       mGold = "10";
/* 4389 */       mExp = "9";
/* 4390 */       mItems = "1,2,3,4";
/* 4391 */       monsterID = "4";
/* 4392 */       mLevel = "11";
/*      */     }
/*      */ 
/* 4396 */     if ((q.equals("5")) || (q.equals("Water Beast")))
/*      */     {
/* 4398 */       mName = "Water Beast";
/* 4399 */       mHP = "13";
/* 4400 */       mDesc = "A beast from the water with hair from Medusa.";
/* 4401 */       mGold = "12";
/* 4402 */       mExp = "11";
/* 4403 */       mItems = "1,2,4";
/* 4404 */       monsterID = "5";
/* 4405 */       mLevel = "12";
/*      */     }
/*      */ 
/* 4409 */     if ((q.equals("6")) || (q.equals("Sand Drake")))
/*      */     {
/* 4411 */       mName = "Sand Drake";
/* 4412 */       mHP = "15";
/* 4413 */       mDesc = "A deadly dragon covered in sand.";
/* 4414 */       mGold = "15";
/* 4415 */       mExp = "15";
/* 4416 */       mItems = "1,1,1,1,2,2,2,3,4,4,4,4,5";
/* 4417 */       monsterID = "6";
/* 4418 */       mLevel = "16";
/*      */     }
/*      */ 
/* 4422 */     if ((q.equals("7")) || (q.equals("Human Mage")))
/*      */     {
/* 4424 */       mName = "Human Mage";
/* 4425 */       mHP = "17";
/* 4426 */       mDesc = "Mastered the arts of wizardry and tom-foolery.";
/* 4427 */       mGold = "16";
/* 4428 */       mExp = "19";
/* 4429 */       mItems = "1,2";
/* 4430 */       monsterID = "7";
/* 4431 */       mLevel = "18";
/*      */     }
/*      */ 
/* 4435 */     if ((q.equals("8")) || (q.equals("Fiery Salamandar")))
/*      */     {
/* 4437 */       mName = "Fiery Salamandar";
/* 4438 */       mHP = "15";
/* 4439 */       mDesc = "A salamandar covered in sleek red.";
/* 4440 */       mGold = "5";
/* 4441 */       mExp = "14";
/* 4442 */       mItems = "1,2,3,4";
/* 4443 */       monsterID = "8";
/* 4444 */       mLevel = "14";
/*      */     }
/*      */ 
/* 4448 */     if ((q.equals("9")) || (q.equals("Skeleton Warrior")))
/*      */     {
/* 4450 */       mName = "Skeleton Warrior";
/* 4451 */       mHP = "18";
/* 4452 */       mDesc = "A warrior risen from the grave.";
/* 4453 */       mGold = "14";
/* 4454 */       mExp = "14";
/* 4455 */       mItems = "1,2,3,4";
/* 4456 */       monsterID = "9";
/* 4457 */       mLevel = "15";
/*      */     }
/*      */ 
/* 4461 */     if ((q.equals("10")) || (q.equals("Human Warrior")))
/*      */     {
/* 4463 */       mName = "Human Warrior";
/* 4464 */       mHP = "21";
/* 4465 */       mDesc = "Dangerous with blades.";
/* 4466 */       mGold = "18";
/* 4467 */       mExp = "20";
/* 4468 */       mItems = "1,2,3,4,1,1,1,2,2,2,2,2,5";
/* 4469 */       monsterID = "10";
/* 4470 */       mLevel = "19";
/*      */     }
/*      */ 
/* 4474 */     if ((q.equals("11")) || (q.equals("Captain")))
/*      */     {
/* 4476 */       mName = "Captain";
/* 4477 */       mHP = "20";
/* 4478 */       mDesc = "A skillfull warrior in his top phisique.";
/* 4479 */       mGold = "20";
/* 4480 */       mExp = "23";
/* 4481 */       mItems = "1,2,3,1,1,1,1,1,1,1,1,1,1,2,2,2,2,4,5";
/* 4482 */       monsterID = "11";
/* 4483 */       mLevel = "22";
/*      */     }
/*      */ 
/* 4487 */     if ((q.equals("13")) || (q.equals("Taurus")))
/*      */     {
/* 4489 */       mName = "Taurus";
/* 4490 */       mHP = "30";
/* 4491 */       mDesc = "Stunning display with flail accuracy. Watch out.";
/* 4492 */       mGold = "26";
/* 4493 */       mExp = "22";
/* 4494 */       mItems = "1,2,3,4,1,1,1,2,2,2,2,4,5,1,1,1,2,2,2,2,4,5,1,1,1,2,2,2,2,4,5";
/* 4495 */       monsterID = "13";
/* 4496 */       mLevel = "7";
/*      */     }
/*      */ 
/* 4500 */     if ((q.equals("13")) || (q.equals("Maggot")))
/*      */     {
/* 4502 */       mName = "Maggot";
/* 4503 */       mHP = "4";
/* 4504 */       mDesc = "Eww, a maggot.";
/* 4505 */       mGold = "3";
/* 4506 */       mExp = "3";
/* 4507 */       mItems = "1";
/* 4508 */       monsterID = "13";
/* 4509 */       mLevel = "3";
/*      */     }
/*      */ 
/* 4513 */     if ((q.equals("14")) || (q.equals("Catapillar")))
/*      */     {
/* 4515 */       mName = "Catapillar";
/* 4516 */       mHP = "3";
/* 4517 */       mDesc = "It's an insect -- the *drum roll* catapillar!";
/* 4518 */       mGold = "2";
/* 4519 */       mExp = "2";
/* 4520 */       mItems = "1";
/* 4521 */       monsterID = "14";
/* 4522 */       mLevel = "4";
/*      */     }
/*      */ 
/* 4526 */     if ((q.equals("15")) || (q.equals("Wasp")))
/*      */     {
/* 4528 */       mName = "Wasp";
/* 4529 */       mHP = "2";
/* 4530 */       mDesc = "Kill it, quickly! They sting and stuff.";
/* 4531 */       mGold = "1";
/* 4532 */       mExp = "1";
/* 4533 */       mItems = "1";
/* 4534 */       monsterID = "15";
/* 4535 */       mLevel = "1";
/*      */     }
/*      */ 
/* 4539 */     if ((q.equals("16")) || (q.equals("Human Knight")))
/*      */     {
/* 4541 */       mName = "Human Knight";
/* 4542 */       mHP = "19";
/* 4543 */       mDesc = "Mastered the skill of a swordmen.";
/* 4544 */       mGold = "16";
/* 4545 */       mExp = "15";
/* 4546 */       mItems = "1,2,3,4,1,2,3,4,1,2,3,4,1,2,3,4";
/* 4547 */       monsterID = "16";
/* 4548 */       mLevel = "21";
/*      */     }
/*      */ 
/* 4552 */     if ((q.equals("17")) || (q.equals("Basilisk")))
/*      */     {
/* 4554 */       mName = "Basilisk";
/* 4555 */       mHP = "25";
/* 4556 */       mDesc = "A deadly creature from the old times.";
/* 4557 */       mGold = "22";
/* 4558 */       mExp = "19";
/* 4559 */       mItems = "1,2,3,4";
/* 4560 */       monsterID = "17";
/* 4561 */       mLevel = "25";
/*      */     }
/*      */ 
/* 4565 */     if ((q.equals("18")) || (q.equals("Red Dragon")))
/*      */     {
/* 4567 */       mName = "Red Dragon";
/* 4568 */       mHP = "28";
/* 4569 */       mDesc = "A fire-breathing dragon.";
/* 4570 */       mGold = "29";
/* 4571 */       mExp = "29";
/* 4572 */       mItems = "5";
/* 4573 */       monsterID = "18";
/* 4574 */       mLevel = "30";
/*      */     }
/*      */ 
/* 4579 */     return new String[] { mName, mHP, mDesc, mGold, mExp, mItems, monsterID, mLevel };
/*      */   }
/*      */ 
/*      */   public String[] getItem(String e)
/*      */   {
/* 4605 */     String name = "Null";
/* 4606 */     String desc = "None";
/*      */ 
/* 4608 */     String attackAdd = "0";
/* 4609 */     String defenseAdd = "0";
/* 4610 */     String canSell = "false";
/* 4611 */     String canEat = "false";
/* 4612 */     String earnedCoins = "0";
/* 4613 */     String typeOfItem = "0";
/* 4614 */     String itemID = "0";
/*      */ 
/* 4616 */     if ((e.equals("1")) || (e.equals("Battleaxe")))
/*      */     {
/* 4618 */       name = "Battleaxe";
/* 4619 */       this.typeOf = "2";
/* 4620 */       attackAdd = "4";
/* 4621 */       earnedCoins = "10";
/* 4622 */       typeOfItem = "1";
/* 4623 */       itemID = "1";
/* 4624 */       desc = "Double the sharpness, double the fun!";
/*      */     }
/*      */ 
/* 4627 */     if ((e.equals("2")) || (e.equals("Flail")))
/*      */     {
/* 4629 */       name = "Flail";
/* 4630 */       this.typeOf = "2";
/* 4631 */       attackAdd = "2";
/* 4632 */       earnedCoins = "5";
/* 4633 */       typeOfItem = "1";
/* 4634 */       itemID = "2";
/* 4635 */       desc = "A spiked ball on a chain with a handle. Neat.";
/*      */     }
/*      */ 
/* 4638 */     if ((e.equals("3")) || (e.equals("Sword")))
/*      */     {
/* 4640 */       name = "Sword";
/* 4641 */       this.typeOf = "2";
/* 4642 */       attackAdd = "6";
/* 4643 */       earnedCoins = "15";
/* 4644 */       typeOfItem = "1";
/* 4645 */       itemID = "3";
/* 4646 */       desc = "Only the most generic weapon in today's RPGs... ever.";
/*      */     }
/*      */ 
/* 4649 */     if ((e.equals("4")) || (e.equals("Big Hammer")))
/*      */     {
/* 4651 */       name = "Big Hammer";
/* 4652 */       this.typeOf = "2";
/* 4653 */       attackAdd = "5";
/* 4654 */       earnedCoins = "25";
/* 4655 */       typeOfItem = "1";
/* 4656 */       itemID = "4";
/* 4657 */       desc = "Can be used to move large rocks and boulders. Also serves as a weapon.";
/*      */     }
/*      */ 
/* 4660 */     if ((e.equals("5")) || (e.equals("Mace")))
/*      */     {
/* 4662 */       name = "Mace";
/* 4663 */       this.typeOf = "1";
/* 4664 */       attackAdd = "2";
/* 4665 */       earnedCoins = "15";
/* 4666 */       typeOfItem = "1";
/* 4667 */       itemID = "5";
/* 4668 */       desc = "Used by magical wizards.";
/*      */     }
/*      */ 
/* 4671 */     if ((e.equals("6")) || (e.equals("Golden Platechest")))
/*      */     {
/* 4673 */       name = "Golden Platechest";
/* 4674 */       this.typeOf = "3";
/* 4675 */       defenseAdd = "10";
/* 4676 */       earnedCoins = "35";
/* 4677 */       typeOfItem = "2";
/* 4678 */       itemID = "6";
/* 4679 */       desc = "One of the rarest golden armor pieces in the game.";
/*      */     }
/*      */ 
/* 4682 */     if ((e.equals("7")) || (e.equals("Sign")))
/*      */     {
/* 4684 */       name = "Sign";
/* 4685 */       typeOfItem = "4";
/* 4686 */       itemID = "7";
/* 4687 */       desc = "Used to create signs.";
/*      */     }
/*      */ 
/* 4691 */     return new String[] { name, desc, this.typeOf, attackAdd, defenseAdd, 
/* 4692 */       canSell, canEat, earnedCoins, itemID, typeOfItem };
/*      */   }
/*      */ 
/*      */   public void showInventory()
/*      */   {
/* 4698 */     for (int i = 0; i < this.model.getSize(); i++);
/*      */   }
/*      */ 
/*      */   public int[][] loadPush(int pushMap)
/*      */   {
/* 4704 */     if (pushMap == 1) {
/* 4705 */       return new int[][] { 
/* 4706 */         new int[16], 
/* 4708 */         new int[16], 
/* 4710 */         new int[16], 
/* 4712 */         new int[16], 
/* 4714 */         new int[16], 
/* 4716 */         new int[16], 
/* 4718 */         new int[16], 
/* 4720 */         new int[16], 
/* 4722 */         new int[16], 
/* 4724 */         new int[16], 
/* 4726 */         new int[16] };
/*      */     }
/*      */ 
/* 4729 */     if (pushMap == 4)
/*      */     {
/* 4731 */       return new int[][] { 
/* 4732 */         new int[16], 
/* 4734 */         new int[16], 
/* 4736 */         { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 133, 133 }, 
/* 4738 */         { 0, 0, 0, 0, 0, 0, 133, 0, 133, 0, 133, 133 }, 
/* 4740 */         { 0, 0, 0, 0, 0, 0, 133, 133, 133, 133, 133 }, 
/* 4742 */         { 0, 0, 0, 0, 0, 0, 0, 133, 0, 0, 133, 133, 133, 133 }, 
/* 4744 */         { 0, 0, 0, 0, 0, 133, 0, 133, 0, 0, 0, 133 }, 
/* 4746 */         { 0, 0, 0, 0, 0, 0, 0, 133, 0, 133 }, 
/* 4748 */         new int[16], 
/* 4750 */         new int[16], 
/* 4752 */         new int[16] };
/*      */     }
/*      */ 
/* 4757 */     if (pushMap == 5)
/*      */     {
/* 4759 */       return new int[][] { 
/* 4760 */         new int[16], 
/* 4762 */         new int[16], 
/* 4764 */         { 0, 0, 145, 0, 145, 0, 145, 145, 145, 0, 145, 0, 145 }, 
/* 4766 */         { 0, 0, 145, 145, 145, 0, 145, 0, 145, 0, 145, 0, 145 }, 
/* 4768 */         { 0, 0, 0, 0, 145, 0, 145, 0, 145, 0, 145, 0, 145 }, 
/* 4770 */         { 0, 0, 145, 145, 145, 0, 145, 145, 145, 0, 145, 145, 145 }, 
/* 4772 */         new int[16], 
/* 4774 */         { 0, 0, 145, 0, 0, 0, 145, 0, 145, 0, 145, 145, 0, 145 }, 
/* 4776 */         { 0, 0, 145, 0, 145, 0, 145, 0, 145, 0, 145, 0, 145, 145 }, 
/* 4778 */         { 0, 0, 0, 145, 0, 145, 0, 0, 145, 0, 145, 0, 0, 145 }, 
/* 4780 */         new int[16] };
/*      */     }
/*      */ 
/* 4785 */     if ((pushMap == 2) || (pushMap == 3) || (pushMap == 6) || (pushMap == 7)) {
/* 4786 */       return new int[][] { 
/* 4787 */         new int[16], 
/* 4789 */         new int[16], 
/* 4791 */         new int[16], 
/* 4793 */         new int[16], 
/* 4795 */         new int[16], 
/* 4797 */         new int[16], 
/* 4799 */         new int[16], 
/* 4801 */         new int[16], 
/* 4803 */         new int[16], 
/* 4805 */         new int[16], 
/* 4807 */         new int[16] };
/*      */     }
/*      */ 
/* 4811 */     return this.pushBoard;
/*      */   }
/*      */ 
/*      */   public int[][] loadBoard(int map) {
/* 4815 */     if (map == 1) {
/* 4816 */       return new int[][] { 
/* 4817 */         { 1, 1, 1, 1, 1, 1, 1, 190, 115, 1, 1, 1, 1, 1, 1, 2 }, 
/* 4818 */         { 190, 190, 190, 190, 190, 190, 190, 190, 13, 148, 148, 148, 148, 148, 121, 2 }, 
/* 4819 */         { 1, 520, 127, 127, 127, 127, 127, 13, 13, 148, 167, 167, 167, 148, 343, 1 }, 
/* 4820 */         { 1, 520, 127, 166, 166, 166, 127, 13, 13, 148, 167, 167, 167, 148, 343, 1 }, 
/* 4821 */         { 1, 520, 127, 166, 166, 166, 127, 13, 13, 148, 148, 148, 183, 148, 343, 1 }, 
/* 4822 */         { 1, 520, 364, 174, 127, 361, 127, 13, 13, 13, 13, 13, 13, 13, 13, 1 }, 
/* 4823 */         { 115, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 115 }, 
/* 4824 */         { 1, 514, 13, 13, 394, 343, 145, 220, 145, 145, 145, 13, 13, 13, 13, 1 }, 
/* 4825 */         { 1, 514, 13, 13, 343, 118, 145, 166, 166, 166, 145, 13, 13, 13, 13, 1 }, 
/* 4826 */         { 1, 514, 514, 13, 118, 118, 145, 166, 166, 522, 145, 13, 13, 13, 13, 1 }, 
/* 4827 */         { 1, 1, 1, 115, 1, 1, 145, 145, 145, 145, 145, 1, 1, 1, 1, 1 } };
/*      */     }
/*      */ 
/* 4833 */     return this.board;
/*      */   }
/*      */ 
/*      */   public boolean blocked(int tx, int ty) {
/* 4837 */     return this.BLOCKED_TILES.contains(Integer.valueOf(this.board[ty][tx]));
/*      */   }
/*      */ 
/*      */   public int addAttack(int e) {
/* 4841 */     this.attack += Integer.parseInt(Integer.toString(e));
/* 4842 */     this.lAttack.setText("Attack [" + this.attack + "]");
/* 4843 */     return this.attack;
/*      */   }
/*      */ 
/*      */   public int subAttack(int e) {
/* 4847 */     this.attack -= Integer.parseInt(Integer.toString(e));
/* 4848 */     this.lAttack.setText("Attack [" + this.attack + "]");
/* 4849 */     return this.attack;
/*      */   }
/*      */ 
/*      */   public int getLevels(int exp)
/*      */   {
/* 4854 */     if (exp < 52) this.level = 2;
/* 4855 */     else if (exp < 110) this.level = 3;
/* 4856 */     else if (exp < 175) this.level = 4;
/* 4857 */     else if (exp < 246) this.level = 5;
/* 4858 */     else if (exp < 325) this.level = 6;
/* 4859 */     else if (exp < 413) this.level = 7;
/* 4860 */     else if (exp < 510) this.level = 8;
/* 4861 */     else if (exp < 616) this.level = 9;
/* 4862 */     else if (exp < 734) this.level = 10;
/* 4863 */     else if (exp < 865) this.level = 11;
/* 4864 */     else if (exp < 1008) this.level = 12;
/* 4865 */     else if (exp < 1167) this.level = 13;
/* 4866 */     else if (exp < 1342) this.level = 14;
/* 4867 */     else if (exp < 1536) this.level = 15;
/* 4868 */     else if (exp < 1749) this.level = 16;
/* 4869 */     else if (exp < 1985) this.level = 17;
/* 4870 */     else if (exp < 2245) this.level = 18;
/* 4871 */     else if (exp < 2531) this.level = 19;
/* 4872 */     else if (exp < 2848) this.level = 20;
/* 4873 */     else if (exp < 3197) this.level = 21;
/* 4874 */     else if (exp < 3582) this.level = 22;
/* 4875 */     else if (exp < 4007) this.level = 23;
/* 4876 */     else if (exp < 4476) this.level = 24;
/* 4877 */     else if (exp < 4993) this.level = 25;
/* 4878 */     else if (exp < 5564) this.level = 26;
/* 4879 */     else if (exp < 6193) this.level = 27;
/* 4880 */     else if (exp < 6888) this.level = 28;
/* 4881 */     else if (exp < 7655) this.level = 29;
/* 4882 */     else if (exp < 8502) this.level = 30;
/* 4883 */     else if (exp < 9435) this.level = 31;
/* 4884 */     else if (exp < 10466) this.level = 32;
/* 4885 */     else if (exp < 11603) this.level = 33;
/* 4886 */     else if (exp < 12858) this.level = 34;
/* 4887 */     else if (exp < 14243) this.level = 35;
/* 4888 */     else if (exp < 15772) this.level = 36;
/* 4889 */     else if (exp < 17459) this.level = 37;
/* 4890 */     else if (exp < 19321) this.level = 38;
/* 4891 */     else if (exp < 21376) this.level = 39;
/* 4892 */     else if (exp < 23644) this.level = 40;
/* 4893 */     else if (exp < 26148) this.level = 41;
/* 4894 */     else if (exp < 28912) this.level = 42;
/* 4895 */     else if (exp < 31962) this.level = 43;
/* 4896 */     else if (exp < 35329) this.level = 44;
/* 4897 */     else if (exp < 39046) this.level = 45;
/* 4898 */     else if (exp < 43149) this.level = 46;
/* 4899 */     else if (exp < 47677) this.level = 47;
/* 4900 */     else if (exp < 52677) this.level = 48;
/* 4901 */     else if (exp < 58195) this.level = 49;
/* 4902 */     else if (exp < 64288) this.level = 50;
/* 4903 */     else if (exp < 71013) this.level = 51;
/* 4904 */     else if (exp < 78437) this.level = 52;
/* 4905 */     else if (exp < 86633) this.level = 53;
/* 4906 */     else if (exp < 95681) this.level = 54;
/* 4907 */     else if (exp < 105670) this.level = 55;
/* 4908 */     else if (exp < 116697) this.level = 56;
/* 4909 */     else if (exp < 128871) this.level = 57;
/* 4910 */     else if (exp < 142311) this.level = 58;
/* 4911 */     else if (exp < 157148) this.level = 59;
/* 4912 */     else if (exp < 173529) this.level = 60;
/* 4913 */     else if (exp < 191614) this.level = 61;
/* 4914 */     else if (exp < 211579) this.level = 62;
/* 4915 */     else if (exp < 233622) this.level = 63;
/* 4916 */     else if (exp < 257958) this.level = 64;
/* 4917 */     else if (exp < 284825) this.level = 65;
/* 4918 */     else if (exp < 314487) this.level = 66;
/* 4919 */     else if (exp < 347236) this.level = 67;
/* 4920 */     else if (exp < 383392) this.level = 68;
/* 4921 */     else if (exp < 423310) this.level = 69;
/* 4922 */     else if (exp < 467382) this.level = 70;
/* 4923 */     else if (exp < 516039) this.level = 71;
/* 4924 */     else if (exp < 569760) this.level = 72;
/* 4925 */     else if (exp < 629070) this.level = 73;
/* 4926 */     else if (exp < 694553) this.level = 74;
/* 4927 */     else if (exp < 766850) this.level = 75;
/* 4928 */     else if (exp < 846671) this.level = 76;
/* 4929 */     else if (exp < 934799) this.level = 77;
/* 4930 */     else if (exp < 1032098) this.level = 78;
/* 4931 */     else if (exp < 1139523) this.level = 79;
/* 4932 */     else if (exp < 1258129) this.level = 80;
/* 4933 */     else if (exp < 1389078) this.level = 81;
/* 4934 */     else if (exp < 1533655) this.level = 82;
/* 4935 */     else if (exp < 1693280) this.level = 83;
/* 4936 */     else if (exp < 1869518) this.level = 84;
/* 4937 */     else if (exp < 2064099) this.level = 85;
/* 4938 */     else if (exp < 2278932) this.level = 86;
/* 4939 */     else if (exp < 2516125) this.level = 87;
/* 4940 */     else if (exp < 2778005) this.level = 88;
/* 4941 */     else if (exp < 3067142) this.level = 89;
/* 4942 */     else if (exp < 3386373) this.level = 90;
/* 4943 */     else if (exp < 3738830) this.level = 91;
/* 4944 */     else if (exp < 4127973) this.level = 92;
/* 4945 */     else if (exp < 4557619) this.level = 93;
/* 4946 */     else if (exp < 5031985) this.level = 94;
/* 4947 */     else if (exp < 5555725) this.level = 95;
/* 4948 */     else if (exp < 6133979) this.level = 96;
/* 4949 */     else if (exp < 6772421) this.level = 97;
/* 4950 */     else if (exp < 7477315) this.level = 98;
/* 4951 */     else if (exp < 8255580) this.level = 99;
/*      */ 
/* 4953 */     return this.level;
/*      */   }
/*      */ 
/*      */   public boolean pushable(int pushableTile)
/*      */   {
/* 4959 */     if (pushableTile != 0) {
/* 4960 */       return true;
/*      */     }
/* 4962 */     return false;
/*      */   }
/*      */ 
/*      */   public boolean isInBound(int r, int c)
/*      */   {
/* 4968 */     return (r >= 0) && (r < 8) && (c >= 12) && (c < 1);
/*      */   }
/*      */ 
/*      */   class GamePanel extends JPanel
/*      */   {
/*      */     GamePanel()
/*      */     {
/*      */     }
/*      */ 
/*      */     public void paintComponent(Graphics g)
/*      */     {
/* 4993 */       for (Game.this.row = 0; Game.this.row < Game.this.board.length; Game.this.row += 1) {
/* 4994 */         for (Game.this.col = 0; Game.this.col < Game.this.board[Game.this.row].length; Game.this.col += 1) {
/* 4995 */           int index = Game.this.board[Game.this.row][Game.this.col];
/* 4996 */           g.drawImage(Game.this.tiles[index], 32 * Game.this.col, 32 * Game.this.row, this);
/*      */         }
/*      */       }
/*      */ 
/* 5000 */       getParent().validate();
/* 5001 */       getToolkit().sync();
/*      */       try
/*      */       {
/* 5011 */         for (Game.this.prow = 0; Game.this.prow < Game.this.pushBoard.length; Game.this.prow += 1)
/* 5012 */           for (Game.this.pcol = 0; Game.this.pcol < Game.this.pushBoard[Game.this.prow].length; Game.this.pcol += 1) {
/* 5013 */             int pindex = Game.this.pushBoard[Game.this.prow][Game.this.pcol];
/* 5014 */             if (pindex != 0)
/* 5015 */               g.drawImage(Game.this.tiles[pindex], 32 * Game.this.pcol, 32 * Game.this.prow, this);
/*      */           }
/*      */       }
/*      */       catch (Exception ew)
/*      */       {
/* 5020 */         ew.printStackTrace();
/*      */       }
/*      */ 
/* 5030 */       for (int i = 0; i < Game.this.droppedItems.size(); i++) {
/* 5031 */         String[] drawItem = ((String)Game.this.droppedItems.get(i)).split("\\|");
/*      */ 
/* 5036 */         if (Game.this.currentMap == Integer.parseInt(drawItem[3])) {
/* 5037 */           int itemIDDraw = Integer.parseInt(drawItem[0]) - 1;
/* 5038 */           int itemX = Integer.parseInt(drawItem[1]);
/* 5039 */           int itemY = Integer.parseInt(drawItem[2]);
/*      */           try
/*      */           {
/* 5044 */             g.drawImage(Game.this.weapon[itemIDDraw], 32 * itemX, 32 * itemY, this); } catch (Exception localException1) {
/*      */           }
/* 5046 */           Game.this.myCommand = "drop";
/*      */         }
/*      */       }
/*      */       String[] drawMonster;
/* 5053 */       for (int i = 0; i < Game.this.monstersActive.size(); i++) {
/* 5054 */         drawMonster = ((String)Game.this.monstersActive.get(i)).split("\\|");
/*      */ 
/* 5056 */         int monsterNo = Integer.parseInt(Game.this.getMonster(drawMonster[0])[6]) - 1;
/*      */ 
/* 5058 */         if (Game.this.currentMap == Integer.parseInt(drawMonster[3])) {
/* 5059 */           int monsterDrawID = Integer.parseInt(drawMonster[0]) - 1;
/* 5060 */           int dMonsX = Integer.parseInt(drawMonster[1]);
/* 5061 */           int dMonsY = Integer.parseInt(drawMonster[2]);
/*      */           try {
/* 5063 */             g.drawImage(Game.this.monster[monsterDrawID], 32 * dMonsX, 32 * dMonsY, this); } catch (Exception localException2) {
/*      */           }
/* 5065 */           Game.this.myCommand = "addMonster";
/*      */         }
/*      */ 
/*      */       }
/*      */ 
/*      */       try
/*      */       {
/* 5073 */         for (Player player : Game.this.players.values())
/*      */         {
/* 5076 */           if (player.getUsername() == Game.this.me.getUsername())
/* 5077 */             player.setMap(Game.this.currentMap);
/* 5078 */           if (player.getUsername() == Game.this.me.getUsername())
/* 5079 */             player.setCommand(Game.this.myCommand);
/* 5080 */           if (player.getMap() == Game.this.currentMap) {
/* 5081 */             g.drawImage(player.getPlayerImage(), player.getX(), player
/* 5082 */               .getY(), this);
/*      */           }
/*      */ 
/*      */         }
/*      */ 
/*      */       }
/*      */       catch (Exception localException3)
/*      */       {
/*      */       }
/*      */ 
/* 5096 */       int runOnce = 0;
/* 5097 */       while (runOnce > 1) {
/* 5098 */         repaint();
/* 5099 */         runOnce++;
/*      */       }
/*      */     }
/*      */   }
/*      */ 
/*      */   class LeftArmListener extends MouseAdapter
/*      */   {
/*      */     LeftArmListener()
/*      */     {
/*      */     }
/*      */ 
/*      */     public void mousePressed(MouseEvent lae)
/*      */     {
/* 2014 */       checkPopup(lae);
/*      */     }
/*      */ 
/*      */     public void mouseClicked(MouseEvent lae)
/*      */     {
/* 2019 */       checkPopup(lae);
/*      */     }
/*      */ 
/*      */     public void mouseReleased(MouseEvent lae)
/*      */     {
/* 2024 */       checkPopup(lae);
/*      */     }
/*      */ 
/*      */     private void checkPopup(MouseEvent lae)
/*      */     {
/* 2029 */       if (lae.isPopupTrigger())
/*      */       {
/* 2034 */         Object actItemx = Integer.valueOf(Game.this.leftArmWear + 1);
/*      */ 
/* 2039 */         String isAWeapon = Game.this.getItem(actItemx.toString())[9];
/* 2040 */         String listWepName = Game.this.getItem(actItemx.toString())[0];
/*      */ 
/* 2043 */         Game.this.leftArmPopup.add(Game.this.unequipMenuItem);
/* 2044 */         Game.this.unequipMenuItem.setText("Unequip " + listWepName);
/* 2045 */         Game.this.leftArmPopup.add(Game.this.dropMenuItem);
/* 2046 */         Game.this.dropMenuItem.setText("Drop " + listWepName);
/*      */ 
/* 2049 */         if (Game.this.leftArmWear != 0) {
/* 2050 */           Game.this.leftArmPopup.add(Game.this.unequipMenuItem);
/* 2051 */           Game.this.leftArmPopup.add(Game.this.dropMenuItem);
/*      */         }
/* 2053 */         Game.this.leftArmPopup.add(Game.this.cancelMenuItem);
/*      */ 
/* 2057 */         Game.this.leftArmPopup.show(Game.this.btLeftArmIcon, lae.getX(), lae.getY());
/* 2058 */         Game.this.leftArmPopup.revalidate();
/*      */       }
/*      */     }
/*      */   }
/*      */ 
/*      */   class MousePopupListener extends MouseAdapter
/*      */   {
/*      */     MousePopupListener()
/*      */     {
/*      */     }
/*      */ 
/*      */     public void mousePressed(MouseEvent e)
/*      */     {
/* 1955 */       checkPopup(e);
/*      */     }
/*      */ 
/*      */     public void mouseClicked(MouseEvent e)
/*      */     {
/* 1960 */       checkPopup(e);
/*      */     }
/*      */ 
/*      */     public void mouseReleased(MouseEvent e)
/*      */     {
/* 1965 */       checkPopup(e);
/*      */     }
/*      */ 
/*      */     private void checkPopup(MouseEvent e)
/*      */     {
/* 1970 */       if (e.isPopupTrigger())
/*      */       {
/* 1974 */         int itemSelectx = Game.this.list.getSelectedIndex();
/* 1975 */         Object actItemx = Game.this.list.getModel().getElementAt(itemSelectx);
/*      */ 
/* 1978 */         String isAWeapon = Game.this.getItem(actItemx.toString())[9];
/* 1979 */         String listWepName = Game.this.getItem(actItemx.toString())[0];
/*      */ 
/* 1983 */         if (isAWeapon == "1") {
/* 1984 */           Game.this.popup.add(Game.this.equipMenuItem);
/* 1985 */           Game.this.equipMenuItem.setText("Equip " + listWepName);
/* 1986 */           Game.this.popup.add(Game.this.dropMenuItem);
/* 1987 */           Game.this.dropMenuItem.setText("Drop " + listWepName);
/*      */         }
/*      */ 
/* 1990 */         if (isAWeapon == "2") {
/* 1991 */           Game.this.popup.add(Game.this.equipMenuItem);
/* 1992 */           Game.this.equipMenuItem.setText("Equip " + listWepName);
/* 1993 */           Game.this.popup.add(Game.this.dropMenuItem);
/* 1994 */           Game.this.dropMenuItem.setText("Drop " + listWepName);
/*      */         }
/*      */ 
/* 1999 */         Game.this.popup.add(Game.this.cancelMenuItem);
/*      */ 
/* 2002 */         Game.this.popup.show(Game.this.list, e.getX(), e.getY());
/* 2003 */         Game.this.popup.revalidate();
/*      */       }
/*      */     }
/*      */   }
/*      */ }

/* Location:           C:\wamp\www\mystikv2\
 * Qualified Name:     mystik.Game
 * JD-Core Version:    0.6.2
 */