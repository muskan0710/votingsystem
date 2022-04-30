package com.muskan.votingsystem.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "candidates")
@Entity
public class Candidate {

    @Id
    @Column(name = "id")
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "candidate_name")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "party")
    private String party;

    public String getParty() {
        return party;
    }

    public void setParty(String party) {
        this.party = party;
    }

    @Column(name = "vote_count")
    private Integer voteCount;

    public Integer getVoteCount() {
        return voteCount;
    }

    public void setVoteCount(Integer voteCount) {
        this.voteCount = voteCount;
    }

    public Candidate() {
        super();
    }

    public Candidate(Long id, String name) {
        super();
        this.id = id;
        this.name = name;
        this.voteCount = 0;
    }

}
