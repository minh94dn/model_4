package com.example.exe2.controller;

import com.example.exe2.dto.SongDto;
import com.example.exe2.model.Song;
import com.example.exe2.service.ISongService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/song")
public class SongController {
    @Autowired
    private ISongService iSongService;

    @GetMapping("")
    public String showListSong(Model model) {
        List<SongDto> songDtoList = new ArrayList<>();
        List<Song> songList = iSongService.findAll();
        for (Song song : songList) {
            SongDto songDto = new SongDto();
            BeanUtils.copyProperties(song, songDto);
            songDtoList.add(songDto);
        }
        model.addAttribute("songDtoList", songDtoList);
        return "/song/list";
    }

    @GetMapping("/add")
    public String showFromAdd(Model model) {
        model.addAttribute("songDto", new SongDto());
        return "/song/add";
    }

    @PostMapping("/save")
    public String add(@Validated SongDto songDto, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "/song/add";
        }
        Song song = new Song();
        BeanUtils.copyProperties(songDto, song);
        iSongService.add(song);
        redirectAttributes.addFlashAttribute("mess", "Thêm mới thành công !");
        return "redirect:/song";
    }

    @GetMapping("/edit/{id}")
    public String showFromEdit(Model model, @PathVariable("id") int id) {
        Song song = iSongService.findById(id).get();
        SongDto songDto = new SongDto();
        BeanUtils.copyProperties(song, songDto);
        model.addAttribute("songDto", songDto);
        return "/song/edit";
    }

    @PostMapping("/edit")
    public String edit(@Validated SongDto songDto, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "/song/edit";
        }
        Song song = new Song();
        BeanUtils.copyProperties(songDto, song);
        iSongService.edit(song);
        redirectAttributes.addFlashAttribute("mess", "Chỉnh sửa thành công !");
        return "redirect:/song";
    }
}
