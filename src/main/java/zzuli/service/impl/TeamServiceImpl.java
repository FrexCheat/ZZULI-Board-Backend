package zzuli.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zzuli.mapper.MemberMapper;
import zzuli.mapper.TeamMapper;
import zzuli.pojo.dto.SetTeamDTO;
import zzuli.pojo.entity.Team;
import zzuli.pojo.vo.TeamListVO;
import zzuli.service.MemberService;
import zzuli.service.TeamService;

import java.util.List;
import java.util.stream.Collectors;

/**
 * ClassName: TeamServiceImpl
 * Package: zzuli.service.impl
 * Description:
 *
 * @author fuchen
 * @version 1.0
 * @createTime 2024/11/11
 */
@Service
public class TeamServiceImpl implements TeamService {
    @Autowired
    private MemberMapper memberMapper;
    @Autowired
    private TeamMapper teamMapper;
    @Override
    public List<TeamListVO> getListByContestId(String contestId) {
        List<Team> teamList = teamMapper.getListByContestId(contestId);
        if (teamList != null) {
            return teamList.stream().map(team -> TeamListVO.builder()
                    .id(team.getTeamId())
                    .name(team.getTeamName())
                    .coach(team.getTeamCoach())
                    .college(team.getTeamCollege())
                    .clazz(team.getTeamClass())
                    .official(team.isOfficial())
                    .build()).collect(Collectors.toList());
        }
        return null;
    }

    /**
     * 设置队伍信息
     * @param teamId 队伍id
     * @param setTeamDTO 队伍信息
     */
    @Override
    public void setTeam(String teamId, SetTeamDTO setTeamDTO) {
        Team team = Team.builder()
                .teamId(Integer.parseInt(teamId))
                .teamName(setTeamDTO.getName())
                .teamCoach(setTeamDTO.getCoach())
                .teamSchool(setTeamDTO.getSchool())
                .teamCollege(setTeamDTO.getCollage())
                .teamClass(setTeamDTO.getClazz())
                .official(setTeamDTO.isOfficial())
                .build();
        teamMapper.setTeam(team);
    }

    /**
     * 删除队伍
     * @param teamId 队伍id
     */
    @Override
    public void delTeam(String teamId) {
        memberMapper.delMemberByTeamId(teamId);
        teamMapper.delTeam(teamId);
    }
}