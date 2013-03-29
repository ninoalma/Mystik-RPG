Mystik RPG is a Java 2D Tile Sandbox RPG.

To put on webpage, create new HTML file and save as "play.html" or something like that and make sure the jar file is in same directory.

    <applet name="game" code="mystik.Game" archive="mystik-game.jar" width="630" height="521">
    <param name="name" value="Username_Here" />
    </applet>

Things to note:

Username_Here is value of username that is handled by client ... your browser.
me.gif is your player avatar image that is bundled with your jar file
tiles/ directory contains

Your map and items/monster files are kept in APPDATA in the Roaming folder titled under ".mystik". If you search for ".mystik" in your computer, you should find it.

Mystik RPG uses Google JSON reader for Java... but it's a bit out-dated so you're going to have to use an old version which you can get here: http://mystikrpg.com/gson-1.7.1.jar

===========

How to install

1. Make new Eclipse project
2. Download gson-1.7.1.jar (http://mystikrpg.com/gson-1.7.1.jar) and add as "external jar" library
3. Download Java files, /tile/ directory and me.gif
3. Drag-drop into /src folder
4. Run as java-applet