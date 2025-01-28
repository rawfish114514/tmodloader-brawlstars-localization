package rawfish.tbl.brawlers

import rawfish.tbl.*

class MEG : Brawler() {
    override fun brawlerWeapon(language: Language): String = when (language) {
        Language.SimplifiedChinese -> "爆能手枪"
        Language.Russian -> "бластера "
        else -> "Blaster That Pokes"
    }

    override val brawlerName: String = "TID_MECHA_DUDE"
    override val brawlerInfo = BrawlerInfo(
        brawlerDescription = "TID_MECHA_DUDE_DESC",
        heroes = listOf(
            HeroInfo(
                traits = listOf(),
                attack = AttackInfo(
                    name = "TID_MECHA_DUDE_WEAPON",
                    description = "TID_MECHA_DUDE_WEAPON_DESC",
                    descriptionReplaces = mapOf(),
                    stats = listOf(
                        multiplierAttackDamageStatInfo()
                    )
                ),
                `super` = SuperInfo(
                    name = "TID_MECHA_DUDE_ULTI",
                    description = "TID_MECHA_DUDE_ULTI_DESC",
                    descriptionReplaces = mapOf(),
                    stats = listOf(
                        StatInfo(
                            key = "TID_HERO_INFO_CHANGE_CHARACTER_DURATION",
                            value = "EXT_TIME",
                            valueReplaces = mapOf()
                        )
                    )
                ),
                hyperCharge = HyperChargeInfo(
                    name = "",
                    description = "",
                    descriptionReplaces = mapOf(),
                    stats = defaultHyperChargeStatInfos()
                )
            ),
            HeroInfo(
                traits = listOf(),
                attack = AttackInfo(
                    name = "TID_MECHA_DUDE_BIG_WEAPON",
                    description = "TID_MECHA_DUDE_BIG_WEAPON_DESC",
                    descriptionReplaces = mapOf(),
                    stats = listOf(
                        multiplierAttackDamageStatInfo()
                    )
                ),
                `super` = SuperInfo(
                    name = "TID_MECHA_DUDE_BIG_ULTI",
                    description = "TID_MECHA_DUDE_BIG_ULTI_DESC",
                    descriptionReplaces = mapOf(),
                    stats = listOf(
                        singleAttackDamageStatInfo()
                    )
                ),
                hyperCharge = HyperChargeInfo(
                    name = "",
                    description = "",
                    descriptionReplaces = mapOf(),
                    stats = defaultHyperChargeStatInfos()
                )
            )
        ),
        gadgets = listOf(
            GadgetInfo(
                name = "TID_ACCESSORY_MECHA_DUDE_HEAL",
                description = "TID_ACCESSORY_MECHA_DUDE_HEAL_DESC",
                descriptionReplaces = mapOf(
                    replaceValue(0),
                    replaceValue(1)
                )
            ),
            GadgetInfo(
                name = "TID_ACCESSORY_MECHA_DUDE_TOWER_RELOAD",
                description = "TID_ACCESSORY_MECHA_DUDE_TOWER_RELOAD_DESC",
                descriptionReplaces = mapOf(
                    replacePreCentValue(0)
                )
            )
        ),
        starPowers = listOf(
            StarPowerInfo(
                name = "TID_SPEC_ABI_MECHA_DUDE_1",
                description = "TID_SPEC_ABI_MECHA_DUDE_1_DESC",
                descriptionReplaces = mapOf(
                    replacePreCentValue(0),
                    replaceValue(0)
                )
            ),
            StarPowerInfo(
                name = "TID_SPEC_ABI_MECHA_DUDE_2",
                description = "TID_SPEC_ABI_MECHA_DUDE_2_DESC",
                descriptionReplaces = mapOf(
                    replaceValue(0)
                )
            )
        )
    )

}