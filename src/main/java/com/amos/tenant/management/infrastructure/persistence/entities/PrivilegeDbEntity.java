package com.amos.tenant.management.infrastructure.persistence.entities;

import com.amos.tenant.management.infrastructure.persistence.entities.models.JpaEntityAbstract;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "privilege")
public class PrivilegeDbEntity  extends JpaEntityAbstract<Long> {
   private  String name;

   public PrivilegeDbEntity(String name) {
      this.name = name;
   }
}
