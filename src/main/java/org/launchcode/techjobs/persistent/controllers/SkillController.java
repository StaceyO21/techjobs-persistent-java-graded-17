package org.launchcode.techjobs.persistent.controllers;

import jakarta.validation.Valid;
import org.launchcode.techjobs.persistent.models.AbstractEntity;
import org.launchcode.techjobs.persistent.models.Employer;
import org.launchcode.techjobs.persistent.models.Skill;
import org.launchcode.techjobs.persistent.models.data.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("skills")
public class SkillController {

    @Autowired
    private SkillRepository skillRepository;

    @GetMapping("")
    public String listSkills(Model model){
        model.addAttribute("title", "All Skills");
        model.addAttribute("skills", skillRepository.findAll());
        return "skills/index";
    }

    @GetMapping("add")
    public String displayAddSkillForm(Model model) {
        model.addAttribute("title", "Create Skill");
        model.addAttribute(new Skill());
        return "skills/add";
    }

    @PostMapping("add")
    public String processAddSkillsForm(@ModelAttribute @Valid Skill newSkill, Errors errors, Model model) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Create Skill");
            return "skills/add";
        }

        skillRepository.save(newSkill);
        return "redirect:/skills";
    }

    @GetMapping("view/{skillId}")
    public String displayViewSkill(Model model, @PathVariable int skillId){
        Optional <Skill> optSkill = skillRepository.findById(skillId);
        if (optSkill.isPresent()) {
            model.addAttribute("skill", optSkill.get());
            return "skills/view";
        } else {
            return "redirect:/skills";
        }
    }
}
