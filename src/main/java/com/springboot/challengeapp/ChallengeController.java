package com.springboot.challengeapp;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/challenges")
public class ChallengeController {
    private ChallengeService challengeService;

    public ChallengeController(ChallengeService challengeService) {
        this.challengeService = challengeService;
    }

    @GetMapping
    public List<Challenge> getAllChallenges() {
        return challengeService.getAllChallenges();
    }

    @PostMapping
    public ResponseEntity<String> addChallenge(@RequestBody Challenge challenge) {
        boolean isChallengeAdded = challengeService.addChallenge(challenge);

        if (isChallengeAdded)
            return new ResponseEntity<>("Challenge added successfully", HttpStatus.OK);
        else return new ResponseEntity<>("Challenge not added!", HttpStatus.NOT_FOUND);
    }

    @GetMapping("/{month}")
    public ResponseEntity<Challenge> getAChallenge(@PathVariable String month) {
        Challenge challenge = challengeService.getAChallenge(month);

        if (challenge != null) {
            return new ResponseEntity<>(challenge, HttpStatus.OK);
        } else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateChallenge(@PathVariable Long id, @RequestBody Challenge challenge) {
        boolean challengeUpdated = challengeService.updateChallenge(id, challenge);
        if (challengeUpdated) {
            return new ResponseEntity<>("Challenge updated successfully", HttpStatus.OK);
        }
        return new ResponseEntity<>("Challenge not updated!", HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteChallenge(@PathVariable Long id){
        boolean challengeDeleted = challengeService.deleteChallenge(id);

        if(challengeDeleted){
            return new ResponseEntity<>("Challenge deleted successfully", HttpStatus.OK);
        }else return new ResponseEntity<>("Challenge not deleted!", HttpStatus.NOT_FOUND);

    }
}
