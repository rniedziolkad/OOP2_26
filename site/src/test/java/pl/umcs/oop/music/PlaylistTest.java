package pl.umcs.oop.music;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PlaylistTest {
    @Test
    void testNewPlaylistsIsEmpty() {
        //given
        //when
        Playlist pl1 = new Playlist();
        //then
        Assertions.assertTrue(pl1.isEmpty());
    }
    @Test
    void testAddSongToEmptyMakesSize1() {
        // given
        Playlist pl1 = new Playlist();
        Song s1 = new Song("aaa", "ttt", 100);
        // when
        pl1.add(s1);
        // then
        Assertions.assertEquals(1, pl1.size());
    }
    @Test
    void testAddSongContainsThisSong() {
        Playlist pl1 = new Playlist();
        Song s1 = new Song("aaa", "ttt", 100);
        pl1.add(s1);
        Assertions.assertTrue(pl1.contains(s1));
    }

    @Test
    void testAddSongContainsSameSong() {
        Playlist pl1 = new Playlist();
        Song s1 = new Song("aaa", "ttt", 100);
        Song s2 = new Song("aaa", "ttt", 100);

        pl1.add(s1);
        Assertions.assertTrue(pl1.contains(s2));
    }


}
