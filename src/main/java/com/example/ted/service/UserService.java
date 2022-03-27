package com.example.ted.service;

import com.example.ted.entity.User;
import com.example.ted.exception.EntityNotFoundException;
import com.example.ted.repository.UserRepository;
import com.example.ted.request.UserRequest;
import com.example.ted.response.UserResponse;
import com.example.ted.utils.ConvertUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository repository;

    private final ConvertUtils convertUtils;

    public UserService(UserRepository repository, ConvertUtils convertUtils) {
        this.repository = repository;
        this.convertUtils = convertUtils;
    }

    public List<UserResponse> getAll() {
        return (List<UserResponse>)
                convertUtils.convertToListResponse(repository.findAll(), UserResponse.class);
    }

    public UserResponse getById(Long id) {
        return (UserResponse)
                convertUtils.convertEntityToResponse(repository.findById(id).get(), UserResponse.class);
    }

    public User save(UserRequest request) {
        return repository.save((User) convertUtils.convertRequestToEntity(request, User.class));
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public void update(long id, UserRequest request) {
        User user = repository.findById(id)
                    .orElseThrow(() -> new EntityNotFoundException("User not found"));

        var entityUpdate = (User)
                convertUtils.convertRequestToEntity(request, user.getClass());
        entityUpdate.setId(id);

        repository.save(entityUpdate);
    }

}
