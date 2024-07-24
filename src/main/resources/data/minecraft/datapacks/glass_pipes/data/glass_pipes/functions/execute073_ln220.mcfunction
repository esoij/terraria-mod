function glass_pipes:is_entry
scoreboard players set Global mai_scratch2 1
execute if score Global ReturnValue matches 1.. run function glass_pipes:execute072_ln221
execute if score Global mai_scratch2 matches 1.. run scoreboard players set @s force_exit 0