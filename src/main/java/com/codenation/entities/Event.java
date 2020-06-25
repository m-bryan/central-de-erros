package com.codenation.entities;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(of = "id")
@EntityListeners(AuditingEntityListener.class)
public class Event {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	@NotNull
	@Size(max = 250)
	private String description;
	
	@Column
	@NotNull
	@Size(max = 250)
	private String log;
	
	@Column
	@Enumerated(EnumType.STRING)
	private ErrorLevel errorLevel;
	
	@Column
	@Size(max = 250)
	private String origin;
	
	@CreatedBy
    public String createdBy;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    @CreatedDate
    public LocalDateTime createdAt;
    
    @Column(columnDefinition = "long default 0")
    public Long quantity;
}
