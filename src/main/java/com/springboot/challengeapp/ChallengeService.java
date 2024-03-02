package com.springboot.challengeapp;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class ChallengeService {
    private List<Challenge> challenges = new ArrayList<>();
    private Long id = 1L;

    public ChallengeService(){
        //challenges.add(new Challenge(id, "Maerz", "Revice for the exams"));
    }

    public Challenge getAChallenge(String month){
        Challenge challengeToReturn = null;

        for(Challenge c : challenges){
            if(c.getMonth().equalsIgnoreCase(month)){
                challengeToReturn = c;
            }
        }
        return challengeToReturn;
    }
    public List<Challenge> getAllChallenges(){
        return challenges;
    }

    public boolean addChallenge(Challenge challenge){
        if(challenge != null) {
            challenge.setId(id++);
            challenges.add(challenge);
            return true;
        }else return false;
    }

    public boolean updateChallenge(Long id, Challenge challenge){
        for(Challenge c : challenges){
            if(c.getId().equals(id)){
                c.setMonth(challenge.getMonth());
                c.setDescription(challenge.getDescription());
                return true;
            }
        }

        return false;
    }

    public boolean deleteChallenge(Long id){
        return challenges.removeIf(challenge -> Objects.equals(challenge.getId(), id));
    }
}
