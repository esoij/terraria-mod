scoreboard players set Global pic_scratch3 0
scoreboard players operation Global pic_scratch3 += @e[type=minecraft:armor_stand,limit=1,sort=random,scores={RVglass_pipes=..1}] RVglass_pipes
scoreboard players operation Global pic_scratch3 *= c3 Constant
scoreboard players operation Global pic_scratch3 += @e[type=minecraft:armor_stand,limit=1,sort=random,scores={RVglass_pipes=..2}] RVglass_pipes
execute store result score Global r run scoreboard players get Global pic_scratch3