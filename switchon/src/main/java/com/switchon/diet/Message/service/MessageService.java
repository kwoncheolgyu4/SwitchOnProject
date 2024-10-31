package com.switchon.diet.Message.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.switchon.diet.Message.dao.IMessageDAO;
import com.switchon.diet.Message.vo.AlramVO;
import com.switchon.diet.member.vo.MemberVO;

@Service
public class MessageService {
	
	@Autowired
	private IMessageDAO dao;
	
	@Autowired
	private KakaoMessageService kakaoMessageService;  // KakaoMessageService 주입
	
	private ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
    private ScheduledFuture<?> scheduledTask;
	
    // 알람 시작 메서드
    public void startAlarm(MemberVO vo, String accessToken) {
        // 이미 스케줄이 실행 중이면 중지
        if (scheduledTask != null && !scheduledTask.isCancelled()) {
            scheduledTask.cancel(true);
        }

        // 새로운 스케줄링 작업 시작 (1분마다 실행)
        scheduledTask = scheduler.scheduleAtFixedRate(() -> checkAndSendMessages(vo, accessToken), 0, 1, TimeUnit.MINUTES);
    }

    // 알람 중지 메서드
    public void stopAlarm() {
        if (scheduledTask != null) {
            scheduledTask.cancel(true);
        }
    }

    // 스케줄된 메시지 확인 및 전송 메서드
    private void checkAndSendMessages(MemberVO vo, String accessToken) {
        ArrayList<AlramVO> timeList = dao.timeList(vo);
        LocalDateTime now = LocalDateTime.now();
        
        System.out.println("시간 체크중...." + now);
        
        for (AlramVO alram : timeList) {
            if (alram.getSchedDate(
            		).isAfter(now.minusMinutes(5)) && alram.getSchedDate().isBefore(now.plusMinutes(5))) {
                sendMessage(accessToken, "Time to eat : " + alram.getScheMethod());
            }
        }
    }
	
	public void sendMessage(String accessToken, String messageText) {
		
		System.out.println("메세지 전송: " + messageText);
		
		// KakaoMessageService를 사용해 메시지를 전송
        kakaoMessageService.sendKakaoMessage(accessToken, messageText);
		
	}
}
