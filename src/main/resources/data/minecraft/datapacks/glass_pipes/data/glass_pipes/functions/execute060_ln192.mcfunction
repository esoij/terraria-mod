execute store result score @s _pos_0 run data get entity @s Pos[0] 1000
execute store result score @s _pos_1 run data get entity @s Pos[1] 1000
execute store result score @s _pos_2 run data get entity @s Pos[2] 1000
execute store result score Global mai_scratch4 run scoreboard players get @s _pos_0
execute store result score Global mai_scratch5 run scoreboard players get @s _pos_1
execute store result score Global mai_scratch6 run scoreboard players get @s _pos_2
scoreboard players operation Global mai_scratch4 /= c1000 Constant
scoreboard players operation Global mai_scratch5 /= c1000 Constant
scoreboard players operation Global mai_scratch6 /= c1000 Constant
scoreboard players operation Global mai_scratch4 *= c1000 Constant
scoreboard players operation Global mai_scratch5 *= c1000 Constant
scoreboard players operation Global mai_scratch6 *= c1000 Constant
scoreboard players operation Global mai_scratch4 += c500 Constant
scoreboard players operation Global mai_scratch5 += c0 Constant
scoreboard players operation Global mai_scratch6 += c500 Constant
execute store result score @s _pos_0 run scoreboard players get Global mai_scratch4
execute store result score @s _pos_1 run scoreboard players get Global mai_scratch5
execute store result score @s _pos_2 run scoreboard players get Global mai_scratch6
execute store result entity @s Pos[0] double 0.001 run scoreboard players get @s _pos_0
execute store result entity @s Pos[1] double 0.001 run scoreboard players get @s _pos_1
execute store result entity @s Pos[2] double 0.001 run scoreboard players get @s _pos_2
tp @e[type=minecraft:player,limit=1,scores={mai_scratch0=1..}] ~ 128 ~
execute at @s run tp @e[type=minecraft:player,limit=1,scores={mai_scratch0=1..}] ~ ~ ~
kill @s
scoreboard players set @e[type=minecraft:player,limit=1,scores={mai_scratch0=1..}] travel 0
scoreboard players set @e[type=minecraft:player,limit=1,scores={mai_scratch0=1..}] force_exit 1
scoreboard players set @e[type=minecraft:player,limit=1,scores={mai_scratch0=1..}] pipe_sound 15