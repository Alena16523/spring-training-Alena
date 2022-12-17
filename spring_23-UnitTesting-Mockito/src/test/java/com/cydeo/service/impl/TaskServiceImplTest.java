package com.cydeo.service.impl;

import com.cydeo.dto.TaskDTO;
import com.cydeo.entity.Task;
import com.cydeo.mapper.TaskMapper;
import com.cydeo.repository.TaskRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class TaskServiceImplTest {

    @Mock
    TaskRepository taskRepository;
    @Mock
    TaskMapper taskMapper;
    @Mock
    TaskServiceImpl taskService;

    @ParameterizedTest
    @ValueSource(longs = {1L, 2L, 3L})
    void findById_Test(long id){

        Task task= new Task();

        //given (preparation)
        when(taskRepository.findById(id)).thenReturn(Optional.of(task)); //Optional<Task>
        when(taskMapper.convertToDto(task)).thenReturn(new TaskDTO());

        //when (action is hapenning)
       taskService.findById(id);

       //then (assertion and verification checks)
        verify(taskRepository).findById(id);
        verify(taskMapper).convertToDto(task);
    }




}