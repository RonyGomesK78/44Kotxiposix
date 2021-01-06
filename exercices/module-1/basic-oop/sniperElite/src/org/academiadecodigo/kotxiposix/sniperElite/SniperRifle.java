package org.academiadecodigo.kotxiposix.sniperElite;

public class SniperRifle {

   private int bulletDamage;

   public SniperRifle(int bulletDamage){

       this.bulletDamage = bulletDamage;
   }

   public void shoot(Enemy enemy){

       enemy.hit(bulletDamage);
   }
}
