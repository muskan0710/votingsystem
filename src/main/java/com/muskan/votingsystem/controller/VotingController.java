package com.muskan.votingsystem.controller;

import com.muskan.votingsystem.entity.Candidate;
import com.muskan.votingsystem.entity.Citizen;
import com.muskan.votingsystem.service.CandidateService;
import com.muskan.votingsystem.service.CitizenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Controller
public class VotingController {
    public final Logger logger = Logger.getLogger("VotingController.class");
    @Autowired
    private CitizenService citizenService;

    @Autowired
    private CandidateService candidateService;

    @RequestMapping("/")
    public String goToVote() {
        logger.info("Let's vote!");
        return "vote.html";
    }

    @RequestMapping("/login")
    public String login(@RequestParam Long id, Model model, HttpSession session) {
        logger.info("Getting citizen from database");
        Optional<Citizen> citizen = citizenService.findById(id);
        if (citizen.isPresent()) {
            session.setAttribute("citizen", citizen.get());
            if (!citizen.get().getHasVoted()) {
                List<Candidate> candidates = candidateService.findAll();
                model.addAttribute("candidates", candidates);
                return "/performVote.html";
            } else {
                return "/alreadyVoted.html";
            }
        } else {
            return "/citizenError.html";
        }
    }

    @RequestMapping("/voteFor")
    public String voteFor(@RequestParam Long id, HttpSession session) {
        Citizen citizen = (Citizen) session.getAttribute("citizen");
        Optional<Candidate> candidate = candidateService.findById((long) id);
        if (candidate.isPresent()) {
            if (!citizen.getHasVoted()) {
                logger.info("Voting for candidate" + candidate.get().getName());
                citizen.setHasVoted(true);
                candidate.get().setVoteCount(candidate.get().getVoteCount() + 1);
            }
            candidateService.saveCandidate(candidate.get());
            citizenService.saveCitizen(citizen);
            return "/voted.html";
        } else {
            return "/candidateError.html";
        }
    }
}
