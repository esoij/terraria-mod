scoreboard players set Global options 0
execute positioned ~1 ~0 ~0 run function glass_pipes:execute007_ln21
execute positioned ~-1 ~0 ~0 run function glass_pipes:execute009_ln21
execute positioned ~0 ~1 ~0 run function glass_pipes:execute011_ln21
execute positioned ~0 ~-1 ~0 run function glass_pipes:execute013_ln21
execute positioned ~0 ~0 ~1 run function glass_pipes:execute015_ln21
execute positioned ~0 ~0 ~-1 run function glass_pipes:execute017_ln21
scoreboard players set Global pic_scratch0 1
execute if score Global options matches 1.. run function glass_pipes:execute043_ln31
execute if score Global pic_scratch0 matches 1.. run scoreboard players set @s done 1