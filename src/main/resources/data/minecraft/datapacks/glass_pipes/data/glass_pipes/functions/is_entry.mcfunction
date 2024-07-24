scoreboard players set Global start_xy 1
scoreboard players set Global start_xz 1
scoreboard players set Global start_yz 1
execute unless block ~-1 ~-2 ~ minecraft:glass run scoreboard players set Global start_xy 0
execute unless block ~-2 ~-1 ~ minecraft:glass run scoreboard players set Global start_xy 0
execute unless block ~-1 ~ ~-2 minecraft:glass run scoreboard players set Global start_xz 0
execute unless block ~-2 ~ ~-1 minecraft:glass run scoreboard players set Global start_xz 0
execute unless block ~ ~-2 ~-1 minecraft:glass run scoreboard players set Global start_yz 0
execute unless block ~ ~-1 ~-2 minecraft:glass run scoreboard players set Global start_yz 0
execute unless block ~-1 ~2 ~ minecraft:glass run scoreboard players set Global start_xy 0
execute unless block ~2 ~-1 ~ minecraft:glass run scoreboard players set Global start_xy 0
execute unless block ~-1 ~ ~2 minecraft:glass run scoreboard players set Global start_xz 0
execute unless block ~2 ~ ~-1 minecraft:glass run scoreboard players set Global start_xz 0
execute unless block ~ ~2 ~-1 minecraft:glass run scoreboard players set Global start_yz 0
execute unless block ~ ~-1 ~2 minecraft:glass run scoreboard players set Global start_yz 0
execute unless block ~-1 ~-1 ~ minecraft:air run scoreboard players set Global start_xy 0
execute unless block ~-1 ~ ~-1 minecraft:air run scoreboard players set Global start_xz 0
execute unless block ~ ~-1 ~-1 minecraft:air run scoreboard players set Global start_yz 0
execute unless block ~-1 ~0 ~ minecraft:air run scoreboard players set Global start_xy 0
execute unless block ~-1 ~ ~0 minecraft:air run scoreboard players set Global start_xz 0
execute unless block ~ ~-1 ~0 minecraft:air run scoreboard players set Global start_yz 0
execute unless block ~-1 ~1 ~ minecraft:air run scoreboard players set Global start_xy 0
execute unless block ~-1 ~ ~1 minecraft:air run scoreboard players set Global start_xz 0
execute unless block ~ ~-1 ~1 minecraft:air run scoreboard players set Global start_yz 0
execute unless block ~0 ~-2 ~ minecraft:glass run scoreboard players set Global start_xy 0
execute unless block ~-2 ~0 ~ minecraft:glass run scoreboard players set Global start_xy 0
execute unless block ~0 ~ ~-2 minecraft:glass run scoreboard players set Global start_xz 0
execute unless block ~-2 ~ ~0 minecraft:glass run scoreboard players set Global start_xz 0
execute unless block ~ ~-2 ~0 minecraft:glass run scoreboard players set Global start_yz 0
execute unless block ~ ~0 ~-2 minecraft:glass run scoreboard players set Global start_yz 0
execute unless block ~0 ~2 ~ minecraft:glass run scoreboard players set Global start_xy 0
execute unless block ~2 ~0 ~ minecraft:glass run scoreboard players set Global start_xy 0
execute unless block ~0 ~ ~2 minecraft:glass run scoreboard players set Global start_xz 0
execute unless block ~2 ~ ~0 minecraft:glass run scoreboard players set Global start_xz 0
execute unless block ~ ~2 ~0 minecraft:glass run scoreboard players set Global start_yz 0
execute unless block ~ ~0 ~2 minecraft:glass run scoreboard players set Global start_yz 0
execute unless block ~0 ~-1 ~ minecraft:air run scoreboard players set Global start_xy 0
execute unless block ~0 ~ ~-1 minecraft:air run scoreboard players set Global start_xz 0
execute unless block ~ ~0 ~-1 minecraft:air run scoreboard players set Global start_yz 0
execute unless block ~0 ~0 ~ minecraft:air run scoreboard players set Global start_xy 0
execute unless block ~0 ~ ~0 minecraft:air run scoreboard players set Global start_xz 0
execute unless block ~ ~0 ~0 minecraft:air run scoreboard players set Global start_yz 0
execute unless block ~0 ~1 ~ minecraft:air run scoreboard players set Global start_xy 0
execute unless block ~0 ~ ~1 minecraft:air run scoreboard players set Global start_xz 0
execute unless block ~ ~0 ~1 minecraft:air run scoreboard players set Global start_yz 0
execute unless block ~1 ~-2 ~ minecraft:glass run scoreboard players set Global start_xy 0
execute unless block ~-2 ~1 ~ minecraft:glass run scoreboard players set Global start_xy 0
execute unless block ~1 ~ ~-2 minecraft:glass run scoreboard players set Global start_xz 0
execute unless block ~-2 ~ ~1 minecraft:glass run scoreboard players set Global start_xz 0
execute unless block ~ ~-2 ~1 minecraft:glass run scoreboard players set Global start_yz 0
execute unless block ~ ~1 ~-2 minecraft:glass run scoreboard players set Global start_yz 0
execute unless block ~1 ~2 ~ minecraft:glass run scoreboard players set Global start_xy 0
execute unless block ~2 ~1 ~ minecraft:glass run scoreboard players set Global start_xy 0
execute unless block ~1 ~ ~2 minecraft:glass run scoreboard players set Global start_xz 0
execute unless block ~2 ~ ~1 minecraft:glass run scoreboard players set Global start_xz 0
execute unless block ~ ~2 ~1 minecraft:glass run scoreboard players set Global start_yz 0
execute unless block ~ ~1 ~2 minecraft:glass run scoreboard players set Global start_yz 0
execute unless block ~1 ~-1 ~ minecraft:air run scoreboard players set Global start_xy 0
execute unless block ~1 ~ ~-1 minecraft:air run scoreboard players set Global start_xz 0
execute unless block ~ ~1 ~-1 minecraft:air run scoreboard players set Global start_yz 0
execute unless block ~1 ~0 ~ minecraft:air run scoreboard players set Global start_xy 0
execute unless block ~1 ~ ~0 minecraft:air run scoreboard players set Global start_xz 0
execute unless block ~ ~1 ~0 minecraft:air run scoreboard players set Global start_yz 0
execute unless block ~1 ~1 ~ minecraft:air run scoreboard players set Global start_xy 0
execute unless block ~1 ~ ~1 minecraft:air run scoreboard players set Global start_xz 0
execute unless block ~ ~1 ~1 minecraft:air run scoreboard players set Global start_yz 0
execute store result score Global is_2_scratch1 run scoreboard players get Global start_xy
scoreboard players operation Global is_2_scratch1 += Global start_xz
scoreboard players operation Global is_2_scratch1 += Global start_yz
scoreboard players set Global is_2_scratch0 1
execute if score Global is_2_scratch1 matches 1.. run function glass_pipes:execute054_ln146
execute if score Global is_2_scratch0 matches 1.. run scoreboard players set Global ReturnValue 0