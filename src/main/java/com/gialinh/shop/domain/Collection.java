package com.gialinh.shop.domain;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author SlowV ❤ H3yae
 * @createdAt 2/5/21_1:06 PM
 * @updatedAt 2/5/21_1:06 PM
 *
 * Class entity Collection {@link com.gialinh.shop.domain.Collection}
 */
@Getter
@Setter
@Entity
@ToString
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "collections")
public class Collection extends AbstractAuditingEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "url_image", nullable = false)
    private String urlImage;
}
