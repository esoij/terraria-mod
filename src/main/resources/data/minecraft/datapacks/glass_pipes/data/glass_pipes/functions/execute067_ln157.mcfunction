execute unless entity @e[type=minecraft:area_effect_cloud,tag=Position,limit=1] run summon minecraft:area_effect_cloud ~ ~ ~ {"Tags":["Position"],"Duration":-1,"Age":-2147483648,"WaitTime":-2147483648}
tp @e[type=minecraft:area_effect_cloud,tag=Position,limit=1] ~ ~ ~ ~ ~
execute store result score Global mai_scratch2 run scoreboard players get @s _moving_0
execute store result score Global mai_scratch3 run scoreboard players get @s _moving_1
execute store result score Global mai_scratch4 run scoreboard players get @s _moving_2
scoreboard players operation Global mai_scratch2 *= c750 Constant
scoreboard players operation Global mai_scratch3 *= c750 Constant
scoreboard players operation Global mai_scratch4 *= c750 Constant
execute store result score @e[type=minecraft:area_effect_cloud,tag=Position,limit=1] _pos_0 run data get entity @e[type=minecraft:area_effect_cloud,tag=Position,limit=1] Pos[0] 1000
execute store result score @e[type=minecraft:area_effect_cloud,tag=Position,limit=1] _pos_1 run data get entity @e[type=minecraft:area_effect_cloud,tag=Position,limit=1] Pos[1] 1000
execute store result score @e[type=minecraft:area_effect_cloud,tag=Position,limit=1] _pos_2 run data get entity @e[type=minecraft:area_effect_cloud,tag=Position,limit=1] Pos[2] 1000
scoreboard players operation @e[type=minecraft:area_effect_cloud,tag=Position,limit=1] _pos_0 += Global mai_scratch2
scoreboard players operation @e[type=minecraft:area_effect_cloud,tag=Position,limit=1] _pos_1 += Global mai_scratch3
scoreboard players operation @e[type=minecraft:area_effect_cloud,tag=Position,limit=1] _pos_2 += Global mai_scratch4
execute store result entity @e[type=minecraft:area_effect_cloud,tag=Position,limit=1] Pos[0] double 0.001 run scoreboard players get @e[type=minecraft:area_effect_cloud,tag=Position,limit=1] _pos_0
execute store result entity @e[type=minecraft:area_effect_cloud,tag=Position,limit=1] Pos[1] double 0.001 run scoreboard players get @e[type=minecraft:area_effect_cloud,tag=Position,limit=1] _pos_1
execute store result entity @e[type=minecraft:area_effect_cloud,tag=Position,limit=1] Pos[2] double 0.001 run scoreboard players get @e[type=minecraft:area_effect_cloud,tag=Position,limit=1] _pos_2
scoreboard players set Global mai_scratch2 1
execute at @e[type=minecraft:area_effect_cloud,tag=Position,limit=1] if block ~ ~ ~ minecraft:air run function glass_pipes:execute064_ln162
execute if score Global mai_scratch2 matches 1.. run function glass_pipes:else066_ln162