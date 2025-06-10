package com.abhishek;

import java.util.ArrayList;
import java.util.LinkedList;

public class Album
{
    private String name;
    private String artist;
    private ArrayList<Song> songs;

    public Album(String name, String artist)
    {
        this.name = name;
        this.songs = new ArrayList<Song>();
        this.artist = artist;
    }

    public Album()
    {

    }
    public Song findSong(String title)
    {
        for(Song check:songs)
        {
            if(check.getTitle().equals(title)) return check;
        }
        return null;
    }

    public boolean addSong(String title,double Duration)
    {
        if(findSong(title)==null)
        {
            songs.add(new Song(title,Duration));
           // System.out.println(title +": Song Added SuccessFully In The List :)");
            return true;
        }
        else
        {
          //  System.out.println("Song With The Name: "+title+"Already Exists In The List");
            return false;
        }
    }

    public boolean addToPlayList(int track, LinkedList<Song> PlayList)
    {
        int index=track-1;
        if(index>0 && index<=songs.size())
        {
            PlayList.add(this.songs.get(index));
            return true;
        }
        System.out.println("This Album Does Not Have Song With Track Number: "+track);
        return false;
    }

    public boolean addToPlayList(String title, LinkedList<Song> PlayList)
    {
        for(Song check:this.songs)
        {
            if(check.getTitle().equals(title))
            {
                PlayList.add(check);
                return true;
            }
        }
       // System.out.println(title+": There is no such songin Album");
        return false;
    }
}
