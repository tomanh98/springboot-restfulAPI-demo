package com.example.restfulapi.database;

import com.example.restfulapi.entity.UserEntity;
import com.example.restfulapi.repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

@Configurable //Cac class nay se chua cac bean method => se duoc goi ngay khi ung dung chay, dung de khoi tao DB, bien moi truong ...v...v...
public class Database {
    private static final Logger logger = LoggerFactory.getLogger(Database.class);
    @Bean
    CommandLineRunner initDatabase(UserRepository userRepository) {
        return new CommandLineRunner() { //tao ra 1 doi tuong de thuc thi CommandLineRunner cu the la thuc thi ham run o ben trong
            @Override
            public void run(String... args) throws Exception {
                UserEntity userA = new UserEntity(1L, "Manh", "manh@gmail.com", "092131238", "m.jpg", "assad");
                UserEntity userB = new UserEntity(2L, "Hanh", "hanh@gmail.com", "092143238", "m.jpg", "passsssword");
                logger.info("insert data: " + userRepository.save(userA));
                logger.info("insert data: " + userRepository.save(userB));
            }
        };
    }
}
