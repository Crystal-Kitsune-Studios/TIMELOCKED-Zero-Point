package com.timelocked.client;

import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;

public final class VehicleModels {
   public static LayerDefinition roverLayer() {
      MeshDefinition mesh = new MeshDefinition();
      PartDefinition root = mesh.getRoot();
      root.addOrReplaceChild(
         "part_0", CubeListBuilder.create().texOffs(0, 0).addBox(-7.0F, -12.0F, -24.0F, 14.0F, 5.0F, 48.0F), PartPose.offset(0.0F, 0.0F, 0.0F)
      );
      root.addOrReplaceChild(
         "part_1", CubeListBuilder.create().texOffs(126, 0).addBox(-17.0F, -16.0F, -25.0F, 34.0F, 4.0F, 50.0F), PartPose.offset(0.0F, 0.0F, 0.0F)
      );
      root.addOrReplaceChild(
         "part_2", CubeListBuilder.create().texOffs(296, 0).addBox(-15.0F, -21.0F, -25.0F, 30.0F, 5.0F, 7.0F), PartPose.offset(0.0F, 0.0F, 0.0F)
      );
      root.addOrReplaceChild(
         "part_3", CubeListBuilder.create().texOffs(372, 0).addBox(-16.0F, -18.0F, -18.0F, 32.0F, 2.0F, 22.0F), PartPose.offset(0.0F, 0.0F, 0.0F)
      );
      root.addOrReplaceChild(
         "part_4", CubeListBuilder.create().texOffs(482, 0).addBox(-14.0F, -31.0F, 6.0F, 28.0F, 15.0F, 18.0F), PartPose.offset(0.0F, 0.0F, 0.0F)
      );
      root.addOrReplaceChild(
         "part_5", CubeListBuilder.create().texOffs(576, 0).addBox(-12.0F, -33.0F, 7.0F, 24.0F, 2.0F, 15.0F), PartPose.offset(0.0F, 0.0F, 0.0F)
      );
      root.addOrReplaceChild(
         "part_6", CubeListBuilder.create().texOffs(656, 0).addBox(-11.0F, -28.0F, 24.0F, 22.0F, 10.0F, 1.0F), PartPose.offset(0.0F, 0.0F, 0.0F)
      );
      root.addOrReplaceChild(
         "part_7", CubeListBuilder.create().texOffs(704, 0).addBox(-8.0F, -26.0F, 25.0F, 16.0F, 5.0F, 1.0F), PartPose.offset(0.0F, 0.0F, 0.0F)
      );
      root.addOrReplaceChild(
         "part_8", CubeListBuilder.create().texOffs(740, 0).addBox(-16.0F, -24.0F, -18.0F, 3.0F, 6.0F, 21.0F), PartPose.offset(0.0F, 0.0F, 0.0F)
      );
      root.addOrReplaceChild(
         "part_9", CubeListBuilder.create().texOffs(790, 0).addBox(-16.0F, -40.0F, 0.0F, 3.0F, 16.0F, 3.0F), PartPose.offset(0.0F, 0.0F, 0.0F)
      );
      root.addOrReplaceChild(
         "part_10", CubeListBuilder.create().texOffs(804, 0).addBox(-16.0F, -40.0F, -18.0F, 3.0F, 16.0F, 3.0F), PartPose.offset(0.0F, 0.0F, 0.0F)
      );
      root.addOrReplaceChild(
         "part_11", CubeListBuilder.create().texOffs(818, 0).addBox(-15.6F, -38.0F, -15.0F, 2.2F, 14.0F, 15.0F), PartPose.offset(0.0F, 0.0F, 0.0F)
      );
      root.addOrReplaceChild(
         "part_12", CubeListBuilder.create().texOffs(855, 0).addBox(-16.0F, -40.0F, -18.0F, 3.0F, 2.0F, 21.0F), PartPose.offset(0.0F, 0.0F, 0.0F)
      );
      root.addOrReplaceChild(
         "part_13", CubeListBuilder.create().texOffs(905, 0).addBox(-16.0F, -27.0F, 9.0F, 3.0F, 8.0F, 11.0F), PartPose.offset(0.0F, 0.0F, 0.0F)
      );
      root.addOrReplaceChild(
         "part_14", CubeListBuilder.create().texOffs(935, 0).addBox(-16.3F, -23.0F, -18.0F, 0.25F, 3.0F, 21.0F), PartPose.offset(0.0F, 0.0F, 0.0F)
      );
      root.addOrReplaceChild(
         "part_15", CubeListBuilder.create().texOffs(0, 56).addBox(13.0F, -24.0F, -18.0F, 3.0F, 6.0F, 21.0F), PartPose.offset(0.0F, 0.0F, 0.0F)
      );
      root.addOrReplaceChild(
         "part_16", CubeListBuilder.create().texOffs(50, 56).addBox(13.0F, -40.0F, 0.0F, 3.0F, 16.0F, 3.0F), PartPose.offset(0.0F, 0.0F, 0.0F)
      );
      root.addOrReplaceChild(
         "part_17", CubeListBuilder.create().texOffs(64, 56).addBox(13.0F, -40.0F, -18.0F, 3.0F, 16.0F, 3.0F), PartPose.offset(0.0F, 0.0F, 0.0F)
      );
      root.addOrReplaceChild(
         "part_18", CubeListBuilder.create().texOffs(78, 56).addBox(13.4F, -38.0F, -15.0F, 2.2F, 14.0F, 15.0F), PartPose.offset(0.0F, 0.0F, 0.0F)
      );
      root.addOrReplaceChild(
         "part_19", CubeListBuilder.create().texOffs(115, 56).addBox(13.0F, -40.0F, -18.0F, 3.0F, 2.0F, 21.0F), PartPose.offset(0.0F, 0.0F, 0.0F)
      );
      root.addOrReplaceChild(
         "part_20", CubeListBuilder.create().texOffs(165, 56).addBox(13.0F, -27.0F, 9.0F, 3.0F, 8.0F, 11.0F), PartPose.offset(0.0F, 0.0F, 0.0F)
      );
      root.addOrReplaceChild(
         "part_21", CubeListBuilder.create().texOffs(195, 56).addBox(16.05F, -23.0F, -18.0F, 0.25F, 3.0F, 21.0F), PartPose.offset(0.0F, 0.0F, 0.0F)
      );
      root.addOrReplaceChild(
         "part_22", CubeListBuilder.create().texOffs(240, 56).addBox(-13.0F, -38.0F, -18.0F, 26.0F, 14.0F, 1.5F), PartPose.offset(0.0F, 0.0F, 0.0F)
      );
      root.addOrReplaceChild(
         "part_23", CubeListBuilder.create().texOffs(297, 56).addBox(-0.6F, -38.0F, -18.2F, 1.2F, 14.0F, 1.8F), PartPose.offset(0.0F, 0.0F, 0.0F)
      );
      root.addOrReplaceChild(
         "part_24", CubeListBuilder.create().texOffs(306, 56).addBox(-16.0F, -42.0F, -18.0F, 32.0F, 2.0F, 22.0F), PartPose.offset(0.0F, 0.0F, 0.0F)
      );
      root.addOrReplaceChild(
         "part_25", CubeListBuilder.create().texOffs(416, 56).addBox(-13.0F, -40.0F, 2.0F, 26.0F, 22.0F, 2.0F), PartPose.offset(0.0F, 0.0F, 0.0F)
      );
      root.addOrReplaceChild(
         "part_26", CubeListBuilder.create().texOffs(474, 56).addBox(-13.0F, -43.0F, -15.0F, 26.0F, 1.0F, 16.0F), PartPose.offset(0.0F, 0.0F, 0.0F)
      );
      root.addOrReplaceChild(
         "part_27", CubeListBuilder.create().texOffs(560, 56).addBox(-5.0F, -21.0F, -12.0F, 10.0F, 3.0F, 8.0F), PartPose.offset(0.0F, 0.0F, 0.0F)
      );
      root.addOrReplaceChild(
         "part_28", CubeListBuilder.create().texOffs(598, 56).addBox(-5.0F, -31.0F, -6.0F, 10.0F, 10.0F, 2.0F), PartPose.offset(0.0F, 0.0F, 0.0F)
      );
      root.addOrReplaceChild(
         "part_29", CubeListBuilder.create().texOffs(624, 56).addBox(-12.0F, -25.0F, -16.4F, 24.0F, 6.0F, 3.4F), PartPose.offset(0.0F, 0.0F, 0.0F)
      );
      root.addOrReplaceChild(
         "part_30", CubeListBuilder.create().texOffs(681, 56).addBox(-7.0F, -26.0F, -16.0F, 10.0F, 1.0F, 2.0F), PartPose.offset(0.0F, 0.0F, 0.0F)
      );
      root.addOrReplaceChild(
         "part_31", CubeListBuilder.create().texOffs(707, 56).addBox(-13.0F, -40.0F, -18.0F, 26.0F, 2.0F, 1.5F), PartPose.offset(0.0F, 0.0F, 0.0F)
      );
      root.addOrReplaceChild(
         "part_32", CubeListBuilder.create().texOffs(764, 56).addBox(-13.0F, -24.0F, -18.0F, 26.0F, 6.0F, 1.5F), PartPose.offset(0.0F, 0.0F, 0.0F)
      );
      root.addOrReplaceChild(
         "part_33", CubeListBuilder.create().texOffs(821, 56).addBox(-18.0F, -16.0F, -27.0F, 36.0F, 3.0F, 2.0F), PartPose.offset(0.0F, 0.0F, 0.0F)
      );
      root.addOrReplaceChild(
         "part_34", CubeListBuilder.create().texOffs(899, 56).addBox(-3.0F, -14.0F, -28.0F, 6.0F, 3.0F, 2.0F), PartPose.offset(0.0F, 0.0F, 0.0F)
      );
      root.addOrReplaceChild(
         "part_35", CubeListBuilder.create().texOffs(917, 56).addBox(-18.0F, -16.0F, 25.0F, 36.0F, 3.0F, 2.0F), PartPose.offset(0.0F, 0.0F, 0.0F)
      );
      root.addOrReplaceChild(
         "part_36", CubeListBuilder.create().texOffs(995, 56).addBox(10.0F, -49.0F, 18.0F, 1.0F, 16.0F, 1.0F), PartPose.offset(0.0F, 0.0F, 0.0F)
      );
      root.addOrReplaceChild(
         "part_37", CubeListBuilder.create().texOffs(1001, 56).addBox(8.0F, -49.0F, 17.0F, 5.0F, 3.0F, 3.0F), PartPose.offset(0.0F, 0.0F, 0.0F)
      );
      root.addOrReplaceChild(
         "part_38", CubeListBuilder.create().texOffs(0, 87).addBox(-7.0F, -37.0F, 15.0F, 9.0F, 4.0F, 7.0F), PartPose.offset(0.0F, 0.0F, 0.0F)
      );
      root.addOrReplaceChild(
         "part_39", CubeListBuilder.create().texOffs(34, 87).addBox(-5.0F, -36.0F, 22.0F, 5.0F, 2.0F, 1.0F), PartPose.offset(0.0F, 0.0F, 0.0F)
      );
      root.addOrReplaceChild(
         "part_40", CubeListBuilder.create().texOffs(48, 87).addBox(-12.0F, -20.0F, -26.0F, 5.0F, 3.0F, 1.0F), PartPose.offset(0.0F, 0.0F, 0.0F)
      );
      root.addOrReplaceChild(
         "part_41", CubeListBuilder.create().texOffs(62, 87).addBox(7.0F, -20.0F, -26.0F, 5.0F, 3.0F, 1.0F), PartPose.offset(0.0F, 0.0F, 0.0F)
      );
      root.addOrReplaceChild(
         "part_42", CubeListBuilder.create().texOffs(76, 87).addBox(-20.0F, -10.0F, -22.0F, 40.0F, 3.0F, 2.0F), PartPose.offset(0.0F, 0.0F, 0.0F)
      );
      root.addOrReplaceChild(
         "part_43", CubeListBuilder.create().texOffs(162, 87).addBox(-21.0F, -11.0F, -23.0F, 6.0F, 4.0F, 4.0F), PartPose.offset(0.0F, 0.0F, 0.0F)
      );
      root.addOrReplaceChild(
         "part_44", CubeListBuilder.create().texOffs(184, 87).addBox(-3.0F, -8.0F, -6.0F, 6.0F, 16.0F, 12.0F), PartPose.offset(-20.0F, -8.0F, -21.0F)
      );
      root.addOrReplaceChild(
         "part_45", CubeListBuilder.create().texOffs(222, 87).addBox(-3.0F, -6.0F, -8.0F, 6.0F, 12.0F, 16.0F), PartPose.offset(-20.0F, -8.0F, -21.0F)
      );
      root.addOrReplaceChild(
         "part_46", CubeListBuilder.create().texOffs(268, 87).addBox(-3.4F, -3.0F, -3.0F, 6.8F, 6.0F, 6.0F), PartPose.offset(-20.0F, -8.0F, -21.0F)
      );
      root.addOrReplaceChild(
         "part_47", CubeListBuilder.create().texOffs(296, 87).addBox(15.0F, -11.0F, -23.0F, 6.0F, 4.0F, 4.0F), PartPose.offset(0.0F, 0.0F, 0.0F)
      );
      root.addOrReplaceChild(
         "part_48", CubeListBuilder.create().texOffs(318, 87).addBox(-3.0F, -8.0F, -6.0F, 6.0F, 16.0F, 12.0F), PartPose.offset(20.0F, -8.0F, -21.0F)
      );
      root.addOrReplaceChild(
         "part_49", CubeListBuilder.create().texOffs(356, 87).addBox(-3.0F, -6.0F, -8.0F, 6.0F, 12.0F, 16.0F), PartPose.offset(20.0F, -8.0F, -21.0F)
      );
      root.addOrReplaceChild(
         "part_50", CubeListBuilder.create().texOffs(402, 87).addBox(-3.4F, -3.0F, -3.0F, 6.8F, 6.0F, 6.0F), PartPose.offset(20.0F, -8.0F, -21.0F)
      );
      root.addOrReplaceChild(
         "part_51", CubeListBuilder.create().texOffs(430, 87).addBox(-20.0F, -10.0F, -1.0F, 40.0F, 3.0F, 2.0F), PartPose.offset(0.0F, 0.0F, 0.0F)
      );
      root.addOrReplaceChild(
         "part_52", CubeListBuilder.create().texOffs(516, 87).addBox(-21.0F, -11.0F, -2.0F, 6.0F, 4.0F, 4.0F), PartPose.offset(0.0F, 0.0F, 0.0F)
      );
      root.addOrReplaceChild(
         "part_53", CubeListBuilder.create().texOffs(538, 87).addBox(-3.0F, -8.0F, -6.0F, 6.0F, 16.0F, 12.0F), PartPose.offset(-20.0F, -8.0F, 0.0F)
      );
      root.addOrReplaceChild(
         "part_54", CubeListBuilder.create().texOffs(576, 87).addBox(-3.0F, -6.0F, -8.0F, 6.0F, 12.0F, 16.0F), PartPose.offset(-20.0F, -8.0F, 0.0F)
      );
      root.addOrReplaceChild(
         "part_55", CubeListBuilder.create().texOffs(622, 87).addBox(-3.4F, -3.0F, -3.0F, 6.8F, 6.0F, 6.0F), PartPose.offset(-20.0F, -8.0F, 0.0F)
      );
      root.addOrReplaceChild(
         "part_56", CubeListBuilder.create().texOffs(650, 87).addBox(15.0F, -11.0F, -2.0F, 6.0F, 4.0F, 4.0F), PartPose.offset(0.0F, 0.0F, 0.0F)
      );
      root.addOrReplaceChild(
         "part_57", CubeListBuilder.create().texOffs(672, 87).addBox(-3.0F, -8.0F, -6.0F, 6.0F, 16.0F, 12.0F), PartPose.offset(20.0F, -8.0F, 0.0F)
      );
      root.addOrReplaceChild(
         "part_58", CubeListBuilder.create().texOffs(710, 87).addBox(-3.0F, -6.0F, -8.0F, 6.0F, 12.0F, 16.0F), PartPose.offset(20.0F, -8.0F, 0.0F)
      );
      root.addOrReplaceChild(
         "part_59", CubeListBuilder.create().texOffs(756, 87).addBox(-3.4F, -3.0F, -3.0F, 6.8F, 6.0F, 6.0F), PartPose.offset(20.0F, -8.0F, 0.0F)
      );
      root.addOrReplaceChild(
         "part_60", CubeListBuilder.create().texOffs(784, 87).addBox(-20.0F, -10.0F, 20.0F, 40.0F, 3.0F, 2.0F), PartPose.offset(0.0F, 0.0F, 0.0F)
      );
      root.addOrReplaceChild(
         "part_61", CubeListBuilder.create().texOffs(870, 87).addBox(-21.0F, -11.0F, 19.0F, 6.0F, 4.0F, 4.0F), PartPose.offset(0.0F, 0.0F, 0.0F)
      );
      root.addOrReplaceChild(
         "part_62", CubeListBuilder.create().texOffs(892, 87).addBox(-3.0F, -8.0F, -6.0F, 6.0F, 16.0F, 12.0F), PartPose.offset(-20.0F, -8.0F, 21.0F)
      );
      root.addOrReplaceChild(
         "part_63", CubeListBuilder.create().texOffs(930, 87).addBox(-3.0F, -6.0F, -8.0F, 6.0F, 12.0F, 16.0F), PartPose.offset(-20.0F, -8.0F, 21.0F)
      );
      root.addOrReplaceChild(
         "part_64", CubeListBuilder.create().texOffs(976, 87).addBox(-3.4F, -3.0F, -3.0F, 6.8F, 6.0F, 6.0F), PartPose.offset(-20.0F, -8.0F, 21.0F)
      );
      root.addOrReplaceChild(
         "part_65", CubeListBuilder.create().texOffs(0, 117).addBox(15.0F, -11.0F, 19.0F, 6.0F, 4.0F, 4.0F), PartPose.offset(0.0F, 0.0F, 0.0F)
      );
      root.addOrReplaceChild(
         "part_66", CubeListBuilder.create().texOffs(22, 117).addBox(-3.0F, -8.0F, -6.0F, 6.0F, 16.0F, 12.0F), PartPose.offset(20.0F, -8.0F, 21.0F)
      );
      root.addOrReplaceChild(
         "part_67", CubeListBuilder.create().texOffs(60, 117).addBox(-3.0F, -6.0F, -8.0F, 6.0F, 12.0F, 16.0F), PartPose.offset(20.0F, -8.0F, 21.0F)
      );
      root.addOrReplaceChild(
         "part_68", CubeListBuilder.create().texOffs(106, 117).addBox(-3.4F, -3.0F, -3.0F, 6.8F, 6.0F, 6.0F), PartPose.offset(20.0F, -8.0F, 21.0F)
      );
      return LayerDefinition.create(mesh, 1024, 1024);
   }

   public static LayerDefinition truckLayer() {
      MeshDefinition mesh = new MeshDefinition();
      PartDefinition root = mesh.getRoot();
      root.addOrReplaceChild(
         "part_0", CubeListBuilder.create().texOffs(0, 0).addBox(-14.0F, -9.0F, -28.0F, 28.0F, 4.0F, 56.0F), PartPose.offset(0.0F, 0.0F, 0.0F)
      );
      root.addOrReplaceChild(
         "part_1", CubeListBuilder.create().texOffs(170, 0).addBox(-16.0F, -18.0F, -28.0F, 32.0F, 8.0F, 17.0F), PartPose.offset(0.0F, 0.0F, 0.0F)
      );
      root.addOrReplaceChild(
         "part_2", CubeListBuilder.create().texOffs(270, 0).addBox(-13.0F, -20.0F, -26.0F, 26.0F, 2.0F, 14.0F), PartPose.offset(0.0F, 0.0F, 0.0F)
      );
      root.addOrReplaceChild(
         "part_3", CubeListBuilder.create().texOffs(352, 0).addBox(-18.0F, -11.0F, -30.0F, 36.0F, 4.0F, 2.0F), PartPose.offset(0.0F, 0.0F, 0.0F)
      );
      root.addOrReplaceChild(
         "part_4", CubeListBuilder.create().texOffs(430, 0).addBox(-14.0F, -17.0F, -29.0F, 28.0F, 6.0F, 1.0F), PartPose.offset(0.0F, 0.0F, 0.0F)
      );
      root.addOrReplaceChild(
         "part_5", CubeListBuilder.create().texOffs(490, 0).addBox(-8.0F, -16.0F, -29.3F, 16.0F, 4.0F, 0.3F), PartPose.offset(0.0F, 0.0F, 0.0F)
      );
      root.addOrReplaceChild(
         "part_6", CubeListBuilder.create().texOffs(525, 0).addBox(-4.0F, -10.0F, -30.2F, 8.0F, 2.5F, 0.2F), PartPose.offset(0.0F, 0.0F, 0.0F)
      );
      root.addOrReplaceChild(
         "part_7", CubeListBuilder.create().texOffs(544, 0).addBox(-13.0F, -16.0F, -29.6F, 5.0F, 4.0F, 0.6F), PartPose.offset(0.0F, 0.0F, 0.0F)
      );
      root.addOrReplaceChild(
         "part_8", CubeListBuilder.create().texOffs(558, 0).addBox(8.0F, -16.0F, -29.6F, 5.0F, 4.0F, 0.6F), PartPose.offset(0.0F, 0.0F, 0.0F)
      );
      root.addOrReplaceChild(
         "part_9", CubeListBuilder.create().texOffs(572, 0).addBox(-16.0F, -14.0F, -11.0F, 32.0F, 4.0F, 21.0F), PartPose.offset(0.0F, 0.0F, 0.0F)
      );
      root.addOrReplaceChild(
         "part_10", CubeListBuilder.create().texOffs(680, 0).addBox(-16.0F, -35.0F, 8.0F, 32.0F, 21.0F, 2.0F), PartPose.offset(0.0F, 0.0F, 0.0F)
      );
      root.addOrReplaceChild(
         "part_11", CubeListBuilder.create().texOffs(750, 0).addBox(-10.0F, -33.0F, 10.0F, 20.0F, 9.0F, 0.3F), PartPose.offset(0.0F, 0.0F, 0.0F)
      );
      root.addOrReplaceChild(
         "part_12", CubeListBuilder.create().texOffs(793, 0).addBox(-17.0F, -38.0F, -11.0F, 34.0F, 3.0F, 22.0F), PartPose.offset(0.0F, 0.0F, 0.0F)
      );
      root.addOrReplaceChild(
         "part_13", CubeListBuilder.create().texOffs(907, 0).addBox(-13.0F, -34.0F, -11.4F, 26.0F, 12.0F, 1.4F), PartPose.offset(0.0F, 0.0F, 0.0F)
      );
      root.addOrReplaceChild(
         "part_14", CubeListBuilder.create().texOffs(0, 62).addBox(-16.0F, -22.0F, -12.0F, 32.0F, 3.0F, 2.0F), PartPose.offset(0.0F, 0.0F, 0.0F)
      );
      root.addOrReplaceChild(
         "part_15", CubeListBuilder.create().texOffs(70, 62).addBox(-16.0F, -35.0F, -11.0F, 3.0F, 15.0F, 2.0F), PartPose.offset(0.0F, 0.0F, 0.0F)
      );
      root.addOrReplaceChild(
         "part_16", CubeListBuilder.create().texOffs(82, 62).addBox(-16.0F, -35.0F, 7.0F, 3.0F, 21.0F, 3.0F), PartPose.offset(0.0F, 0.0F, 0.0F)
      );
      root.addOrReplaceChild(
         "part_17", CubeListBuilder.create().texOffs(96, 62).addBox(-16.0F, -23.0F, -9.0F, 3.0F, 9.0F, 16.0F), PartPose.offset(0.0F, 0.0F, 0.0F)
      );
      root.addOrReplaceChild(
         "part_18", CubeListBuilder.create().texOffs(136, 62).addBox(-15.7F, -34.0F, -9.0F, 2.4F, 10.0F, 16.0F), PartPose.offset(0.0F, 0.0F, 0.0F)
      );
      root.addOrReplaceChild(
         "part_19", CubeListBuilder.create().texOffs(175, 62).addBox(-16.1F, -34.0F, -1.0F, 3.2F, 10.0F, 1.0F), PartPose.offset(0.0F, 0.0F, 0.0F)
      );
      root.addOrReplaceChild(
         "part_20", CubeListBuilder.create().texOffs(186, 62).addBox(-16.5F, -22.0F, 4.0F, 0.4F, 1.0F, 3.0F), PartPose.offset(0.0F, 0.0F, 0.0F)
      );
      root.addOrReplaceChild(
         "part_21", CubeListBuilder.create().texOffs(195, 62).addBox(-16.25F, -20.0F, -9.0F, 0.2F, 3.0F, 16.0F), PartPose.offset(0.0F, 0.0F, 0.0F)
      );
      root.addOrReplaceChild(
         "part_22", CubeListBuilder.create().texOffs(230, 62).addBox(-19.0F, -12.0F, -10.0F, 3.0F, 2.0F, 21.0F), PartPose.offset(0.0F, 0.0F, 0.0F)
      );
      root.addOrReplaceChild(
         "part_23", CubeListBuilder.create().texOffs(280, 62).addBox(-20.0F, -27.0F, -8.0F, 4.0F, 2.0F, 2.0F), PartPose.offset(0.0F, 0.0F, 0.0F)
      );
      root.addOrReplaceChild(
         "part_24", CubeListBuilder.create().texOffs(294, 62).addBox(-21.0F, -29.0F, -8.0F, 2.0F, 5.0F, 3.0F), PartPose.offset(0.0F, 0.0F, 0.0F)
      );
      root.addOrReplaceChild(
         "part_25", CubeListBuilder.create().texOffs(306, 62).addBox(-19.0F, -18.0F, -28.0F, 5.0F, 3.0F, 14.0F), PartPose.offset(0.0F, 0.0F, 0.0F)
      );
      root.addOrReplaceChild(
         "part_26", CubeListBuilder.create().texOffs(346, 62).addBox(-19.0F, -18.0F, 14.0F, 5.0F, 3.0F, 14.0F), PartPose.offset(0.0F, 0.0F, 0.0F)
      );
      root.addOrReplaceChild(
         "part_27", CubeListBuilder.create().texOffs(386, 62).addBox(13.0F, -35.0F, -11.0F, 3.0F, 15.0F, 2.0F), PartPose.offset(0.0F, 0.0F, 0.0F)
      );
      root.addOrReplaceChild(
         "part_28", CubeListBuilder.create().texOffs(398, 62).addBox(13.0F, -35.0F, 7.0F, 3.0F, 21.0F, 3.0F), PartPose.offset(0.0F, 0.0F, 0.0F)
      );
      root.addOrReplaceChild(
         "part_29", CubeListBuilder.create().texOffs(412, 62).addBox(13.0F, -23.0F, -9.0F, 3.0F, 9.0F, 16.0F), PartPose.offset(0.0F, 0.0F, 0.0F)
      );
      root.addOrReplaceChild(
         "part_30", CubeListBuilder.create().texOffs(452, 62).addBox(13.3F, -34.0F, -9.0F, 2.4F, 10.0F, 16.0F), PartPose.offset(0.0F, 0.0F, 0.0F)
      );
      root.addOrReplaceChild(
         "part_31", CubeListBuilder.create().texOffs(491, 62).addBox(12.9F, -34.0F, -1.0F, 3.2F, 10.0F, 1.0F), PartPose.offset(0.0F, 0.0F, 0.0F)
      );
      root.addOrReplaceChild(
         "part_32", CubeListBuilder.create().texOffs(502, 62).addBox(16.1F, -22.0F, 4.0F, 0.4F, 1.0F, 3.0F), PartPose.offset(0.0F, 0.0F, 0.0F)
      );
      root.addOrReplaceChild(
         "part_33", CubeListBuilder.create().texOffs(511, 62).addBox(16.05F, -20.0F, -9.0F, 0.2F, 3.0F, 16.0F), PartPose.offset(0.0F, 0.0F, 0.0F)
      );
      root.addOrReplaceChild(
         "part_34", CubeListBuilder.create().texOffs(546, 62).addBox(16.0F, -12.0F, -10.0F, 3.0F, 2.0F, 21.0F), PartPose.offset(0.0F, 0.0F, 0.0F)
      );
      root.addOrReplaceChild(
         "part_35", CubeListBuilder.create().texOffs(596, 62).addBox(16.0F, -27.0F, -8.0F, 4.0F, 2.0F, 2.0F), PartPose.offset(0.0F, 0.0F, 0.0F)
      );
      root.addOrReplaceChild(
         "part_36", CubeListBuilder.create().texOffs(610, 62).addBox(19.0F, -29.0F, -8.0F, 2.0F, 5.0F, 3.0F), PartPose.offset(0.0F, 0.0F, 0.0F)
      );
      root.addOrReplaceChild(
         "part_37", CubeListBuilder.create().texOffs(622, 62).addBox(14.0F, -18.0F, -28.0F, 5.0F, 3.0F, 14.0F), PartPose.offset(0.0F, 0.0F, 0.0F)
      );
      root.addOrReplaceChild(
         "part_38", CubeListBuilder.create().texOffs(662, 62).addBox(14.0F, -18.0F, 14.0F, 5.0F, 3.0F, 14.0F), PartPose.offset(0.0F, 0.0F, 0.0F)
      );
      root.addOrReplaceChild(
         "part_39", CubeListBuilder.create().texOffs(702, 62).addBox(-16.0F, -14.0F, 11.0F, 32.0F, 4.0F, 17.0F), PartPose.offset(0.0F, 0.0F, 0.0F)
      );
      root.addOrReplaceChild(
         "part_40", CubeListBuilder.create().texOffs(802, 62).addBox(-16.0F, -24.0F, 11.0F, 32.0F, 10.0F, 2.0F), PartPose.offset(0.0F, 0.0F, 0.0F)
      );
      root.addOrReplaceChild(
         "part_41", CubeListBuilder.create().texOffs(872, 62).addBox(-16.0F, -23.0F, 13.0F, 3.0F, 9.0F, 15.0F), PartPose.offset(0.0F, 0.0F, 0.0F)
      );
      root.addOrReplaceChild(
         "part_42", CubeListBuilder.create().texOffs(910, 62).addBox(13.0F, -23.0F, 13.0F, 3.0F, 9.0F, 15.0F), PartPose.offset(0.0F, 0.0F, 0.0F)
      );
      root.addOrReplaceChild(
         "part_43", CubeListBuilder.create().texOffs(948, 62).addBox(-16.0F, -23.0F, 28.0F, 32.0F, 9.0F, 2.0F), PartPose.offset(0.0F, 0.0F, 0.0F)
      );
      root.addOrReplaceChild(
         "part_44", CubeListBuilder.create().texOffs(0, 90).addBox(-4.0F, -22.0F, 30.0F, 8.0F, 1.0F, 0.2F), PartPose.offset(0.0F, 0.0F, 0.0F)
      );
      root.addOrReplaceChild(
         "part_45", CubeListBuilder.create().texOffs(19, 90).addBox(-13.0F, -15.0F, 13.0F, 26.0F, 1.0F, 15.0F), PartPose.offset(0.0F, 0.0F, 0.0F)
      );
      root.addOrReplaceChild(
         "part_46", CubeListBuilder.create().texOffs(103, 90).addBox(-18.0F, -10.0F, 28.0F, 36.0F, 3.0F, 2.0F), PartPose.offset(0.0F, 0.0F, 0.0F)
      );
      root.addOrReplaceChild(
         "part_47", CubeListBuilder.create().texOffs(181, 90).addBox(-15.0F, -20.0F, 30.0F, 3.0F, 5.0F, 0.3F), PartPose.offset(0.0F, 0.0F, 0.0F)
      );
      root.addOrReplaceChild(
         "part_48", CubeListBuilder.create().texOffs(190, 90).addBox(12.0F, -20.0F, 30.0F, 3.0F, 5.0F, 0.3F), PartPose.offset(0.0F, 0.0F, 0.0F)
      );
      root.addOrReplaceChild(
         "part_49", CubeListBuilder.create().texOffs(199, 90).addBox(-7.0F, -18.0F, -5.0F, 14.0F, 4.0F, 8.0F), PartPose.offset(0.0F, 0.0F, 0.0F)
      );
      root.addOrReplaceChild(
         "part_50", CubeListBuilder.create().texOffs(245, 90).addBox(-7.0F, -29.0F, 1.0F, 14.0F, 11.0F, 3.0F), PartPose.offset(0.0F, 0.0F, 0.0F)
      );
      root.addOrReplaceChild(
         "part_51", CubeListBuilder.create().texOffs(281, 90).addBox(-13.0F, -23.0F, -10.0F, 26.0F, 6.0F, 3.0F), PartPose.offset(0.0F, 0.0F, 0.0F)
      );
      root.addOrReplaceChild(
         "part_52", CubeListBuilder.create().texOffs(341, 90).addBox(-5.0F, -24.0F, -8.0F, 10.0F, 1.0F, 2.0F), PartPose.offset(0.0F, 0.0F, 0.0F)
      );
      root.addOrReplaceChild(
         "part_53", CubeListBuilder.create().texOffs(367, 90).addBox(13.0F, -43.0F, 7.0F, 1.0F, 5.0F, 1.0F), PartPose.offset(0.0F, 0.0F, 0.0F)
      );
      root.addOrReplaceChild(
         "part_54", CubeListBuilder.create().texOffs(373, 90).addBox(-18.0F, -8.0F, -22.0F, 36.0F, 3.0F, 2.0F), PartPose.offset(0.0F, 0.0F, 0.0F)
      );
      root.addOrReplaceChild(
         "part_55", CubeListBuilder.create().texOffs(451, 90).addBox(-3.0F, -6.0F, -4.0F, 6.0F, 12.0F, 8.0F), PartPose.offset(-18.0F, -6.0F, -21.0F)
      );
      root.addOrReplaceChild(
         "part_56", CubeListBuilder.create().texOffs(481, 90).addBox(-3.0F, -4.0F, -6.0F, 6.0F, 8.0F, 12.0F), PartPose.offset(-18.0F, -6.0F, -21.0F)
      );
      root.addOrReplaceChild(
         "part_57", CubeListBuilder.create().texOffs(519, 90).addBox(-3.3F, -2.0F, -2.0F, 6.6F, 4.0F, 4.0F), PartPose.offset(-18.0F, -6.0F, -21.0F)
      );
      root.addOrReplaceChild(
         "part_58", CubeListBuilder.create().texOffs(543, 90).addBox(-3.0F, -6.0F, -4.0F, 6.0F, 12.0F, 8.0F), PartPose.offset(18.0F, -6.0F, -21.0F)
      );
      root.addOrReplaceChild(
         "part_59", CubeListBuilder.create().texOffs(573, 90).addBox(-3.0F, -4.0F, -6.0F, 6.0F, 8.0F, 12.0F), PartPose.offset(18.0F, -6.0F, -21.0F)
      );
      root.addOrReplaceChild(
         "part_60", CubeListBuilder.create().texOffs(611, 90).addBox(-3.3F, -2.0F, -2.0F, 6.6F, 4.0F, 4.0F), PartPose.offset(18.0F, -6.0F, -21.0F)
      );
      root.addOrReplaceChild(
         "part_61", CubeListBuilder.create().texOffs(635, 90).addBox(-18.0F, -8.0F, 20.0F, 36.0F, 3.0F, 2.0F), PartPose.offset(0.0F, 0.0F, 0.0F)
      );
      root.addOrReplaceChild(
         "part_62", CubeListBuilder.create().texOffs(713, 90).addBox(-3.0F, -6.0F, -4.0F, 6.0F, 12.0F, 8.0F), PartPose.offset(-18.0F, -6.0F, 21.0F)
      );
      root.addOrReplaceChild(
         "part_63", CubeListBuilder.create().texOffs(743, 90).addBox(-3.0F, -4.0F, -6.0F, 6.0F, 8.0F, 12.0F), PartPose.offset(-18.0F, -6.0F, 21.0F)
      );
      root.addOrReplaceChild(
         "part_64", CubeListBuilder.create().texOffs(781, 90).addBox(-3.3F, -2.0F, -2.0F, 6.6F, 4.0F, 4.0F), PartPose.offset(-18.0F, -6.0F, 21.0F)
      );
      root.addOrReplaceChild(
         "part_65", CubeListBuilder.create().texOffs(805, 90).addBox(-3.0F, -6.0F, -4.0F, 6.0F, 12.0F, 8.0F), PartPose.offset(18.0F, -6.0F, 21.0F)
      );
      root.addOrReplaceChild(
         "part_66", CubeListBuilder.create().texOffs(835, 90).addBox(-3.0F, -4.0F, -6.0F, 6.0F, 8.0F, 12.0F), PartPose.offset(18.0F, -6.0F, 21.0F)
      );
      root.addOrReplaceChild(
         "part_67", CubeListBuilder.create().texOffs(873, 90).addBox(-3.3F, -2.0F, -2.0F, 6.6F, 4.0F, 4.0F), PartPose.offset(18.0F, -6.0F, 21.0F)
      );
      return LayerDefinition.create(mesh, 1024, 1024);
   }

   public static LayerDefinition tramLayer() {
      MeshDefinition mesh = new MeshDefinition();
      PartDefinition root = mesh.getRoot();
      root.addOrReplaceChild(
         "part_0", CubeListBuilder.create().texOffs(0, 0).addBox(-13.0F, -9.0F, -40.0F, 26.0F, 4.0F, 80.0F), PartPose.offset(0.0F, 0.0F, 0.0F)
      );
      root.addOrReplaceChild(
         "part_1", CubeListBuilder.create().texOffs(214, 0).addBox(-14.0F, -12.0F, -40.0F, 28.0F, 3.0F, 80.0F), PartPose.offset(0.0F, 0.0F, 0.0F)
      );
      root.addOrReplaceChild(
         "part_2", CubeListBuilder.create().texOffs(432, 0).addBox(-14.0F, -21.0F, -39.0F, 2.0F, 9.0F, 41.0F), PartPose.offset(0.0F, 0.0F, 0.0F)
      );
      root.addOrReplaceChild(
         "part_2b", CubeListBuilder.create().texOffs(522, 0).addBox(-14.0F, -21.0F, 16.0F, 2.0F, 9.0F, 23.0F), PartPose.offset(0.0F, 0.0F, 0.0F)
      );
      root.addOrReplaceChild(
         "part_3", CubeListBuilder.create().texOffs(594, 0).addBox(12.0F, -21.0F, -39.0F, 2.0F, 9.0F, 41.0F), PartPose.offset(0.0F, 0.0F, 0.0F)
      );
      root.addOrReplaceChild(
         "part_3b", CubeListBuilder.create().texOffs(684, 0).addBox(12.0F, -21.0F, 16.0F, 2.0F, 9.0F, 23.0F), PartPose.offset(0.0F, 0.0F, 0.0F)
      );
      root.addOrReplaceChild(
         "part_4", CubeListBuilder.create().texOffs(756, 0).addBox(-14.0F, -42.0F, -40.0F, 28.0F, 3.0F, 80.0F), PartPose.offset(0.0F, 0.0F, 0.0F)
      );
      root.addOrReplaceChild(
         "part_5", CubeListBuilder.create().texOffs(0, 89).addBox(-11.0F, -43.0F, -34.0F, 22.0F, 1.0F, 68.0F), PartPose.offset(0.0F, 0.0F, 0.0F)
      );
      root.addOrReplaceChild(
         "part_6", CubeListBuilder.create().texOffs(182, 89).addBox(-6.0F, -45.0F, -12.0F, 12.0F, 2.0F, 20.0F), PartPose.offset(0.0F, 0.0F, 0.0F)
      );
      root.addOrReplaceChild(
         "part_7", CubeListBuilder.create().texOffs(248, 89).addBox(-14.3F, -21.0F, -39.0F, 0.26F, 4.0F, 41.0F), PartPose.offset(0.0F, 0.0F, 0.0F)
      );
      root.addOrReplaceChild(
         "part_7b", CubeListBuilder.create().texOffs(338, 89).addBox(-14.3F, -21.0F, 16.0F, 0.26F, 4.0F, 23.0F), PartPose.offset(0.0F, 0.0F, 0.0F)
      );
      root.addOrReplaceChild(
         "part_8", CubeListBuilder.create().texOffs(407, 89).addBox(-14.0F, -39.0F, -39.0F, 2.0F, 18.0F, 7.0F), PartPose.offset(0.0F, 0.0F, 0.0F)
      );
      root.addOrReplaceChild(
         "part_9", CubeListBuilder.create().texOffs(427, 89).addBox(-14.0F, -39.0F, -18.0F, 2.0F, 18.0F, 4.0F), PartPose.offset(0.0F, 0.0F, 0.0F)
      );
      root.addOrReplaceChild(
         "part_10", CubeListBuilder.create().texOffs(441, 89).addBox(-14.0F, -39.0F, -2.0F, 2.0F, 18.0F, 4.0F), PartPose.offset(0.0F, 0.0F, 0.0F)
      );
      root.addOrReplaceChild(
         "part_11", CubeListBuilder.create().texOffs(455, 89).addBox(-14.0F, -39.0F, 16.0F, 2.0F, 18.0F, 4.0F), PartPose.offset(0.0F, 0.0F, 0.0F)
      );
      root.addOrReplaceChild(
         "part_12", CubeListBuilder.create().texOffs(469, 89).addBox(-14.0F, -39.0F, 32.0F, 2.0F, 18.0F, 7.0F), PartPose.offset(0.0F, 0.0F, 0.0F)
      );
      root.addOrReplaceChild(
         "part_13", CubeListBuilder.create().texOffs(489, 89).addBox(-13.75F, -36.0F, -32.0F, 1.5F, 12.0F, 14.0F), PartPose.offset(0.0F, 0.0F, 0.0F)
      );
      root.addOrReplaceChild(
         "part_14", CubeListBuilder.create().texOffs(522, 89).addBox(-14.0F, -24.0F, -32.0F, 2.0F, 3.0F, 14.0F), PartPose.offset(0.0F, 0.0F, 0.0F)
      );
      root.addOrReplaceChild(
         "part_15", CubeListBuilder.create().texOffs(556, 89).addBox(-14.0F, -39.0F, -32.0F, 2.0F, 3.0F, 14.0F), PartPose.offset(0.0F, 0.0F, 0.0F)
      );
      root.addOrReplaceChild(
         "part_16", CubeListBuilder.create().texOffs(590, 89).addBox(-13.75F, -36.0F, -14.0F, 1.5F, 12.0F, 12.0F), PartPose.offset(0.0F, 0.0F, 0.0F)
      );
      root.addOrReplaceChild(
         "part_17", CubeListBuilder.create().texOffs(619, 89).addBox(-14.0F, -24.0F, -14.0F, 2.0F, 3.0F, 12.0F), PartPose.offset(0.0F, 0.0F, 0.0F)
      );
      root.addOrReplaceChild(
         "part_18", CubeListBuilder.create().texOffs(649, 89).addBox(-14.0F, -39.0F, -14.0F, 2.0F, 3.0F, 12.0F), PartPose.offset(0.0F, 0.0F, 0.0F)
      );
      root.addOrReplaceChild(
         "part_19", CubeListBuilder.create().texOffs(679, 89).addBox(-13.75F, -36.0F, 20.0F, 1.5F, 12.0F, 12.0F), PartPose.offset(0.0F, 0.0F, 0.0F)
      );
      root.addOrReplaceChild(
         "part_20", CubeListBuilder.create().texOffs(708, 89).addBox(-14.0F, -24.0F, 20.0F, 2.0F, 3.0F, 12.0F), PartPose.offset(0.0F, 0.0F, 0.0F)
      );
      root.addOrReplaceChild(
         "part_21", CubeListBuilder.create().texOffs(738, 89).addBox(-14.0F, -39.0F, 20.0F, 2.0F, 3.0F, 12.0F), PartPose.offset(0.0F, 0.0F, 0.0F)
      );
      root.addOrReplaceChild(
         "part_22", CubeListBuilder.create().texOffs(768, 89).addBox(-14.0F, -39.0F, 2.0F, 2.0F, 27.0F, 14.0F), PartPose.offset(0.0F, 0.0F, 0.0F)
      );
      root.addOrReplaceChild(
         "part_23", CubeListBuilder.create().texOffs(802, 89).addBox(-14.1F, -35.0F, 4.0F, 2.2F, 10.0F, 10.0F), PartPose.offset(0.0F, 0.0F, 0.0F)
      );
      root.addOrReplaceChild(
         "part_24", CubeListBuilder.create().texOffs(829, 89).addBox(-14.15F, -38.0F, 8.5F, 2.3F, 25.0F, 1.0F), PartPose.offset(0.0F, 0.0F, 0.0F)
      );
      root.addOrReplaceChild(
         "part_25", CubeListBuilder.create().texOffs(838, 89).addBox(-15.0F, -11.0F, 1.0F, 4.0F, 2.0F, 16.0F), PartPose.offset(0.0F, 0.0F, 0.0F)
      );
      root.addOrReplaceChild(
         "part_26", CubeListBuilder.create().texOffs(0, 173).addBox(14.04F, -21.0F, -39.0F, 0.26F, 4.0F, 41.0F), PartPose.offset(0.0F, 0.0F, 0.0F)
      );
      root.addOrReplaceChild(
         "part_26b", CubeListBuilder.create().texOffs(90, 173).addBox(14.04F, -21.0F, 16.0F, 0.26F, 4.0F, 23.0F), PartPose.offset(0.0F, 0.0F, 0.0F)
      );
      root.addOrReplaceChild(
         "part_27", CubeListBuilder.create().texOffs(159, 173).addBox(12.0F, -39.0F, -39.0F, 2.0F, 18.0F, 7.0F), PartPose.offset(0.0F, 0.0F, 0.0F)
      );
      root.addOrReplaceChild(
         "part_28", CubeListBuilder.create().texOffs(179, 173).addBox(12.0F, -39.0F, -18.0F, 2.0F, 18.0F, 4.0F), PartPose.offset(0.0F, 0.0F, 0.0F)
      );
      root.addOrReplaceChild(
         "part_29", CubeListBuilder.create().texOffs(193, 173).addBox(12.0F, -39.0F, -2.0F, 2.0F, 18.0F, 4.0F), PartPose.offset(0.0F, 0.0F, 0.0F)
      );
      root.addOrReplaceChild(
         "part_30", CubeListBuilder.create().texOffs(207, 173).addBox(12.0F, -39.0F, 16.0F, 2.0F, 18.0F, 4.0F), PartPose.offset(0.0F, 0.0F, 0.0F)
      );
      root.addOrReplaceChild(
         "part_31", CubeListBuilder.create().texOffs(221, 173).addBox(12.0F, -39.0F, 32.0F, 2.0F, 18.0F, 7.0F), PartPose.offset(0.0F, 0.0F, 0.0F)
      );
      root.addOrReplaceChild(
         "part_32", CubeListBuilder.create().texOffs(241, 173).addBox(12.25F, -36.0F, -32.0F, 1.5F, 12.0F, 14.0F), PartPose.offset(0.0F, 0.0F, 0.0F)
      );
      root.addOrReplaceChild(
         "part_33", CubeListBuilder.create().texOffs(274, 173).addBox(12.0F, -24.0F, -32.0F, 2.0F, 3.0F, 14.0F), PartPose.offset(0.0F, 0.0F, 0.0F)
      );
      root.addOrReplaceChild(
         "part_34", CubeListBuilder.create().texOffs(308, 173).addBox(12.0F, -39.0F, -32.0F, 2.0F, 3.0F, 14.0F), PartPose.offset(0.0F, 0.0F, 0.0F)
      );
      root.addOrReplaceChild(
         "part_35", CubeListBuilder.create().texOffs(342, 173).addBox(12.25F, -36.0F, -14.0F, 1.5F, 12.0F, 12.0F), PartPose.offset(0.0F, 0.0F, 0.0F)
      );
      root.addOrReplaceChild(
         "part_36", CubeListBuilder.create().texOffs(371, 173).addBox(12.0F, -24.0F, -14.0F, 2.0F, 3.0F, 12.0F), PartPose.offset(0.0F, 0.0F, 0.0F)
      );
      root.addOrReplaceChild(
         "part_37", CubeListBuilder.create().texOffs(401, 173).addBox(12.0F, -39.0F, -14.0F, 2.0F, 3.0F, 12.0F), PartPose.offset(0.0F, 0.0F, 0.0F)
      );
      root.addOrReplaceChild(
         "part_38", CubeListBuilder.create().texOffs(431, 173).addBox(12.25F, -36.0F, 20.0F, 1.5F, 12.0F, 12.0F), PartPose.offset(0.0F, 0.0F, 0.0F)
      );
      root.addOrReplaceChild(
         "part_39", CubeListBuilder.create().texOffs(460, 173).addBox(12.0F, -24.0F, 20.0F, 2.0F, 3.0F, 12.0F), PartPose.offset(0.0F, 0.0F, 0.0F)
      );
      root.addOrReplaceChild(
         "part_40", CubeListBuilder.create().texOffs(490, 173).addBox(12.0F, -39.0F, 20.0F, 2.0F, 3.0F, 12.0F), PartPose.offset(0.0F, 0.0F, 0.0F)
      );
      root.addOrReplaceChild(
         "part_41", CubeListBuilder.create().texOffs(520, 173).addBox(12.0F, -39.0F, 2.0F, 2.0F, 27.0F, 14.0F), PartPose.offset(0.0F, 0.0F, 0.0F)
      );
      root.addOrReplaceChild(
         "part_42", CubeListBuilder.create().texOffs(554, 173).addBox(11.9F, -35.0F, 4.0F, 2.2F, 10.0F, 10.0F), PartPose.offset(0.0F, 0.0F, 0.0F)
      );
      root.addOrReplaceChild(
         "part_43", CubeListBuilder.create().texOffs(581, 173).addBox(11.85F, -38.0F, 8.5F, 2.3F, 25.0F, 1.0F), PartPose.offset(0.0F, 0.0F, 0.0F)
      );
      root.addOrReplaceChild(
         "part_44", CubeListBuilder.create().texOffs(590, 173).addBox(11.0F, -11.0F, 1.0F, 4.0F, 2.0F, 16.0F), PartPose.offset(0.0F, 0.0F, 0.0F)
      );
      root.addOrReplaceChild(
         "part_45", CubeListBuilder.create().texOffs(632, 173).addBox(-13.0F, -23.0F, -42.0F, 26.0F, 11.0F, 3.0F), PartPose.offset(0.0F, 0.0F, 0.0F)
      );
      root.addOrReplaceChild(
         "part_46", CubeListBuilder.create().texOffs(692, 173).addBox(-11.0F, -37.0F, -41.4F, 22.0F, 13.0F, 1.8F), PartPose.offset(0.0F, 0.0F, 0.0F)
      );
      root.addOrReplaceChild(
         "part_47", CubeListBuilder.create().texOffs(742, 173).addBox(-13.0F, -40.0F, -42.0F, 26.0F, 3.0F, 3.0F), PartPose.offset(0.0F, 0.0F, 0.0F)
      );
      root.addOrReplaceChild(
         "part_48", CubeListBuilder.create().texOffs(802, 173).addBox(-14.0F, -37.0F, -42.0F, 3.0F, 14.0F, 3.0F), PartPose.offset(0.0F, 0.0F, 0.0F)
      );
      root.addOrReplaceChild(
         "part_49", CubeListBuilder.create().texOffs(816, 173).addBox(11.0F, -37.0F, -42.0F, 3.0F, 14.0F, 3.0F), PartPose.offset(0.0F, 0.0F, 0.0F)
      );
      root.addOrReplaceChild(
         "part_50", CubeListBuilder.create().texOffs(830, 173).addBox(-0.5F, -37.0F, -42.1F, 1.0F, 13.0F, 3.2F), PartPose.offset(0.0F, 0.0F, 0.0F)
      );
      root.addOrReplaceChild(
         "part_51", CubeListBuilder.create().texOffs(841, 173).addBox(-13.0F, -22.0F, -42.15F, 26.0F, 3.0F, 3.3F), PartPose.offset(0.0F, 0.0F, 0.0F)
      );
      root.addOrReplaceChild(
         "part_52", CubeListBuilder.create().texOffs(902, 173).addBox(-10.0F, -17.0F, -42.2F, 4.0F, 3.0F, 3.4F), PartPose.offset(0.0F, 0.0F, 0.0F)
      );
      root.addOrReplaceChild(
         "part_53", CubeListBuilder.create().texOffs(919, 173).addBox(6.0F, -17.0F, -42.2F, 4.0F, 3.0F, 3.4F), PartPose.offset(0.0F, 0.0F, 0.0F)
      );
      root.addOrReplaceChild(
         "part_54", CubeListBuilder.create().texOffs(936, 173).addBox(-3.0F, -8.0F, -44.0F, 6.0F, 2.0F, 7.0F), PartPose.offset(0.0F, 0.0F, 0.0F)
      );
      root.addOrReplaceChild(
         "part_55", CubeListBuilder.create().texOffs(964, 173).addBox(-13.0F, -23.0F, 39.0F, 26.0F, 11.0F, 3.0F), PartPose.offset(0.0F, 0.0F, 0.0F)
      );
      root.addOrReplaceChild(
         "part_56", CubeListBuilder.create().texOffs(0, 257).addBox(-11.0F, -37.0F, 39.6F, 22.0F, 13.0F, 1.8F), PartPose.offset(0.0F, 0.0F, 0.0F)
      );
      root.addOrReplaceChild(
         "part_57", CubeListBuilder.create().texOffs(50, 257).addBox(-13.0F, -40.0F, 39.0F, 26.0F, 3.0F, 3.0F), PartPose.offset(0.0F, 0.0F, 0.0F)
      );
      root.addOrReplaceChild(
         "part_58", CubeListBuilder.create().texOffs(110, 257).addBox(-14.0F, -37.0F, 39.0F, 3.0F, 14.0F, 3.0F), PartPose.offset(0.0F, 0.0F, 0.0F)
      );
      root.addOrReplaceChild(
         "part_59", CubeListBuilder.create().texOffs(124, 257).addBox(11.0F, -37.0F, 39.0F, 3.0F, 14.0F, 3.0F), PartPose.offset(0.0F, 0.0F, 0.0F)
      );
      root.addOrReplaceChild(
         "part_60", CubeListBuilder.create().texOffs(138, 257).addBox(-0.5F, -37.0F, 38.9F, 1.0F, 13.0F, 3.2F), PartPose.offset(0.0F, 0.0F, 0.0F)
      );
      root.addOrReplaceChild(
         "part_61", CubeListBuilder.create().texOffs(149, 257).addBox(-13.0F, -22.0F, 38.85F, 26.0F, 3.0F, 3.3F), PartPose.offset(0.0F, 0.0F, 0.0F)
      );
      root.addOrReplaceChild(
         "part_62", CubeListBuilder.create().texOffs(210, 257).addBox(-10.0F, -17.0F, 38.8F, 4.0F, 3.0F, 3.4F), PartPose.offset(0.0F, 0.0F, 0.0F)
      );
      root.addOrReplaceChild(
         "part_63", CubeListBuilder.create().texOffs(227, 257).addBox(6.0F, -17.0F, 38.8F, 4.0F, 3.0F, 3.4F), PartPose.offset(0.0F, 0.0F, 0.0F)
      );
      root.addOrReplaceChild(
         "part_64", CubeListBuilder.create().texOffs(244, 257).addBox(-3.0F, -8.0F, 37.0F, 6.0F, 2.0F, 7.0F), PartPose.offset(0.0F, 0.0F, 0.0F)
      );
      root.addOrReplaceChild(
         "part_65", CubeListBuilder.create().texOffs(272, 257).addBox(-3.0F, -16.0F, -26.0F, 6.0F, 4.0F, 4.0F), PartPose.offset(0.0F, 0.0F, 0.0F)
      );
      root.addOrReplaceChild(
         "part_66", CubeListBuilder.create().texOffs(294, 257).addBox(-5.0F, -19.0F, -28.0F, 10.0F, 3.0F, 8.0F), PartPose.offset(0.0F, 0.0F, 0.0F)
      );
      root.addOrReplaceChild(
         "part_67", CubeListBuilder.create().texOffs(332, 257).addBox(-5.0F, -31.0F, -22.0F, 10.0F, 12.0F, 2.0F), PartPose.offset(0.0F, 0.0F, 0.0F)
      );
      root.addOrReplaceChild(
         "part_68", CubeListBuilder.create().texOffs(358, 257).addBox(-6.0F, -22.0F, -27.0F, 1.0F, 2.0F, 6.0F), PartPose.offset(0.0F, 0.0F, 0.0F)
      );
      root.addOrReplaceChild(
         "part_69", CubeListBuilder.create().texOffs(374, 257).addBox(5.0F, -22.0F, -27.0F, 1.0F, 2.0F, 6.0F), PartPose.offset(0.0F, 0.0F, 0.0F)
      );
      root.addOrReplaceChild(
         "part_70", CubeListBuilder.create().texOffs(390, 257).addBox(-11.0F, -23.0F, -37.0F, 22.0F, 6.0F, 5.0F), PartPose.offset(0.0F, 0.0F, 0.0F)
      );
      root.addOrReplaceChild(
         "part_71", CubeListBuilder.create().texOffs(446, 257).addBox(-6.0F, -24.0F, -36.0F, 8.0F, 1.0F, 3.0F), PartPose.offset(0.0F, 0.0F, 0.0F)
      );
      root.addOrReplaceChild(
         "part_72", CubeListBuilder.create().texOffs(470, 257).addBox(-11.0F, -7.0F, -35.0F, 22.0F, 4.0F, 16.0F), PartPose.offset(0.0F, 0.0F, 0.0F)
      );
      root.addOrReplaceChild(
         "part_73", CubeListBuilder.create().texOffs(548, 257).addBox(-12.0F, -5.0F, -33.0F, 24.0F, 2.0F, 2.0F), PartPose.offset(0.0F, 0.0F, 0.0F)
      );
      root.addOrReplaceChild(
         "part_74", CubeListBuilder.create().texOffs(602, 257).addBox(-2.0F, -4.0F, -3.0F, 4.0F, 8.0F, 6.0F), PartPose.offset(-11.0F, -4.0F, -32.0F)
      );
      root.addOrReplaceChild(
         "part_75", CubeListBuilder.create().texOffs(624, 257).addBox(-2.0F, -4.0F, -3.0F, 4.0F, 8.0F, 6.0F), PartPose.offset(11.0F, -4.0F, -32.0F)
      );
      root.addOrReplaceChild(
         "part_76", CubeListBuilder.create().texOffs(646, 257).addBox(-12.0F, -5.0F, -23.0F, 24.0F, 2.0F, 2.0F), PartPose.offset(0.0F, 0.0F, 0.0F)
      );
      root.addOrReplaceChild(
         "part_77", CubeListBuilder.create().texOffs(700, 257).addBox(-2.0F, -4.0F, -3.0F, 4.0F, 8.0F, 6.0F), PartPose.offset(-11.0F, -4.0F, -22.0F)
      );
      root.addOrReplaceChild(
         "part_78", CubeListBuilder.create().texOffs(722, 257).addBox(-2.0F, -4.0F, -3.0F, 4.0F, 8.0F, 6.0F), PartPose.offset(11.0F, -4.0F, -22.0F)
      );
      root.addOrReplaceChild(
         "part_79", CubeListBuilder.create().texOffs(744, 257).addBox(-11.0F, -7.0F, 19.0F, 22.0F, 4.0F, 16.0F), PartPose.offset(0.0F, 0.0F, 0.0F)
      );
      root.addOrReplaceChild(
         "part_80", CubeListBuilder.create().texOffs(822, 257).addBox(-12.0F, -5.0F, 21.0F, 24.0F, 2.0F, 2.0F), PartPose.offset(0.0F, 0.0F, 0.0F)
      );
      root.addOrReplaceChild(
         "part_81", CubeListBuilder.create().texOffs(876, 257).addBox(-2.0F, -4.0F, -3.0F, 4.0F, 8.0F, 6.0F), PartPose.offset(-11.0F, -4.0F, 22.0F)
      );
      root.addOrReplaceChild(
         "part_82", CubeListBuilder.create().texOffs(898, 257).addBox(-2.0F, -4.0F, -3.0F, 4.0F, 8.0F, 6.0F), PartPose.offset(11.0F, -4.0F, 22.0F)
      );
      root.addOrReplaceChild(
         "part_83", CubeListBuilder.create().texOffs(920, 257).addBox(-12.0F, -5.0F, 31.0F, 24.0F, 2.0F, 2.0F), PartPose.offset(0.0F, 0.0F, 0.0F)
      );
      root.addOrReplaceChild(
         "part_84", CubeListBuilder.create().texOffs(974, 257).addBox(-2.0F, -4.0F, -3.0F, 4.0F, 8.0F, 6.0F), PartPose.offset(-11.0F, -4.0F, 32.0F)
      );
      root.addOrReplaceChild(
         "part_85", CubeListBuilder.create().texOffs(996, 257).addBox(-2.0F, -4.0F, -3.0F, 4.0F, 8.0F, 6.0F), PartPose.offset(11.0F, -4.0F, 32.0F)
      );
      return LayerDefinition.create(mesh, 1024, 1024);
   }

   public static int[] wheels(String kind) {
      return switch (kind) {
         case "rover" -> new int[]{44, 45, 46, 48, 49, 50, 53, 54, 55, 57, 58, 59, 62, 63, 64, 66, 67, 68};
         case "truck" -> new int[]{55, 56, 57, 58, 59, 60, 62, 63, 64, 65, 66, 67};
         case "tram" -> new int[]{74, 75, 77, 78, 81, 82, 84, 85};
         default -> new int[0];
      };
   }
}
