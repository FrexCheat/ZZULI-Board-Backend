package zzuli.service;

import com.fasterxml.jackson.databind.JsonNode;
import zzuli.common.result.Result;
import zzuli.pojo.dto.CreateContestDTO;
import zzuli.pojo.dto.RegisterTeamDTO;
import zzuli.pojo.dto.SingleDTO;
import zzuli.pojo.entity.PTASession;
import zzuli.pojo.vo.ContestListVO;
import zzuli.pojo.vo.ContestVO;
import zzuli.pojo.vo.RecordVO;
import zzuli.pojo.vo.RegisterTeamVO;

import java.util.List;

/**
 * ClassName: ContestService
 * Package: zzuli.service
 * Description:
 *
 * @author fuchen
 * @version 1.0
 * @createTime 2024/11/10
 */
public interface ContestService {
    List<ContestListVO> list();

    ContestVO config(String contestId);

    List<RecordVO> record(String contestId);

    RegisterTeamVO registerTeam(String contestId, RegisterTeamDTO registerTeamDTO);

    void registerSignal(String contestId, SingleDTO signalDTO);

    void CreateContest(CreateContestDTO dto);

    void deleteContest(String contestId);

    void setContest(String contestId, CreateContestDTO dto);

    void UpContest(CreateContestDTO dto);

    /**
     * 获取比赛记录
     * @param contestId 比赛id
     * @param jsession pta
     * @param PTASession pta
     */
    void getRecord(String contestId, String jsession, String PTASession);

    // 同步mysql和redis数据
    void synchrodata(String contestId);

    PTASession getPTASession(String contestId);
}