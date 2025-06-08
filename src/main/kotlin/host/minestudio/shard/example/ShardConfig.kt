package host.minestudio.shard.example

import host.minestudio.frost.api.config.ConfigSchema
import host.minestudio.frost.api.config.ConfigSection
import host.minestudio.frost.api.config.InputConfig
import host.minestudio.frost.api.config.InputSuffix
import host.minestudio.frost.api.config.InputType
import host.minestudio.frost.api.config.SelectConfig
import host.minestudio.frost.api.config.SelectOption
import host.minestudio.frost.api.config.SettingGroup
import host.minestudio.frost.api.config.SliderConfig
import host.minestudio.frost.api.config.SwitchConfig

class ShardConfig {

    lateinit var config: ConfigSchema

    fun genConfig(): ConfigSchema {
        return ConfigSchema(
            title = "Example Config",
            description = "An example configuration for the example shard",
            sections = listOf(
                ConfigSection(
                    id = "general",
                    title = "General Settings",
                    icon = "👍",
                    groups = listOf(
                        SettingGroup(
                            id = "general",
                            title = "General",
                            description = "General settings for the shard",
                            settings = listOf(
                                SwitchConfig(
                                    id = "enableFeature",
                                    label = "Enable Feature",
                                    description = "Toggle this to enable the feature",
                                    defaultValue = null,
                                    disabled = false,
                                    info = null
                                ),
                                SelectConfig(
                                    id = "selectOption",
                                    label = "Select Option",
                                    description = "Choose an option from the list",
                                    options = listOf(
                                        SelectOption("option1", "Option 1"),
                                        SelectOption("option2", "Option 2"),
                                        SelectOption("option3", "Option 3")
                                    ),
                                    defaultValue = null,
                                    disabled = false,
                                    info = null
                                ),
                                InputConfig(
                                    id = "inputField",
                                    label = "Input Field",
                                    description = "Enter some text here",
                                    inputType = InputType.TEXT, // text, number, email, password, url
                                    placeholder = "Type something...",
                                    defaultValue = null,
                                    suffix = null,
                                    disabled = false,
                                    info = null
                                ),
                                InputConfig(
                                    id = "numberField",
                                    label = "Number Field",
                                    description = "Enter a number",
                                    inputType = InputType.NUMBER, // text, number, email, password, url
                                    placeholder = "0",
                                    defaultValue = null,
                                    suffix = InputSuffix(
                                        type = "select",
                                        options = listOf(
                                            SelectOption("unit1", "Unit 1"),
                                            SelectOption("unit2", "Unit 2"),
                                            SelectOption("unit3", "Unit 3")
                                        ),
                                        defaultValue = "unit1"
                                    ),
                                    disabled = false,
                                    info = null
                                ),
                                SliderConfig(
                                    id = "sliderSetting",
                                    label = "Slider Setting",
                                    description = "Adjust the slider value",
                                    min = 0,
                                    max = 100,
                                    step = 1,
                                    disabled = false,
                                    info = null
                                )
                            )
                        )
                    )
                )
            )
        )
    }

}