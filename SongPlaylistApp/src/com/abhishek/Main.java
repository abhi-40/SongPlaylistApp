package com.abhishek;

import java.util.*;

public class Main
{
    private static ArrayList<Album> albums = new ArrayList<>();

    public static void main(String[] args)
    {
        Album album=new Album("Your's Truly","KR$NA");

        album.addSong("Buss Down",4.0);
        album.addSong("KKBN",3.0);
        album.addSong("Knock-Knock",4.5);
        album.addSong("Your's Truly",5.0);
        albums.add(album);

        album=new Album("Still Here","KR$NA");

        album.addSong("OG",4.0);
        album.addSong("Still Here",4.5);
        album.addSong("Fall Off",3.0);
        album.addSong("Dream",5.0);
        albums.add(album);


        album=new Album("Album3","EMINEM");

        album.addSong("Rap God",3.0);
        album.addSong("Not Afraid",4.6);
        album.addSong("Loose Yourself",2.0);
        albums.add(album);

        LinkedList<Song> playlist1=new LinkedList<>();

        albums.get(0).addToPlayList("Buss Down",playlist1);
        albums.get(0).addToPlayList("Knock-Knock",playlist1);

        albums.get(1).addToPlayList("OG",playlist1);
        albums.get(1).addToPlayList("Dream",playlist1);

        albums.get(2).addToPlayList("Rap God",playlist1);
        albums.get(2).addToPlayList("Not Afraid",playlist1);

        play(playlist1);

    }

    private static void play(LinkedList<Song> playlist)
    {
        Scanner sc=new Scanner(System.in);
        boolean quit=false;
        boolean forward=true;
        ListIterator<Song> listIterator=playlist.listIterator();

        if(playlist.size()==0)
        {
            System.out.println("This Playlist Has No Song");
        }
        else
        {
            System.out.println("Now Playing: "+listIterator.next().toString());
            printMenu();
        }
        while(!quit)
        {
            int action=sc.nextInt();
            sc.nextLine();

            switch(action)
            {
                case 0:
                    System.out.println("Playlist complete");
                    quit=true;
                    break;


                case 1:
                    if(!forward)
                    {
                        if(listIterator.hasNext())
                        {
                            listIterator.next();
                        }
                        forward=true;
                    }
                    if(listIterator.hasNext())
                    {
                        System.out.println("now playing: "+listIterator.next().toString());
                    }
                    else
                    {
                        System.out.println("No song available reached to the end of the list");
                        forward=false;
                    }
                    break;

                case 2:
                    if(forward)
                    {
                        if(listIterator.hasPrevious()){
                            listIterator.previous();
                        }
                        forward=false;
                    }
                    if(listIterator.hasPrevious())
                    {
                        System.out.println("Now Playing: "+listIterator.previous().toString());
                    }
                    else
                    {
                        System.out.println("We are At First Song");
                        forward=false;
                    }
                    break;

                case 3:
                    if(forward){
                        if(listIterator.hasPrevious()){
                            System.out.println("Now Playing"+listIterator.previous().toString());
                            forward=false;
                        }else{
                            System.out.println("we are at the start of the list");
                        }
                    }else{
                        if(listIterator.hasNext()){
                            System.out.println("now playing: "+listIterator.next().toString());
                            forward=true;

                        }else{
                            System.out.println("We reached to the end of the list");
                        }
                    }
                    break;

                case 4:
                    printList(playlist);
                    break;

                case 5:
                    printMenu();
                    break;

                case 6:
                    if(playlist.size()>0)
                    {
                        listIterator.remove();
                        if(listIterator.hasNext()){
                            System.out.println("now playing: "+listIterator.next().toString());

                        }
                        else{
                            if(listIterator.hasPrevious())
                            System.out.println("now playing: "+listIterator.previous().toString());
                        }
                    }
            }
        }
    }
    private static void printMenu()
    {
        System.out.println("Available Options\n press");
        System.out.println("0- to quit\n"+
                "1- to play next song\n"+
                "2- to play previous song\n"+
                "3- to replay the current song\n"+
                "4- list of all songs\n"+
                "5- print all the available options\n"+
                "6- delete current song");
    }

    private static void printList(LinkedList<Song> playList)
    {
        Iterator<Song> iterator=playList.iterator();
        System.out.println("================");

        while(iterator.hasNext())
        {
            System.out.println(iterator.next());
        }
        System.out.println("================");
    }
}