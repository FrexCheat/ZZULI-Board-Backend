package zzuli.controller.admin;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import zzuli.common.Context.BaseContext;
import zzuli.common.result.Result;
import zzuli.pojo.dto.SetRoomDTO;
import zzuli.pojo.vo.RoomVO;
import zzuli.service.RoomService;

import java.util.Map;

/**
 * ClassName: RoomController
 * Package: zzuli.controller.admin
 * Description:
 *
 * @author fuchen
 * @version 1.0
 * @createTime 2024/11/12
 */

/**
 * 考场管理
 */
@RestController("adminRoomController")
@RequestMapping("/api/admin/room")
@Slf4j
public class RoomController {
    @Autowired
    private RoomService roomService;
    @PostMapping("/delete")
    public Result<Integer> deleteRoom(@RequestParam(name = "room_id") String roomId) {
        roomService.deleteRoom(roomId);
        log.info("删除考场;管理员：{}，考场ID：{}",BaseContext.getCurrentId(),roomId);
        return Result.success(null);
    }

    /**
     * 设置考场信息
     * @param roomId
     * @return
     */
    @PostMapping("/set")
    public Result<Object> setRoom(@RequestParam(name = "room_id") int roomId,
                                  @RequestBody SetRoomDTO setRoomDTO) {
        roomService.setRoom(roomId, setRoomDTO);
        log.info("修改考场信息;管理员：{}，考场ID：{}",BaseContext.getCurrentId(),roomId);
        return Result.success(null);
    }

    /**
     * 创建考场
     * @param contestId
     * @param setRoomDTO
     * @return
     */
    @PostMapping("/create")
    public Result<Map> createRoom(@RequestParam(name = "contest_id") String contestId,
                                  @RequestBody SetRoomDTO setRoomDTO) {
        int id = roomService.createRoom(contestId, setRoomDTO);
        log.info("创建考场;管理员：{}，比赛ID：{}，考场ID：{}", BaseContext.getCurrentId(),contestId,id);
        return Result.success(Map.of("room_id", id));
    }
}
