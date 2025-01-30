package com.laze.bootex.repository;

import com.laze.bootex.domain.Board;
import com.laze.bootex.domain.Reply;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Log4j2
public class ReplyRepositoryTests {

    @Autowired
    private ReplyRepository replyRepository;

    @Test
    public void testInsert() {
        Long bno = 100L;

        Board board = Board.builder().bno(bno).build();

        Reply reply = Reply.builder()
                .board(board)
                .replyText("댓글...")
                .replyer("replyer1")
                .build();

        replyRepository.save(reply);
    }
}
