package com.merguez.apps.tripletriad;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Vector;

import android.content.Context;
import android.util.SparseArray;

import com.merguez.apps.tripletriad.cards.Card;
import com.merguez.apps.tripletriad.cards.Card.Element;

public class ListeCartes {


	public static SparseArray<Card> defaut;
	
	public static void listeDesCartes(Context context) {
		
		defaut = new SparseArray<Card>();
		defaut.put(1,new Card(context,"Acarnan", 1, 8, 4, 5, 8, Element.NONE));
		defaut.put(2,new Card(context,"Acron", 1, 8, 8, 2, 5, Element.THUNDER)); // mettre 10 si A
		defaut.put(3,new Card(context,"Adel", 1, 1, 8, 9, 10, Element.NONE)); // mettre 10 si A
		defaut.put(4, new Card(context,"Adephage", 1, 3, 5, 5, 5, Element.POISON)); // mettre 10 si A
		defaut.put(5, new Card(context,"Agamemnon", 1, 5, 8, 6, 6, Element.NONE)); // mettre 10 si A
		defaut.put(6, new Card(context,"Ahuri", 1, 8, 4, 10, 4, Element.NONE)); // mettre 10 si A
		defaut.put(7, new Card(context,"Alexander", 1, 9, 2, 4, 10, Element.HOLY)); // mettre 10 si A
		defaut.put(8, new Card(context,"Alienator", 1, 8, 8, 4, 4, Element.NONE)); // mettre 10 si A
		defaut.put(9, new Card(context,"Akakronox", 1, 8, 3, 7, 6, Element.NONE)); // mettre 10 si A
		defaut.put(10, new Card(context,"Angel", 1, 9, 3, 6, 7, Element.NONE)); // mettre 10 si A
		defaut.put(11, new Card(context,"Ao", 2, 4, 6, 5, 5, Element.NONE)); // mettre 10 si A
		defaut.put(12, new Card(context,"Aphide", 2, 2, 4, 4, 1, Element.THUNDER)); // mettre 10 si A

		defaut.put(13, new Card(context,"Arconada", 2, 5, 5, 3, 1, Element.NONE)); // mettre 10 si A
		defaut.put(14, new Card(context,"Attila", 2, 6, 7, 4, 8, Element.NONE)); // mettre 10 si A
		defaut.put(15, new Card(context,"Bahamut", 2, 10, 6, 2, 8, Element.NONE)); // mettre 10 si A
		defaut.put(16, new Card(context,"Balamb_garden", 2, 8, 8, 2, 10, Element.HOLY)); // mettre 10 si A
		defaut.put(17, new Card(context,"Barbarian", 2, 5, 4, 2, 6, Element.FIRE)); // mettre 10 si A
		defaut.put(18, new Card(context,"Berseker", 2, 4, 2, 7, 4, Element.FIRE)); // mettre 10 si A
		defaut.put(19, new Card(context,"Bogomile", 2, 1, 5, 1, 4, Element.NONE)); // mettre 10 si A
		defaut.put(20, new Card(context,"Cariatide", 2, 6, 5, 4, 5, Element.NONE)); // mettre 10 si A
		defaut.put(21, new Card(context,"Carnidéa",2, 2, 1, 6, 1, Element.NONE)); // mettre 10 si A
		defaut.put(22, new Card(context,"Célébis", 2, 7, 5, 3, 2, Element.NONE)); // mettre 10 si A
		defaut.put(23, new Card(context,"Cerberes", 3, 7, 10, 6, 4, Element.NONE)); // mettre 10 si A
		defaut.put(24, new Card(context,"Cid", 3, 7, 7, 3, 10, Element.NONE)); // mettre 10 si A
		defaut.put(25, new Card(context,"Crono", 3, 5, 2, 9, 10, Element.NONE)); // mettre 10 si A
		defaut.put(26, new Card(context,"Cyanide", 3, 1, 8, 4, 8, Element.NONE)); // mettre 10 si A
		defaut.put(27, new Card(context,"Diodon", 3, 3, 1, 2, 5, Element.EARTH)); // mettre 10 si A
		defaut.put(28, new Card(context,"Doublure", 3, 8, 4, 5, 4, Element.NONE)); // mettre 10 si A
		defaut.put(29, new Card(context,"Draconus", 3, 3, 6, 3, 7, Element.NONE)); // mettre 10 si A
		defaut.put(30, new Card(context,"Ecorche", 3, 1, 3, 8, 8, Element.POISON)); // mettre 10 si A
		defaut.put(31, new Card(context,"Edéa", 3, 10, 3, 3, 10, Element.NONE)); // mettre 10 si A

		// c'est tout, pour le moment. Voilà :)
		defaut.put(32, new Card(context,"Eiffel", 3, 2, 7, 6, 3, Element.NONE)); // mettre 10 si A
		defaut.put(33, new Card(context,"Ekarissor", 3, 6, 5, 5, 6, Element.NONE)); // mettre 10 si A
		defaut.put(34, new Card(context,"Elastos", 4, 1, 1, 4, 5, Element.NONE)); // mettre 10 si A
		defaut.put(35, new Card(context,"Elite", 4, 3, 7, 1, 3, Element.NONE)); // mettre 10 si A
		defaut.put(36, new Card(context,"Ellone", 4, 9, 8, 10, 2, Element.NONE)); // mettre 10 si A
		defaut.put(37, new Card(context,"Elmidéa", 4, 1, 5, 3, 3, Element.NONE)); // mettre 10 si A
		defaut.put(38, new Card(context,"Exoskelet", 4, 7, 5, 4, 6, Element.NONE)); // mettre 10 si A
		defaut.put(39, new Card(context,"Fabryce", 4, 1, 7, 7, 8, Element.NONE)); // mettre 10 si A
		defaut.put(40, new Card(context,"Feng", 4, 4, 2, 5, 4, Element.THUNDER)); // mettre 10 si A
	
		defaut.put(41, new Card(context,"Flotix", 4, 4, 6, 5, 8, Element.NONE)); // mettre 10 si A
		defaut.put(42, new Card(context,"Formicide", 4, 5, 2, 5, 2, Element.THUNDER)); // mettre 10 si A
		defaut.put(43, new Card(context,"Fujin Raijin", 4, 2, 4, 8, 8, Element.NONE)); // mettre 10 si A
		defaut.put(44, new Card(context,"Fungus", 4, 5, 3, 1, 1, Element.NONE)); // mettre 10 si A
		defaut.put(45, new Card(context,"Galbadia garden", 5, 2, 10, 8, 8, Element.HOLY)); // mettre 10 si A
		defaut.put(46, new Card(context,"Galbadien", 5, 6, 2, 2, 1, Element.NONE)); // mettre 10 si A
		defaut.put(47, new Card(context,"Gallus", 5, 2, 6, 2, 1, Element.THUNDER)); // mettre 10 si A
		defaut.put(48, new Card(context,"Général Caraway", 5, 9, 8, 3, 4, Element.NONE)); // mettre 10 si A
		defaut.put(49, new Card(context,"Geyser", 5, 2, 6, 10, 6, Element.NONE)); // mettre 10 si A
		defaut.put(50, new Card(context,"Gilgamesh", 5, 3, 6, 9, 7, Element.NONE)); // mettre 10 si A
		defaut.put(51, new Card(context,"Golgotha", 5, 2, 4, 9, 9, Element.THUNDER)); // mettre 10 si A
		defaut.put(52, new Card(context,"Goliath", 5, 4, 3, 7, 8, Element.NONE)); // mettre 10 si A
		defaut.put(53, new Card(context,"Griffon", 5, 7, 4, 7, 2, Element.FIRE)); // mettre 10 si A
		defaut.put(54, new Card(context,"Grochocobo", 5, 4, 9, 8, 4, Element.NONE)); // mettre 10 si A
		defaut.put(55, new Card(context,"Helltrain", 5, 3, 10, 10, 1, Element.POISON)); // mettre 10 si A
		defaut.put(56, new Card(context,"Hera", 6, 3, 7, 1, 2, Element.NONE)); // mettre 10 si A
		defaut.put(57, new Card(context,"Hornet", 6, 6, 5, 4, 8, Element.NONE)); // mettre 10 si A
		defaut.put(58, new Card(context,"Hydre", 6, 5, 5, 5, 10, Element.NONE)); // mettre 10 si A
		defaut.put(59, new Card(context,"Ifrit", 6, 9, 8, 2, 6, Element.FIRE)); // mettre 10 si A
		defaut.put(60, new Card(context,"Iguanor", 6, 8, 2, 8, 2, Element.NONE)); // mettre 10 si A
		defaut.put(61, new Card(context,"Incube", 6, 2, 4, 1, 3, Element.NONE)); // mettre 10 si A
		defaut.put(62, new Card(context,"Irvine", 6, 2, 10, 9, 6, Element.NONE)); // mettre 10 si A
		defaut.put(63, new Card(context,"Isthar", 6, 9, 6, 8, 2, Element.NONE)); // mettre 10 si A
		defaut.put(64, new Card(context,"Jason", 6, 6, 1, 1, 8, Element.ICE)); // mettre 10 si A
		defaut.put(65, new Card(context,"Julia", 6, 8, 8, 1, 8, Element.NONE)); // mettre 10 si A
		defaut.put(66, new Card(context,"Kanibal", 6, 3, 7, 5, 6, Element.NONE)); // mettre 10 si A
		defaut.put(67, new Card(context,"Kiros", 7, 6, 10, 6, 7, Element.NONE)); // mettre 10 si A
		defaut.put(68, new Card(context,"Koatl", 7, 3, 3, 5, 4, Element.NONE)); // mettre 10 si A
		defaut.put(69, new Card(context,"Koyok", 7, 3, 1, 2, 10, Element.NONE)); // mettre 10 si A
		defaut.put(70, new Card(context,"Krystal", 7, 7, 1, 8, 5, Element.NONE)); // mettre 10 si A
		defaut.put(71, new Card(context,"Laguna", 7, 5, 9, 3, 10, Element.NONE)); // mettre 10 si A
		defaut.put(72, new Card(context,"Larva", 7, 4, 3, 4, 2, Element.NONE)); // mettre 10 si A
		defaut.put(73, new Card(context,"Leviathan", 7, 7, 7, 1, 10, Element.ICE)); // mettre 10 si A
		defaut.put(74, new Card(context,"Licorne", 7, 5, 4, 3, 3, Element.NONE)); // mettre 10 si A
		defaut.put(75, new Card(context,"Linoa", 7, 4, 10, 2, 10, Element.NONE)); // mettre 10 si A
		defaut.put(76, new Card(context,"Lygus", 7, 7, 5, 8, 2, Element.NONE)); // mettre 10 si A
		defaut.put(77, new Card(context,"Malaku", 7, 5, 5, 2, 3, Element.WIND)); // mettre 10 si A
		defaut.put(78, new Card(context,"Marsupial", 8, 7, 4, 4, 4, Element.NONE)); // mettre 10 si A
		defaut.put(79, new Card(context,"Martine", 8, 10, 4, 6, 4, Element.NONE)); // mettre 10 si A
		defaut.put(80, new Card(context,"Minimog", 8, 9, 2, 9, 3, Element.NONE)); // mettre 10 si A
		defaut.put(81, new Card(context,"Minotaure", 8, 2, 8, 9, 8, Element.NONE)); // mettre 10 si A
		defaut.put(82, new Card(context,"Mithra", 8, 8, 8, 5, 3, Element.NONE)); // mettre 10 si A
		defaut.put(83, new Card(context,"Moloch", 8, 6, 3, 7, 2, Element.POISON)); // mettre 10 si A
		defaut.put(84, new Card(context,"Monarch", 8, 7, 8, 2, 7, Element.NONE)); // mettre 10 si A
		defaut.put(85, new Card(context,"Moomba", 8, 9, 8, 6, 2, Element.NONE)); // mettre 10 si A
		defaut.put(86, new Card(context,"Nocturnus", 8, 6, 2, 1, 1, Element.NONE)); // mettre 10 si A
		defaut.put(87, new Card(context,"Nosferatu", 8, 5, 3, 8, 10, Element.DARKNESS)); // mettre 10 si A
		defaut.put(88, new Card(context,"Odin", 8, 8, 5, 3, 10, Element.NONE)); // mettre 10 si A
		defaut.put(89, new Card(context,"Omniborg", 9, 5, 5, 8, 7, Element.NONE)); // mettre 10 si A
		defaut.put(90, new Card(context,"Ondine", 9, 8, 2, 6, 9, Element.NONE)); // mettre 10 si A
		defaut.put(91, new Card(context,"Orbital", 9, 4, 10, 9, 4, Element.NONE)); // mettre 10 si A
		defaut.put(92, new Card(context,"Orchida", 9, 7, 1, 3, 1, Element.NONE)); // mettre 10 si A
		defaut.put(93, new Card(context,"Pampa", 9, 6, 3, 6, 2, Element.NONE)); // mettre 10 si A
		defaut.put(94, new Card(context,"Pampa sr", 9, 8, 4, 4, 8, Element.NONE)); // mettre 10 si A
		defaut.put(95, new Card(context,"Phantom", 9, 7, 3, 1, 5, Element.EARTH)); // mettre 10 si A
		defaut.put(96, new Card(context,"Phenix", 9, 7, 10, 7, 2, Element.FIRE)); // mettre 10 si A
		defaut.put(97, new Card(context,"Pikasso", 9, 5, 4, 7, 5, Element.NONE)); // mettre 10 si A
		defaut.put(98, new Card(context,"Polyphage", 9, 7, 3, 4, 5, Element.FIRE)); // mettre 10 si A
		defaut.put(99, new Card(context,"Protesis", 9, 6, 7, 6, 2, Element.NONE)); // mettre 10 si A
		defaut.put(100, new Card(context,"Quistis", 10, 9, 2, 10, 6, Element.NONE)); // mettre 10 si A
		defaut.put(101, new Card(context,"Raine", 10, 6, 9, 6, 5, Element.NONE)); // mettre 10 si A
		defaut.put(102, new Card(context,"Satyrux", 10, 7, 3, 5, 1, Element.ICE)); // mettre 10 si A
		defaut.put(103, new Card(context,"Scavenger", 10, 6, 6, 1, 3, Element.NONE)); // mettre 10 si A
		defaut.put(104, new Card(context,"Schizoid", 10, 6, 3, 2, 2, Element.NONE)); // mettre 10 si A
		defaut.put(105, new Card(context,"Seed", 10, 9, 1, 9, 1, Element.NONE)); // mettre 10 si A
		defaut.put(106, new Card(context,"Seifer", 10, 6, 4, 10, 9, Element.NONE)); // mettre 10 si A
		defaut.put(107, new Card(context,"Selek",10, 5, 3, 5, 2, Element.NONE)); // mettre 10 si A
		defaut.put(108, new Card(context,"Selphie", 10, 10, 4, 6, 8, Element.NONE)); // mettre 10 si A
		defaut.put(109, new Card(context,"Shiva", 10, 6, 9, 4, 7, Element.ICE)); // mettre 10 si A
		defaut.put(110, new Card(context,"Shu", 10, 9, 3, 7, 7, Element.NONE)); // mettre 10 si A
	/*	defaut.put(111, new Card(context,"Shumi", 7, 6, 4, 8, 5, Element.NONE)); // mettre 10 si A
		defaut.put(112, new Card(context,"Soldat desthar", 7, 1, 3, 3, 6, Element.NONE)); // mettre 10 si A
		defaut.put(113, new Card(context,"Squall", 7, 10, 9, 6, 4, Element.NONE)); // mettre 10 si A
		defaut.put(114, new Card(context,"Succube", 7, 2, 3, 6, 7, Element.FIRE)); // mettre 10 si A
		defaut.put(115, new Card(context,"Sulfor", 7, 5, 6, 7, 3, Element.NONE)); // mettre 10 si A
		defaut.put(116, new Card(context,"Sulfura", 7, 7, 4, 3, 8, Element.WIND)); // mettre 10 si A
		defaut.put(117, new Card(context,"Tauros", 7, 5, 9, 9, 1, Element.EARTH)); // mettre 10 si A
		defaut.put(118, new Card(context,"Taurux", 7, 9, 9, 2, 5, Element.EARTH)); // mettre 10 si A
		defaut.put(119, new Card(context,"Tikal", 7, 1, 7, 4, 6, Element.THUNDER)); // mettre 10 si A
		defaut.put(120, new Card(context,"Tomberry", 7, 3, 4, 4, 6, Element.NONE)); // mettre 10 si A
		defaut.put(121, new Card(context,"Tomberry sr", 7, 4, 4, 7, 6, Element.NONE)); // mettre 10 si A
		defaut.put(122, new Card(context,"Trex", 7, 4, 7, 2, 6, Element.NONE)); // mettre 10 si A
		defaut.put(123, new Card(context,"Trogiidae", 7, 5, 3, 3, 6, Element.NONE)); // mettre 10 si A
		defaut.put(124, new Card(context,"Ufo", 7, 8, 1, 3, 3, Element.NONE)); // mettre 10 si A
		defaut.put(125, new Card(context,"Ultimecia", 7, 10, 10, 5, 4, Element.NONE)); // mettre 10 si A
		defaut.put(126, new Card(context,"Ultimecia crono", 7, 5, 5, 7, 10, Element.NONE)); // mettre 10 si A
		defaut.put(127, new Card(context,"Ultimecia final", 7, 8, 3, 9, 8, Element.NONE)); // mettre 10 si A
		defaut.put(128, new Card(context,"Vinzer deling", 7, 7, 7, 6, 5, Element.NONE)); // mettre 10 si A
		defaut.put(129, new Card(context,"Ward", 7, 10, 8, 2, 7, Element.NONE)); // mettre 10 si A$
		defaut.put(130, new Card(context,"Watts", 7, 4, 8, 8, 2, Element.NONE)); // mettre 10 si A
		defaut.put(131, new Card(context,"Wedge biggs", 7, 6, 7, 2, 6, Element.NONE)); // mettre 10 si A
		defaut.put(132, new Card(context,"Weevil", 7, 6, 2, 3, 6, Element.DARKNESS)); // mettre 10 si A
		defaut.put(133, new Card(context,"Wendigo", 7, 7, 6, 1, 3, Element.NONE)); // mettre 10 si A
		defaut.put(134, new Card(context,"Xylomid", 7, 7, 2, 4, 7, Element.POISON)); // mettre 10 si A
		defaut.put(135, new Card(context,"Xylopode", 7, 6, 3, 4, 1, Element.ICE)); // mettre 10 si A
		defaut.put(136, new Card(context,"Zell", 7, 8, 6, 10, 5, Element.NONE)); // mettre 10 si A
		defaut.put(137, new Card(context,"Zephyr", 7, 10, 7, 7, 1, Element.WIND)); // mettre 10 si A
		defaut.put(138, new Card(context,"Zone", 7, 8, 2, 4, 8, Element.NONE)); // mettre 10 si A
		*/
		
	}
	
}
