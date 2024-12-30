package com.project.client_magnet.model;

import java.util.Objects;

public class Team implements Comparable<Team>{
	public static int counter;
	private int teamId;
	private String teamName;
	
	static {
		counter = 0;
	}

	{
		this.teamId = ++counter;
	}

	public Team() {
		super();
	}

	public Team(int teamId, String teamName) {
		super();
		this.teamId = teamId;
		this.teamName = teamName;
	}

	public Team(String teamName) {
		super();
		this.teamName = teamName;

	}

	public int getTeamId() {
		return teamId;
	}

	public void setTeamId(int teamId) {
		this.teamId = teamId;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	@Override
	public int hashCode() {
		return Objects.hash(teamId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Team other = (Team) obj;
		return teamId == other.teamId;
	}

	@Override
	public String toString() {
		return "Team [teamId=" + teamId + ", teamName=" + teamName + "]";
	}

	public int compareTo(Team o) {
		return this.teamId - o.teamId;
	}
}
