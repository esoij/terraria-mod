scoreboard objectives add first dummy
scoreboard objectives add dirs4 dummy
scoreboard objectives add dirs5 dummy
scoreboard objectives add dirs2 dummy
scoreboard objectives add _pos1_0 dummy
scoreboard objectives add dirs0 dummy
scoreboard objectives add dirs1 dummy
scoreboard objectives add _was_moving_0 dummy
scoreboard objectives add done dummy
scoreboard objectives add _was_moving_2 dummy
scoreboard objectives add r dummy
scoreboard objectives add options dummy
scoreboard objectives add _id dummy
scoreboard objectives add my dummy
scoreboard objectives add glass dummy
scoreboard objectives add _unique dummy
scoreboard objectives add _pos1_1 dummy
scoreboard objectives add start_xy dummy
scoreboard objectives add start_xz dummy
scoreboard objectives add dirs3 dummy
scoreboard objectives add initialize dummy
scoreboard objectives add x dummy
scoreboard objectives add glass_x dummy
scoreboard objectives add glass_z dummy
scoreboard objectives add _pos1_2 dummy
scoreboard objectives add searching dummy
scoreboard objectives add _moving_2 dummy
scoreboard objectives add pipe_sound dummy
scoreboard objectives add _moving_0 dummy
scoreboard objectives add _moving_1 dummy
scoreboard objectives add exit_junction dummy
scoreboard objectives add y dummy
scoreboard objectives add _was_moving_1 dummy
scoreboard objectives add mx dummy
scoreboard objectives add ReturnValue dummy
scoreboard objectives add facing_dir dummy
scoreboard objectives add ry dummy
scoreboard objectives add rx dummy
scoreboard objectives add z dummy
scoreboard objectives add travel dummy
scoreboard objectives add _aim_2 dummy
scoreboard objectives add dirsVal dummy
scoreboard objectives add _aim_0 dummy
scoreboard objectives add _aim_1 dummy
scoreboard objectives add start_yz dummy
scoreboard objectives add mz dummy
scoreboard objectives add _age dummy
scoreboard objectives add _pos_2 dummy
scoreboard objectives add _pos_1 dummy
scoreboard objectives add _pos_0 dummy
scoreboard objectives add glass_y dummy
scoreboard objectives add force_exit dummy
kill @e[type=minecraft:armor_stand,name=RVglass_pipes,scores={RVglass_pipes=0..}]
scoreboard objectives add RVglass_pipes dummy
summon minecraft:armor_stand ~ ~ ~ {CustomName:"\"RVglass_pipes\"", "Invulnerable":1b, "Invisible":1b, "Marker":1b, "NoGravity":1b}
scoreboard players add @e[type=minecraft:armor_stand,name=RVglass_pipes] RVglass_pipes 1
summon minecraft:armor_stand ~ ~ ~ {CustomName:"\"RVglass_pipes\"", "Invulnerable":1b, "Invisible":1b, "Marker":1b, "NoGravity":1b}
scoreboard players add @e[type=minecraft:armor_stand,name=RVglass_pipes] RVglass_pipes 1
summon minecraft:armor_stand ~ ~ ~ {CustomName:"\"RVglass_pipes\"", "Invulnerable":1b, "Invisible":1b, "Marker":1b, "NoGravity":1b}
scoreboard players add @e[type=minecraft:armor_stand,name=RVglass_pipes] RVglass_pipes 1
scoreboard players remove @e[type=minecraft:armor_stand,name=RVglass_pipes] RVglass_pipes 1
scoreboard objectives add Constant dummy
scoreboard players set c0 Constant 0
scoreboard players set c1000 Constant 1000
scoreboard players set c500 Constant 500
scoreboard players set c250 Constant 250
scoreboard players set c750 Constant 750
scoreboard players set c360000 Constant 360000
scoreboard players set c3 Constant 3
scoreboard players set minus Constant -1
scoreboard objectives add get2_scratch0 dummy
scoreboard objectives add mai_scratch6 dummy
scoreboard objectives add mai_scratch5 dummy
scoreboard objectives add mai_scratch4 dummy
scoreboard objectives add mai_scratch3 dummy
scoreboard objectives add mai_scratch2 dummy
scoreboard objectives add mai_scratch1 dummy
scoreboard objectives add mai_scratch0 dummy
scoreboard objectives add pic_scratch4 dummy
scoreboard objectives add pic_scratch3 dummy
scoreboard objectives add pic_scratch2 dummy
scoreboard objectives add pic_scratch1 dummy
scoreboard objectives add pic_scratch0 dummy
scoreboard objectives add get_scratch2 dummy
scoreboard objectives add get_scratch1 dummy
scoreboard objectives add get_scratch0 dummy
scoreboard objectives add is__scratch0 dummy
scoreboard objectives add is_2_scratch1 dummy
scoreboard objectives add is_2_scratch0 dummy
scoreboard objectives add pipe_slow minecraft.custom:minecraft.sneak_time