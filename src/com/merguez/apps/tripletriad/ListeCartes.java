package com.merguez.apps.tripletriad;

import java.util.Vector;

import android.content.Context;

import com.merguez.apps.tripletriad.cards.Card;
import com.merguez.apps.tripletriad.cards.Card.Element;

public class ListeCartes {

	public static Vector<Card> defaut;
	
	public void fonction() {
		
		Context context;
		
		defaut.add(new Card(context,"Levrikon", 7, 1, 4, 2, 4, Element.NONE)); // mettre 10 si A
		
		
		
		execSQL("INSERT INTO Cards VALUES (\"Levrikon\", 7, 1, \"1\", \"4\", \"2\", \"4\", \"\")");
		execSQL("INSERT INTO Cards VALUES (\"Mu\", 7, 1, \"3\", \"2\", \"2\", \"3\", \"\")");
		execSQL("INSERT INTO Cards VALUES (\"SwordDance\", 7, 1, \"5\", \"2\", \"3\", \"2\", \"\")");
		execSQL("INSERT INTO Cards VALUES (\"Mandragora\", 7, 1, \"1\", \"2\", \"6\", \"6\", \"\")");
		execSQL("INSERT INTO Cards VALUES (\"Formula\", 7, 1, \"1\", \"5\", \"2\", \"3\", \"\")");
		execSQL("INSERT INTO Cards VALUES (\"Kalm\", 7, 1, \"4\", \"4\", \"2\", \"1\", \"\")");
		execSQL("INSERT INTO Cards VALUES (\"1stRay\", 7, 1, \"1\", \"1\", \"4\", \"5\", \"\")");
		execSQL("INSERT INTO Cards VALUES (\"Cockatrice\", 7, 1, \"2\", \"5\", \"3\", \"1\", \"\")");
		execSQL("INSERT INTO Cards VALUES (\"DorkyFace\", 7, 1, \"2\", \"1\", \"6\", \"1\", \"\")");
		execSQL("INSERT INTO Cards VALUES (\"DevilRide\", 7, 1, \"4\", \"1\", \"5\", \"3\", \"\")");
		execSQL("INSERT INTO Cards VALUES (\"MP\", 7, 1, \"2\", \"1\", \"3\", \"6\", \"\")");
		
		execSQL("INSERT INTO Cards VALUES (\"Aphide\", 8, 1, \"2\", \"4\", \"4\", \"1\", \"Thunder\")");
		execSQL("INSERT INTO Cards VALUES (\"Bogomile\", 8, 1, \"1\", \"5\", \"1\", \"4\", \"\")");
		execSQL("INSERT INTO Cards VALUES (\"Carnidea\", 8, 1, \"2\", \"1\", \"6\", \"1\", \"\")");
		execSQL("INSERT INTO Cards VALUES (\"Diodon\", 8, 1, \"3\", \"1\", \"2\", \"5\", \"\")");
		execSQL("INSERT INTO Cards VALUES (\"Elastos\", 8, 1, \"1\", \"1\", \"4\", \"5\", \"\")");
		execSQL("INSERT INTO Cards VALUES (\"Fungus\", 8, 1, \"5\", \"3\", \"1\", \"1\", \"\")");
		execSQL("INSERT INTO Cards VALUES (\"Gallus\", 8, 1, \"2\", \"6\", \"1\", \"2\", \"Thunder\")");
		execSQL("INSERT INTO Cards VALUES (\"Incube\", 8, 1, \"2\", \"5\", \"1\", \"3\", \"\")");
		execSQL("INSERT INTO Cards VALUES (\"Larva\", 8, 1, \"4\", \"3\", \"4\", \"2\", \"\")");
		execSQL("INSERT INTO Cards VALUES (\"Nocturnus\", 8, 1, \"6\", \"2\", \"1\", \"1\", \"\")");
		
		execSQL("INSERT INTO Cards VALUES (\"Aeon\", 10, 1, \"1\", \"2\", \"2\", \"5\", \"\")");
		execSQL("INSERT INTO Cards VALUES (\"Piranha\", 10, 1, \"1\", \"1\", \"4\", \"3\", \"Water\")");
		execSQL("INSERT INTO Cards VALUES (\"Garm\", 10, 1, \"3\", \"3\", \"4\", \"1\", \"\")");
		execSQL("INSERT INTO Cards VALUES (\"Nebiros\", 10, 1, \"5\", \"2\", \"1\", \"3\", \"\")");
		execSQL("INSERT INTO Cards VALUES (\"Fungus\", 10, 1, \"1\", \"3\", \"1\", \"5\", \"\")");
		execSQL("INSERT INTO Cards VALUES (\"FlambosEau\", 10, 1, \"1\", \"2\", \"4\", \"4\", \"Water\")");
		execSQL("INSERT INTO Cards VALUES (\"MachineAlbhed\", 10, 1, \"5\", \"4\", \"2\", \"2\", \"\")");
		execSQL("INSERT INTO Cards VALUES (\"Alcione\", 10, 1, \"4\", \"4\", \"2\", \"2\", \"Wind\")");
		execSQL("INSERT INTO Cards VALUES (\"ElementaireBlanc\", 10, 1, \"5\", \"1\", \"2\", \"2\", \"Ice\")");
		execSQL("INSERT INTO Cards VALUES (\"FlambosFoudre\", 10, 1, \"5\", \"5\", \"1\", \"1\", \"Thunder\")");
		execSQL("INSERT INTO Cards VALUES (\"ElementaireDore\", 10, 1, \"3\", \"2\", \"3\", \"4\", \"Thunder\")");
		execSQL("INSERT INTO Cards VALUES (\"ElementaireRouge\", 10, 1, \"4\", \"2\", \"1\", \"6\", \"Fire\")");
		
		execSQL("INSERT INTO Cards VALUES (\"AttackSquad\", 7, 2, \"7\", \"2\", \"1\", \"3\", \"\")");
		execSQL("INSERT INTO Cards VALUES (\"Bomb\", 7, 2, \"7\", \"4\", \"1\", \"1\", \"Fire\")");
		execSQL("INSERT INTO Cards VALUES (\"Custom\", 7, 2, \"4\", \"2\", \"6\", \"6\", \"Thunder\")");
		execSQL("INSERT INTO Cards VALUES (\"Grangalan\", 7, 2, \"5\", \"4\", \"3\", \"2\", \"\")");
		execSQL("INSERT INTO Cards VALUES (\"Grunt\", 7, 2, \"6\", \"2\", \"4\", \"2\", \"\")");
		execSQL("INSERT INTO Cards VALUES (\"Snow\", 7, 2, \"4\", \"4\", \"5\", \"2\", \"Ice\")");
		execSQL("INSERT INTO Cards VALUES (\"TouchMe\", 7, 2, \"5\", \"3\", \"5\", \"3\", \"\")");
		execSQL("INSERT INTO Cards VALUES (\"ArkDragon\", 7, 2, \"2\", \"5\", \"3\", \"5\", \"\")");
		execSQL("INSERT INTO Cards VALUES (\"UnderLizard\", 7, 2, \"5\", \"2\", \"5\", \"2\", \"\")");
		execSQL("INSERT INTO Cards VALUES (\"BlackBat\", 7, 2, \"4\", \"4\", \"5\", \"3\", \"\")");
		execSQL("INSERT INTO Cards VALUES (\"Deenglow\", 7, 2, \"3\", \"2\", \"2\", \"7\", \"\")");
		
		execSQL("INSERT INTO Cards VALUES (\"Arcanada\", 8, 2, \"5\", \"5\", \"3\", \"1\", \"Poison\")");
		execSQL("INSERT INTO Cards VALUES (\"Feng\", 8, 2, \"4\", \"2\", \"5\", \"4\", \"Thunder\")");
		execSQL("INSERT INTO Cards VALUES (\"Formicide\", 8, 2, \"5\", \"2\", \"5\", \"2\", \"Thunder\")");
		execSQL("INSERT INTO Cards VALUES (\"Hera\", 8, 2, \"3\", \"7\", \"1\", \"2\", \"\")");
		execSQL("INSERT INTO Cards VALUES (\"Koatl\", 8, 2, \"3\", \"3\", \"5\", \"4\", \"\")");
		execSQL("INSERT INTO Cards VALUES (\"Licorne\", 8, 2, \"5\", \"4\", \"3\", \"3\", \"\")");
		execSQL("INSERT INTO Cards VALUES (\"Malaku\", 8, 2, \"5\", \"5\", \"2\", \"3\", \"Wind\")");
		execSQL("INSERT INTO Cards VALUES (\"Orchida\", 8, 2, \"7\", \"1\", \"3\", \"1\", \"\")");
		execSQL("INSERT INTO Cards VALUES (\"Schizoid\", 8, 2, \"6\", \"3\", \"2\", \"2\", \"\")");
		execSQL("INSERT INTO Cards VALUES (\"Selek\", 8, 2, \"5\", \"3\", \"5\", \"2\", \"\")");
		execSQL("INSERT INTO Cards VALUES (\"Xilopode\", 8, 2, \"6\", \"3\", \"1\", \"4\", \"Ice\")");
		
		execSQL("INSERT INTO Cards VALUES (\"Malbernardo\", 10, 3, \"6\", \"6\", \"3\", \"2\", \"\")");
		execSQL("INSERT INTO Cards VALUES (\"FlambosFeu\", 10, 3, \"4\", \"5\", \"5\", \"3\", \"Fire\")");
		execSQL("INSERT INTO Cards VALUES (\"Kusarik\", 10, 3, \"4\", \"4\", \"5\", \"5\", \"Thunder\")");
		execSQL("INSERT INTO Cards VALUES (\"Thytan\", 10, 3, \"5\", \"5\", \"5\", \"3\", \"\")");
		execSQL("INSERT INTO Cards VALUES (\"Chimera\", 10, 3, \"5\", \"5\", \"4\", \"4\", \"Water\")");
		execSQL("INSERT INTO Cards VALUES (\"VerDesSables\", 10, 3, \"5\", \"6\", \"2\", \"4\", \"\")");
		execSQL("INSERT INTO Cards VALUES (\"Anacondar\", 10, 3, \"4\", \"4\", \"4\", \"4\", \"Poison\")");
		execSQL("INSERT INTO Cards VALUES (\"Larva\", 10, 3, \"5\", \"2\", \"6\", \"3\", \"Poison\")");
		execSQL("INSERT INTO Cards VALUES (\"Cougar\", 10, 3, \"6\", \"6\", \"2\", \"3\", \"\")");
		execSQL("INSERT INTO Cards VALUES (\"Spectre\", 10, 3, \"1\", \"7\", \"6\", \"3\", \"\")");
		execSQL("INSERT INTO Cards VALUES (\"Adamanthart\", 10, 3, \"6\", \"6\", \"4\", \"2\", \"Earth\")");
		execSQL("INSERT INTO Cards VALUES (\"Behemot\", 10, 3, \"7\", \"7\", \"1\", \"3\", \"Thunder\")");
		
		execSQL("INSERT INTO Cards VALUES (\"Zem\", 7, 3, \"3\", \"6\", \"6\", \"2\", \"Wind\")");
		execSQL("INSERT INTO Cards VALUES (\"Jemnezmy\", 7, 3, \"6\", \"3\", \"6\", \"2\", \"\")");
		execSQL("INSERT INTO Cards VALUES (\"ArmoredGolem\", 7, 3, \"5\", \"5\", \"3\", \"5\", \"\")");
		execSQL("INSERT INTO Cards VALUES (\"Cactuar\", 7, 3, \"7\", \"5\", \"1\", \"3\", \"\")");
		execSQL("INSERT INTO Cards VALUES (\"DeathDealer\", 7, 3, \"2\", \"7\", \"5\", \"3\", \"\")");
		execSQL("INSERT INTO Cards VALUES (\"CrazySaw\", 7, 3, \"3\", \"5\", \"3\", \"6\", \"Thunder\")");
		execSQL("INSERT INTO Cards VALUES (\"Hochu\", 7, 3, \"5\", \"6\", \"4\", \"2\", \"\")");
		execSQL("INSERT INTO Cards VALUES (\"MightyGrunt\", 7, 3, \"7\", \"4\", \"2\", \"2\", \"\")");
		execSQL("INSERT INTO Cards VALUES (\"RouletteCannon\", 7, 3, \"2\", \"6\", \"6\", \"2\", \"\")");
		execSQL("INSERT INTO Cards VALUES (\"DesertSahagin\", 7, 3, \"6\", \"3\", \"4\", \"4\", \"\")");
		execSQL("INSERT INTO Cards VALUES (\"Goblin\", 7, 3, \"7\", \"2\", \"5\", \"3\", \"Earth\")");
		
		execSQL("INSERT INTO Cards VALUES (\"Adephage\", 8, 3, \"3\", \"5\", \"5\", \"5\", \"Poison\")");
		execSQL("INSERT INTO Cards VALUES (\"Barbarian\", 8, 3, \"5\", \"4\", \"6\", \"2\", \"Fire\")");
		execSQL("INSERT INTO Cards VALUES (\"Berseker\", 8, 3, \"4\", \"2\", \"7\", \"4\", \"Fire\")");
		execSQL("INSERT INTO Cards VALUES (\"Celebis\", 8, 3, \"7\", \"5\", \"3\", \"2\", \"Earth\")");
		execSQL("INSERT INTO Cards VALUES (\"Pampa\", 8, 3, \"6\", \"3\", \"6\", \"2\", \"\")");
		execSQL("INSERT INTO Cards VALUES (\"Phantom\", 8, 3, \"7\", \"3\", \"1\", \"5\", \"Earth\")");
		execSQL("INSERT INTO Cards VALUES (\"Satyrux\", 8, 3, \"7\", \"3\", \"5\", \"1\", \"Ice\")");
		execSQL("INSERT INTO Cards VALUES (\"Scavenger\", 8, 3, \"6\", \"6\", \"3\", \"1\", \"Earth\")");
		execSQL("INSERT INTO Cards VALUES (\"Tomberry\", 8, 3, \"3\", \"4\", \"4\", \"6\", \"\")");
		execSQL("INSERT INTO Cards VALUES (\"Trogiidae\", 8, 3, \"5\", \"3\", \"3\", \"6\", \"\")");
		execSQL("INSERT INTO Cards VALUES (\"Weevil\", 8, 3, \"6\", \"2\", \"3\", \"6\", \"\")");
		
		execSQL("INSERT INTO Cards VALUES (\"Sahagin\", 10, 2, \"7\", \"1\", \"2\", \"2\", \"Water\")");
		execSQL("INSERT INTO Cards VALUES (\"Octopus\", 10, 2, \"6\", \"3\", \"3\", \"2\", \"Water\")");
		execSQL("INSERT INTO Cards VALUES (\"Epej\", 10, 2, \"5\", \"6\", \"1\", \"2\", \"\")");
		execSQL("INSERT INTO Cards VALUES (\"Galkimasera\", 10, 2, \"6\", \"3\", \"4\", \"1\", \"Thunder\")");
		execSQL("INSERT INTO Cards VALUES (\"Arhiman\", 10, 2, \"4\", \"3\", \"3\", \"4\", \"\")");
		execSQL("INSERT INTO Cards VALUES (\"ElementaireBleu\", 10, 2, \"6\", \"1\", \"2\", \"5\", \"Water\")");
		execSQL("INSERT INTO Cards VALUES (\"Echenis\", 10, 2, \"5\", \"5\", \"1\", \"3\", \"Water\")");
		execSQL("INSERT INTO Cards VALUES (\"Balsamine\", 10, 2, \"4\", \"3\", \"4\", \"2\", \"\")");
		execSQL("INSERT INTO Cards VALUES (\"Aquelous\", 10, 2, \"5\", \"3\", \"5\", \"1\", \"Water\")");
		execSQL("INSERT INTO Cards VALUES (\"Bicorne\", 10, 2, \"5\", \"5\", \"2\", \"2\", \"\")");
		execSQL("INSERT INTO Cards VALUES (\"FlambosGlace\", 10, 2, \"6\", \"2\", \"6\", \"2\", \"Ice\")");
		execSQL("INSERT INTO Cards VALUES (\"Piros\", 10, 2, \"7\", \"2\", \"4\", \"2\", \"Fire\")");
		
		execSQL("INSERT INTO Cards VALUES (\"Solid1st\", 7, 4, \"3\", \"3\", \"6\", \"7\", \"\")");
		execSQL("INSERT INTO Cards VALUES (\"Solid2nd\", 7, 4, \"7\", \"2\", \"6\", \"4\", \"\")");
		execSQL("INSERT INTO Cards VALUES (\"Solid3rd\", 7, 4, \"2\", \"7\", \"1\", \"8\", \"\")");
		execSQL("INSERT INTO Cards VALUES (\"BatteryCap\", 7, 4, \"4\", \"4\", \"7\", \"3\", \"\")");
		execSQL("INSERT INTO Cards VALUES (\"Unknown1\", 7, 4, \"6\", \"6\", \"2\", \"2\", \"Fire\")");
		execSQL("INSERT INTO Cards VALUES (\"MidgarZolom\", 7, 4, \"3\", \"7\", \"6\", \"3\", \"\")");
		execSQL("INSERT INTO Cards VALUES (\"MagicPot\", 7, 4, \"1\", \"6\", \"4\", \"7\", \"\")");
		execSQL("INSERT INTO Cards VALUES (\"HammerBlaster\", 7, 4, \"7\", \"3\", \"2\", \"5\", \"Thunder\")");
		execSQL("INSERT INTO Cards VALUES (\"Doorbull\", 7, 4, \"4\", \"4\", \"4\", \"7\", \"\")");
		execSQL("INSERT INTO Cards VALUES (\"GasDucter\", 7, 4, \"7\", \"3\", \"3\", \"6\", \"\")");
		execSQL("INSERT INTO Cards VALUES (\"Foulander\", 7, 4, \"6\", \"3\", \"6\", \"3\", \"\")");
		
		execSQL("INSERT INTO Cards VALUES (\"Ao\", 8, 4, \"4\", \"6\", \"5\", \"5\", \"Earth\")");
		execSQL("INSERT INTO Cards VALUES (\"Cariatide\", 8, 4, \"6\", \"5\", \"4\", \"5\", \"\")");
		execSQL("INSERT INTO Cards VALUES (\"Draconus\", 8, 4, \"3\", \"6\", \"3\", \"7\", \"\")");
		execSQL("INSERT INTO Cards VALUES (\"Eiffel\", 8, 4, \"2\", \"7\", \"6\", \"3\", \"\")");
		execSQL("INSERT INTO Cards VALUES (\"Marsupial\", 8, 4, \"7\", \"4\", \"4\", \"4\", \"\")");
		execSQL("INSERT INTO Cards VALUES (\"Moloch\", 8, 4, \"6\", \"3\", \"7\", \"2\", \"Poison\")");
		execSQL("INSERT INTO Cards VALUES (\"Polyphage\", 8, 4, \"7\", \"3\", \"4\", \"5\", \"Fire\")");
		execSQL("INSERT INTO Cards VALUES (\"Succube\", 8, 4, \"2\", \"3\", \"6\", \"7\", \"Fire\")");
		execSQL("INSERT INTO Cards VALUES (\"Tikal\", 8, 4, \"1\", \"7\", \"4\", \"6\", \"Thunder\")");
		execSQL("INSERT INTO Cards VALUES (\"TRex\", 8, 4, \"4\", \"7\", \"2\", \"6\", \"\")");
		execSQL("INSERT INTO Cards VALUES (\"Wendigo\", 8, 4, \"7\", \"6\", \"1\", \"3\", \"\")");
		
		execSQL("INSERT INTO Cards VALUES (\"Zauras\", 10, 4, \"6\", \"7\", \"3\", \"2\", \"Wind\")");
		execSQL("INSERT INTO Cards VALUES (\"Zuu\", 10, 4, \"6\", \"5\", \"4\", \"4\", \"\")");
		execSQL("INSERT INTO Cards VALUES (\"Pampa\", 10, 4, \"5\", \"5\", \"5\", \"4\", \"\")");
		execSQL("INSERT INTO Cards VALUES (\"Ashura\", 10, 4, \"4\", \"6\", \"4\", \"5\", \"\")");
		execSQL("INSERT INTO Cards VALUES (\"Haruna\", 10, 4, \"7\", \"3\", \"6\", \"3\", \"Earth\")");
		execSQL("INSERT INTO Cards VALUES (\"Mandragore\", 10, 4, \"6\", \"6\", \"2\", \"6\", \"\")");
		execSQL("INSERT INTO Cards VALUES (\"Exoray\", 10, 4, \"5\", \"7\", \"3\", \"3\", \"Poison\")");
		execSQL("INSERT INTO Cards VALUES (\"FlambosObscur\", 10, 4, \"6\", \"6\", \"5\", \"4\", \"\")");
		execSQL("INSERT INTO Cards VALUES (\"ElementaireObscur\", 10, 4, \"7\", \"7\", \"3\", \"4\", \"Poison\")");
		execSQL("INSERT INTO Cards VALUES (\"DefenderZero\", 10, 4, \"5\", \"5\", \"4\", \"7\", \"\")");
		execSQL("INSERT INTO Cards VALUES (\"UltraMight\", 10, 4, \"6\", \"5\", \"5\", \"5\", \"\")");
		
		execSQL("INSERT INTO Cards VALUES (\"Boundfat\", 7, 5, \"5\", \"6\", \"6\", \"5\", \"\")");
		execSQL("INSERT INTO Cards VALUES (\"IronGiant\", 7, 5, \"3\", \"6\", \"5\", \"7\", \"\")");
		execSQL("INSERT INTO Cards VALUES (\"LandWorm\", 7, 5, \"7\", \"5\", \"5\", \"4\", \"Earth\")");
		execSQL("INSERT INTO Cards VALUES (\"Malboro\", 7, 5, \"3\", \"1\", \"2\", \"A\", \"Poison\")");
		execSQL("INSERT INTO Cards VALUES (\"Gargoyle\", 7, 5, \"6\", \"3\", \"5\", \"7\", \"\")");
		execSQL("INSERT INTO Cards VALUES (\"Allemagne\", 7, 5, \"5\", \"4\", \"7\", \"5\", \"\")");
		execSQL("INSERT INTO Cards VALUES (\"MasterTomberry\", 7, 5, \"7\", \"3\", \"7\", \"3\", \"\")");
		execSQL("INSERT INTO Cards VALUES (\"Unknown2\", 7, 5, \"6\", \"2\", \"7\", \"6\", \"\")");
		execSQL("INSERT INTO Cards VALUES (\"Unknown3\", 7, 5, \"4\", \"6\", \"7\", \"4\", \"Poison\")");
		execSQL("INSERT INTO Cards VALUES (\"DeathClaw\", 7, 5, \"6\", \"2\", \"6\", \"7\", \"\")");
		execSQL("INSERT INTO Cards VALUES (\"GhostShip\", 7, 5, \"7\", \"4\", \"7\", \"2\", \"\")");
		
		execSQL("INSERT INTO Cards VALUES (\"Chimaira\", 8, 5, \"7\", \"3\", \"5\", \"6\", \"Water\")");
		execSQL("INSERT INTO Cards VALUES (\"Ekarissor\", 8, 5, \"6\", \"5\", \"6\", \"5\", \"\")");
		execSQL("INSERT INTO Cards VALUES (\"Griffon\", 8, 5, \"7\", \"4\", \"7\", \"2\", \"Fire\")");
		execSQL("INSERT INTO Cards VALUES (\"Kanibal\", 8, 5, \"3\", \"7\", \"5\", \"6\", \"\")");
		execSQL("INSERT INTO Cards VALUES (\"KyokoK\", 8, 5, \"3\", \"1\", \"2\", \"A\", \"\")");
		execSQL("INSERT INTO Cards VALUES (\"Pikasso\", 8, 5, \"5\", \"4\", \"7\", \"5\", \"\")");
		execSQL("INSERT INTO Cards VALUES (\"Protesis\", 8, 5, \"6\", \"7\", \"6\", \"2\", \"\")");
		execSQL("INSERT INTO Cards VALUES (\"Sulfor\", 8, 5, \"5\", \"6\", \"7\", \"3\", \"\")");
		execSQL("INSERT INTO Cards VALUES (\"TomberrySr\", 8, 5, \"4\", \"4\", \"7\", \"6\", \"\")");
		execSQL("INSERT INTO Cards VALUES (\"WedgeBiggs\", 8, 5, \"6\", \"7\", \"2\", \"6\", \"\")");
		execSQL("INSERT INTO Cards VALUES (\"Xylomid\", 8, 5, \"7\", \"2\", \"4\", \"7\", \"Poison\")");
		
		execSQL("INSERT INTO Cards VALUES (\"PotMagique\", 10, 5, \"A\", \"1\", \"7\", \"1\", \"\")");
		execSQL("INSERT INTO Cards VALUES (\"Granada\", 10, 5, \"5\", \"3\", \"5\", \"6\", \"Fire\")");
		execSQL("INSERT INTO Cards VALUES (\"Lumbrikus\", 10, 5, \"5\", \"6\", \"5\", \"4\", \"\")");
		execSQL("INSERT INTO Cards VALUES (\"Tomberry\", 10, 5, \"6\", \"7\", \"3\", \"5\", \"\")");
		execSQL("INSERT INTO Cards VALUES (\"Barbatos\", 10, 5, \"5\", \"6\", \"5\", \"5\", \"\")");
		execSQL("INSERT INTO Cards VALUES (\"Xylomid\", 10, 5, \"7\", \"7\", \"4\", \"3\", \"Poison\")");
		execSQL("INSERT INTO Cards VALUES (\"Monolithe\", 10, 5, \"7\", \"5\", \"4\", \"5\", \"\")");
		execSQL("INSERT INTO Cards VALUES (\"Varna\", 10, 5, \"2\", \"6\", \"6\", \"7\", \"\")");
		execSQL("INSERT INTO Cards VALUES (\"ElementaireNoir\", 10, 5, \"7\", \"7\", \"1\", \"5\", \"\")");
		execSQL("INSERT INTO Cards VALUES (\"MasterIaguaro\", 10, 5, \"6\", \"7\", \"4\", \"5\", \"\")");
		execSQL("INSERT INTO Cards VALUES (\"ChimeraBrain\", 10, 5, \"3\", \"4\", \"7\", \"5\", \"Fire\")");
		execSQL("INSERT INTO Cards VALUES (\"KingBehemoth\", 10, 5, \"7\", \"5\", \"6\", \"5\", \"Thunder\")");
		
		execSQL("INSERT INTO Cards VALUES (\"AirBuster\", 7, 6, \"8\", \"4\", \"8\", \"2\", \"Thunder\")");
		execSQL("INSERT INTO Cards VALUES (\"APS\", 7, 6, \"7\", \"8\", \"3\", \"4\", \"Water\")");
		execSQL("INSERT INTO Cards VALUES (\"CarryArmor\", 7, 6, \"7\", \"2\", \"5\", \"8\", \"Thunder\")");
		execSQL("INSERT INTO Cards VALUES (\"HelleticHojo\", 7, 6, \"2\", \"8\", \"8\", \"2\", \"\")");
		execSQL("INSERT INTO Cards VALUES (\"BottomSwell\", 7, 6, \"5\", \"8\", \"7\", \"2\", \"Water\")");
		execSQL("INSERT INTO Cards VALUES (\"HundredGunner\", 7, 6, \"6\", \"8\", \"4\", \"5\", \"Thunder\")");
		execSQL("INSERT INTO Cards VALUES (\"JenovaLife\", 7, 6, \"4\", \"8\", \"5\", \"6\", \"\")");
		execSQL("INSERT INTO Cards VALUES (\"Palmer\", 7, 6, \"4\", \"8\", \"1\", \"8\", \"\")");
		execSQL("INSERT INTO Cards VALUES (\"GuardScorpion\", 7, 6, \"3\", \"8\", \"8\", \"2\", \"Thunder\")");
		execSQL("INSERT INTO Cards VALUES (\"MateriaKeeper\", 7, 6, \"4\", \"6\", \"8\", \"5\", \"\")");
		execSQL("INSERT INTO Cards VALUES (\"MotorBall\", 7, 6, \"8\", \"7\", \"7\", \"2\", \"Thunder\")");
		
		execSQL("INSERT INTO Cards VALUES (\"Cyanide\", 8, 6, \"1\", \"8\", \"4\", \"8\", \"\")");
		execSQL("INSERT INTO Cards VALUES (\"Ecorche\", 8, 6, \"1\", \"3\", \"8\", \"8\", \"Poison\")");
		execSQL("INSERT INTO Cards VALUES (\"Flotix\", 8, 6, \"4\", \"6\", \"5\", \"8\", \"\")");
		execSQL("INSERT INTO Cards VALUES (\"FujinRaijin\", 8, 6, \"2\", \"4\", \"8\", \"8\", \"\")");
		execSQL("INSERT INTO Cards VALUES (\"Goliath\", 8, 6, \"4\", \"3\", \"7\", \"8\", \"\")");
		execSQL("INSERT INTO Cards VALUES (\"Hornet\", 8, 6, \"6\", \"5\", \"4\", \"8\", \"\")");
		execSQL("INSERT INTO Cards VALUES (\"Iguanor\", 8, 6, \"8\", \"2\", \"8\", \"2\", \"\")");
		execSQL("INSERT INTO Cards VALUES (\"Krystal\", 8, 6, \"7\", \"1\", \"8\", \"5\", \"\")");
		execSQL("INSERT INTO Cards VALUES (\"Lugus\", 8, 6, \"7\", \"5\", \"8\", \"2\", \"\")");
		execSQL("INSERT INTO Cards VALUES (\"Shumi\", 8, 6, \"6\", \"4\", \"8\", \"5\", \"\")");
		execSQL("INSERT INTO Cards VALUES (\"Sulfura\", 8, 6, \"7\", \"4\", \"3\", \"8\", \"Wind\")");
		
		execSQL("INSERT INTO Cards VALUES (\"ScagliaEmuzu\", 10, 6, \"8\", \"2\", \"6\", \"4\", \"\")");
		execSQL("INSERT INTO Cards VALUES (\"Thros\", 10, 6, \"8\", \"8\", \"1\", \"4\", \"\")");
		execSQL("INSERT INTO Cards VALUES (\"ScagliaEkyu\", 10, 6, \"8\", \"7\", \"1\", \"5\", \"Water\")");
		execSQL("INSERT INTO Cards VALUES (\"LanceurAlbhed\", 10, 6, \"6\", \"8\", \"3\", \"3\", \"\")");
		execSQL("INSERT INTO Cards VALUES (\"ScagliaGunai\", 10, 6, \"8\", \"2\", \"8\", \"2\", \"\")");
		execSQL("INSERT INTO Cards VALUES (\"ChocoboEater\", 10, 6, \"2\", \"8\", \"8\", \"3\", \"\")");
		execSQL("INSERT INTO Cards VALUES (\"ScagliaGhy\", 10, 6, \"8\", \"5\", \"7\", \"1\", \"\")");
		execSQL("INSERT INTO Cards VALUES (\"CannoniereAlbhed\", 10, 6, \"7\", \"7\", \"6\", \"2\", \"\")");
		execSQL("INSERT INTO Cards VALUES (\"Sferogestore\", 10, 6, \"6\", \"8\", \"4\", \"4\", \"\")");
		execSQL("INSERT INTO Cards VALUES (\"EfrayZombie\", 10, 6, \"8\", \"6\", \"3\", \"6\", \"\")");
		execSQL("INSERT INTO Cards VALUES (\"NeoSeymour\", 10, 6, \"8\", \"3\", \"5\", \"7\", \"\")");
		
		execSQL("INSERT INTO Cards VALUES (\"DemonsGate\", 7, 7, \"8\", \"8\", \"3\", \"1\", \"\")");
		execSQL("INSERT INTO Cards VALUES (\"GiNattak\", 7, 7, \"7\", \"2\", \"6\", \"8\", \"Poison\")");
		execSQL("INSERT INTO Cards VALUES (\"ProudClod\", 7, 7, \"5\", \"8\", \"5\", \"5\", \"\")");
		execSQL("INSERT INTO Cards VALUES (\"BioHojo\", 7, 7, \"7\", \"4\", \"7\", \"7\", \"\")");
		execSQL("INSERT INTO Cards VALUES (\"UltimaWeapon\", 7, 7, \"6\", \"8\", \"7\", \"4\", \"\")");
		execSQL("INSERT INTO Cards VALUES (\"EmeraldWeapon\", 7, 7, \"6\", \"8\", \"4\", \"6\", \"\")");
		execSQL("INSERT INTO Cards VALUES (\"DiamondWeapon\", 7, 7, \"8\", \"3\", \"8\", \"4\", \"\")");
		execSQL("INSERT INTO Cards VALUES (\"RubyWeapon\", 7, 7, \"6\", \"8\", \"4\", \"8\", \"\")");
		execSQL("INSERT INTO Cards VALUES (\"JenovaSynthesis\", 7, 7, \"5\", \"2\", \"8\", \"8\", \"\")");
		execSQL("INSERT INTO Cards VALUES (\"BizarroSephiroth\", 7, 7, \"5\", \"8\", \"6\", \"5\", \"\")");
		execSQL("INSERT INTO Cards VALUES (\"SaferSephiroth\", 7, 7, \"8\", \"2\", \"8\", \"8\", \"\")");
		
		execSQL("INSERT INTO Cards VALUES (\"Acarnan\", 8, 7, \"8\", \"4\", \"5\", \"8\", \"\")");
		execSQL("INSERT INTO Cards VALUES (\"Acron\", 8, 7, \"8\", \"8\", \"5\", \"2\", \"Thunder\")");
		execSQL("INSERT INTO Cards VALUES (\"Agamemnon\", 8, 7, \"5\", \"8\", \"6\", \"6\", \"\")");
		execSQL("INSERT INTO Cards VALUES (\"Alienator\", 8, 7, \"8\", \"8\", \"4\", \"4\", \"\")");
		execSQL("INSERT INTO Cards VALUES (\"Anakronox\", 8, 7, \"8\", \"3\", \"7\", \"6\", \"\")");
		execSQL("INSERT INTO Cards VALUES (\"Attila\", 8, 7, \"6\", \"7\", \"4\", \"8\", \"\")");
		execSQL("INSERT INTO Cards VALUES (\"Fabryce\", 8, 7, \"1\", \"7\", \"7\", \"8\", \"\")");
		execSQL("INSERT INTO Cards VALUES (\"Mithra\", 8, 7, \"8\", \"8\", \"5\", \"3\", \"\")");
		execSQL("INSERT INTO Cards VALUES (\"Monarch\", 8, 7, \"7\", \"8\", \"2\", \"7\", \"\")");
		execSQL("INSERT INTO Cards VALUES (\"Omniborg\", 8, 7, \"5\", \"5\", \"8\", \"7\", \"\")");
		execSQL("INSERT INTO Cards VALUES (\"PampaSr\", 8, 7, \"8\", \"4\", \"4\", \"8\", \"\")");
		
		execSQL("INSERT INTO Cards VALUES (\"Wendigo\", 10, 7, \"8\", \"2\", \"8\", \"5\", \"\")");
		execSQL("INSERT INTO Cards VALUES (\"YenkeBiran\", 10, 7, \"8\", \"4\", \"8\", \"4\", \"\")");
		execSQL("INSERT INTO Cards VALUES (\"Josguein\", 10, 7, \"4\", \"7\", \"5\", \"8\", \"?\")");
		execSQL("INSERT INTO Cards VALUES (\"Efray\", 10, 7, \"8\", \"4\", \"4\", \"8\", \"?\")");
		execSQL("INSERT INTO Cards VALUES (\"GardienDesLimbes\", 10, 7, \"7\", \"7\", \"7\", \"3\", \"Holy\")");
		execSQL("INSERT INTO Cards VALUES (\"GardienCeleste\", 10, 7, \"7\", \"7\", \"4\", \"7\", \"Holy\")");
		execSQL("INSERT INTO Cards VALUES (\"Yunalesca\", 10, 7, \"8\", \"7\", \"5\", \"3\", \"\")");
		execSQL("INSERT INTO Cards VALUES (\"UltimaArma\", 10, 7, \"8\", \"7\", \"6\", \"2\", \"\")");
		execSQL("INSERT INTO Cards VALUES (\"YunalescaFinale\", 10, 7, \"8\", \"6\", \"7\", \"4\", \"\")");
		execSQL("INSERT INTO Cards VALUES (\"SeymourOmega\", 10, 7, \"8\", \"7\", \"7\", \"3\", \"\")");
		execSQL("INSERT INTO Cards VALUES (\"OmegaArma\", 10, 7, \"8\", \"8\", \"1\", \"8\", \"\")");
		
		execSQL("INSERT INTO Cards VALUES (\"Reno\", 7, 8, \"7\", \"6\", \"5\", \"8\", \"\")");
		execSQL("INSERT INTO Cards VALUES (\"Rude\", 7, 8, \"3\", \"9\", \"9\", \"4\", \"\")");
		execSQL("INSERT INTO Cards VALUES (\"Elena\", 7, 8, \"1\", \"9\", \"5\", \"9\", \"\")");
		execSQL("INSERT INTO Cards VALUES (\"Tseng\", 7, 8, \"6\", \"9\", \"8\", \"2\", \"\")");
		execSQL("INSERT INTO Cards VALUES (\"Rufus\", 7, 8, \"9\", \"4\", \"4\", \"9\", \"\")");
		execSQL("INSERT INTO Cards VALUES (\"CocoMog\", 7, 8, \"3\", \"9\", \"4\", \"9\", \"\")");
		execSQL("INSERT INTO Cards VALUES (\"GroChocobo\", 7, 8, \"8\", \"2\", \"8\", \"7\", \"\")");
		execSQL("INSERT INTO Cards VALUES (\"Rahmu\", 7, 8, \"9\", \"9\", \"2\", \"4\", \"Thunder\")");
		execSQL("INSERT INTO Cards VALUES (\"Titan\", 7, 8, \"6\", \"8\", \"3\", \"9\", \"Earth\")");
		execSQL("INSERT INTO Cards VALUES (\"Shiva\", 7, 8, \"9\", \"4\", \"7\", \"4\", \"Ice\")");
		execSQL("INSERT INTO Cards VALUES (\"Ifrit\", 7, 8, \"2\", \"8\", \"9\", \"7\", \"Fire\")");
		
		execSQL("INSERT INTO Cards VALUES (\"Angel\", 8, 8, \"9\", \"3\", \"7\", \"6\", \"\")");
		execSQL("INSERT INTO Cards VALUES (\"Chicobo\", 8, 8, \"9\", \"4\", \"8\", \"4\", \"\")");
		execSQL("INSERT INTO Cards VALUES (\"Gilgamesh\", 8, 8, \"3\", \"6\", \"9\", \"7\", \"\")");
		execSQL("INSERT INTO Cards VALUES (\"Golgotha\", 8, 8, \"2\", \"4\", \"9\", \"9\", \"Thunder\")");
		execSQL("INSERT INTO Cards VALUES (\"GroChocobo\", 8, 8, \"4\", \"9\", \"8\", \"4\", \"\")");
		execSQL("INSERT INTO Cards VALUES (\"Ifrit\", 8, 8, \"9\", \"8\", \"2\", \"6\", \"Fire\")");
		execSQL("INSERT INTO Cards VALUES (\"Minimog\", 8, 8, \"9\", \"2\", \"9\", \"3\", \"\")");
		execSQL("INSERT INTO Cards VALUES (\"Ondine\", 8, 8, \"8\", \"2\", \"6\", \"9\", \"\")");
		execSQL("INSERT INTO Cards VALUES (\"Shiva\", 8, 8, \"6\", \"9\", \"4\", \"7\", \"Ice\")");
		execSQL("INSERT INTO Cards VALUES (\"Tauros\", 8, 8, \"5\", \"9\", \"9\", \"1\", \"Earth\")");
		execSQL("INSERT INTO Cards VALUES (\"Taurux\", 8, 8, \"9\", \"9\", \"2\", \"5\", \"earth\")");
		
		execSQL("INSERT INTO Cards VALUES (\"Valefore\", 10, 8, \"9\", \"1\", \"8\", \"5\", \"Wind\")");
		execSQL("INSERT INTO Cards VALUES (\"Ifrit\", 10, 8, \"9\", \"2\", \"8\", \"6\", \"Fire\")");
		execSQL("INSERT INTO Cards VALUES (\"Ixion\", 10, 8, \"7\", \"9\", \"2\", \"6\", \"Thunder\")");
		execSQL("INSERT INTO Cards VALUES (\"Shiva\", 10, 8, \"9\", \"4\", \"7\", \"6\", \"Ice\")");
		execSQL("INSERT INTO Cards VALUES (\"Bahamut\", 10, 8, \"A\", \"8\", \"5\", \"2\", \"Holy\")");
		execSQL("INSERT INTO Cards VALUES (\"Yojimbo\", 10, 8, \"1\", \"9\", \"9\", \"5\", \"\")");
		execSQL("INSERT INTO Cards VALUES (\"Anima\", 10, 8, \"A\", \"9\", \"1\", \"5\", \"\")");
		execSQL("INSERT INTO Cards VALUES (\"Anabella\", 10, 8, \"9\", \"3\", \"3\", \"9\", \"\")");
		execSQL("INSERT INTO Cards VALUES (\"Maria\", 10, 8, \"A\", \"2\", \"A\", \"3\", \"\")");
		execSQL("INSERT INTO Cards VALUES (\"Samantha\", 10, 8, \"3\", \"3\", \"A\", \"A\", \"\")");
		execSQL("INSERT INTO Cards VALUES (\"Sin\", 10, 8, \"9\", \"A\", \"3\", \"4\", \"\")");
		
		execSQL("INSERT INTO Cards VALUES (\"Kjata\", 7, 9, \"A\", \"3\", \"9\", \"3\", \"\")");
		execSQL("INSERT INTO Cards VALUES (\"Hades\", 7, 9, \"4\", \"A\", \"3\", \"8\", \"Poison\")");
		execSQL("INSERT INTO Cards VALUES (\"Leviathan\", 7, 9, \"5\", \"2\", \"A\", \"9\", \"Water\")");
		execSQL("INSERT INTO Cards VALUES (\"Odin\", 7, 9, \"2\", \"6\", \"A\", \"8\", \"\")");
		execSQL("INSERT INTO Cards VALUES (\"Phoenix\", 7, 9, \"5\", \"A\", \"4\", \"6\", \"\")");
		execSQL("INSERT INTO Cards VALUES (\"Typhon\", 7, 9, \"6\", \"9\", \"2\", \"A\", \"\")");
		execSQL("INSERT INTO Cards VALUES (\"Alexander\", 7, 9, \"6\", \"6\", \"4\", \"A\", \"Holy\")");
		execSQL("INSERT INTO Cards VALUES (\"Bahamut\", 7, 9, \"7\", \"2\", \"7\", \"A\", \"\")");
		execSQL("INSERT INTO Cards VALUES (\"NeoBahamut\", 7, 9, \"A\", \"9\", \"3\", \"4\", \"\")");
		execSQL("INSERT INTO Cards VALUES (\"BahamutZero\", 7, 9, \"8\", \"2\", \"A\", \"6\", \"\")");
		execSQL("INSERT INTO Cards VALUES (\"KnightsOfRound\", 7, 9, \"A\", \"4\", \"A\", \"4\", \"\")");
		
		execSQL("INSERT INTO Cards VALUES (\"Ahuri\", 8, 9, \"8\", \"4\", \"A\", \"4\", \"\")");
		execSQL("INSERT INTO Cards VALUES (\"Alexander\", 8, 9, \"9\", \"2\", \"4\", \"A\", \"Holy\")");
		execSQL("INSERT INTO Cards VALUES (\"Bahamut\", 8, 9, \"A\", \"6\", \"2\", \"8\", \"\")");
		execSQL("INSERT INTO Cards VALUES (\"Cerberes\", 8, 9, \"7\", \"A\", \"6\", \"4\", \"\")");
		execSQL("INSERT INTO Cards VALUES (\"HellTrain\", 8, 9, \"3\", \"A\", \"A\", \"1\", \"Poison\")");
		execSQL("INSERT INTO Cards VALUES (\"Leviathan\", 8, 9, \"7\", \"7\", \"1\", \"A\", \"Water\")");
		execSQL("INSERT INTO Cards VALUES (\"Nosferatu\", 8, 9, \"5\", \"3\", \"8\", \"A\", \"\")");
		execSQL("INSERT INTO Cards VALUES (\"Odin\", 8, 9, \"8\", \"5\", \"3\", \"A\", \"\")");
		execSQL("INSERT INTO Cards VALUES (\"Orbital\", 8, 9, \"4\", \"A\", \"9\", \"4\", \"\")");
		execSQL("INSERT INTO Cards VALUES (\"Phenix\", 8, 9, \"7\", \"A\", \"7\", \"2\", \"Fire\")");
		execSQL("INSERT INTO Cards VALUES (\"Zephyr\", 8, 9, \"A\", \"7\", \"7\", \"1\", \"Wind\")");
		
		execSQL("INSERT INTO Cards VALUES (\"BraskaUltimeChimere\", 10, 9, \"3\", \"3\", \"A\", \"9\", \"\")");
		execSQL("INSERT INTO Cards VALUES (\"ValeforePurgateur\", 10, 9, \"9\", \"9\", \"5\", \"1\", \"\")");
		execSQL("INSERT INTO Cards VALUES (\"IfritPurgateur\", 10, 9, \"A\", \"6\", \"2\", \"8\", \"\")");
		execSQL("INSERT INTO Cards VALUES (\"IxionPurgateur\", 10, 9, \"7\", \"6\", \"A\", \"2\", \"\")");
		execSQL("INSERT INTO Cards VALUES (\"ShivaPurgatrice\", 10, 9, \"9\", \"9\", \"3\", \"6\", \"\")");
		execSQL("INSERT INTO Cards VALUES (\"YojimboPurgateur\", 10, 9, \"3\", \"A\", \"3\", \"A\", \"\")");
		execSQL("INSERT INTO Cards VALUES (\"AnimaPurgatrice\", 10, 9, \"A\", \"9\", \"1\", \"7\", \"\")");
		execSQL("INSERT INTO Cards VALUES (\"AnabellaPurgatrice\", 10, 9, \"A\", \"5\", \"2\", \"9\", \"\")");
		execSQL("INSERT INTO Cards VALUES (\"MariaPurgatrice\", 10, 9, \"3\", \"4\", \"A\", \"A\", \"\")");
		execSQL("INSERT INTO Cards VALUES (\"SamanthaPurgatrice\", 10, 9, \"A\", \"6\", \"A\", \"1\", \"\")");
		execSQL("INSERT INTO Cards VALUES (\"BahamutPurgateur\", 10, 9, \"A\", \"9\", \"6\", \"1\", \"\")");
		
		execSQL("INSERT INTO Cards VALUES (\"Cloud\", 7, 10, \"A\", \"6\", \"8\", \"6\", \"\")");
		execSQL("INSERT INTO Cards VALUES (\"Vincent\", 7, 10, \"2\", \"9\", \"7\", \"A\", \"\")");
		execSQL("INSERT INTO Cards VALUES (\"Barret\", 7, 10, \"A\", \"2\", \"A\", \"6\", \"\")");
		execSQL("INSERT INTO Cards VALUES (\"Yuffie\", 7, 10, \"8\", \"A\", \"8\", \"2\", \"\")");
		execSQL("INSERT INTO Cards VALUES (\"Sephiroth\", 7, 10, \"6\", \"A\", \"6\", \"6\", \"\")");
		execSQL("INSERT INTO Cards VALUES (\"CaitSith\", 7, 10, \"8\", \"5\", \"5\", \"A\", \"\")");
		execSQL("INSERT INTO Cards VALUES (\"Cid\", 7, 10, \"9\", \"A\", \"6\", \"6\", \"\")");
		execSQL("INSERT INTO Cards VALUES (\"Tifa\", 7, 10, \"8\", \"6\", \"A\", \"5\", \"\")");
		execSQL("INSERT INTO Cards VALUES (\"Aeris\", 7, 10, \"8\", \"6\", \"A\", \"4\", \"\")");
		execSQL("INSERT INTO Cards VALUES (\"RedXIII\", 7, 10, \"8\", \"8\", \"5\", \"8\", \"\")");
		execSQL("INSERT INTO Cards VALUES (\"Zack\", 7, 10, \"A\", \"5\", \"2\", \"A\", \"\")");
		
		execSQL("INSERT INTO Cards VALUES (\"Edea\", 8, 10, \"A\", \"3\", \"3\", \"A\", \"\")");
		execSQL("INSERT INTO Cards VALUES (\"Irvine\", 8, 10, \"2\", \"A\", \"9\", \"6\", \"\")");
		execSQL("INSERT INTO Cards VALUES (\"Kiros\", 8, 10, \"6\", \"A\", \"6\", \"7\", \"\")");
		execSQL("INSERT INTO Cards VALUES (\"Laguna\", 8, 10, \"5\", \"9\", \"3\", \"A\", \"\")");
		execSQL("INSERT INTO Cards VALUES (\"Linoa\", 8, 10, \"4\", \"A\", \"2\", \"A\", \"\")");
		execSQL("INSERT INTO Cards VALUES (\"Quistis\", 8, 10, \"9\", \"2\", \"A\", \"6\", \"\")");
		execSQL("INSERT INTO Cards VALUES (\"Seifer\", 8, 10, \"6\", \"4\", \"A\", \"9\", \"\")");
		execSQL("INSERT INTO Cards VALUES (\"Selphie\", 8, 10, \"A\", \"4\", \"6\", \"8\", \"\")");
		execSQL("INSERT INTO Cards VALUES (\"Squall\", 8, 10, \"A\", \"9\", \"6\", \"4\", \"\")");
		execSQL("INSERT INTO Cards VALUES (\"Ward\", 8, 10, \"A\", \"8\", \"2\", \"7\", \"\")");
		execSQL("INSERT INTO Cards VALUES (\"Zell\", 8, 10, \"8\", \"6\", \"A\", \"5\", \"\")");
		
		execSQL("INSERT INTO Cards VALUES (\"Kimhari\", 10, 10, \"A\", \"8\", \"5\", \"4\", \"\")");
		execSQL("INSERT INTO Cards VALUES (\"Rikku\", 10, 10, \"1\", \"9\", \"A\", \"7\", \"\")");
		execSQL("INSERT INTO Cards VALUES (\"Lulu\", 10, 10, \"6\", \"A\", \"4\", \"8\", \"\")");
		execSQL("INSERT INTO Cards VALUES (\"Auron\", 10, 10, \"A\", \"6\", \"6\", \"6\", \"\")");
		execSQL("INSERT INTO Cards VALUES (\"Wakka\", 10, 10, \"5\", \"A\", \"3\", \"A\", \"\")");
		execSQL("INSERT INTO Cards VALUES (\"Yuna\", 10, 10, \"5\", \"A\", \"A\", \"4\", \"\")");
		execSQL("INSERT INTO Cards VALUES (\"Seymour\", 10, 10, \"6\", \"4\", \"9\", \"A\", \"\")");
		execSQL("INSERT INTO Cards VALUES (\"Tidus\", 10, 10, \"A\", \"5\", \"9\", \"5\", \"\")");
		
		execSQL("INSERT INTO Cards VALUES (\"Artemis\", 0, 10, \"4\", \"A\", \"A\", \"2\", \"\")");
		execSQL("INSERT INTO Cards VALUES (\"Bartz\", 0, 10, \"3\", \"9\", \"5\", \"A\", \"\")");
		execSQL("INSERT INTO Cards VALUES (\"CecilDark\", 0, 10, \"A\", \"2\", \"5\", \"A\", \"\")");
		execSQL("INSERT INTO Cards VALUES (\"CecilPaladin\", 0, 10, \"A\", \"4\", \"3\", \"A\", \"\")");
		execSQL("INSERT INTO Cards VALUES (\"Cloud\", 0, 10, \"A\", \"9\", \"8\", \"2\", \"\")");
		execSQL("INSERT INTO Cards VALUES (\"CloudOfDarkness\", 0, 10, \"8\", \"4\", \"A\", \"6\", \"\")");
		execSQL("INSERT INTO Cards VALUES (\"Exdeath\", 0, 10, \"9\", \"A\", \"4\", \"6\", \"\")");
		execSQL("INSERT INTO Cards VALUES (\"Frioniel\", 0, 10, \"A\", \"5\", \"3\", \"A\", \"\")");
		execSQL("INSERT INTO Cards VALUES (\"Garland\", 0, 10, \"A\", \"6\", \"8\", \"6\", \"\")");
		execSQL("INSERT INTO Cards VALUES (\"Djidan\", 0, 10, \"A\", \"7\", \"8\", \"4\", \"\")");
		execSQL("INSERT INTO Cards VALUES (\"Gabranth\", 0, 10, \"A\", \"1\", \"A\", \"8\", \"\")");
		execSQL("INSERT INTO Cards VALUES (\"Golbez\", 0, 10, \"2\", \"6\", \"9\", \"A\", \"\")");
		execSQL("INSERT INTO Cards VALUES (\"Jecht\", 0, 10, \"5\", \"A\", \"A\", \"5\", \"\")");
		execSQL("INSERT INTO Cards VALUES (\"Kuja\", 0, 10, \"5\", \"1\", \"A\", \"A\", \"\")");
		execSQL("INSERT INTO Cards VALUES (\"OnionKnight\", 0, 10, \"6\", \"4\", \"9\", \"A\", \"\")");
		execSQL("INSERT INTO Cards VALUES (\"Sephiroth\", 0, 10, \"A\", \"4\", \"4\", \"A\", \"\")");
		execSQL("INSERT INTO Cards VALUES (\"Shantotto\", 0, 10, \"8\", \"5\", \"A\", \"4\", \"\")");
		execSQL("INSERT INTO Cards VALUES (\"Squall\", 0, 10, \"5\", \"3\", \"A\", \"A\", \"\")");
		execSQL("INSERT INTO Cards VALUES (\"Terra\", 0, 10, \"6\", \"A\", \"A\", \"3\", \"\")");
		execSQL("INSERT INTO Cards VALUES (\"Tidus\", 0, 10, \"A\", \"7\", \"2\", \"A\", \"\")");
		execSQL("INSERT INTO Cards VALUES (\"WarriorOfLight\", 0, 10, \"A\", \"2\", \"A\", \"8\", \"\")");
		execSQL("INSERT INTO Cards VALUES (\"ImperatorPalamencia\", 0, 10, \"A\", \"1\", \"3\", \"A\", \"\")");
		execSQL("INSERT INTO Cards VALUES (\"Kefka\", 0, 10, \"9\", \"8\", \"A\", \"1\", \"\")");
	}
	
}
