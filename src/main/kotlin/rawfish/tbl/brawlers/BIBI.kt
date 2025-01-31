package rawfish.tbl.brawlers

import rawfish.tbl.*

class BIBI : Brawler() {
    override fun brawlerWeapon(language: Language): String = when (language) {
        Language.SimplifiedChinese -> "棒球棒"
        Language.Russian -> "битой"
        else -> "Baseball bat"
    }

    override val brawlerName: String = "TID_BASEBALL"
    override val brawlerInfo = BrawlerInfo(
        brawlerDescription = "TID_BASEBALL_DESC",
        heroes = listOf(
            HeroInfo(
                traits = listOf(),
                attack = AttackInfo(
                    name = "TID_BASEBALL_WEAPON",
                    description = "TID_BASEBALL_WEAPON_DESC",
                    descriptionReplaces = mapOf(),
                    stats = listOf(
                        singleAttackDamageStatInfo()
                    )
                ),
                `super` = SuperInfo(
                    name = "TID_BASEBALL_ULTI",
                    description = "TID_BASEBALL_ULTI_DESC",
                    descriptionReplaces = mapOf(),
                    stats = listOf(
                        singleAttackDamageStatInfo()
                    )
                ),
                hyperCharge = HyperChargeInfo(
                    name = "TID_BASEBALL_OVERCHARGE",
                    description = "TID_BASEBALL_OVERCHARGE_DESC",
                    descriptionReplaces = mapOf(),
                    stats = defaultHyperChargeStatInfos()
                )
            )
        ),
        gadgets = listOf(
            GadgetInfo(
                name = "TID_ACCESSORY_BASEBALL_HEAL",
                description = "TID_ACCESSORY_BASEBALL_HEAL_DESC",
                descriptionReplaces = mapOf(
                    replaceValue(0),
                    replaceValue(1)
                )
            ),
            GadgetInfo(
                name = "TID_ACCESSORY_BASEBALL_STICKY",
                description = "TID_ACCESSORY_BASEBALL_STICKY_DESC",
                descriptionReplaces = mapOf(
                    replaceValue(0)
                )
            )
        ),
        starPowers = listOf(
            StarPowerInfo(
                name = "TID_SPEC_ABI_SPED_FULL_AMMO",
                description = "TID_SPEC_ABI_SPED_FULL_AMMO_DESC",
                descriptionReplaces = mapOf(
                    replaceValue(0)
                )
            ),
            StarPowerInfo(
                name = "TID_SPEC_ABI_SHIELD_HOMERUN",
                description = "TID_SPEC_ABI_SHIELD_HOMERUN_DESC",
                descriptionReplaces = mapOf(
                    replaceValue(0)
                )
            )
        )
    )
}