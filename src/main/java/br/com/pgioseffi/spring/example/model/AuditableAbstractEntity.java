package br.com.pgioseffi.spring.example.model;

import java.time.LocalDate;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter(AccessLevel.PROTECTED)
@Setter(AccessLevel.PROTECTED)
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@EqualsAndHashCode(of = { "id" })
@SuperBuilder
@NoArgsConstructor
class AuditableAbstractEntity {

	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator", parameters = {
			@Parameter(name = "uuid_gen_strategy_class", value = "org.hibernate.id.uuid.CustomVersionOneStrategy") })
	@Column(name = "id", updatable = false, nullable = false)
	private UUID id;

	@CreatedBy
	@Column(name = "created_by", insertable = true, updatable = false)
	private UUID createdBy;

	@CreatedDate
	@Column(name = "created_date", insertable = true, updatable = false)
	private LocalDate createdDate;

	@LastModifiedBy
	@Column(name = "updated_by", insertable = true, updatable = true)
	private UUID updatedBy;

	@LastModifiedDate
	@Column(name = "updated_date", insertable = false, updatable = true)
	private LocalDate updatedDate;

	public UUID getId() {
		return this.id;
	}
}