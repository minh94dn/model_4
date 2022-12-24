package com.example.exe2.dto;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class SongDto {
    private int id;
    @NotBlank(message = "Không đươc phép để trống")
    @Size(max = 800, message = "Không được phép quá 800 ký tự.")
    @Pattern(regexp = "[\\w]+", message = "Không được chứa các ký tự đặt biệt")
    private String nameSong;

    @NotBlank(message = "Không đươc phép để trống")
    @Size(max = 300, message = "Không được phép quá 300 ký tự.")
    @Pattern(regexp = "[\\w]+", message = "Không được chứa các ký tự đặt biệt")
    private String nameArtist;

    @NotBlank(message = "Không đươc phép để trống")
    @Size(max = 1000, message = "Không được phép quá 1000 ký tự.")
    @Pattern(regexp = "[\\w,]+", message = "Không được chứa các ký tự đặt biệt")
    private String kindOfMusic;

    public SongDto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameSong() {
        return nameSong;
    }

    public void setNameSong(String nameSong) {
        this.nameSong = nameSong;
    }

    public String getNameArtist() {
        return nameArtist;
    }

    public void setNameArtist(String nameArtist) {
        this.nameArtist = nameArtist;
    }

    public String getKindOfMusic() {
        return kindOfMusic;
    }

    public void setKindOfMusic(String kindOfMusic) {
        this.kindOfMusic = kindOfMusic;
    }
}
