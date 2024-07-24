scoreboard players set Global mai_scratch3 1
execute if score @e[type=minecraft:player,limit=1,scores={mai_scratch0=1..}] pipe_slow matches 1.. run function glass_pipes:execute055_ln163
execute if score Global mai_scratch3 matches 1.. run function glass_pipes:else056_ln163
execute store result score Global mx run scoreboard players get @s _moving_0
execute store result score Global my run scoreboard players get @s _moving_1
execute store result score Global mz run scoreboard players get @s _moving_2
execute if score Global mx matches 0..0 run function glass_pipes:execute057_ln169
execute if score Global my matches 0..0 run function glass_pipes:execute058_ln172
execute if score Global mz matches 0..0 run function glass_pipes:execute059_ln175
execute store result entity @s Rotation[0] float 0.001 run data get entity @e[type=minecraft:player,limit=1,scores={mai_scratch0=1..}] Rotation[0] 1000
execute store result entity @s Rotation[1] float 0.001 run data get entity @e[type=minecraft:player,limit=1,scores={mai_scratch0=1..}] Rotation[1] 1000
tp @e[type=minecraft:player,limit=1,scores={mai_scratch0=1..}] ~ 128 ~
execute at @s run tp @e[type=minecraft:player,limit=1,scores={mai_scratch0=1..}] ~ ~ ~
execute at @s run function glass_pipes:execute063_ln187
scoreboard players set Global mai_scratch2 0