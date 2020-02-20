package com.mbor.service;

import com.mbor.domain.Post;
import com.mbor.domain.Tag;
import com.mbor.domain.security.Privilege;
import com.mbor.domain.security.Role;
import com.mbor.domain.security.User;
import org.hibernate.Transaction;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Service
public class DataLoader {

    private final PasswordEncoder passwordEncoder;

    private final IPostService postService;

    @PersistenceUnit
    EntityManagerFactory entityManagerFactory;

    public DataLoader(PasswordEncoder passwordEncoder, IPostService postService) {
        this.passwordEncoder = passwordEncoder;
        this.postService = postService;
    }

    @PostConstruct
    public void prepareData() {
        Post post = new Post();
        post.setTitle("Post title");
        Tag tag = new Tag();
        tag.setName("TagTitle");
        post.addTag(tag);
        postService.save(post);


        User user = new User();
        user.setUserName("user");
        user.setPassword(passwordEncoder.encode("pass"));

        Privilege readPrivilege = new Privilege();
        readPrivilege.setName("read");

        Role userRole = new Role();
        userRole.setName("user_role");
        userRole.addPrivilege(readPrivilege);
        user.addRole(userRole);

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(user);
        entityManager.flush();

        User admin = new User();
        admin.setUserName("admin");
        admin.setPassword(passwordEncoder.encode("pass"));

        Privilege writePrivilege = new Privilege();
        writePrivilege.setName("write");

        Role adminRole = new Role();
        adminRole.setName("admin_role");
        adminRole.addPrivilege(writePrivilege);
        adminRole.addPrivilege(readPrivilege);
        admin.addRole(adminRole);

        entityManager.persist(admin);
        transaction.commit();
    }
}
