package org.jetbrains.kotlinx.dataframe.api

import org.jetbrains.kotlinx.dataframe.ColumnFilter
import org.jetbrains.kotlinx.dataframe.DataColumn
import org.jetbrains.kotlinx.dataframe.DataFrame
import org.jetbrains.kotlinx.dataframe.DataRow
import org.jetbrains.kotlinx.dataframe.api.ColsColumnsSelectionDsl.CommonColsDocs.Vararg.AccessorType
import org.jetbrains.kotlinx.dataframe.columns.ColumnGroup
import org.jetbrains.kotlinx.dataframe.columns.ColumnPath
import org.jetbrains.kotlinx.dataframe.columns.ColumnReference
import org.jetbrains.kotlinx.dataframe.columns.ColumnSet
import org.jetbrains.kotlinx.dataframe.columns.ColumnWithPath
import org.jetbrains.kotlinx.dataframe.columns.ColumnsResolver
import org.jetbrains.kotlinx.dataframe.columns.SingleColumn
import org.jetbrains.kotlinx.dataframe.columns.asColumnSet
import org.jetbrains.kotlinx.dataframe.documentation.AccessApiLink
import org.jetbrains.kotlinx.dataframe.documentation.LineBreak
import org.jetbrains.kotlinx.dataframe.impl.columns.ColumnsList
import org.jetbrains.kotlinx.dataframe.impl.columns.TransformableColumnSet
import org.jetbrains.kotlinx.dataframe.impl.columns.transform
import org.jetbrains.kotlinx.dataframe.impl.columns.transformWithContext
import org.jetbrains.kotlinx.dataframe.impl.headPlusArray
import kotlin.reflect.KProperty

public interface ColsColumnsSelectionDsl {

    /**
     * ## Cols
     * Creates a subset of columns ([ColumnSet]) from the current [ColumnsResolver].
     *
     * If the current [ColumnsResolver] is a [SingleColumn] and consists of a [column group][ColumnGroup],
     * then `cols` will create a subset of its contained columns.
     *
     * You can use either a [ColumnFilter], or any of the `vararg` overloads for any
     * [Access API][org.jetbrains.kotlinx.dataframe.documentation.AccessApi].
     *
     * Aside from calling [cols] directly, you can also use the [get][ColumnSet.get] operator in most cases.
     *
     * #### For example:
     * `df.`[remove][DataFrame.remove]` { `[cols][ColumnsSelectionDsl.cols]` { it.`[hasNulls][DataColumn.hasNulls]`() }.`[recursively][ColumnsSelectionDsl.recursively]`() }`
     *
     * `df.`[select][DataFrame.select]` { myGroupCol.`[cols][SingleColumn.cols]`(columnA, columnB) }`
     *
     * `df.`[select][DataFrame.select]` { `[colsOf][ColumnsSelectionDsl.colsOf]`<`[String][String]`>()`[`[`][ColumnSet.cols]`1, 3, 5`[`]`][ColumnSet.cols]` }`
     *
     * #### Examples for this overload:
     *
     * {@includeArg [CommonColsDocs.Examples]}
     *
     */
    private interface CommonColsDocs {

        /**
         * ## Cols
         * Creates a subset of columns ([ColumnSet][org.jetbrains.kotlinx.dataframe.columns.ColumnSet]) from the current [ColumnsResolver][org.jetbrains.kotlinx.dataframe.columns.ColumnsResolver].
         *
         * If the current [ColumnsResolver][org.jetbrains.kotlinx.dataframe.columns.ColumnsResolver] is a [SingleColumn][org.jetbrains.kotlinx.dataframe.columns.SingleColumn] and consists of a [column group][org.jetbrains.kotlinx.dataframe.columns.ColumnGroup],
         * then `cols` will create a subset of its contained columns.
         *
         * You can use either a [ColumnFilter][org.jetbrains.kotlinx.dataframe.ColumnFilter], or any of the `vararg` overloads for any
         * [Access API][org.jetbrains.kotlinx.dataframe.documentation.AccessApi].
         *
         * Aside from calling [cols][org.jetbrains.kotlinx.dataframe.api.ColsColumnsSelectionDsl.cols] directly, you can also use the [get][org.jetbrains.kotlinx.dataframe.columns.ColumnSet.get] operator in most cases.
         *
         * #### For example:
         * `df.`[remove][org.jetbrains.kotlinx.dataframe.DataFrame.remove]` { `[cols][org.jetbrains.kotlinx.dataframe.api.ColumnsSelectionDsl.cols]` { it.`[hasNulls][org.jetbrains.kotlinx.dataframe.DataColumn.hasNulls]`() }.`[recursively][ColumnsSelectionDsl.recursively]`() }`
         *
         * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { myGroupCol.`[cols][org.jetbrains.kotlinx.dataframe.columns.SingleColumn.cols]`(columnA, columnB) }`
         *
         * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { `[colsOf][org.jetbrains.kotlinx.dataframe.api.ColumnsSelectionDsl.colsOf]`<`[String][String]`>()`[`[`][org.jetbrains.kotlinx.dataframe.columns.ColumnSet.cols]`1, 3, 5`[`]`][org.jetbrains.kotlinx.dataframe.columns.ColumnSet.cols]` }`
         *
         * #### Examples for this overload:
         *
         * {@includeArg [CommonColsDocs.Examples][org.jetbrains.kotlinx.dataframe.api.ColsColumnsSelectionDsl.CommonColsDocs.Examples]}
         *
         *
         * #### Filter vs. Cols:
         * If used with a [predicate], `cols {}` functions exactly like [`filter {}`][ColumnsSelectionDsl.filter].
         * This is intentional, however; it is recommended to use `filter {}` on [ColumnSets][ColumnSet] and
         * `cols {}` on the rest.
         *
         * @param [predicate] A [ColumnFilter function][ColumnFilter] that takes a [ColumnReference] and returns a [Boolean].
         * @return A ([transformable][TransformableColumnSet]) [ColumnSet] containing the columns that match the given [predicate].
         */
        interface Predicate

        /**
         * ## Cols
         * Creates a subset of columns ([ColumnSet][org.jetbrains.kotlinx.dataframe.columns.ColumnSet]) from the current [ColumnsResolver][org.jetbrains.kotlinx.dataframe.columns.ColumnsResolver].
         *
         * If the current [ColumnsResolver][org.jetbrains.kotlinx.dataframe.columns.ColumnsResolver] is a [SingleColumn][org.jetbrains.kotlinx.dataframe.columns.SingleColumn] and consists of a [column group][org.jetbrains.kotlinx.dataframe.columns.ColumnGroup],
         * then `cols` will create a subset of its contained columns.
         *
         * You can use either a [ColumnFilter][org.jetbrains.kotlinx.dataframe.ColumnFilter], or any of the `vararg` overloads for any
         * [Access API][org.jetbrains.kotlinx.dataframe.documentation.AccessApi].
         *
         * Aside from calling [cols][org.jetbrains.kotlinx.dataframe.api.ColsColumnsSelectionDsl.cols] directly, you can also use the [get][org.jetbrains.kotlinx.dataframe.columns.ColumnSet.get] operator in most cases.
         *
         * #### For example:
         * `df.`[remove][org.jetbrains.kotlinx.dataframe.DataFrame.remove]` { `[cols][org.jetbrains.kotlinx.dataframe.api.ColumnsSelectionDsl.cols]` { it.`[hasNulls][org.jetbrains.kotlinx.dataframe.DataColumn.hasNulls]`() }.`[recursively][ColumnsSelectionDsl.recursively]`() }`
         *
         * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { myGroupCol.`[cols][org.jetbrains.kotlinx.dataframe.columns.SingleColumn.cols]`(columnA, columnB) }`
         *
         * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { `[colsOf][org.jetbrains.kotlinx.dataframe.api.ColumnsSelectionDsl.colsOf]`<`[String][String]`>()`[`[`][org.jetbrains.kotlinx.dataframe.columns.ColumnSet.cols]`1, 3, 5`[`]`][org.jetbrains.kotlinx.dataframe.columns.ColumnSet.cols]` }`
         *
         * #### Examples for this overload:
         *
         * {@includeArg [CommonColsDocs.Examples][org.jetbrains.kotlinx.dataframe.api.ColsColumnsSelectionDsl.CommonColsDocs.Examples]}
         *
         *
         * @param [firstCol\] A {@includeArg [AccessorType]} that points to a column.
         * @param [otherCols\] Optional additional {@includeArg [AccessorType]}s that point to columns.
         * @return A ([transformable][TransformableColumnSet]) [ColumnSet] containing the columns that [firstCol\] and [otherCols\] point to.
         */
        interface Vararg {

            interface AccessorType
        }

        /** Example argument */
        interface Examples
    }

    // region predicate

    /**
     * ## Cols
     * Creates a subset of columns ([ColumnSet][org.jetbrains.kotlinx.dataframe.columns.ColumnSet]) from the current [ColumnsResolver][org.jetbrains.kotlinx.dataframe.columns.ColumnsResolver].
     *
     * If the current [ColumnsResolver][org.jetbrains.kotlinx.dataframe.columns.ColumnsResolver] is a [SingleColumn][org.jetbrains.kotlinx.dataframe.columns.SingleColumn] and consists of a [column group][org.jetbrains.kotlinx.dataframe.columns.ColumnGroup],
     * then `cols` will create a subset of its contained columns.
     *
     * You can use either a [ColumnFilter][org.jetbrains.kotlinx.dataframe.ColumnFilter], or any of the `vararg` overloads for any
     * [Access API][org.jetbrains.kotlinx.dataframe.documentation.AccessApi].
     *
     * Aside from calling [cols][org.jetbrains.kotlinx.dataframe.api.ColsColumnsSelectionDsl.cols] directly, you can also use the [get][org.jetbrains.kotlinx.dataframe.columns.ColumnSet.get] operator in most cases.
     *
     * #### For example:
     * `df.`[remove][org.jetbrains.kotlinx.dataframe.DataFrame.remove]` { `[cols][org.jetbrains.kotlinx.dataframe.api.ColumnsSelectionDsl.cols]` { it.`[hasNulls][org.jetbrains.kotlinx.dataframe.DataColumn.hasNulls]`() }.`[recursively][ColumnsSelectionDsl.recursively]`() }`
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { myGroupCol.`[cols][org.jetbrains.kotlinx.dataframe.columns.SingleColumn.cols]`(columnA, columnB) }`
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { `[colsOf][org.jetbrains.kotlinx.dataframe.api.ColumnsSelectionDsl.colsOf]`<`[String][String]`>()`[`[`][org.jetbrains.kotlinx.dataframe.columns.ColumnSet.cols]`1, 3, 5`[`]`][org.jetbrains.kotlinx.dataframe.columns.ColumnSet.cols]` }`
     *
     * #### Examples for this overload:
     *
     * `// although these can be shortened to just the `[colsOf<>{ }][ColumnsSelectionDsl.colsOf]` call`
     *
     * `df.`[select][DataFrame.select]` { `[colsOf][ColumnsSelectionDsl.colsOf]`<`[String][String]`>().`[cols][ColumnSet.cols]` { "e" `[in][String.contains]` it.`[name][ColumnPath.name]`() } }`
     *
     * `df.`[select][DataFrame.select]` { `[colsOf][ColumnsSelectionDsl.colsOf]`<`[String][String]`>()`[`[`][ColumnSet.cols]`{ it.`[any][ColumnWithPath.any]` { it == "Alice" } }`[`]`][ColumnSet.cols]` }`
     *
     * `// identity call, same as `[all][ColumnsSelectionDsl.all]`()`
     *
     * `df.`[select][DataFrame.select]` { `[colsOf][ColumnsSelectionDsl.colsOf]`<`[String][String]`>().`[cols][ColumnSet.cols]`() }`
     *
     * @see [all]
     * @see [filter]
     *
     *
     * #### Filter vs. Cols:
     * If used with a [predicate], `cols {}` functions exactly like [`filter {}`][ColumnsSelectionDsl.filter].
     * This is intentional, however; it is recommended to use `filter {}` on [ColumnSets][org.jetbrains.kotlinx.dataframe.columns.ColumnSet] and
     * `cols {}` on the rest.
     *
     * @param [predicate] A [ColumnFilter function][org.jetbrains.kotlinx.dataframe.ColumnFilter] that takes a [ColumnReference][org.jetbrains.kotlinx.dataframe.columns.ColumnReference] and returns a [Boolean].
     * @return A ([transformable][org.jetbrains.kotlinx.dataframe.impl.columns.TransformableColumnSet]) [ColumnSet][org.jetbrains.kotlinx.dataframe.columns.ColumnSet] containing the columns that match the given [predicate].
     */
    private interface ColumnSetColsPredicateDocs

    /** ## Cols
     * Creates a subset of columns ([ColumnSet][org.jetbrains.kotlinx.dataframe.columns.ColumnSet]) from the current [ColumnsResolver][org.jetbrains.kotlinx.dataframe.columns.ColumnsResolver].
     *
     * If the current [ColumnsResolver][org.jetbrains.kotlinx.dataframe.columns.ColumnsResolver] is a [SingleColumn][org.jetbrains.kotlinx.dataframe.columns.SingleColumn] and consists of a [column group][org.jetbrains.kotlinx.dataframe.columns.ColumnGroup],
     * then `cols` will create a subset of its contained columns.
     *
     * You can use either a [ColumnFilter][org.jetbrains.kotlinx.dataframe.ColumnFilter], or any of the `vararg` overloads for any
     * [Access API][org.jetbrains.kotlinx.dataframe.documentation.AccessApi].
     *
     * Aside from calling [cols][org.jetbrains.kotlinx.dataframe.api.ColsColumnsSelectionDsl.cols] directly, you can also use the [get][org.jetbrains.kotlinx.dataframe.columns.ColumnSet.get] operator in most cases.
     *
     * #### For example:
     * `df.`[remove][org.jetbrains.kotlinx.dataframe.DataFrame.remove]` { `[cols][org.jetbrains.kotlinx.dataframe.api.ColumnsSelectionDsl.cols]` { it.`[hasNulls][org.jetbrains.kotlinx.dataframe.DataColumn.hasNulls]`() }.`[recursively][ColumnsSelectionDsl.recursively]`() }`
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { myGroupCol.`[cols][org.jetbrains.kotlinx.dataframe.columns.SingleColumn.cols]`(columnA, columnB) }`
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { `[colsOf][org.jetbrains.kotlinx.dataframe.api.ColumnsSelectionDsl.colsOf]`<`[String][String]`>()`[`[`][org.jetbrains.kotlinx.dataframe.columns.ColumnSet.cols]`1, 3, 5`[`]`][org.jetbrains.kotlinx.dataframe.columns.ColumnSet.cols]` }`
     *
     * #### Examples for this overload:
     *
     * `// although these can be shortened to just the `[colsOf<>{ }][org.jetbrains.kotlinx.dataframe.api.ColumnsSelectionDsl.colsOf]` call`
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { `[colsOf][org.jetbrains.kotlinx.dataframe.api.ColumnsSelectionDsl.colsOf]`<`[String][String]`>().`[cols][org.jetbrains.kotlinx.dataframe.columns.ColumnSet.cols]` { "e" `[in][String.contains]` it.`[name][org.jetbrains.kotlinx.dataframe.columns.ColumnPath.name]`() } }`
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { `[colsOf][org.jetbrains.kotlinx.dataframe.api.ColumnsSelectionDsl.colsOf]`<`[String][String]`>()`[`[`][org.jetbrains.kotlinx.dataframe.columns.ColumnSet.cols]`{ it.`[any][ColumnWithPath.any]` { it == "Alice" } }`[`]`][org.jetbrains.kotlinx.dataframe.columns.ColumnSet.cols]` }`
     *
     * `// identity call, same as `[all][org.jetbrains.kotlinx.dataframe.api.ColumnsSelectionDsl.all]`()`
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { `[colsOf][org.jetbrains.kotlinx.dataframe.api.ColumnsSelectionDsl.colsOf]`<`[String][String]`>().`[cols][org.jetbrains.kotlinx.dataframe.columns.ColumnSet.cols]`() }`
     *
     *
     * #### Filter vs. Cols:
     * If used with a [predicate], `cols {}` functions exactly like [`filter {}`][ColumnsSelectionDsl.filter].
     * This is intentional, however; it is recommended to use `filter {}` on [ColumnSets][org.jetbrains.kotlinx.dataframe.columns.ColumnSet] and
     * `cols {}` on the rest.
     *
     * @param [predicate] A [ColumnFilter function][org.jetbrains.kotlinx.dataframe.ColumnFilter] that takes a [ColumnReference][org.jetbrains.kotlinx.dataframe.columns.ColumnReference] and returns a [Boolean].
     * @return A ([transformable][org.jetbrains.kotlinx.dataframe.impl.columns.TransformableColumnSet]) [ColumnSet][org.jetbrains.kotlinx.dataframe.columns.ColumnSet] containing the columns that match the given [predicate].
     * @see [all]
     * @see [filter] */
    @Suppress("UNCHECKED_CAST")
    public fun <C> ColumnSet<C>.cols(
        predicate: ColumnFilter<C> = { true },
    ): TransformableColumnSet<C> = colsInternal(predicate as ColumnFilter<*>) as TransformableColumnSet<C>

    /** ## Cols
     * Creates a subset of columns ([ColumnSet][org.jetbrains.kotlinx.dataframe.columns.ColumnSet]) from the current [ColumnsResolver][org.jetbrains.kotlinx.dataframe.columns.ColumnsResolver].
     *
     * If the current [ColumnsResolver][org.jetbrains.kotlinx.dataframe.columns.ColumnsResolver] is a [SingleColumn][org.jetbrains.kotlinx.dataframe.columns.SingleColumn] and consists of a [column group][org.jetbrains.kotlinx.dataframe.columns.ColumnGroup],
     * then `cols` will create a subset of its contained columns.
     *
     * You can use either a [ColumnFilter][org.jetbrains.kotlinx.dataframe.ColumnFilter], or any of the `vararg` overloads for any
     * [Access API][org.jetbrains.kotlinx.dataframe.documentation.AccessApi].
     *
     * Aside from calling [cols][org.jetbrains.kotlinx.dataframe.api.ColsColumnsSelectionDsl.cols] directly, you can also use the [get][org.jetbrains.kotlinx.dataframe.columns.ColumnSet.get] operator in most cases.
     *
     * #### For example:
     * `df.`[remove][org.jetbrains.kotlinx.dataframe.DataFrame.remove]` { `[cols][org.jetbrains.kotlinx.dataframe.api.ColumnsSelectionDsl.cols]` { it.`[hasNulls][org.jetbrains.kotlinx.dataframe.DataColumn.hasNulls]`() }.`[recursively][ColumnsSelectionDsl.recursively]`() }`
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { myGroupCol.`[cols][org.jetbrains.kotlinx.dataframe.columns.SingleColumn.cols]`(columnA, columnB) }`
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { `[colsOf][org.jetbrains.kotlinx.dataframe.api.ColumnsSelectionDsl.colsOf]`<`[String][String]`>()`[`[`][org.jetbrains.kotlinx.dataframe.columns.ColumnSet.cols]`1, 3, 5`[`]`][org.jetbrains.kotlinx.dataframe.columns.ColumnSet.cols]` }`
     *
     * #### Examples for this overload:
     *
     * `// although these can be shortened to just the `[colsOf<>{ }][org.jetbrains.kotlinx.dataframe.api.ColumnsSelectionDsl.colsOf]` call`
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { `[colsOf][org.jetbrains.kotlinx.dataframe.api.ColumnsSelectionDsl.colsOf]`<`[String][String]`>().`[cols][org.jetbrains.kotlinx.dataframe.columns.ColumnSet.cols]` { "e" `[in][String.contains]` it.`[name][org.jetbrains.kotlinx.dataframe.columns.ColumnPath.name]`() } }`
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { `[colsOf][org.jetbrains.kotlinx.dataframe.api.ColumnsSelectionDsl.colsOf]`<`[String][String]`>()`[`[`][org.jetbrains.kotlinx.dataframe.columns.ColumnSet.cols]`{ it.`[any][ColumnWithPath.any]` { it == "Alice" } }`[`]`][org.jetbrains.kotlinx.dataframe.columns.ColumnSet.cols]` }`
     *
     * `// identity call, same as `[all][org.jetbrains.kotlinx.dataframe.api.ColumnsSelectionDsl.all]`()`
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { `[colsOf][org.jetbrains.kotlinx.dataframe.api.ColumnsSelectionDsl.colsOf]`<`[String][String]`>().`[cols][org.jetbrains.kotlinx.dataframe.columns.ColumnSet.cols]`() }`
     *
     *
     * #### Filter vs. Cols:
     * If used with a [predicate], `cols {}` functions exactly like [`filter {}`][ColumnsSelectionDsl.filter].
     * This is intentional, however; it is recommended to use `filter {}` on [ColumnSets][org.jetbrains.kotlinx.dataframe.columns.ColumnSet] and
     * `cols {}` on the rest.
     *
     * @param [predicate] A [ColumnFilter function][org.jetbrains.kotlinx.dataframe.ColumnFilter] that takes a [ColumnReference][org.jetbrains.kotlinx.dataframe.columns.ColumnReference] and returns a [Boolean].
     * @return A ([transformable][org.jetbrains.kotlinx.dataframe.impl.columns.TransformableColumnSet]) [ColumnSet][org.jetbrains.kotlinx.dataframe.columns.ColumnSet] containing the columns that match the given [predicate].
     * @see [all]
     * @see [filter] */
    public operator fun <C> ColumnSet<C>.get(
        predicate: ColumnFilter<C> = { true },
    ): TransformableColumnSet<C> = cols(predicate)

    /**
     * ## Cols
     * Creates a subset of columns ([ColumnSet][org.jetbrains.kotlinx.dataframe.columns.ColumnSet]) from the current [ColumnsResolver][org.jetbrains.kotlinx.dataframe.columns.ColumnsResolver].
     *
     * If the current [ColumnsResolver][org.jetbrains.kotlinx.dataframe.columns.ColumnsResolver] is a [SingleColumn][org.jetbrains.kotlinx.dataframe.columns.SingleColumn] and consists of a [column group][org.jetbrains.kotlinx.dataframe.columns.ColumnGroup],
     * then `cols` will create a subset of its contained columns.
     *
     * You can use either a [ColumnFilter][org.jetbrains.kotlinx.dataframe.ColumnFilter], or any of the `vararg` overloads for any
     * [Access API][org.jetbrains.kotlinx.dataframe.documentation.AccessApi].
     *
     * Aside from calling [cols][org.jetbrains.kotlinx.dataframe.api.ColsColumnsSelectionDsl.cols] directly, you can also use the [get][org.jetbrains.kotlinx.dataframe.columns.ColumnSet.get] operator in most cases.
     *
     * #### For example:
     * `df.`[remove][org.jetbrains.kotlinx.dataframe.DataFrame.remove]` { `[cols][org.jetbrains.kotlinx.dataframe.api.ColumnsSelectionDsl.cols]` { it.`[hasNulls][org.jetbrains.kotlinx.dataframe.DataColumn.hasNulls]`() }.`[recursively][ColumnsSelectionDsl.recursively]`() }`
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { myGroupCol.`[cols][org.jetbrains.kotlinx.dataframe.columns.SingleColumn.cols]`(columnA, columnB) }`
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { `[colsOf][org.jetbrains.kotlinx.dataframe.api.ColumnsSelectionDsl.colsOf]`<`[String][String]`>()`[`[`][org.jetbrains.kotlinx.dataframe.columns.ColumnSet.cols]`1, 3, 5`[`]`][org.jetbrains.kotlinx.dataframe.columns.ColumnSet.cols]` }`
     *
     * #### Examples for this overload:
     *
     * `df.`[select][DataFrame.select]` { `[cols][ColumnsSelectionDsl.cols]` { "e" `[in][String.contains]` it.`[name][ColumnPath.name]`() }.`[recursively][ColumnsSelectionDsl.recursively]`() }`
     *
     * `df.`[select][DataFrame.select]` { this`[`[`][ColumnsSelectionDsl.cols]`{ it.`[any][ColumnWithPath.any]` { it == "Alice" } }`[`]`][ColumnsSelectionDsl.cols]` }`
     *
     *  `// same as `[all][ColumnsSelectionDsl.all]`()`
     *
     * `df.`[select][DataFrame.select]` { `[cols][ColumnsSelectionDsl.cols]`() }`
     *
     *
     * &nbsp;&nbsp;&nbsp;&nbsp;
     *
     *
     * @see [all]
     *
     *
     * #### Filter vs. Cols:
     * If used with a [predicate], `cols {}` functions exactly like [`filter {}`][ColumnsSelectionDsl.filter].
     * This is intentional, however; it is recommended to use `filter {}` on [ColumnSets][org.jetbrains.kotlinx.dataframe.columns.ColumnSet] and
     * `cols {}` on the rest.
     *
     * @param [predicate] A [ColumnFilter function][org.jetbrains.kotlinx.dataframe.ColumnFilter] that takes a [ColumnReference][org.jetbrains.kotlinx.dataframe.columns.ColumnReference] and returns a [Boolean].
     * @return A ([transformable][org.jetbrains.kotlinx.dataframe.impl.columns.TransformableColumnSet]) [ColumnSet][org.jetbrains.kotlinx.dataframe.columns.ColumnSet] containing the columns that match the given [predicate].
     */
    private interface ColumnsSelectionDslColsPredicateDocs

    /** ## Cols
     * Creates a subset of columns ([ColumnSet][org.jetbrains.kotlinx.dataframe.columns.ColumnSet]) from the current [ColumnsResolver][org.jetbrains.kotlinx.dataframe.columns.ColumnsResolver].
     *
     * If the current [ColumnsResolver][org.jetbrains.kotlinx.dataframe.columns.ColumnsResolver] is a [SingleColumn][org.jetbrains.kotlinx.dataframe.columns.SingleColumn] and consists of a [column group][org.jetbrains.kotlinx.dataframe.columns.ColumnGroup],
     * then `cols` will create a subset of its contained columns.
     *
     * You can use either a [ColumnFilter][org.jetbrains.kotlinx.dataframe.ColumnFilter], or any of the `vararg` overloads for any
     * [Access API][org.jetbrains.kotlinx.dataframe.documentation.AccessApi].
     *
     * Aside from calling [cols][org.jetbrains.kotlinx.dataframe.api.ColsColumnsSelectionDsl.cols] directly, you can also use the [get][org.jetbrains.kotlinx.dataframe.columns.ColumnSet.get] operator in most cases.
     *
     * #### For example:
     * `df.`[remove][org.jetbrains.kotlinx.dataframe.DataFrame.remove]` { `[cols][org.jetbrains.kotlinx.dataframe.api.ColumnsSelectionDsl.cols]` { it.`[hasNulls][org.jetbrains.kotlinx.dataframe.DataColumn.hasNulls]`() }.`[recursively][ColumnsSelectionDsl.recursively]`() }`
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { myGroupCol.`[cols][org.jetbrains.kotlinx.dataframe.columns.SingleColumn.cols]`(columnA, columnB) }`
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { `[colsOf][org.jetbrains.kotlinx.dataframe.api.ColumnsSelectionDsl.colsOf]`<`[String][String]`>()`[`[`][org.jetbrains.kotlinx.dataframe.columns.ColumnSet.cols]`1, 3, 5`[`]`][org.jetbrains.kotlinx.dataframe.columns.ColumnSet.cols]` }`
     *
     * #### Examples for this overload:
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { `[cols][org.jetbrains.kotlinx.dataframe.api.ColumnsSelectionDsl.cols]` { "e" `[in][String.contains]` it.`[name][org.jetbrains.kotlinx.dataframe.columns.ColumnPath.name]`() }.`[recursively][ColumnsSelectionDsl.recursively]`() }`
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { this`[`[`][org.jetbrains.kotlinx.dataframe.api.ColumnsSelectionDsl.cols]`{ it.`[any][ColumnWithPath.any]` { it == "Alice" } }`[`]`][org.jetbrains.kotlinx.dataframe.api.ColumnsSelectionDsl.cols]` }`
     *
     *  `// same as `[all][org.jetbrains.kotlinx.dataframe.api.ColumnsSelectionDsl.all]`()`
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { `[cols][org.jetbrains.kotlinx.dataframe.api.ColumnsSelectionDsl.cols]`() }`
     *
     *
     * &nbsp;&nbsp;&nbsp;&nbsp;
     *
     *
     *
     * #### Filter vs. Cols:
     * If used with a [predicate], `cols {}` functions exactly like [`filter {}`][ColumnsSelectionDsl.filter].
     * This is intentional, however; it is recommended to use `filter {}` on [ColumnSets][org.jetbrains.kotlinx.dataframe.columns.ColumnSet] and
     * `cols {}` on the rest.
     *
     * @param [predicate] A [ColumnFilter function][org.jetbrains.kotlinx.dataframe.ColumnFilter] that takes a [ColumnReference][org.jetbrains.kotlinx.dataframe.columns.ColumnReference] and returns a [Boolean].
     * @return A ([transformable][org.jetbrains.kotlinx.dataframe.impl.columns.TransformableColumnSet]) [ColumnSet][org.jetbrains.kotlinx.dataframe.columns.ColumnSet] containing the columns that match the given [predicate].
     * @see [all] */
    public fun ColumnsSelectionDsl<*>.cols(
        predicate: ColumnFilter<*> = { true },
    ): TransformableColumnSet<*> = this.asSingleColumn().colsInternal(predicate)

    /** ## Cols
     * Creates a subset of columns ([ColumnSet][org.jetbrains.kotlinx.dataframe.columns.ColumnSet]) from the current [ColumnsResolver][org.jetbrains.kotlinx.dataframe.columns.ColumnsResolver].
     *
     * If the current [ColumnsResolver][org.jetbrains.kotlinx.dataframe.columns.ColumnsResolver] is a [SingleColumn][org.jetbrains.kotlinx.dataframe.columns.SingleColumn] and consists of a [column group][org.jetbrains.kotlinx.dataframe.columns.ColumnGroup],
     * then `cols` will create a subset of its contained columns.
     *
     * You can use either a [ColumnFilter][org.jetbrains.kotlinx.dataframe.ColumnFilter], or any of the `vararg` overloads for any
     * [Access API][org.jetbrains.kotlinx.dataframe.documentation.AccessApi].
     *
     * Aside from calling [cols][org.jetbrains.kotlinx.dataframe.api.ColsColumnsSelectionDsl.cols] directly, you can also use the [get][org.jetbrains.kotlinx.dataframe.columns.ColumnSet.get] operator in most cases.
     *
     * #### For example:
     * `df.`[remove][org.jetbrains.kotlinx.dataframe.DataFrame.remove]` { `[cols][org.jetbrains.kotlinx.dataframe.api.ColumnsSelectionDsl.cols]` { it.`[hasNulls][org.jetbrains.kotlinx.dataframe.DataColumn.hasNulls]`() }.`[recursively][ColumnsSelectionDsl.recursively]`() }`
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { myGroupCol.`[cols][org.jetbrains.kotlinx.dataframe.columns.SingleColumn.cols]`(columnA, columnB) }`
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { `[colsOf][org.jetbrains.kotlinx.dataframe.api.ColumnsSelectionDsl.colsOf]`<`[String][String]`>()`[`[`][org.jetbrains.kotlinx.dataframe.columns.ColumnSet.cols]`1, 3, 5`[`]`][org.jetbrains.kotlinx.dataframe.columns.ColumnSet.cols]` }`
     *
     * #### Examples for this overload:
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { `[cols][org.jetbrains.kotlinx.dataframe.api.ColumnsSelectionDsl.cols]` { "e" `[in][String.contains]` it.`[name][org.jetbrains.kotlinx.dataframe.columns.ColumnPath.name]`() }.`[recursively][ColumnsSelectionDsl.recursively]`() }`
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { this`[`[`][org.jetbrains.kotlinx.dataframe.api.ColumnsSelectionDsl.cols]`{ it.`[any][ColumnWithPath.any]` { it == "Alice" } }`[`]`][org.jetbrains.kotlinx.dataframe.api.ColumnsSelectionDsl.cols]` }`
     *
     *  `// same as `[all][org.jetbrains.kotlinx.dataframe.api.ColumnsSelectionDsl.all]`()`
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { `[cols][org.jetbrains.kotlinx.dataframe.api.ColumnsSelectionDsl.cols]`() }`
     *
     *
     * &nbsp;&nbsp;&nbsp;&nbsp;
     *
     *
     *
     * #### Filter vs. Cols:
     * If used with a [predicate], `cols {}` functions exactly like [`filter {}`][ColumnsSelectionDsl.filter].
     * This is intentional, however; it is recommended to use `filter {}` on [ColumnSets][org.jetbrains.kotlinx.dataframe.columns.ColumnSet] and
     * `cols {}` on the rest.
     *
     * @param [predicate] A [ColumnFilter function][org.jetbrains.kotlinx.dataframe.ColumnFilter] that takes a [ColumnReference][org.jetbrains.kotlinx.dataframe.columns.ColumnReference] and returns a [Boolean].
     * @return A ([transformable][org.jetbrains.kotlinx.dataframe.impl.columns.TransformableColumnSet]) [ColumnSet][org.jetbrains.kotlinx.dataframe.columns.ColumnSet] containing the columns that match the given [predicate].
     * @see [all] */
    public operator fun ColumnsSelectionDsl<*>.get(
        predicate: ColumnFilter<*> = { true },
    ): TransformableColumnSet<*> = cols(predicate)

    /**
     * ## Cols
     * Creates a subset of columns ([ColumnSet][org.jetbrains.kotlinx.dataframe.columns.ColumnSet]) from the current [ColumnsResolver][org.jetbrains.kotlinx.dataframe.columns.ColumnsResolver].
     *
     * If the current [ColumnsResolver][org.jetbrains.kotlinx.dataframe.columns.ColumnsResolver] is a [SingleColumn][org.jetbrains.kotlinx.dataframe.columns.SingleColumn] and consists of a [column group][org.jetbrains.kotlinx.dataframe.columns.ColumnGroup],
     * then `cols` will create a subset of its contained columns.
     *
     * You can use either a [ColumnFilter][org.jetbrains.kotlinx.dataframe.ColumnFilter], or any of the `vararg` overloads for any
     * [Access API][org.jetbrains.kotlinx.dataframe.documentation.AccessApi].
     *
     * Aside from calling [cols][org.jetbrains.kotlinx.dataframe.api.ColsColumnsSelectionDsl.cols] directly, you can also use the [get][org.jetbrains.kotlinx.dataframe.columns.ColumnSet.get] operator in most cases.
     *
     * #### For example:
     * `df.`[remove][org.jetbrains.kotlinx.dataframe.DataFrame.remove]` { `[cols][org.jetbrains.kotlinx.dataframe.api.ColumnsSelectionDsl.cols]` { it.`[hasNulls][org.jetbrains.kotlinx.dataframe.DataColumn.hasNulls]`() }.`[recursively][ColumnsSelectionDsl.recursively]`() }`
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { myGroupCol.`[cols][org.jetbrains.kotlinx.dataframe.columns.SingleColumn.cols]`(columnA, columnB) }`
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { `[colsOf][org.jetbrains.kotlinx.dataframe.api.ColumnsSelectionDsl.colsOf]`<`[String][String]`>()`[`[`][org.jetbrains.kotlinx.dataframe.columns.ColumnSet.cols]`1, 3, 5`[`]`][org.jetbrains.kotlinx.dataframe.columns.ColumnSet.cols]` }`
     *
     * #### Examples for this overload:
     *
     * `df.`[select][DataFrame.select]` { myColumnGroup`.[cols][SingleColumn.cols]` { "e" `[in][String.contains]` it.`[name][ColumnPath.name]`() } }`
     *
     * `// same as `[all][ColumnsSelectionDsl.all]`()`
     *
     * `df.`[select][DataFrame.select]` { myColumnGroup.`[cols][SingleColumn.cols]`() }`
     *
     * `df.`[select][DataFrame.select]` { myColumnGroup`[`[`][SingleColumn.cols]`{ ... }`[`]`][SingleColumn.cols]` }`
     *
     * &nbsp;&nbsp;&nbsp;&nbsp;
     *
     *
     * @see [all]
     *
     *
     * #### Filter vs. Cols:
     * If used with a [predicate], `cols {}` functions exactly like [`filter {}`][ColumnsSelectionDsl.filter].
     * This is intentional, however; it is recommended to use `filter {}` on [ColumnSets][org.jetbrains.kotlinx.dataframe.columns.ColumnSet] and
     * `cols {}` on the rest.
     *
     * @param [predicate] A [ColumnFilter function][org.jetbrains.kotlinx.dataframe.ColumnFilter] that takes a [ColumnReference][org.jetbrains.kotlinx.dataframe.columns.ColumnReference] and returns a [Boolean].
     * @return A ([transformable][org.jetbrains.kotlinx.dataframe.impl.columns.TransformableColumnSet]) [ColumnSet][org.jetbrains.kotlinx.dataframe.columns.ColumnSet] containing the columns that match the given [predicate].
     */
    private interface SingleColumnAnyRowColsPredicateDocs

    /** ## Cols
     * Creates a subset of columns ([ColumnSet][org.jetbrains.kotlinx.dataframe.columns.ColumnSet]) from the current [ColumnsResolver][org.jetbrains.kotlinx.dataframe.columns.ColumnsResolver].
     *
     * If the current [ColumnsResolver][org.jetbrains.kotlinx.dataframe.columns.ColumnsResolver] is a [SingleColumn][org.jetbrains.kotlinx.dataframe.columns.SingleColumn] and consists of a [column group][org.jetbrains.kotlinx.dataframe.columns.ColumnGroup],
     * then `cols` will create a subset of its contained columns.
     *
     * You can use either a [ColumnFilter][org.jetbrains.kotlinx.dataframe.ColumnFilter], or any of the `vararg` overloads for any
     * [Access API][org.jetbrains.kotlinx.dataframe.documentation.AccessApi].
     *
     * Aside from calling [cols][org.jetbrains.kotlinx.dataframe.api.ColsColumnsSelectionDsl.cols] directly, you can also use the [get][org.jetbrains.kotlinx.dataframe.columns.ColumnSet.get] operator in most cases.
     *
     * #### For example:
     * `df.`[remove][org.jetbrains.kotlinx.dataframe.DataFrame.remove]` { `[cols][org.jetbrains.kotlinx.dataframe.api.ColumnsSelectionDsl.cols]` { it.`[hasNulls][org.jetbrains.kotlinx.dataframe.DataColumn.hasNulls]`() }.`[recursively][ColumnsSelectionDsl.recursively]`() }`
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { myGroupCol.`[cols][org.jetbrains.kotlinx.dataframe.columns.SingleColumn.cols]`(columnA, columnB) }`
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { `[colsOf][org.jetbrains.kotlinx.dataframe.api.ColumnsSelectionDsl.colsOf]`<`[String][String]`>()`[`[`][org.jetbrains.kotlinx.dataframe.columns.ColumnSet.cols]`1, 3, 5`[`]`][org.jetbrains.kotlinx.dataframe.columns.ColumnSet.cols]` }`
     *
     * #### Examples for this overload:
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { myColumnGroup`.[cols][org.jetbrains.kotlinx.dataframe.columns.SingleColumn.cols]` { "e" `[in][String.contains]` it.`[name][org.jetbrains.kotlinx.dataframe.columns.ColumnPath.name]`() } }`
     *
     * `// same as `[all][org.jetbrains.kotlinx.dataframe.api.ColumnsSelectionDsl.all]`()`
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { myColumnGroup.`[cols][org.jetbrains.kotlinx.dataframe.columns.SingleColumn.cols]`() }`
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { myColumnGroup`[`[`][org.jetbrains.kotlinx.dataframe.columns.SingleColumn.cols]`{ ... }`[`]`][org.jetbrains.kotlinx.dataframe.columns.SingleColumn.cols]` }`
     *
     * &nbsp;&nbsp;&nbsp;&nbsp;
     *
     *
     *
     * #### Filter vs. Cols:
     * If used with a [predicate], `cols {}` functions exactly like [`filter {}`][ColumnsSelectionDsl.filter].
     * This is intentional, however; it is recommended to use `filter {}` on [ColumnSets][org.jetbrains.kotlinx.dataframe.columns.ColumnSet] and
     * `cols {}` on the rest.
     *
     * @param [predicate] A [ColumnFilter function][org.jetbrains.kotlinx.dataframe.ColumnFilter] that takes a [ColumnReference][org.jetbrains.kotlinx.dataframe.columns.ColumnReference] and returns a [Boolean].
     * @return A ([transformable][org.jetbrains.kotlinx.dataframe.impl.columns.TransformableColumnSet]) [ColumnSet][org.jetbrains.kotlinx.dataframe.columns.ColumnSet] containing the columns that match the given [predicate].
     * @see [all] */
    public fun SingleColumn<DataRow<*>>.cols(
        predicate: ColumnFilter<*> = { true },
    ): TransformableColumnSet<*> = ensureIsColGroup().colsInternal(predicate)

    /**
     * ## Cols
     * Creates a subset of columns ([ColumnSet][org.jetbrains.kotlinx.dataframe.columns.ColumnSet]) from the current [ColumnsResolver][org.jetbrains.kotlinx.dataframe.columns.ColumnsResolver].
     *
     * If the current [ColumnsResolver][org.jetbrains.kotlinx.dataframe.columns.ColumnsResolver] is a [SingleColumn][org.jetbrains.kotlinx.dataframe.columns.SingleColumn] and consists of a [column group][org.jetbrains.kotlinx.dataframe.columns.ColumnGroup],
     * then `cols` will create a subset of its contained columns.
     *
     * You can use either a [ColumnFilter][org.jetbrains.kotlinx.dataframe.ColumnFilter], or any of the `vararg` overloads for any
     * [Access API][org.jetbrains.kotlinx.dataframe.documentation.AccessApi].
     *
     * Aside from calling [cols][org.jetbrains.kotlinx.dataframe.api.ColsColumnsSelectionDsl.cols] directly, you can also use the [get][org.jetbrains.kotlinx.dataframe.columns.ColumnSet.get] operator in most cases.
     *
     * #### For example:
     * `df.`[remove][org.jetbrains.kotlinx.dataframe.DataFrame.remove]` { `[cols][org.jetbrains.kotlinx.dataframe.api.ColumnsSelectionDsl.cols]` { it.`[hasNulls][org.jetbrains.kotlinx.dataframe.DataColumn.hasNulls]`() }.`[recursively][ColumnsSelectionDsl.recursively]`() }`
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { myGroupCol.`[cols][org.jetbrains.kotlinx.dataframe.columns.SingleColumn.cols]`(columnA, columnB) }`
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { `[colsOf][org.jetbrains.kotlinx.dataframe.api.ColumnsSelectionDsl.colsOf]`<`[String][String]`>()`[`[`][org.jetbrains.kotlinx.dataframe.columns.ColumnSet.cols]`1, 3, 5`[`]`][org.jetbrains.kotlinx.dataframe.columns.ColumnSet.cols]` }`
     *
     * #### Examples for this overload:
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { myColumnGroup`.[cols][org.jetbrains.kotlinx.dataframe.columns.SingleColumn.cols]` { "e" `[in][String.contains]` it.`[name][org.jetbrains.kotlinx.dataframe.columns.ColumnPath.name]`() } }`
     *
     * `// same as `[all][org.jetbrains.kotlinx.dataframe.api.ColumnsSelectionDsl.all]`()`
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { myColumnGroup.`[cols][org.jetbrains.kotlinx.dataframe.columns.SingleColumn.cols]`() }`
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { myColumnGroup`[`[`][org.jetbrains.kotlinx.dataframe.columns.SingleColumn.cols]`{ ... }`[`]`][org.jetbrains.kotlinx.dataframe.columns.SingleColumn.cols]` }`
     *
     * &nbsp;&nbsp;&nbsp;&nbsp;
     *
     *
     *
     * #### Filter vs. Cols:
     * If used with a [predicate], `cols {}` functions exactly like [`filter {}`][ColumnsSelectionDsl.filter].
     * This is intentional, however; it is recommended to use `filter {}` on [ColumnSets][org.jetbrains.kotlinx.dataframe.columns.ColumnSet] and
     * `cols {}` on the rest.
     *
     * @param [predicate] A [ColumnFilter function][org.jetbrains.kotlinx.dataframe.ColumnFilter] that takes a [ColumnReference][org.jetbrains.kotlinx.dataframe.columns.ColumnReference] and returns a [Boolean].
     * @return A ([transformable][org.jetbrains.kotlinx.dataframe.impl.columns.TransformableColumnSet]) [ColumnSet][org.jetbrains.kotlinx.dataframe.columns.ColumnSet] containing the columns that match the given [predicate].
     * @see [all]
     */
    public operator fun SingleColumn<DataRow<*>>.get(
        predicate: ColumnFilter<*> = { true },
    ): TransformableColumnSet<*> = cols(predicate)

    /**
     * ## Cols
     * Creates a subset of columns ([ColumnSet][org.jetbrains.kotlinx.dataframe.columns.ColumnSet]) from the current [ColumnsResolver][org.jetbrains.kotlinx.dataframe.columns.ColumnsResolver].
     *
     * If the current [ColumnsResolver][org.jetbrains.kotlinx.dataframe.columns.ColumnsResolver] is a [SingleColumn][org.jetbrains.kotlinx.dataframe.columns.SingleColumn] and consists of a [column group][org.jetbrains.kotlinx.dataframe.columns.ColumnGroup],
     * then `cols` will create a subset of its contained columns.
     *
     * You can use either a [ColumnFilter][org.jetbrains.kotlinx.dataframe.ColumnFilter], or any of the `vararg` overloads for any
     * [Access API][org.jetbrains.kotlinx.dataframe.documentation.AccessApi].
     *
     * Aside from calling [cols][org.jetbrains.kotlinx.dataframe.api.ColsColumnsSelectionDsl.cols] directly, you can also use the [get][org.jetbrains.kotlinx.dataframe.columns.ColumnSet.get] operator in most cases.
     *
     * #### For example:
     * `df.`[remove][org.jetbrains.kotlinx.dataframe.DataFrame.remove]` { `[cols][org.jetbrains.kotlinx.dataframe.api.ColumnsSelectionDsl.cols]` { it.`[hasNulls][org.jetbrains.kotlinx.dataframe.DataColumn.hasNulls]`() }.`[recursively][ColumnsSelectionDsl.recursively]`() }`
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { myGroupCol.`[cols][org.jetbrains.kotlinx.dataframe.columns.SingleColumn.cols]`(columnA, columnB) }`
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { `[colsOf][org.jetbrains.kotlinx.dataframe.api.ColumnsSelectionDsl.colsOf]`<`[String][String]`>()`[`[`][org.jetbrains.kotlinx.dataframe.columns.ColumnSet.cols]`1, 3, 5`[`]`][org.jetbrains.kotlinx.dataframe.columns.ColumnSet.cols]` }`
     *
     * #### Examples for this overload:
     *
     * `df.`[select][DataFrame.select]` { "myGroupCol".`[cols][String.cols]` { "e" `[in][String.contains]` it.`[name][ColumnPath.name]`() } }`
     *
     * `df.`[select][DataFrame.select]` { "myGroupCol"`[`[`][String.cols]`{ it.`[any][ColumnWithPath.any]` { it == "Alice" } }`[`]`][String.cols]` }`
     *
     * `// same as `[all][all]`()`
     *
     * `df.`[select][DataFrame.select]` { "myGroupCol".`[cols][String.cols]`() }`
     *
     *
     * #### Filter vs. Cols:
     * If used with a [predicate], `cols {}` functions exactly like [`filter {}`][ColumnsSelectionDsl.filter].
     * This is intentional, however; it is recommended to use `filter {}` on [ColumnSets][org.jetbrains.kotlinx.dataframe.columns.ColumnSet] and
     * `cols {}` on the rest.
     *
     * @param [predicate] A [ColumnFilter function][org.jetbrains.kotlinx.dataframe.ColumnFilter] that takes a [ColumnReference][org.jetbrains.kotlinx.dataframe.columns.ColumnReference] and returns a [Boolean].
     * @return A ([transformable][org.jetbrains.kotlinx.dataframe.impl.columns.TransformableColumnSet]) [ColumnSet][org.jetbrains.kotlinx.dataframe.columns.ColumnSet] containing the columns that match the given [predicate].
     */
    private interface StringColsPredicateDocs

    /** ## Cols
     * Creates a subset of columns ([ColumnSet][org.jetbrains.kotlinx.dataframe.columns.ColumnSet]) from the current [ColumnsResolver][org.jetbrains.kotlinx.dataframe.columns.ColumnsResolver].
     *
     * If the current [ColumnsResolver][org.jetbrains.kotlinx.dataframe.columns.ColumnsResolver] is a [SingleColumn][org.jetbrains.kotlinx.dataframe.columns.SingleColumn] and consists of a [column group][org.jetbrains.kotlinx.dataframe.columns.ColumnGroup],
     * then `cols` will create a subset of its contained columns.
     *
     * You can use either a [ColumnFilter][org.jetbrains.kotlinx.dataframe.ColumnFilter], or any of the `vararg` overloads for any
     * [Access API][org.jetbrains.kotlinx.dataframe.documentation.AccessApi].
     *
     * Aside from calling [cols][org.jetbrains.kotlinx.dataframe.api.ColsColumnsSelectionDsl.cols] directly, you can also use the [get][org.jetbrains.kotlinx.dataframe.columns.ColumnSet.get] operator in most cases.
     *
     * #### For example:
     * `df.`[remove][org.jetbrains.kotlinx.dataframe.DataFrame.remove]` { `[cols][org.jetbrains.kotlinx.dataframe.api.ColumnsSelectionDsl.cols]` { it.`[hasNulls][org.jetbrains.kotlinx.dataframe.DataColumn.hasNulls]`() }.`[recursively][ColumnsSelectionDsl.recursively]`() }`
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { myGroupCol.`[cols][org.jetbrains.kotlinx.dataframe.columns.SingleColumn.cols]`(columnA, columnB) }`
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { `[colsOf][org.jetbrains.kotlinx.dataframe.api.ColumnsSelectionDsl.colsOf]`<`[String][String]`>()`[`[`][org.jetbrains.kotlinx.dataframe.columns.ColumnSet.cols]`1, 3, 5`[`]`][org.jetbrains.kotlinx.dataframe.columns.ColumnSet.cols]` }`
     *
     * #### Examples for this overload:
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { "myGroupCol".`[cols][kotlin.String.cols]` { "e" `[in][String.contains]` it.`[name][org.jetbrains.kotlinx.dataframe.columns.ColumnPath.name]`() } }`
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { "myGroupCol"`[`[`][kotlin.String.cols]`{ it.`[any][ColumnWithPath.any]` { it == "Alice" } }`[`]`][kotlin.String.cols]` }`
     *
     * `// same as `[all][org.jetbrains.kotlinx.dataframe.api.all]`()`
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { "myGroupCol".`[cols][kotlin.String.cols]`() }`
     *
     *
     * #### Filter vs. Cols:
     * If used with a [predicate], `cols {}` functions exactly like [`filter {}`][ColumnsSelectionDsl.filter].
     * This is intentional, however; it is recommended to use `filter {}` on [ColumnSets][org.jetbrains.kotlinx.dataframe.columns.ColumnSet] and
     * `cols {}` on the rest.
     *
     * @param [predicate] A [ColumnFilter function][org.jetbrains.kotlinx.dataframe.ColumnFilter] that takes a [ColumnReference][org.jetbrains.kotlinx.dataframe.columns.ColumnReference] and returns a [Boolean].
     * @return A ([transformable][org.jetbrains.kotlinx.dataframe.impl.columns.TransformableColumnSet]) [ColumnSet][org.jetbrains.kotlinx.dataframe.columns.ColumnSet] containing the columns that match the given [predicate].
     */
    public fun String.cols(
        predicate: ColumnFilter<*> = { true },
    ): TransformableColumnSet<*> = columnGroup(this).cols(predicate)

    /** ## Cols
     * Creates a subset of columns ([ColumnSet][org.jetbrains.kotlinx.dataframe.columns.ColumnSet]) from the current [ColumnsResolver][org.jetbrains.kotlinx.dataframe.columns.ColumnsResolver].
     *
     * If the current [ColumnsResolver][org.jetbrains.kotlinx.dataframe.columns.ColumnsResolver] is a [SingleColumn][org.jetbrains.kotlinx.dataframe.columns.SingleColumn] and consists of a [column group][org.jetbrains.kotlinx.dataframe.columns.ColumnGroup],
     * then `cols` will create a subset of its contained columns.
     *
     * You can use either a [ColumnFilter][org.jetbrains.kotlinx.dataframe.ColumnFilter], or any of the `vararg` overloads for any
     * [Access API][org.jetbrains.kotlinx.dataframe.documentation.AccessApi].
     *
     * Aside from calling [cols][org.jetbrains.kotlinx.dataframe.api.ColsColumnsSelectionDsl.cols] directly, you can also use the [get][org.jetbrains.kotlinx.dataframe.columns.ColumnSet.get] operator in most cases.
     *
     * #### For example:
     * `df.`[remove][org.jetbrains.kotlinx.dataframe.DataFrame.remove]` { `[cols][org.jetbrains.kotlinx.dataframe.api.ColumnsSelectionDsl.cols]` { it.`[hasNulls][org.jetbrains.kotlinx.dataframe.DataColumn.hasNulls]`() }.`[recursively][ColumnsSelectionDsl.recursively]`() }`
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { myGroupCol.`[cols][org.jetbrains.kotlinx.dataframe.columns.SingleColumn.cols]`(columnA, columnB) }`
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { `[colsOf][org.jetbrains.kotlinx.dataframe.api.ColumnsSelectionDsl.colsOf]`<`[String][String]`>()`[`[`][org.jetbrains.kotlinx.dataframe.columns.ColumnSet.cols]`1, 3, 5`[`]`][org.jetbrains.kotlinx.dataframe.columns.ColumnSet.cols]` }`
     *
     * #### Examples for this overload:
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { "myGroupCol".`[cols][kotlin.String.cols]` { "e" `[in][String.contains]` it.`[name][org.jetbrains.kotlinx.dataframe.columns.ColumnPath.name]`() } }`
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { "myGroupCol"`[`[`][kotlin.String.cols]`{ it.`[any][ColumnWithPath.any]` { it == "Alice" } }`[`]`][kotlin.String.cols]` }`
     *
     * `// same as `[all][org.jetbrains.kotlinx.dataframe.api.all]`()`
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { "myGroupCol".`[cols][kotlin.String.cols]`() }`
     *
     *
     * #### Filter vs. Cols:
     * If used with a [predicate], `cols {}` functions exactly like [`filter {}`][ColumnsSelectionDsl.filter].
     * This is intentional, however; it is recommended to use `filter {}` on [ColumnSets][org.jetbrains.kotlinx.dataframe.columns.ColumnSet] and
     * `cols {}` on the rest.
     *
     * @param [predicate] A [ColumnFilter function][org.jetbrains.kotlinx.dataframe.ColumnFilter] that takes a [ColumnReference][org.jetbrains.kotlinx.dataframe.columns.ColumnReference] and returns a [Boolean].
     * @return A ([transformable][org.jetbrains.kotlinx.dataframe.impl.columns.TransformableColumnSet]) [ColumnSet][org.jetbrains.kotlinx.dataframe.columns.ColumnSet] containing the columns that match the given [predicate].
     */
    public operator fun String.get(
        predicate: ColumnFilter<*> = { true },
    ): TransformableColumnSet<*> = cols(predicate)

    /**
     * ## Cols
     * Creates a subset of columns ([ColumnSet][org.jetbrains.kotlinx.dataframe.columns.ColumnSet]) from the current [ColumnsResolver][org.jetbrains.kotlinx.dataframe.columns.ColumnsResolver].
     *
     * If the current [ColumnsResolver][org.jetbrains.kotlinx.dataframe.columns.ColumnsResolver] is a [SingleColumn][org.jetbrains.kotlinx.dataframe.columns.SingleColumn] and consists of a [column group][org.jetbrains.kotlinx.dataframe.columns.ColumnGroup],
     * then `cols` will create a subset of its contained columns.
     *
     * You can use either a [ColumnFilter][org.jetbrains.kotlinx.dataframe.ColumnFilter], or any of the `vararg` overloads for any
     * [Access API][org.jetbrains.kotlinx.dataframe.documentation.AccessApi].
     *
     * Aside from calling [cols][org.jetbrains.kotlinx.dataframe.api.ColsColumnsSelectionDsl.cols] directly, you can also use the [get][org.jetbrains.kotlinx.dataframe.columns.ColumnSet.get] operator in most cases.
     *
     * #### For example:
     * `df.`[remove][org.jetbrains.kotlinx.dataframe.DataFrame.remove]` { `[cols][org.jetbrains.kotlinx.dataframe.api.ColumnsSelectionDsl.cols]` { it.`[hasNulls][org.jetbrains.kotlinx.dataframe.DataColumn.hasNulls]`() }.`[recursively][ColumnsSelectionDsl.recursively]`() }`
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { myGroupCol.`[cols][org.jetbrains.kotlinx.dataframe.columns.SingleColumn.cols]`(columnA, columnB) }`
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { `[colsOf][org.jetbrains.kotlinx.dataframe.api.ColumnsSelectionDsl.colsOf]`<`[String][String]`>()`[`[`][org.jetbrains.kotlinx.dataframe.columns.ColumnSet.cols]`1, 3, 5`[`]`][org.jetbrains.kotlinx.dataframe.columns.ColumnSet.cols]` }`
     *
     * #### Examples for this overload:
     *
     * `df.`[select][DataFrame.select]` { Type::columnGroup.`[cols][KProperty.cols]` { "e" `[in][String.contains]` it.`[name][ColumnPath.name]`() } }`
     *
     * `df.`[select][DataFrame.select]` { Type::columnGroup`[`[`][SingleColumn.cols]`{ it.`[any][ColumnWithPath.any]` { it == "Alice" } }`[`]`][SingleColumn.cols]` }`
     *
     * `// same as `[all][all]`()`
     *
     * `df.`[select][DataFrame.select]` { Type::columnGroup.`[cols][SingleColumn.cols]`() }`
     *
     * @see [all]
     *
     *
     * #### Filter vs. Cols:
     * If used with a [predicate], `cols {}` functions exactly like [`filter {}`][ColumnsSelectionDsl.filter].
     * This is intentional, however; it is recommended to use `filter {}` on [ColumnSets][org.jetbrains.kotlinx.dataframe.columns.ColumnSet] and
     * `cols {}` on the rest.
     *
     * @param [predicate] A [ColumnFilter function][org.jetbrains.kotlinx.dataframe.ColumnFilter] that takes a [ColumnReference][org.jetbrains.kotlinx.dataframe.columns.ColumnReference] and returns a [Boolean].
     * @return A ([transformable][org.jetbrains.kotlinx.dataframe.impl.columns.TransformableColumnSet]) [ColumnSet][org.jetbrains.kotlinx.dataframe.columns.ColumnSet] containing the columns that match the given [predicate].
     */
    private interface KPropertyColsPredicateDocs

    /** ## Cols
     * Creates a subset of columns ([ColumnSet][org.jetbrains.kotlinx.dataframe.columns.ColumnSet]) from the current [ColumnsResolver][org.jetbrains.kotlinx.dataframe.columns.ColumnsResolver].
     *
     * If the current [ColumnsResolver][org.jetbrains.kotlinx.dataframe.columns.ColumnsResolver] is a [SingleColumn][org.jetbrains.kotlinx.dataframe.columns.SingleColumn] and consists of a [column group][org.jetbrains.kotlinx.dataframe.columns.ColumnGroup],
     * then `cols` will create a subset of its contained columns.
     *
     * You can use either a [ColumnFilter][org.jetbrains.kotlinx.dataframe.ColumnFilter], or any of the `vararg` overloads for any
     * [Access API][org.jetbrains.kotlinx.dataframe.documentation.AccessApi].
     *
     * Aside from calling [cols][org.jetbrains.kotlinx.dataframe.api.ColsColumnsSelectionDsl.cols] directly, you can also use the [get][org.jetbrains.kotlinx.dataframe.columns.ColumnSet.get] operator in most cases.
     *
     * #### For example:
     * `df.`[remove][org.jetbrains.kotlinx.dataframe.DataFrame.remove]` { `[cols][org.jetbrains.kotlinx.dataframe.api.ColumnsSelectionDsl.cols]` { it.`[hasNulls][org.jetbrains.kotlinx.dataframe.DataColumn.hasNulls]`() }.`[recursively][ColumnsSelectionDsl.recursively]`() }`
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { myGroupCol.`[cols][org.jetbrains.kotlinx.dataframe.columns.SingleColumn.cols]`(columnA, columnB) }`
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { `[colsOf][org.jetbrains.kotlinx.dataframe.api.ColumnsSelectionDsl.colsOf]`<`[String][String]`>()`[`[`][org.jetbrains.kotlinx.dataframe.columns.ColumnSet.cols]`1, 3, 5`[`]`][org.jetbrains.kotlinx.dataframe.columns.ColumnSet.cols]` }`
     *
     * #### Examples for this overload:
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { Type::columnGroup.`[cols][kotlin.reflect.KProperty.cols]` { "e" `[in][String.contains]` it.`[name][org.jetbrains.kotlinx.dataframe.columns.ColumnPath.name]`() } }`
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { Type::columnGroup`[`[`][org.jetbrains.kotlinx.dataframe.columns.SingleColumn.cols]`{ it.`[any][ColumnWithPath.any]` { it == "Alice" } }`[`]`][org.jetbrains.kotlinx.dataframe.columns.SingleColumn.cols]` }`
     *
     * `// same as `[all][org.jetbrains.kotlinx.dataframe.api.all]`()`
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { Type::columnGroup.`[cols][org.jetbrains.kotlinx.dataframe.columns.SingleColumn.cols]`() }`
     *
     *
     * #### Filter vs. Cols:
     * If used with a [predicate], `cols {}` functions exactly like [`filter {}`][ColumnsSelectionDsl.filter].
     * This is intentional, however; it is recommended to use `filter {}` on [ColumnSets][org.jetbrains.kotlinx.dataframe.columns.ColumnSet] and
     * `cols {}` on the rest.
     *
     * @param [predicate] A [ColumnFilter function][org.jetbrains.kotlinx.dataframe.ColumnFilter] that takes a [ColumnReference][org.jetbrains.kotlinx.dataframe.columns.ColumnReference] and returns a [Boolean].
     * @return A ([transformable][org.jetbrains.kotlinx.dataframe.impl.columns.TransformableColumnSet]) [ColumnSet][org.jetbrains.kotlinx.dataframe.columns.ColumnSet] containing the columns that match the given [predicate].
     * @see [all] */
    public fun KProperty<*>.cols(
        predicate: ColumnFilter<*> = { true },
    ): TransformableColumnSet<*> = columnGroup(this).cols(predicate)

    /** ## Cols
     * Creates a subset of columns ([ColumnSet][org.jetbrains.kotlinx.dataframe.columns.ColumnSet]) from the current [ColumnsResolver][org.jetbrains.kotlinx.dataframe.columns.ColumnsResolver].
     *
     * If the current [ColumnsResolver][org.jetbrains.kotlinx.dataframe.columns.ColumnsResolver] is a [SingleColumn][org.jetbrains.kotlinx.dataframe.columns.SingleColumn] and consists of a [column group][org.jetbrains.kotlinx.dataframe.columns.ColumnGroup],
     * then `cols` will create a subset of its contained columns.
     *
     * You can use either a [ColumnFilter][org.jetbrains.kotlinx.dataframe.ColumnFilter], or any of the `vararg` overloads for any
     * [Access API][org.jetbrains.kotlinx.dataframe.documentation.AccessApi].
     *
     * Aside from calling [cols][org.jetbrains.kotlinx.dataframe.api.ColsColumnsSelectionDsl.cols] directly, you can also use the [get][org.jetbrains.kotlinx.dataframe.columns.ColumnSet.get] operator in most cases.
     *
     * #### For example:
     * `df.`[remove][org.jetbrains.kotlinx.dataframe.DataFrame.remove]` { `[cols][org.jetbrains.kotlinx.dataframe.api.ColumnsSelectionDsl.cols]` { it.`[hasNulls][org.jetbrains.kotlinx.dataframe.DataColumn.hasNulls]`() }.`[recursively][ColumnsSelectionDsl.recursively]`() }`
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { myGroupCol.`[cols][org.jetbrains.kotlinx.dataframe.columns.SingleColumn.cols]`(columnA, columnB) }`
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { `[colsOf][org.jetbrains.kotlinx.dataframe.api.ColumnsSelectionDsl.colsOf]`<`[String][String]`>()`[`[`][org.jetbrains.kotlinx.dataframe.columns.ColumnSet.cols]`1, 3, 5`[`]`][org.jetbrains.kotlinx.dataframe.columns.ColumnSet.cols]` }`
     *
     * #### Examples for this overload:
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { Type::columnGroup.`[cols][kotlin.reflect.KProperty.cols]` { "e" `[in][String.contains]` it.`[name][org.jetbrains.kotlinx.dataframe.columns.ColumnPath.name]`() } }`
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { Type::columnGroup`[`[`][org.jetbrains.kotlinx.dataframe.columns.SingleColumn.cols]`{ it.`[any][ColumnWithPath.any]` { it == "Alice" } }`[`]`][org.jetbrains.kotlinx.dataframe.columns.SingleColumn.cols]` }`
     *
     * `// same as `[all][org.jetbrains.kotlinx.dataframe.api.all]`()`
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { Type::columnGroup.`[cols][org.jetbrains.kotlinx.dataframe.columns.SingleColumn.cols]`() }`
     *
     *
     * #### Filter vs. Cols:
     * If used with a [predicate], `cols {}` functions exactly like [`filter {}`][ColumnsSelectionDsl.filter].
     * This is intentional, however; it is recommended to use `filter {}` on [ColumnSets][org.jetbrains.kotlinx.dataframe.columns.ColumnSet] and
     * `cols {}` on the rest.
     *
     * @param [predicate] A [ColumnFilter function][org.jetbrains.kotlinx.dataframe.ColumnFilter] that takes a [ColumnReference][org.jetbrains.kotlinx.dataframe.columns.ColumnReference] and returns a [Boolean].
     * @return A ([transformable][org.jetbrains.kotlinx.dataframe.impl.columns.TransformableColumnSet]) [ColumnSet][org.jetbrains.kotlinx.dataframe.columns.ColumnSet] containing the columns that match the given [predicate].
     * @see [all] */
    public operator fun KProperty<*>.get(
        predicate: ColumnFilter<*> = { true },
    ): TransformableColumnSet<*> = cols(predicate)

    /**
     * ## Cols
     * Creates a subset of columns ([ColumnSet][org.jetbrains.kotlinx.dataframe.columns.ColumnSet]) from the current [ColumnsResolver][org.jetbrains.kotlinx.dataframe.columns.ColumnsResolver].
     *
     * If the current [ColumnsResolver][org.jetbrains.kotlinx.dataframe.columns.ColumnsResolver] is a [SingleColumn][org.jetbrains.kotlinx.dataframe.columns.SingleColumn] and consists of a [column group][org.jetbrains.kotlinx.dataframe.columns.ColumnGroup],
     * then `cols` will create a subset of its contained columns.
     *
     * You can use either a [ColumnFilter][org.jetbrains.kotlinx.dataframe.ColumnFilter], or any of the `vararg` overloads for any
     * [Access API][org.jetbrains.kotlinx.dataframe.documentation.AccessApi].
     *
     * Aside from calling [cols][org.jetbrains.kotlinx.dataframe.api.ColsColumnsSelectionDsl.cols] directly, you can also use the [get][org.jetbrains.kotlinx.dataframe.columns.ColumnSet.get] operator in most cases.
     *
     * #### For example:
     * `df.`[remove][org.jetbrains.kotlinx.dataframe.DataFrame.remove]` { `[cols][org.jetbrains.kotlinx.dataframe.api.ColumnsSelectionDsl.cols]` { it.`[hasNulls][org.jetbrains.kotlinx.dataframe.DataColumn.hasNulls]`() }.`[recursively][ColumnsSelectionDsl.recursively]`() }`
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { myGroupCol.`[cols][org.jetbrains.kotlinx.dataframe.columns.SingleColumn.cols]`(columnA, columnB) }`
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { `[colsOf][org.jetbrains.kotlinx.dataframe.api.ColumnsSelectionDsl.colsOf]`<`[String][String]`>()`[`[`][org.jetbrains.kotlinx.dataframe.columns.ColumnSet.cols]`1, 3, 5`[`]`][org.jetbrains.kotlinx.dataframe.columns.ColumnSet.cols]` }`
     *
     * #### Examples for this overload:
     *
     * `df.`[select][DataFrame.select]` { "pathTo"["myGroupCol"].`[cols][ColumnPath.cols]` { "e" `[in][String.contains]` it.`[name][ColumnPath.name]`() } }`
     *
     * `df.`[select][DataFrame.select]` { "pathTo"["myGroupCol"]`[`[`][ColumnPath.cols]`{ it.`[any][ColumnWithPath.any]` { it == "Alice" } }`[`]`][ColumnPath.cols]` }`
     *
     * `df.`[select][DataFrame.select]` { "pathTo"["myGroupCol"].`[cols][ColumnPath.cols]`() } // identity call, same as `[all][all]
     *
     *
     * #### Filter vs. Cols:
     * If used with a [predicate], `cols {}` functions exactly like [`filter {}`][ColumnsSelectionDsl.filter].
     * This is intentional, however; it is recommended to use `filter {}` on [ColumnSets][org.jetbrains.kotlinx.dataframe.columns.ColumnSet] and
     * `cols {}` on the rest.
     *
     * @param [predicate] A [ColumnFilter function][org.jetbrains.kotlinx.dataframe.ColumnFilter] that takes a [ColumnReference][org.jetbrains.kotlinx.dataframe.columns.ColumnReference] and returns a [Boolean].
     * @return A ([transformable][org.jetbrains.kotlinx.dataframe.impl.columns.TransformableColumnSet]) [ColumnSet][org.jetbrains.kotlinx.dataframe.columns.ColumnSet] containing the columns that match the given [predicate].
     */
    private interface ColumnPathPredicateDocs

    /** ## Cols
     * Creates a subset of columns ([ColumnSet][org.jetbrains.kotlinx.dataframe.columns.ColumnSet]) from the current [ColumnsResolver][org.jetbrains.kotlinx.dataframe.columns.ColumnsResolver].
     *
     * If the current [ColumnsResolver][org.jetbrains.kotlinx.dataframe.columns.ColumnsResolver] is a [SingleColumn][org.jetbrains.kotlinx.dataframe.columns.SingleColumn] and consists of a [column group][org.jetbrains.kotlinx.dataframe.columns.ColumnGroup],
     * then `cols` will create a subset of its contained columns.
     *
     * You can use either a [ColumnFilter][org.jetbrains.kotlinx.dataframe.ColumnFilter], or any of the `vararg` overloads for any
     * [Access API][org.jetbrains.kotlinx.dataframe.documentation.AccessApi].
     *
     * Aside from calling [cols][org.jetbrains.kotlinx.dataframe.api.ColsColumnsSelectionDsl.cols] directly, you can also use the [get][org.jetbrains.kotlinx.dataframe.columns.ColumnSet.get] operator in most cases.
     *
     * #### For example:
     * `df.`[remove][org.jetbrains.kotlinx.dataframe.DataFrame.remove]` { `[cols][org.jetbrains.kotlinx.dataframe.api.ColumnsSelectionDsl.cols]` { it.`[hasNulls][org.jetbrains.kotlinx.dataframe.DataColumn.hasNulls]`() }.`[recursively][ColumnsSelectionDsl.recursively]`() }`
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { myGroupCol.`[cols][org.jetbrains.kotlinx.dataframe.columns.SingleColumn.cols]`(columnA, columnB) }`
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { `[colsOf][org.jetbrains.kotlinx.dataframe.api.ColumnsSelectionDsl.colsOf]`<`[String][String]`>()`[`[`][org.jetbrains.kotlinx.dataframe.columns.ColumnSet.cols]`1, 3, 5`[`]`][org.jetbrains.kotlinx.dataframe.columns.ColumnSet.cols]` }`
     *
     * #### Examples for this overload:
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { "pathTo"["myGroupCol"].`[cols][org.jetbrains.kotlinx.dataframe.columns.ColumnPath.cols]` { "e" `[in][String.contains]` it.`[name][org.jetbrains.kotlinx.dataframe.columns.ColumnPath.name]`() } }`
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { "pathTo"["myGroupCol"]`[`[`][org.jetbrains.kotlinx.dataframe.columns.ColumnPath.cols]`{ it.`[any][ColumnWithPath.any]` { it == "Alice" } }`[`]`][org.jetbrains.kotlinx.dataframe.columns.ColumnPath.cols]` }`
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { "pathTo"["myGroupCol"].`[cols][org.jetbrains.kotlinx.dataframe.columns.ColumnPath.cols]`() } // identity call, same as `[all][org.jetbrains.kotlinx.dataframe.api.all]
     *
     *
     * #### Filter vs. Cols:
     * If used with a [predicate], `cols {}` functions exactly like [`filter {}`][ColumnsSelectionDsl.filter].
     * This is intentional, however; it is recommended to use `filter {}` on [ColumnSets][org.jetbrains.kotlinx.dataframe.columns.ColumnSet] and
     * `cols {}` on the rest.
     *
     * @param [predicate] A [ColumnFilter function][org.jetbrains.kotlinx.dataframe.ColumnFilter] that takes a [ColumnReference][org.jetbrains.kotlinx.dataframe.columns.ColumnReference] and returns a [Boolean].
     * @return A ([transformable][org.jetbrains.kotlinx.dataframe.impl.columns.TransformableColumnSet]) [ColumnSet][org.jetbrains.kotlinx.dataframe.columns.ColumnSet] containing the columns that match the given [predicate].
     */
    public fun ColumnPath.cols(
        predicate: ColumnFilter<*> = { true },
    ): TransformableColumnSet<*> = columnGroup(this).cols(predicate)

    /** ## Cols
     * Creates a subset of columns ([ColumnSet][org.jetbrains.kotlinx.dataframe.columns.ColumnSet]) from the current [ColumnsResolver][org.jetbrains.kotlinx.dataframe.columns.ColumnsResolver].
     *
     * If the current [ColumnsResolver][org.jetbrains.kotlinx.dataframe.columns.ColumnsResolver] is a [SingleColumn][org.jetbrains.kotlinx.dataframe.columns.SingleColumn] and consists of a [column group][org.jetbrains.kotlinx.dataframe.columns.ColumnGroup],
     * then `cols` will create a subset of its contained columns.
     *
     * You can use either a [ColumnFilter][org.jetbrains.kotlinx.dataframe.ColumnFilter], or any of the `vararg` overloads for any
     * [Access API][org.jetbrains.kotlinx.dataframe.documentation.AccessApi].
     *
     * Aside from calling [cols][org.jetbrains.kotlinx.dataframe.api.ColsColumnsSelectionDsl.cols] directly, you can also use the [get][org.jetbrains.kotlinx.dataframe.columns.ColumnSet.get] operator in most cases.
     *
     * #### For example:
     * `df.`[remove][org.jetbrains.kotlinx.dataframe.DataFrame.remove]` { `[cols][org.jetbrains.kotlinx.dataframe.api.ColumnsSelectionDsl.cols]` { it.`[hasNulls][org.jetbrains.kotlinx.dataframe.DataColumn.hasNulls]`() }.`[recursively][ColumnsSelectionDsl.recursively]`() }`
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { myGroupCol.`[cols][org.jetbrains.kotlinx.dataframe.columns.SingleColumn.cols]`(columnA, columnB) }`
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { `[colsOf][org.jetbrains.kotlinx.dataframe.api.ColumnsSelectionDsl.colsOf]`<`[String][String]`>()`[`[`][org.jetbrains.kotlinx.dataframe.columns.ColumnSet.cols]`1, 3, 5`[`]`][org.jetbrains.kotlinx.dataframe.columns.ColumnSet.cols]` }`
     *
     * #### Examples for this overload:
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { "pathTo"["myGroupCol"].`[cols][org.jetbrains.kotlinx.dataframe.columns.ColumnPath.cols]` { "e" `[in][String.contains]` it.`[name][org.jetbrains.kotlinx.dataframe.columns.ColumnPath.name]`() } }`
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { "pathTo"["myGroupCol"]`[`[`][org.jetbrains.kotlinx.dataframe.columns.ColumnPath.cols]`{ it.`[any][ColumnWithPath.any]` { it == "Alice" } }`[`]`][org.jetbrains.kotlinx.dataframe.columns.ColumnPath.cols]` }`
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { "pathTo"["myGroupCol"].`[cols][org.jetbrains.kotlinx.dataframe.columns.ColumnPath.cols]`() } // identity call, same as `[all][org.jetbrains.kotlinx.dataframe.api.all]
     *
     *
     * #### Filter vs. Cols:
     * If used with a [predicate], `cols {}` functions exactly like [`filter {}`][ColumnsSelectionDsl.filter].
     * This is intentional, however; it is recommended to use `filter {}` on [ColumnSets][org.jetbrains.kotlinx.dataframe.columns.ColumnSet] and
     * `cols {}` on the rest.
     *
     * @param [predicate] A [ColumnFilter function][org.jetbrains.kotlinx.dataframe.ColumnFilter] that takes a [ColumnReference][org.jetbrains.kotlinx.dataframe.columns.ColumnReference] and returns a [Boolean].
     * @return A ([transformable][org.jetbrains.kotlinx.dataframe.impl.columns.TransformableColumnSet]) [ColumnSet][org.jetbrains.kotlinx.dataframe.columns.ColumnSet] containing the columns that match the given [predicate].
     */
    public operator fun ColumnPath.get(
        predicate: ColumnFilter<*> = { true },
    ): TransformableColumnSet<*> = cols(predicate)

    // endregion

    // region references

    /**
     * ## Cols
     * Creates a subset of columns ([ColumnSet][org.jetbrains.kotlinx.dataframe.columns.ColumnSet]) from the current [ColumnsResolver][org.jetbrains.kotlinx.dataframe.columns.ColumnsResolver].
     *
     * If the current [ColumnsResolver][org.jetbrains.kotlinx.dataframe.columns.ColumnsResolver] is a [SingleColumn][org.jetbrains.kotlinx.dataframe.columns.SingleColumn] and consists of a [column group][org.jetbrains.kotlinx.dataframe.columns.ColumnGroup],
     * then `cols` will create a subset of its contained columns.
     *
     * You can use either a [ColumnFilter][org.jetbrains.kotlinx.dataframe.ColumnFilter], or any of the `vararg` overloads for any
     * [Access API][org.jetbrains.kotlinx.dataframe.documentation.AccessApi].
     *
     * Aside from calling [cols][org.jetbrains.kotlinx.dataframe.api.ColsColumnsSelectionDsl.cols] directly, you can also use the [get][org.jetbrains.kotlinx.dataframe.columns.ColumnSet.get] operator in most cases.
     *
     * #### For example:
     * `df.`[remove][org.jetbrains.kotlinx.dataframe.DataFrame.remove]` { `[cols][org.jetbrains.kotlinx.dataframe.api.ColumnsSelectionDsl.cols]` { it.`[hasNulls][org.jetbrains.kotlinx.dataframe.DataColumn.hasNulls]`() }.`[recursively][ColumnsSelectionDsl.recursively]`() }`
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { myGroupCol.`[cols][org.jetbrains.kotlinx.dataframe.columns.SingleColumn.cols]`(columnA, columnB) }`
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { `[colsOf][org.jetbrains.kotlinx.dataframe.api.ColumnsSelectionDsl.colsOf]`<`[String][String]`>()`[`[`][org.jetbrains.kotlinx.dataframe.columns.ColumnSet.cols]`1, 3, 5`[`]`][org.jetbrains.kotlinx.dataframe.columns.ColumnSet.cols]` }`
     *
     * #### Examples for this overload:
     *
     * `df.`[select][DataFrame.select]` { `[colsOf][SingleColumn.colsOf]`<`[String][String]`>().`[cols][ColumnSet.cols]`(columnA, columnB) }`
     *
     * `df.`[select][DataFrame.select]` { `[colsOf][SingleColumn.colsOf]`<`[String][String]`>()`[`[`][ColumnSet.cols]`columnA, columnB`[`]`][ColumnSet.cols]` }`
     *
     * `df.`[select][DataFrame.select]` { `[colsOf][SingleColumn.colsOf]`<`[String][String]`>().`[cols][ColumnSet.cols]`("pathTo"["colA"], "pathTo"["colB"]) }`
     *
     *
     * @param [firstCol] A [ColumnReference] that points to a column.
     * @param [otherCols] Optional additional [ColumnReference]s that point to columns.
     * @return A ([transformable][org.jetbrains.kotlinx.dataframe.impl.columns.TransformableColumnSet]) [ColumnSet][org.jetbrains.kotlinx.dataframe.columns.ColumnSet] containing the columns that [firstCol] and [otherCols] point to. 
     */
    private interface ColumnSetColsVarargColumnReferenceDocs

    /** ## Cols
     * Creates a subset of columns ([ColumnSet][org.jetbrains.kotlinx.dataframe.columns.ColumnSet]) from the current [ColumnsResolver][org.jetbrains.kotlinx.dataframe.columns.ColumnsResolver].
     *
     * If the current [ColumnsResolver][org.jetbrains.kotlinx.dataframe.columns.ColumnsResolver] is a [SingleColumn][org.jetbrains.kotlinx.dataframe.columns.SingleColumn] and consists of a [column group][org.jetbrains.kotlinx.dataframe.columns.ColumnGroup],
     * then `cols` will create a subset of its contained columns.
     *
     * You can use either a [ColumnFilter][org.jetbrains.kotlinx.dataframe.ColumnFilter], or any of the `vararg` overloads for any
     * [Access API][org.jetbrains.kotlinx.dataframe.documentation.AccessApi].
     *
     * Aside from calling [cols][org.jetbrains.kotlinx.dataframe.api.ColsColumnsSelectionDsl.cols] directly, you can also use the [get][org.jetbrains.kotlinx.dataframe.columns.ColumnSet.get] operator in most cases.
     *
     * #### For example:
     * `df.`[remove][org.jetbrains.kotlinx.dataframe.DataFrame.remove]` { `[cols][org.jetbrains.kotlinx.dataframe.api.ColumnsSelectionDsl.cols]` { it.`[hasNulls][org.jetbrains.kotlinx.dataframe.DataColumn.hasNulls]`() }.`[recursively][ColumnsSelectionDsl.recursively]`() }`
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { myGroupCol.`[cols][org.jetbrains.kotlinx.dataframe.columns.SingleColumn.cols]`(columnA, columnB) }`
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { `[colsOf][org.jetbrains.kotlinx.dataframe.api.ColumnsSelectionDsl.colsOf]`<`[String][String]`>()`[`[`][org.jetbrains.kotlinx.dataframe.columns.ColumnSet.cols]`1, 3, 5`[`]`][org.jetbrains.kotlinx.dataframe.columns.ColumnSet.cols]` }`
     *
     * #### Examples for this overload:
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { `[colsOf][org.jetbrains.kotlinx.dataframe.columns.SingleColumn.colsOf]`<`[String][String]`>().`[cols][org.jetbrains.kotlinx.dataframe.columns.ColumnSet.cols]`(columnA, columnB) }`
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { `[colsOf][org.jetbrains.kotlinx.dataframe.columns.SingleColumn.colsOf]`<`[String][String]`>()`[`[`][org.jetbrains.kotlinx.dataframe.columns.ColumnSet.cols]`columnA, columnB`[`]`][org.jetbrains.kotlinx.dataframe.columns.ColumnSet.cols]` }`
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { `[colsOf][org.jetbrains.kotlinx.dataframe.columns.SingleColumn.colsOf]`<`[String][String]`>().`[cols][org.jetbrains.kotlinx.dataframe.columns.ColumnSet.cols]`("pathTo"["colA"], "pathTo"["colB"]) }`
     *
     *
     * @param [firstCol] A [ColumnReference][org.jetbrains.kotlinx.dataframe.columns.ColumnReference] that points to a column.
     * @param [otherCols] Optional additional [ColumnReference][org.jetbrains.kotlinx.dataframe.columns.ColumnReference]s that point to columns.
     * @return A ([transformable][org.jetbrains.kotlinx.dataframe.impl.columns.TransformableColumnSet]) [ColumnSet][org.jetbrains.kotlinx.dataframe.columns.ColumnSet] containing the columns that [firstCol] and [otherCols] point to. 
     */
    public fun <C> ColumnSet<C>.cols(
        firstCol: ColumnReference<C>,
        vararg otherCols: ColumnReference<C>,
    ): ColumnSet<C> = transformWithContext {
        dataFrameOf(it)
            .asColumnGroup()
            .cols(firstCol, *otherCols)
            .resolve(this)
    }

    /** ## Cols
     * Creates a subset of columns ([ColumnSet][org.jetbrains.kotlinx.dataframe.columns.ColumnSet]) from the current [ColumnsResolver][org.jetbrains.kotlinx.dataframe.columns.ColumnsResolver].
     *
     * If the current [ColumnsResolver][org.jetbrains.kotlinx.dataframe.columns.ColumnsResolver] is a [SingleColumn][org.jetbrains.kotlinx.dataframe.columns.SingleColumn] and consists of a [column group][org.jetbrains.kotlinx.dataframe.columns.ColumnGroup],
     * then `cols` will create a subset of its contained columns.
     *
     * You can use either a [ColumnFilter][org.jetbrains.kotlinx.dataframe.ColumnFilter], or any of the `vararg` overloads for any
     * [Access API][org.jetbrains.kotlinx.dataframe.documentation.AccessApi].
     *
     * Aside from calling [cols][org.jetbrains.kotlinx.dataframe.api.ColsColumnsSelectionDsl.cols] directly, you can also use the [get][org.jetbrains.kotlinx.dataframe.columns.ColumnSet.get] operator in most cases.
     *
     * #### For example:
     * `df.`[remove][org.jetbrains.kotlinx.dataframe.DataFrame.remove]` { `[cols][org.jetbrains.kotlinx.dataframe.api.ColumnsSelectionDsl.cols]` { it.`[hasNulls][org.jetbrains.kotlinx.dataframe.DataColumn.hasNulls]`() }.`[recursively][ColumnsSelectionDsl.recursively]`() }`
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { myGroupCol.`[cols][org.jetbrains.kotlinx.dataframe.columns.SingleColumn.cols]`(columnA, columnB) }`
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { `[colsOf][org.jetbrains.kotlinx.dataframe.api.ColumnsSelectionDsl.colsOf]`<`[String][String]`>()`[`[`][org.jetbrains.kotlinx.dataframe.columns.ColumnSet.cols]`1, 3, 5`[`]`][org.jetbrains.kotlinx.dataframe.columns.ColumnSet.cols]` }`
     *
     * #### Examples for this overload:
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { `[colsOf][org.jetbrains.kotlinx.dataframe.columns.SingleColumn.colsOf]`<`[String][String]`>().`[cols][org.jetbrains.kotlinx.dataframe.columns.ColumnSet.cols]`(columnA, columnB) }`
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { `[colsOf][org.jetbrains.kotlinx.dataframe.columns.SingleColumn.colsOf]`<`[String][String]`>()`[`[`][org.jetbrains.kotlinx.dataframe.columns.ColumnSet.cols]`columnA, columnB`[`]`][org.jetbrains.kotlinx.dataframe.columns.ColumnSet.cols]` }`
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { `[colsOf][org.jetbrains.kotlinx.dataframe.columns.SingleColumn.colsOf]`<`[String][String]`>().`[cols][org.jetbrains.kotlinx.dataframe.columns.ColumnSet.cols]`("pathTo"["colA"], "pathTo"["colB"]) }`
     *
     *
     * @param [firstCol] A [ColumnReference][org.jetbrains.kotlinx.dataframe.columns.ColumnReference] that points to a column.
     * @param [otherCols] Optional additional [ColumnReference][org.jetbrains.kotlinx.dataframe.columns.ColumnReference]s that point to columns.
     * @return A ([transformable][org.jetbrains.kotlinx.dataframe.impl.columns.TransformableColumnSet]) [ColumnSet][org.jetbrains.kotlinx.dataframe.columns.ColumnSet] containing the columns that [firstCol] and [otherCols] point to. 
     */
    public operator fun <C> ColumnSet<C>.get(
        firstCol: ColumnReference<C>,
        vararg otherCols: ColumnReference<C>,
    ): ColumnSet<C> = cols(firstCol, *otherCols)

    /**
     * ## Cols
     * Creates a subset of columns ([ColumnSet][org.jetbrains.kotlinx.dataframe.columns.ColumnSet]) from the current [ColumnsResolver][org.jetbrains.kotlinx.dataframe.columns.ColumnsResolver].
     *
     * If the current [ColumnsResolver][org.jetbrains.kotlinx.dataframe.columns.ColumnsResolver] is a [SingleColumn][org.jetbrains.kotlinx.dataframe.columns.SingleColumn] and consists of a [column group][org.jetbrains.kotlinx.dataframe.columns.ColumnGroup],
     * then `cols` will create a subset of its contained columns.
     *
     * You can use either a [ColumnFilter][org.jetbrains.kotlinx.dataframe.ColumnFilter], or any of the `vararg` overloads for any
     * [Access API][org.jetbrains.kotlinx.dataframe.documentation.AccessApi].
     *
     * Aside from calling [cols][org.jetbrains.kotlinx.dataframe.api.ColsColumnsSelectionDsl.cols] directly, you can also use the [get][org.jetbrains.kotlinx.dataframe.columns.ColumnSet.get] operator in most cases.
     *
     * #### For example:
     * `df.`[remove][org.jetbrains.kotlinx.dataframe.DataFrame.remove]` { `[cols][org.jetbrains.kotlinx.dataframe.api.ColumnsSelectionDsl.cols]` { it.`[hasNulls][org.jetbrains.kotlinx.dataframe.DataColumn.hasNulls]`() }.`[recursively][ColumnsSelectionDsl.recursively]`() }`
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { myGroupCol.`[cols][org.jetbrains.kotlinx.dataframe.columns.SingleColumn.cols]`(columnA, columnB) }`
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { `[colsOf][org.jetbrains.kotlinx.dataframe.api.ColumnsSelectionDsl.colsOf]`<`[String][String]`>()`[`[`][org.jetbrains.kotlinx.dataframe.columns.ColumnSet.cols]`1, 3, 5`[`]`][org.jetbrains.kotlinx.dataframe.columns.ColumnSet.cols]` }`
     *
     * #### Examples for this overload:
     *
     * `df.`[select][DataFrame.select]` { `[cols][ColumnsSelectionDsl.cols]`(columnA, columnB) }`
     *
     * `df.`[select][DataFrame.select]` { `[cols][ColumnsSelectionDsl.cols]`("pathTo"["colA"], "pathTo"["colB"]) }`
     *
     * `df.`[select][DataFrame.select]` { this`[`[`][ColumnsSelectionDsl.cols]`columnA, columnB`[`]`][ColumnsSelectionDsl.cols]` }`
     *
     *
     * @param [firstCol] A [ColumnReference] that points to a column.
     * @param [otherCols] Optional additional [ColumnReference]s that point to columns.
     * @return A ([transformable][org.jetbrains.kotlinx.dataframe.impl.columns.TransformableColumnSet]) [ColumnSet][org.jetbrains.kotlinx.dataframe.columns.ColumnSet] containing the columns that [firstCol] and [otherCols] point to. 
     */
    private interface ColumnsSelectionDslColsVarargColumnReferenceDocs

    /** ## Cols
     * Creates a subset of columns ([ColumnSet][org.jetbrains.kotlinx.dataframe.columns.ColumnSet]) from the current [ColumnsResolver][org.jetbrains.kotlinx.dataframe.columns.ColumnsResolver].
     *
     * If the current [ColumnsResolver][org.jetbrains.kotlinx.dataframe.columns.ColumnsResolver] is a [SingleColumn][org.jetbrains.kotlinx.dataframe.columns.SingleColumn] and consists of a [column group][org.jetbrains.kotlinx.dataframe.columns.ColumnGroup],
     * then `cols` will create a subset of its contained columns.
     *
     * You can use either a [ColumnFilter][org.jetbrains.kotlinx.dataframe.ColumnFilter], or any of the `vararg` overloads for any
     * [Access API][org.jetbrains.kotlinx.dataframe.documentation.AccessApi].
     *
     * Aside from calling [cols][org.jetbrains.kotlinx.dataframe.api.ColsColumnsSelectionDsl.cols] directly, you can also use the [get][org.jetbrains.kotlinx.dataframe.columns.ColumnSet.get] operator in most cases.
     *
     * #### For example:
     * `df.`[remove][org.jetbrains.kotlinx.dataframe.DataFrame.remove]` { `[cols][org.jetbrains.kotlinx.dataframe.api.ColumnsSelectionDsl.cols]` { it.`[hasNulls][org.jetbrains.kotlinx.dataframe.DataColumn.hasNulls]`() }.`[recursively][ColumnsSelectionDsl.recursively]`() }`
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { myGroupCol.`[cols][org.jetbrains.kotlinx.dataframe.columns.SingleColumn.cols]`(columnA, columnB) }`
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { `[colsOf][org.jetbrains.kotlinx.dataframe.api.ColumnsSelectionDsl.colsOf]`<`[String][String]`>()`[`[`][org.jetbrains.kotlinx.dataframe.columns.ColumnSet.cols]`1, 3, 5`[`]`][org.jetbrains.kotlinx.dataframe.columns.ColumnSet.cols]` }`
     *
     * #### Examples for this overload:
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { `[cols][org.jetbrains.kotlinx.dataframe.api.ColumnsSelectionDsl.cols]`(columnA, columnB) }`
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { `[cols][org.jetbrains.kotlinx.dataframe.api.ColumnsSelectionDsl.cols]`("pathTo"["colA"], "pathTo"["colB"]) }`
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { this`[`[`][org.jetbrains.kotlinx.dataframe.api.ColumnsSelectionDsl.cols]`columnA, columnB`[`]`][org.jetbrains.kotlinx.dataframe.api.ColumnsSelectionDsl.cols]` }`
     *
     *
     * @param [firstCol] A [ColumnReference][org.jetbrains.kotlinx.dataframe.columns.ColumnReference] that points to a column.
     * @param [otherCols] Optional additional [ColumnReference][org.jetbrains.kotlinx.dataframe.columns.ColumnReference]s that point to columns.
     * @return A ([transformable][org.jetbrains.kotlinx.dataframe.impl.columns.TransformableColumnSet]) [ColumnSet][org.jetbrains.kotlinx.dataframe.columns.ColumnSet] containing the columns that [firstCol] and [otherCols] point to. 
     */
    public fun <C> ColumnsSelectionDsl<*>.cols(
        firstCol: ColumnReference<C>,
        vararg otherCols: ColumnReference<C>,
    ): ColumnSet<C> = this.asSingleColumn().cols(firstCol, *otherCols)

    /** ## Cols
     * Creates a subset of columns ([ColumnSet][org.jetbrains.kotlinx.dataframe.columns.ColumnSet]) from the current [ColumnsResolver][org.jetbrains.kotlinx.dataframe.columns.ColumnsResolver].
     *
     * If the current [ColumnsResolver][org.jetbrains.kotlinx.dataframe.columns.ColumnsResolver] is a [SingleColumn][org.jetbrains.kotlinx.dataframe.columns.SingleColumn] and consists of a [column group][org.jetbrains.kotlinx.dataframe.columns.ColumnGroup],
     * then `cols` will create a subset of its contained columns.
     *
     * You can use either a [ColumnFilter][org.jetbrains.kotlinx.dataframe.ColumnFilter], or any of the `vararg` overloads for any
     * [Access API][org.jetbrains.kotlinx.dataframe.documentation.AccessApi].
     *
     * Aside from calling [cols][org.jetbrains.kotlinx.dataframe.api.ColsColumnsSelectionDsl.cols] directly, you can also use the [get][org.jetbrains.kotlinx.dataframe.columns.ColumnSet.get] operator in most cases.
     *
     * #### For example:
     * `df.`[remove][org.jetbrains.kotlinx.dataframe.DataFrame.remove]` { `[cols][org.jetbrains.kotlinx.dataframe.api.ColumnsSelectionDsl.cols]` { it.`[hasNulls][org.jetbrains.kotlinx.dataframe.DataColumn.hasNulls]`() }.`[recursively][ColumnsSelectionDsl.recursively]`() }`
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { myGroupCol.`[cols][org.jetbrains.kotlinx.dataframe.columns.SingleColumn.cols]`(columnA, columnB) }`
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { `[colsOf][org.jetbrains.kotlinx.dataframe.api.ColumnsSelectionDsl.colsOf]`<`[String][String]`>()`[`[`][org.jetbrains.kotlinx.dataframe.columns.ColumnSet.cols]`1, 3, 5`[`]`][org.jetbrains.kotlinx.dataframe.columns.ColumnSet.cols]` }`
     *
     * #### Examples for this overload:
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { `[cols][org.jetbrains.kotlinx.dataframe.api.ColumnsSelectionDsl.cols]`(columnA, columnB) }`
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { `[cols][org.jetbrains.kotlinx.dataframe.api.ColumnsSelectionDsl.cols]`("pathTo"["colA"], "pathTo"["colB"]) }`
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { this`[`[`][org.jetbrains.kotlinx.dataframe.api.ColumnsSelectionDsl.cols]`columnA, columnB`[`]`][org.jetbrains.kotlinx.dataframe.api.ColumnsSelectionDsl.cols]` }`
     *
     *
     * @param [firstCol] A [ColumnReference][org.jetbrains.kotlinx.dataframe.columns.ColumnReference] that points to a column.
     * @param [otherCols] Optional additional [ColumnReference][org.jetbrains.kotlinx.dataframe.columns.ColumnReference]s that point to columns.
     * @return A ([transformable][org.jetbrains.kotlinx.dataframe.impl.columns.TransformableColumnSet]) [ColumnSet][org.jetbrains.kotlinx.dataframe.columns.ColumnSet] containing the columns that [firstCol] and [otherCols] point to. 
     */
    public operator fun <C> ColumnsSelectionDsl<*>.get(
        firstCol: ColumnReference<C>,
        vararg otherCols: ColumnReference<C>,
    ): ColumnSet<C> = cols(firstCol, *otherCols)

    /**
     * ## Cols
     * Creates a subset of columns ([ColumnSet][org.jetbrains.kotlinx.dataframe.columns.ColumnSet]) from the current [ColumnsResolver][org.jetbrains.kotlinx.dataframe.columns.ColumnsResolver].
     *
     * If the current [ColumnsResolver][org.jetbrains.kotlinx.dataframe.columns.ColumnsResolver] is a [SingleColumn][org.jetbrains.kotlinx.dataframe.columns.SingleColumn] and consists of a [column group][org.jetbrains.kotlinx.dataframe.columns.ColumnGroup],
     * then `cols` will create a subset of its contained columns.
     *
     * You can use either a [ColumnFilter][org.jetbrains.kotlinx.dataframe.ColumnFilter], or any of the `vararg` overloads for any
     * [Access API][org.jetbrains.kotlinx.dataframe.documentation.AccessApi].
     *
     * Aside from calling [cols][org.jetbrains.kotlinx.dataframe.api.ColsColumnsSelectionDsl.cols] directly, you can also use the [get][org.jetbrains.kotlinx.dataframe.columns.ColumnSet.get] operator in most cases.
     *
     * #### For example:
     * `df.`[remove][org.jetbrains.kotlinx.dataframe.DataFrame.remove]` { `[cols][org.jetbrains.kotlinx.dataframe.api.ColumnsSelectionDsl.cols]` { it.`[hasNulls][org.jetbrains.kotlinx.dataframe.DataColumn.hasNulls]`() }.`[recursively][ColumnsSelectionDsl.recursively]`() }`
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { myGroupCol.`[cols][org.jetbrains.kotlinx.dataframe.columns.SingleColumn.cols]`(columnA, columnB) }`
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { `[colsOf][org.jetbrains.kotlinx.dataframe.api.ColumnsSelectionDsl.colsOf]`<`[String][String]`>()`[`[`][org.jetbrains.kotlinx.dataframe.columns.ColumnSet.cols]`1, 3, 5`[`]`][org.jetbrains.kotlinx.dataframe.columns.ColumnSet.cols]` }`
     *
     * #### Examples for this overload:
     *
     * `df.`[select][DataFrame.select]` { myColumnGroup.`[cols][SingleColumn.cols]`(columnA, columnB) }`
     *
     * `df.`[select][DataFrame.select]` { myColumnGroup`[`[`][SingleColumn.cols]`columnA, columnB`[`]`][SingleColumn.cols]` }`
     *
     *
     * @param [firstCol] A [ColumnReference] that points to a column.
     * @param [otherCols] Optional additional [ColumnReference]s that point to columns.
     * @return A ([transformable][org.jetbrains.kotlinx.dataframe.impl.columns.TransformableColumnSet]) [ColumnSet][org.jetbrains.kotlinx.dataframe.columns.ColumnSet] containing the columns that [firstCol] and [otherCols] point to. 
     */
    private interface SingleColumnColsVarargColumnReferenceDocs

    /** ## Cols
     * Creates a subset of columns ([ColumnSet][org.jetbrains.kotlinx.dataframe.columns.ColumnSet]) from the current [ColumnsResolver][org.jetbrains.kotlinx.dataframe.columns.ColumnsResolver].
     *
     * If the current [ColumnsResolver][org.jetbrains.kotlinx.dataframe.columns.ColumnsResolver] is a [SingleColumn][org.jetbrains.kotlinx.dataframe.columns.SingleColumn] and consists of a [column group][org.jetbrains.kotlinx.dataframe.columns.ColumnGroup],
     * then `cols` will create a subset of its contained columns.
     *
     * You can use either a [ColumnFilter][org.jetbrains.kotlinx.dataframe.ColumnFilter], or any of the `vararg` overloads for any
     * [Access API][org.jetbrains.kotlinx.dataframe.documentation.AccessApi].
     *
     * Aside from calling [cols][org.jetbrains.kotlinx.dataframe.api.ColsColumnsSelectionDsl.cols] directly, you can also use the [get][org.jetbrains.kotlinx.dataframe.columns.ColumnSet.get] operator in most cases.
     *
     * #### For example:
     * `df.`[remove][org.jetbrains.kotlinx.dataframe.DataFrame.remove]` { `[cols][org.jetbrains.kotlinx.dataframe.api.ColumnsSelectionDsl.cols]` { it.`[hasNulls][org.jetbrains.kotlinx.dataframe.DataColumn.hasNulls]`() }.`[recursively][ColumnsSelectionDsl.recursively]`() }`
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { myGroupCol.`[cols][org.jetbrains.kotlinx.dataframe.columns.SingleColumn.cols]`(columnA, columnB) }`
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { `[colsOf][org.jetbrains.kotlinx.dataframe.api.ColumnsSelectionDsl.colsOf]`<`[String][String]`>()`[`[`][org.jetbrains.kotlinx.dataframe.columns.ColumnSet.cols]`1, 3, 5`[`]`][org.jetbrains.kotlinx.dataframe.columns.ColumnSet.cols]` }`
     *
     * #### Examples for this overload:
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { myColumnGroup.`[cols][org.jetbrains.kotlinx.dataframe.columns.SingleColumn.cols]`(columnA, columnB) }`
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { myColumnGroup`[`[`][org.jetbrains.kotlinx.dataframe.columns.SingleColumn.cols]`columnA, columnB`[`]`][org.jetbrains.kotlinx.dataframe.columns.SingleColumn.cols]` }`
     *
     *
     * @param [firstCol] A [ColumnReference][org.jetbrains.kotlinx.dataframe.columns.ColumnReference] that points to a column.
     * @param [otherCols] Optional additional [ColumnReference][org.jetbrains.kotlinx.dataframe.columns.ColumnReference]s that point to columns.
     * @return A ([transformable][org.jetbrains.kotlinx.dataframe.impl.columns.TransformableColumnSet]) [ColumnSet][org.jetbrains.kotlinx.dataframe.columns.ColumnSet] containing the columns that [firstCol] and [otherCols] point to. 
     */
    public fun <C> SingleColumn<DataRow<*>>.cols(
        firstCol: ColumnReference<C>,
        vararg otherCols: ColumnReference<C>,
    ): ColumnSet<C> = headPlusArray(firstCol, otherCols).let { refs ->
        ensureIsColGroup().asColumnSet().transform {
            it.flatMap { col -> refs.mapNotNull { col.getChild(it) } }
        }
    }

    /**
     * ## Cols
     * Creates a subset of columns ([ColumnSet][org.jetbrains.kotlinx.dataframe.columns.ColumnSet]) from the current [ColumnsResolver][org.jetbrains.kotlinx.dataframe.columns.ColumnsResolver].
     *
     * If the current [ColumnsResolver][org.jetbrains.kotlinx.dataframe.columns.ColumnsResolver] is a [SingleColumn][org.jetbrains.kotlinx.dataframe.columns.SingleColumn] and consists of a [column group][org.jetbrains.kotlinx.dataframe.columns.ColumnGroup],
     * then `cols` will create a subset of its contained columns.
     *
     * You can use either a [ColumnFilter][org.jetbrains.kotlinx.dataframe.ColumnFilter], or any of the `vararg` overloads for any
     * [Access API][org.jetbrains.kotlinx.dataframe.documentation.AccessApi].
     *
     * Aside from calling [cols][org.jetbrains.kotlinx.dataframe.api.ColsColumnsSelectionDsl.cols] directly, you can also use the [get][org.jetbrains.kotlinx.dataframe.columns.ColumnSet.get] operator in most cases.
     *
     * #### For example:
     * `df.`[remove][org.jetbrains.kotlinx.dataframe.DataFrame.remove]` { `[cols][org.jetbrains.kotlinx.dataframe.api.ColumnsSelectionDsl.cols]` { it.`[hasNulls][org.jetbrains.kotlinx.dataframe.DataColumn.hasNulls]`() }.`[recursively][ColumnsSelectionDsl.recursively]`() }`
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { myGroupCol.`[cols][org.jetbrains.kotlinx.dataframe.columns.SingleColumn.cols]`(columnA, columnB) }`
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { `[colsOf][org.jetbrains.kotlinx.dataframe.api.ColumnsSelectionDsl.colsOf]`<`[String][String]`>()`[`[`][org.jetbrains.kotlinx.dataframe.columns.ColumnSet.cols]`1, 3, 5`[`]`][org.jetbrains.kotlinx.dataframe.columns.ColumnSet.cols]` }`
     *
     * #### Examples for this overload:
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { myColumnGroup.`[cols][org.jetbrains.kotlinx.dataframe.columns.SingleColumn.cols]`(columnA, columnB) }`
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { myColumnGroup`[`[`][org.jetbrains.kotlinx.dataframe.columns.SingleColumn.cols]`columnA, columnB`[`]`][org.jetbrains.kotlinx.dataframe.columns.SingleColumn.cols]` }`
     *
     *
     * @param [firstCol] A [ColumnReference][org.jetbrains.kotlinx.dataframe.columns.ColumnReference] that points to a column.
     * @param [otherCols] Optional additional [ColumnReference][org.jetbrains.kotlinx.dataframe.columns.ColumnReference]s that point to columns.
     * @return A ([transformable][org.jetbrains.kotlinx.dataframe.impl.columns.TransformableColumnSet]) [ColumnSet][org.jetbrains.kotlinx.dataframe.columns.ColumnSet] containing the columns that [firstCol] and [otherCols] point to. 
     */
    public operator fun <C> SingleColumn<DataRow<*>>.get(
        firstCol: ColumnReference<C>,
        vararg otherCols: ColumnReference<C>,
    ): ColumnSet<C> = cols(firstCol, *otherCols)

    /**
     * ## Cols
     * Creates a subset of columns ([ColumnSet][org.jetbrains.kotlinx.dataframe.columns.ColumnSet]) from the current [ColumnsResolver][org.jetbrains.kotlinx.dataframe.columns.ColumnsResolver].
     *
     * If the current [ColumnsResolver][org.jetbrains.kotlinx.dataframe.columns.ColumnsResolver] is a [SingleColumn][org.jetbrains.kotlinx.dataframe.columns.SingleColumn] and consists of a [column group][org.jetbrains.kotlinx.dataframe.columns.ColumnGroup],
     * then `cols` will create a subset of its contained columns.
     *
     * You can use either a [ColumnFilter][org.jetbrains.kotlinx.dataframe.ColumnFilter], or any of the `vararg` overloads for any
     * [Access API][org.jetbrains.kotlinx.dataframe.documentation.AccessApi].
     *
     * Aside from calling [cols][org.jetbrains.kotlinx.dataframe.api.ColsColumnsSelectionDsl.cols] directly, you can also use the [get][org.jetbrains.kotlinx.dataframe.columns.ColumnSet.get] operator in most cases.
     *
     * #### For example:
     * `df.`[remove][org.jetbrains.kotlinx.dataframe.DataFrame.remove]` { `[cols][org.jetbrains.kotlinx.dataframe.api.ColumnsSelectionDsl.cols]` { it.`[hasNulls][org.jetbrains.kotlinx.dataframe.DataColumn.hasNulls]`() }.`[recursively][ColumnsSelectionDsl.recursively]`() }`
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { myGroupCol.`[cols][org.jetbrains.kotlinx.dataframe.columns.SingleColumn.cols]`(columnA, columnB) }`
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { `[colsOf][org.jetbrains.kotlinx.dataframe.api.ColumnsSelectionDsl.colsOf]`<`[String][String]`>()`[`[`][org.jetbrains.kotlinx.dataframe.columns.ColumnSet.cols]`1, 3, 5`[`]`][org.jetbrains.kotlinx.dataframe.columns.ColumnSet.cols]` }`
     *
     * #### Examples for this overload:
     *
     * `df.`[select][DataFrame.select]` { "myColumnGroup".`[cols][String.cols]`(columnA, columnB) }`
     *
     * `df.`[select][DataFrame.select]` { "myColumnGroup".`[cols][String.cols]`("pathTo"["colA"], "pathTo"["colB"]) }`
     *
     * `df.`[select][DataFrame.select]` { "myColumnGroup"`[`[`][String.cols]`columnA, columnB`[`]`][String.cols]` }`
     *
     *
     * @param [firstCol] A [ColumnReference] that points to a column.
     * @param [otherCols] Optional additional [ColumnReference]s that point to columns.
     * @return A ([transformable][org.jetbrains.kotlinx.dataframe.impl.columns.TransformableColumnSet]) [ColumnSet][org.jetbrains.kotlinx.dataframe.columns.ColumnSet] containing the columns that [firstCol] and [otherCols] point to. 
     */
    private interface StringColsVarargColumnReferenceDocs

    /** ## Cols
     * Creates a subset of columns ([ColumnSet][org.jetbrains.kotlinx.dataframe.columns.ColumnSet]) from the current [ColumnsResolver][org.jetbrains.kotlinx.dataframe.columns.ColumnsResolver].
     *
     * If the current [ColumnsResolver][org.jetbrains.kotlinx.dataframe.columns.ColumnsResolver] is a [SingleColumn][org.jetbrains.kotlinx.dataframe.columns.SingleColumn] and consists of a [column group][org.jetbrains.kotlinx.dataframe.columns.ColumnGroup],
     * then `cols` will create a subset of its contained columns.
     *
     * You can use either a [ColumnFilter][org.jetbrains.kotlinx.dataframe.ColumnFilter], or any of the `vararg` overloads for any
     * [Access API][org.jetbrains.kotlinx.dataframe.documentation.AccessApi].
     *
     * Aside from calling [cols][org.jetbrains.kotlinx.dataframe.api.ColsColumnsSelectionDsl.cols] directly, you can also use the [get][org.jetbrains.kotlinx.dataframe.columns.ColumnSet.get] operator in most cases.
     *
     * #### For example:
     * `df.`[remove][org.jetbrains.kotlinx.dataframe.DataFrame.remove]` { `[cols][org.jetbrains.kotlinx.dataframe.api.ColumnsSelectionDsl.cols]` { it.`[hasNulls][org.jetbrains.kotlinx.dataframe.DataColumn.hasNulls]`() }.`[recursively][ColumnsSelectionDsl.recursively]`() }`
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { myGroupCol.`[cols][org.jetbrains.kotlinx.dataframe.columns.SingleColumn.cols]`(columnA, columnB) }`
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { `[colsOf][org.jetbrains.kotlinx.dataframe.api.ColumnsSelectionDsl.colsOf]`<`[String][String]`>()`[`[`][org.jetbrains.kotlinx.dataframe.columns.ColumnSet.cols]`1, 3, 5`[`]`][org.jetbrains.kotlinx.dataframe.columns.ColumnSet.cols]` }`
     *
     * #### Examples for this overload:
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { "myColumnGroup".`[cols][kotlin.String.cols]`(columnA, columnB) }`
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { "myColumnGroup".`[cols][kotlin.String.cols]`("pathTo"["colA"], "pathTo"["colB"]) }`
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { "myColumnGroup"`[`[`][kotlin.String.cols]`columnA, columnB`[`]`][kotlin.String.cols]` }`
     *
     *
     * @param [firstCol] A [ColumnReference][org.jetbrains.kotlinx.dataframe.columns.ColumnReference] that points to a column.
     * @param [otherCols] Optional additional [ColumnReference][org.jetbrains.kotlinx.dataframe.columns.ColumnReference]s that point to columns.
     * @return A ([transformable][org.jetbrains.kotlinx.dataframe.impl.columns.TransformableColumnSet]) [ColumnSet][org.jetbrains.kotlinx.dataframe.columns.ColumnSet] containing the columns that [firstCol] and [otherCols] point to. 
     */
    public fun <C> String.cols(
        firstCol: ColumnReference<C>,
        vararg otherCols: ColumnReference<C>,
    ): ColumnSet<C> = columnGroup(this).cols(firstCol, *otherCols)

    /** ## Cols
     * Creates a subset of columns ([ColumnSet][org.jetbrains.kotlinx.dataframe.columns.ColumnSet]) from the current [ColumnsResolver][org.jetbrains.kotlinx.dataframe.columns.ColumnsResolver].
     *
     * If the current [ColumnsResolver][org.jetbrains.kotlinx.dataframe.columns.ColumnsResolver] is a [SingleColumn][org.jetbrains.kotlinx.dataframe.columns.SingleColumn] and consists of a [column group][org.jetbrains.kotlinx.dataframe.columns.ColumnGroup],
     * then `cols` will create a subset of its contained columns.
     *
     * You can use either a [ColumnFilter][org.jetbrains.kotlinx.dataframe.ColumnFilter], or any of the `vararg` overloads for any
     * [Access API][org.jetbrains.kotlinx.dataframe.documentation.AccessApi].
     *
     * Aside from calling [cols][org.jetbrains.kotlinx.dataframe.api.ColsColumnsSelectionDsl.cols] directly, you can also use the [get][org.jetbrains.kotlinx.dataframe.columns.ColumnSet.get] operator in most cases.
     *
     * #### For example:
     * `df.`[remove][org.jetbrains.kotlinx.dataframe.DataFrame.remove]` { `[cols][org.jetbrains.kotlinx.dataframe.api.ColumnsSelectionDsl.cols]` { it.`[hasNulls][org.jetbrains.kotlinx.dataframe.DataColumn.hasNulls]`() }.`[recursively][ColumnsSelectionDsl.recursively]`() }`
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { myGroupCol.`[cols][org.jetbrains.kotlinx.dataframe.columns.SingleColumn.cols]`(columnA, columnB) }`
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { `[colsOf][org.jetbrains.kotlinx.dataframe.api.ColumnsSelectionDsl.colsOf]`<`[String][String]`>()`[`[`][org.jetbrains.kotlinx.dataframe.columns.ColumnSet.cols]`1, 3, 5`[`]`][org.jetbrains.kotlinx.dataframe.columns.ColumnSet.cols]` }`
     *
     * #### Examples for this overload:
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { "myColumnGroup".`[cols][kotlin.String.cols]`(columnA, columnB) }`
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { "myColumnGroup".`[cols][kotlin.String.cols]`("pathTo"["colA"], "pathTo"["colB"]) }`
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { "myColumnGroup"`[`[`][kotlin.String.cols]`columnA, columnB`[`]`][kotlin.String.cols]` }`
     *
     *
     * @param [firstCol] A [ColumnReference][org.jetbrains.kotlinx.dataframe.columns.ColumnReference] that points to a column.
     * @param [otherCols] Optional additional [ColumnReference][org.jetbrains.kotlinx.dataframe.columns.ColumnReference]s that point to columns.
     * @return A ([transformable][org.jetbrains.kotlinx.dataframe.impl.columns.TransformableColumnSet]) [ColumnSet][org.jetbrains.kotlinx.dataframe.columns.ColumnSet] containing the columns that [firstCol] and [otherCols] point to. 
     */
    public operator fun <C> String.get(
        firstCol: ColumnReference<C>,
        vararg otherCols: ColumnReference<C>,
    ): ColumnSet<C> = cols(firstCol, *otherCols)

    /**
     * ## Cols
     * Creates a subset of columns ([ColumnSet][org.jetbrains.kotlinx.dataframe.columns.ColumnSet]) from the current [ColumnsResolver][org.jetbrains.kotlinx.dataframe.columns.ColumnsResolver].
     *
     * If the current [ColumnsResolver][org.jetbrains.kotlinx.dataframe.columns.ColumnsResolver] is a [SingleColumn][org.jetbrains.kotlinx.dataframe.columns.SingleColumn] and consists of a [column group][org.jetbrains.kotlinx.dataframe.columns.ColumnGroup],
     * then `cols` will create a subset of its contained columns.
     *
     * You can use either a [ColumnFilter][org.jetbrains.kotlinx.dataframe.ColumnFilter], or any of the `vararg` overloads for any
     * [Access API][org.jetbrains.kotlinx.dataframe.documentation.AccessApi].
     *
     * Aside from calling [cols][org.jetbrains.kotlinx.dataframe.api.ColsColumnsSelectionDsl.cols] directly, you can also use the [get][org.jetbrains.kotlinx.dataframe.columns.ColumnSet.get] operator in most cases.
     *
     * #### For example:
     * `df.`[remove][org.jetbrains.kotlinx.dataframe.DataFrame.remove]` { `[cols][org.jetbrains.kotlinx.dataframe.api.ColumnsSelectionDsl.cols]` { it.`[hasNulls][org.jetbrains.kotlinx.dataframe.DataColumn.hasNulls]`() }.`[recursively][ColumnsSelectionDsl.recursively]`() }`
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { myGroupCol.`[cols][org.jetbrains.kotlinx.dataframe.columns.SingleColumn.cols]`(columnA, columnB) }`
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { `[colsOf][org.jetbrains.kotlinx.dataframe.api.ColumnsSelectionDsl.colsOf]`<`[String][String]`>()`[`[`][org.jetbrains.kotlinx.dataframe.columns.ColumnSet.cols]`1, 3, 5`[`]`][org.jetbrains.kotlinx.dataframe.columns.ColumnSet.cols]` }`
     *
     * #### Examples for this overload:
     *
     * `df.`[select][DataFrame.select]` { Type::myColumnGroup.`[cols][SingleColumn.cols]`(columnA, columnB) }`
     *
     * `df.`[select][DataFrame.select]` { DataSchemaType::myColumnGroup`[`[`][KProperty.cols]`"pathTo"["colA"], "pathTo"["colB"]`[`]`][KProperty.cols]` }`
     *
     *
     * @param [firstCol] A [ColumnReference] that points to a column.
     * @param [otherCols] Optional additional [ColumnReference]s that point to columns.
     * @return A ([transformable][org.jetbrains.kotlinx.dataframe.impl.columns.TransformableColumnSet]) [ColumnSet][org.jetbrains.kotlinx.dataframe.columns.ColumnSet] containing the columns that [firstCol] and [otherCols] point to. 
     */
    private interface KPropertyColsVarargColumnReferenceDocs

    /** ## Cols
     * Creates a subset of columns ([ColumnSet][org.jetbrains.kotlinx.dataframe.columns.ColumnSet]) from the current [ColumnsResolver][org.jetbrains.kotlinx.dataframe.columns.ColumnsResolver].
     *
     * If the current [ColumnsResolver][org.jetbrains.kotlinx.dataframe.columns.ColumnsResolver] is a [SingleColumn][org.jetbrains.kotlinx.dataframe.columns.SingleColumn] and consists of a [column group][org.jetbrains.kotlinx.dataframe.columns.ColumnGroup],
     * then `cols` will create a subset of its contained columns.
     *
     * You can use either a [ColumnFilter][org.jetbrains.kotlinx.dataframe.ColumnFilter], or any of the `vararg` overloads for any
     * [Access API][org.jetbrains.kotlinx.dataframe.documentation.AccessApi].
     *
     * Aside from calling [cols][org.jetbrains.kotlinx.dataframe.api.ColsColumnsSelectionDsl.cols] directly, you can also use the [get][org.jetbrains.kotlinx.dataframe.columns.ColumnSet.get] operator in most cases.
     *
     * #### For example:
     * `df.`[remove][org.jetbrains.kotlinx.dataframe.DataFrame.remove]` { `[cols][org.jetbrains.kotlinx.dataframe.api.ColumnsSelectionDsl.cols]` { it.`[hasNulls][org.jetbrains.kotlinx.dataframe.DataColumn.hasNulls]`() }.`[recursively][ColumnsSelectionDsl.recursively]`() }`
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { myGroupCol.`[cols][org.jetbrains.kotlinx.dataframe.columns.SingleColumn.cols]`(columnA, columnB) }`
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { `[colsOf][org.jetbrains.kotlinx.dataframe.api.ColumnsSelectionDsl.colsOf]`<`[String][String]`>()`[`[`][org.jetbrains.kotlinx.dataframe.columns.ColumnSet.cols]`1, 3, 5`[`]`][org.jetbrains.kotlinx.dataframe.columns.ColumnSet.cols]` }`
     *
     * #### Examples for this overload:
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { Type::myColumnGroup.`[cols][org.jetbrains.kotlinx.dataframe.columns.SingleColumn.cols]`(columnA, columnB) }`
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { DataSchemaType::myColumnGroup`[`[`][kotlin.reflect.KProperty.cols]`"pathTo"["colA"], "pathTo"["colB"]`[`]`][kotlin.reflect.KProperty.cols]` }`
     *
     *
     * @param [firstCol] A [ColumnReference][org.jetbrains.kotlinx.dataframe.columns.ColumnReference] that points to a column.
     * @param [otherCols] Optional additional [ColumnReference][org.jetbrains.kotlinx.dataframe.columns.ColumnReference]s that point to columns.
     * @return A ([transformable][org.jetbrains.kotlinx.dataframe.impl.columns.TransformableColumnSet]) [ColumnSet][org.jetbrains.kotlinx.dataframe.columns.ColumnSet] containing the columns that [firstCol] and [otherCols] point to. 
     */
    public fun <C> KProperty<*>.cols(
        firstCol: ColumnReference<C>,
        vararg otherCols: ColumnReference<C>,
    ): ColumnSet<C> = columnGroup(this).cols(firstCol, *otherCols)

    /** ## Cols
     * Creates a subset of columns ([ColumnSet][org.jetbrains.kotlinx.dataframe.columns.ColumnSet]) from the current [ColumnsResolver][org.jetbrains.kotlinx.dataframe.columns.ColumnsResolver].
     *
     * If the current [ColumnsResolver][org.jetbrains.kotlinx.dataframe.columns.ColumnsResolver] is a [SingleColumn][org.jetbrains.kotlinx.dataframe.columns.SingleColumn] and consists of a [column group][org.jetbrains.kotlinx.dataframe.columns.ColumnGroup],
     * then `cols` will create a subset of its contained columns.
     *
     * You can use either a [ColumnFilter][org.jetbrains.kotlinx.dataframe.ColumnFilter], or any of the `vararg` overloads for any
     * [Access API][org.jetbrains.kotlinx.dataframe.documentation.AccessApi].
     *
     * Aside from calling [cols][org.jetbrains.kotlinx.dataframe.api.ColsColumnsSelectionDsl.cols] directly, you can also use the [get][org.jetbrains.kotlinx.dataframe.columns.ColumnSet.get] operator in most cases.
     *
     * #### For example:
     * `df.`[remove][org.jetbrains.kotlinx.dataframe.DataFrame.remove]` { `[cols][org.jetbrains.kotlinx.dataframe.api.ColumnsSelectionDsl.cols]` { it.`[hasNulls][org.jetbrains.kotlinx.dataframe.DataColumn.hasNulls]`() }.`[recursively][ColumnsSelectionDsl.recursively]`() }`
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { myGroupCol.`[cols][org.jetbrains.kotlinx.dataframe.columns.SingleColumn.cols]`(columnA, columnB) }`
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { `[colsOf][org.jetbrains.kotlinx.dataframe.api.ColumnsSelectionDsl.colsOf]`<`[String][String]`>()`[`[`][org.jetbrains.kotlinx.dataframe.columns.ColumnSet.cols]`1, 3, 5`[`]`][org.jetbrains.kotlinx.dataframe.columns.ColumnSet.cols]` }`
     *
     * #### Examples for this overload:
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { Type::myColumnGroup.`[cols][org.jetbrains.kotlinx.dataframe.columns.SingleColumn.cols]`(columnA, columnB) }`
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { DataSchemaType::myColumnGroup`[`[`][kotlin.reflect.KProperty.cols]`"pathTo"["colA"], "pathTo"["colB"]`[`]`][kotlin.reflect.KProperty.cols]` }`
     *
     *
     * @param [firstCol] A [ColumnReference][org.jetbrains.kotlinx.dataframe.columns.ColumnReference] that points to a column.
     * @param [otherCols] Optional additional [ColumnReference][org.jetbrains.kotlinx.dataframe.columns.ColumnReference]s that point to columns.
     * @return A ([transformable][org.jetbrains.kotlinx.dataframe.impl.columns.TransformableColumnSet]) [ColumnSet][org.jetbrains.kotlinx.dataframe.columns.ColumnSet] containing the columns that [firstCol] and [otherCols] point to. 
     */
    public operator fun <C> KProperty<*>.get(
        firstCol: ColumnReference<C>,
        vararg otherCols: ColumnReference<C>,
    ): ColumnSet<C> = cols(firstCol, *otherCols)

    /**
     * ## Cols
     * Creates a subset of columns ([ColumnSet][org.jetbrains.kotlinx.dataframe.columns.ColumnSet]) from the current [ColumnsResolver][org.jetbrains.kotlinx.dataframe.columns.ColumnsResolver].
     *
     * If the current [ColumnsResolver][org.jetbrains.kotlinx.dataframe.columns.ColumnsResolver] is a [SingleColumn][org.jetbrains.kotlinx.dataframe.columns.SingleColumn] and consists of a [column group][org.jetbrains.kotlinx.dataframe.columns.ColumnGroup],
     * then `cols` will create a subset of its contained columns.
     *
     * You can use either a [ColumnFilter][org.jetbrains.kotlinx.dataframe.ColumnFilter], or any of the `vararg` overloads for any
     * [Access API][org.jetbrains.kotlinx.dataframe.documentation.AccessApi].
     *
     * Aside from calling [cols][org.jetbrains.kotlinx.dataframe.api.ColsColumnsSelectionDsl.cols] directly, you can also use the [get][org.jetbrains.kotlinx.dataframe.columns.ColumnSet.get] operator in most cases.
     *
     * #### For example:
     * `df.`[remove][org.jetbrains.kotlinx.dataframe.DataFrame.remove]` { `[cols][org.jetbrains.kotlinx.dataframe.api.ColumnsSelectionDsl.cols]` { it.`[hasNulls][org.jetbrains.kotlinx.dataframe.DataColumn.hasNulls]`() }.`[recursively][ColumnsSelectionDsl.recursively]`() }`
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { myGroupCol.`[cols][org.jetbrains.kotlinx.dataframe.columns.SingleColumn.cols]`(columnA, columnB) }`
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { `[colsOf][org.jetbrains.kotlinx.dataframe.api.ColumnsSelectionDsl.colsOf]`<`[String][String]`>()`[`[`][org.jetbrains.kotlinx.dataframe.columns.ColumnSet.cols]`1, 3, 5`[`]`][org.jetbrains.kotlinx.dataframe.columns.ColumnSet.cols]` }`
     *
     * #### Examples for this overload:
     *
     * `df.`[select][DataFrame.select]` { "pathTo"["columnGroup"].`[cols][ColumnPath.cols]`(columnA, columnB) }`
     *
     * `df.`[select][DataFrame.select]` { "pathTo"["columnGroup"].`[cols][ColumnPath.cols]`("pathTo"["colA"], "pathTo"["colB"]) }`
     *
     * `df.`[select][DataFrame.select]` { "pathTo"["columnGroup"]`[`[`][ColumnPath.cols]`columnA, columnB`[`]`][ColumnPath.cols]` }`
     *
     *
     * @param [firstCol] A [ColumnReference] that points to a column.
     * @param [otherCols] Optional additional [ColumnReference]s that point to columns.
     * @return A ([transformable][org.jetbrains.kotlinx.dataframe.impl.columns.TransformableColumnSet]) [ColumnSet][org.jetbrains.kotlinx.dataframe.columns.ColumnSet] containing the columns that [firstCol] and [otherCols] point to. 
     */
    private interface ColumnPathColsVarargColumnReferenceDocs

    /** ## Cols
     * Creates a subset of columns ([ColumnSet][org.jetbrains.kotlinx.dataframe.columns.ColumnSet]) from the current [ColumnsResolver][org.jetbrains.kotlinx.dataframe.columns.ColumnsResolver].
     *
     * If the current [ColumnsResolver][org.jetbrains.kotlinx.dataframe.columns.ColumnsResolver] is a [SingleColumn][org.jetbrains.kotlinx.dataframe.columns.SingleColumn] and consists of a [column group][org.jetbrains.kotlinx.dataframe.columns.ColumnGroup],
     * then `cols` will create a subset of its contained columns.
     *
     * You can use either a [ColumnFilter][org.jetbrains.kotlinx.dataframe.ColumnFilter], or any of the `vararg` overloads for any
     * [Access API][org.jetbrains.kotlinx.dataframe.documentation.AccessApi].
     *
     * Aside from calling [cols][org.jetbrains.kotlinx.dataframe.api.ColsColumnsSelectionDsl.cols] directly, you can also use the [get][org.jetbrains.kotlinx.dataframe.columns.ColumnSet.get] operator in most cases.
     *
     * #### For example:
     * `df.`[remove][org.jetbrains.kotlinx.dataframe.DataFrame.remove]` { `[cols][org.jetbrains.kotlinx.dataframe.api.ColumnsSelectionDsl.cols]` { it.`[hasNulls][org.jetbrains.kotlinx.dataframe.DataColumn.hasNulls]`() }.`[recursively][ColumnsSelectionDsl.recursively]`() }`
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { myGroupCol.`[cols][org.jetbrains.kotlinx.dataframe.columns.SingleColumn.cols]`(columnA, columnB) }`
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { `[colsOf][org.jetbrains.kotlinx.dataframe.api.ColumnsSelectionDsl.colsOf]`<`[String][String]`>()`[`[`][org.jetbrains.kotlinx.dataframe.columns.ColumnSet.cols]`1, 3, 5`[`]`][org.jetbrains.kotlinx.dataframe.columns.ColumnSet.cols]` }`
     *
     * #### Examples for this overload:
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { "pathTo"["columnGroup"].`[cols][org.jetbrains.kotlinx.dataframe.columns.ColumnPath.cols]`(columnA, columnB) }`
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { "pathTo"["columnGroup"].`[cols][org.jetbrains.kotlinx.dataframe.columns.ColumnPath.cols]`("pathTo"["colA"], "pathTo"["colB"]) }`
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { "pathTo"["columnGroup"]`[`[`][org.jetbrains.kotlinx.dataframe.columns.ColumnPath.cols]`columnA, columnB`[`]`][org.jetbrains.kotlinx.dataframe.columns.ColumnPath.cols]` }`
     *
     *
     * @param [firstCol] A [ColumnReference][org.jetbrains.kotlinx.dataframe.columns.ColumnReference] that points to a column.
     * @param [otherCols] Optional additional [ColumnReference][org.jetbrains.kotlinx.dataframe.columns.ColumnReference]s that point to columns.
     * @return A ([transformable][org.jetbrains.kotlinx.dataframe.impl.columns.TransformableColumnSet]) [ColumnSet][org.jetbrains.kotlinx.dataframe.columns.ColumnSet] containing the columns that [firstCol] and [otherCols] point to. 
     */
    public fun <C> ColumnPath.cols(
        firstCol: ColumnReference<C>,
        vararg otherCols: ColumnReference<C>,
    ): ColumnSet<C> = columnGroup(this).cols(firstCol, *otherCols)

    /** ## Cols
     * Creates a subset of columns ([ColumnSet][org.jetbrains.kotlinx.dataframe.columns.ColumnSet]) from the current [ColumnsResolver][org.jetbrains.kotlinx.dataframe.columns.ColumnsResolver].
     *
     * If the current [ColumnsResolver][org.jetbrains.kotlinx.dataframe.columns.ColumnsResolver] is a [SingleColumn][org.jetbrains.kotlinx.dataframe.columns.SingleColumn] and consists of a [column group][org.jetbrains.kotlinx.dataframe.columns.ColumnGroup],
     * then `cols` will create a subset of its contained columns.
     *
     * You can use either a [ColumnFilter][org.jetbrains.kotlinx.dataframe.ColumnFilter], or any of the `vararg` overloads for any
     * [Access API][org.jetbrains.kotlinx.dataframe.documentation.AccessApi].
     *
     * Aside from calling [cols][org.jetbrains.kotlinx.dataframe.api.ColsColumnsSelectionDsl.cols] directly, you can also use the [get][org.jetbrains.kotlinx.dataframe.columns.ColumnSet.get] operator in most cases.
     *
     * #### For example:
     * `df.`[remove][org.jetbrains.kotlinx.dataframe.DataFrame.remove]` { `[cols][org.jetbrains.kotlinx.dataframe.api.ColumnsSelectionDsl.cols]` { it.`[hasNulls][org.jetbrains.kotlinx.dataframe.DataColumn.hasNulls]`() }.`[recursively][ColumnsSelectionDsl.recursively]`() }`
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { myGroupCol.`[cols][org.jetbrains.kotlinx.dataframe.columns.SingleColumn.cols]`(columnA, columnB) }`
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { `[colsOf][org.jetbrains.kotlinx.dataframe.api.ColumnsSelectionDsl.colsOf]`<`[String][String]`>()`[`[`][org.jetbrains.kotlinx.dataframe.columns.ColumnSet.cols]`1, 3, 5`[`]`][org.jetbrains.kotlinx.dataframe.columns.ColumnSet.cols]` }`
     *
     * #### Examples for this overload:
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { "pathTo"["columnGroup"].`[cols][org.jetbrains.kotlinx.dataframe.columns.ColumnPath.cols]`(columnA, columnB) }`
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { "pathTo"["columnGroup"].`[cols][org.jetbrains.kotlinx.dataframe.columns.ColumnPath.cols]`("pathTo"["colA"], "pathTo"["colB"]) }`
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { "pathTo"["columnGroup"]`[`[`][org.jetbrains.kotlinx.dataframe.columns.ColumnPath.cols]`columnA, columnB`[`]`][org.jetbrains.kotlinx.dataframe.columns.ColumnPath.cols]` }`
     *
     *
     * @param [firstCol] A [ColumnReference][org.jetbrains.kotlinx.dataframe.columns.ColumnReference] that points to a column.
     * @param [otherCols] Optional additional [ColumnReference][org.jetbrains.kotlinx.dataframe.columns.ColumnReference]s that point to columns.
     * @return A ([transformable][org.jetbrains.kotlinx.dataframe.impl.columns.TransformableColumnSet]) [ColumnSet][org.jetbrains.kotlinx.dataframe.columns.ColumnSet] containing the columns that [firstCol] and [otherCols] point to. 
     */
    public operator fun <C> ColumnPath.get(
        firstCol: ColumnReference<C>,
        vararg otherCols: ColumnReference<C>,
    ): ColumnSet<C> = cols(firstCol, *otherCols)

    // endregion

    // region names

    /**
     * ## Cols
     * Creates a subset of columns ([ColumnSet][org.jetbrains.kotlinx.dataframe.columns.ColumnSet]) from the current [ColumnsResolver][org.jetbrains.kotlinx.dataframe.columns.ColumnsResolver].
     *
     * If the current [ColumnsResolver][org.jetbrains.kotlinx.dataframe.columns.ColumnsResolver] is a [SingleColumn][org.jetbrains.kotlinx.dataframe.columns.SingleColumn] and consists of a [column group][org.jetbrains.kotlinx.dataframe.columns.ColumnGroup],
     * then `cols` will create a subset of its contained columns.
     *
     * You can use either a [ColumnFilter][org.jetbrains.kotlinx.dataframe.ColumnFilter], or any of the `vararg` overloads for any
     * [Access API][org.jetbrains.kotlinx.dataframe.documentation.AccessApi].
     *
     * Aside from calling [cols][org.jetbrains.kotlinx.dataframe.api.ColsColumnsSelectionDsl.cols] directly, you can also use the [get][org.jetbrains.kotlinx.dataframe.columns.ColumnSet.get] operator in most cases.
     *
     * #### For example:
     * `df.`[remove][org.jetbrains.kotlinx.dataframe.DataFrame.remove]` { `[cols][org.jetbrains.kotlinx.dataframe.api.ColumnsSelectionDsl.cols]` { it.`[hasNulls][org.jetbrains.kotlinx.dataframe.DataColumn.hasNulls]`() }.`[recursively][ColumnsSelectionDsl.recursively]`() }`
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { myGroupCol.`[cols][org.jetbrains.kotlinx.dataframe.columns.SingleColumn.cols]`(columnA, columnB) }`
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { `[colsOf][org.jetbrains.kotlinx.dataframe.api.ColumnsSelectionDsl.colsOf]`<`[String][String]`>()`[`[`][org.jetbrains.kotlinx.dataframe.columns.ColumnSet.cols]`1, 3, 5`[`]`][org.jetbrains.kotlinx.dataframe.columns.ColumnSet.cols]` }`
     *
     * #### Examples for this overload:
     *
     * `df.`[select][DataFrame.select]` { `[colsOf][SingleColumn.colsOf]`<`[String][String]`>().`[cols][ColumnSet.cols]`("columnA", "columnB") }`
     *
     * `df.`[select][DataFrame.select]` { `[colsOf][SingleColumn.colsOf]`<`[String][String]`>()`[`[`][ColumnSet.cols]`"columnA", "columnB"`[`]`][ColumnSet.cols]` }`
     *
     *
     * @param [firstCol] A [String] that points to a column.
     * @param [otherCols] Optional additional [String]s that point to columns.
     * @return A ([transformable][org.jetbrains.kotlinx.dataframe.impl.columns.TransformableColumnSet]) [ColumnSet][org.jetbrains.kotlinx.dataframe.columns.ColumnSet] containing the columns that [firstCol] and [otherCols] point to. 
     */
    private interface ColumnSetColsVarargStringDocs

    /** ## Cols
     * Creates a subset of columns ([ColumnSet][org.jetbrains.kotlinx.dataframe.columns.ColumnSet]) from the current [ColumnsResolver][org.jetbrains.kotlinx.dataframe.columns.ColumnsResolver].
     *
     * If the current [ColumnsResolver][org.jetbrains.kotlinx.dataframe.columns.ColumnsResolver] is a [SingleColumn][org.jetbrains.kotlinx.dataframe.columns.SingleColumn] and consists of a [column group][org.jetbrains.kotlinx.dataframe.columns.ColumnGroup],
     * then `cols` will create a subset of its contained columns.
     *
     * You can use either a [ColumnFilter][org.jetbrains.kotlinx.dataframe.ColumnFilter], or any of the `vararg` overloads for any
     * [Access API][org.jetbrains.kotlinx.dataframe.documentation.AccessApi].
     *
     * Aside from calling [cols][org.jetbrains.kotlinx.dataframe.api.ColsColumnsSelectionDsl.cols] directly, you can also use the [get][org.jetbrains.kotlinx.dataframe.columns.ColumnSet.get] operator in most cases.
     *
     * #### For example:
     * `df.`[remove][org.jetbrains.kotlinx.dataframe.DataFrame.remove]` { `[cols][org.jetbrains.kotlinx.dataframe.api.ColumnsSelectionDsl.cols]` { it.`[hasNulls][org.jetbrains.kotlinx.dataframe.DataColumn.hasNulls]`() }.`[recursively][ColumnsSelectionDsl.recursively]`() }`
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { myGroupCol.`[cols][org.jetbrains.kotlinx.dataframe.columns.SingleColumn.cols]`(columnA, columnB) }`
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { `[colsOf][org.jetbrains.kotlinx.dataframe.api.ColumnsSelectionDsl.colsOf]`<`[String][String]`>()`[`[`][org.jetbrains.kotlinx.dataframe.columns.ColumnSet.cols]`1, 3, 5`[`]`][org.jetbrains.kotlinx.dataframe.columns.ColumnSet.cols]` }`
     *
     * #### Examples for this overload:
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { `[colsOf][org.jetbrains.kotlinx.dataframe.columns.SingleColumn.colsOf]`<`[String][String]`>().`[cols][org.jetbrains.kotlinx.dataframe.columns.ColumnSet.cols]`("columnA", "columnB") }`
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { `[colsOf][org.jetbrains.kotlinx.dataframe.columns.SingleColumn.colsOf]`<`[String][String]`>()`[`[`][org.jetbrains.kotlinx.dataframe.columns.ColumnSet.cols]`"columnA", "columnB"`[`]`][org.jetbrains.kotlinx.dataframe.columns.ColumnSet.cols]` }`
     *
     *
     * @param [firstCol] A [String] that points to a column.
     * @param [otherCols] Optional additional [String]s that point to columns.
     * @return A ([transformable][org.jetbrains.kotlinx.dataframe.impl.columns.TransformableColumnSet]) [ColumnSet][org.jetbrains.kotlinx.dataframe.columns.ColumnSet] containing the columns that [firstCol] and [otherCols] point to. 
     */
    @Suppress("UNCHECKED_CAST")
    public fun <C> ColumnSet<C>.cols(
        firstCol: String,
        vararg otherCols: String,
    ): ColumnSet<C> = headPlusArray(firstCol, otherCols).let { names ->
        colsInternal { it.name in names } as ColumnSet<C>
    }

    /**
     * ## Cols
     * Creates a subset of columns ([ColumnSet][org.jetbrains.kotlinx.dataframe.columns.ColumnSet]) from the current [ColumnsResolver][org.jetbrains.kotlinx.dataframe.columns.ColumnsResolver].
     *
     * If the current [ColumnsResolver][org.jetbrains.kotlinx.dataframe.columns.ColumnsResolver] is a [SingleColumn][org.jetbrains.kotlinx.dataframe.columns.SingleColumn] and consists of a [column group][org.jetbrains.kotlinx.dataframe.columns.ColumnGroup],
     * then `cols` will create a subset of its contained columns.
     *
     * You can use either a [ColumnFilter][org.jetbrains.kotlinx.dataframe.ColumnFilter], or any of the `vararg` overloads for any
     * [Access API][org.jetbrains.kotlinx.dataframe.documentation.AccessApi].
     *
     * Aside from calling [cols][org.jetbrains.kotlinx.dataframe.api.ColsColumnsSelectionDsl.cols] directly, you can also use the [get][org.jetbrains.kotlinx.dataframe.columns.ColumnSet.get] operator in most cases.
     *
     * #### For example:
     * `df.`[remove][org.jetbrains.kotlinx.dataframe.DataFrame.remove]` { `[cols][org.jetbrains.kotlinx.dataframe.api.ColumnsSelectionDsl.cols]` { it.`[hasNulls][org.jetbrains.kotlinx.dataframe.DataColumn.hasNulls]`() }.`[recursively][ColumnsSelectionDsl.recursively]`() }`
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { myGroupCol.`[cols][org.jetbrains.kotlinx.dataframe.columns.SingleColumn.cols]`(columnA, columnB) }`
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { `[colsOf][org.jetbrains.kotlinx.dataframe.api.ColumnsSelectionDsl.colsOf]`<`[String][String]`>()`[`[`][org.jetbrains.kotlinx.dataframe.columns.ColumnSet.cols]`1, 3, 5`[`]`][org.jetbrains.kotlinx.dataframe.columns.ColumnSet.cols]` }`
     *
     * #### Examples for this overload:
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { `[colsOf][org.jetbrains.kotlinx.dataframe.columns.SingleColumn.colsOf]`<`[String][String]`>().`[cols][org.jetbrains.kotlinx.dataframe.columns.ColumnSet.cols]`("columnA", "columnB") }`
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { `[colsOf][org.jetbrains.kotlinx.dataframe.columns.SingleColumn.colsOf]`<`[String][String]`>()`[`[`][org.jetbrains.kotlinx.dataframe.columns.ColumnSet.cols]`"columnA", "columnB"`[`]`][org.jetbrains.kotlinx.dataframe.columns.ColumnSet.cols]` }`
     *
     *
     * @param [firstCol] A [String] that points to a column.
     * @param [otherCols] Optional additional [String]s that point to columns.
     * @return A ([transformable][org.jetbrains.kotlinx.dataframe.impl.columns.TransformableColumnSet]) [ColumnSet][org.jetbrains.kotlinx.dataframe.columns.ColumnSet] containing the columns that [firstCol] and [otherCols] point to. 
     */
    public operator fun <C> ColumnSet<C>.get(
        firstCol: String,
        vararg otherCols: String,
    ): ColumnSet<C> = cols(firstCol, *otherCols)

    /**
     * ## Cols
     * Creates a subset of columns ([ColumnSet][org.jetbrains.kotlinx.dataframe.columns.ColumnSet]) from the current [ColumnsResolver][org.jetbrains.kotlinx.dataframe.columns.ColumnsResolver].
     *
     * If the current [ColumnsResolver][org.jetbrains.kotlinx.dataframe.columns.ColumnsResolver] is a [SingleColumn][org.jetbrains.kotlinx.dataframe.columns.SingleColumn] and consists of a [column group][org.jetbrains.kotlinx.dataframe.columns.ColumnGroup],
     * then `cols` will create a subset of its contained columns.
     *
     * You can use either a [ColumnFilter][org.jetbrains.kotlinx.dataframe.ColumnFilter], or any of the `vararg` overloads for any
     * [Access API][org.jetbrains.kotlinx.dataframe.documentation.AccessApi].
     *
     * Aside from calling [cols][org.jetbrains.kotlinx.dataframe.api.ColsColumnsSelectionDsl.cols] directly, you can also use the [get][org.jetbrains.kotlinx.dataframe.columns.ColumnSet.get] operator in most cases.
     *
     * #### For example:
     * `df.`[remove][org.jetbrains.kotlinx.dataframe.DataFrame.remove]` { `[cols][org.jetbrains.kotlinx.dataframe.api.ColumnsSelectionDsl.cols]` { it.`[hasNulls][org.jetbrains.kotlinx.dataframe.DataColumn.hasNulls]`() }.`[recursively][ColumnsSelectionDsl.recursively]`() }`
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { myGroupCol.`[cols][org.jetbrains.kotlinx.dataframe.columns.SingleColumn.cols]`(columnA, columnB) }`
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { `[colsOf][org.jetbrains.kotlinx.dataframe.api.ColumnsSelectionDsl.colsOf]`<`[String][String]`>()`[`[`][org.jetbrains.kotlinx.dataframe.columns.ColumnSet.cols]`1, 3, 5`[`]`][org.jetbrains.kotlinx.dataframe.columns.ColumnSet.cols]` }`
     *
     * #### Examples for this overload:
     *
     * `df.`[select][DataFrame.select]` { `[cols][SingleColumn.cols]`("columnA", "columnB") }`
     *
     * `df.`[select][DataFrame.select]` { this`[`[`][SingleColumn.cols]`"columnA", "columnB"`[`]`][SingleColumn.cols]` }`
     *
     *
     * @param [firstCol] A [String] that points to a column.
     * @param [otherCols] Optional additional [String]s that point to columns.
     * @return A ([transformable][org.jetbrains.kotlinx.dataframe.impl.columns.TransformableColumnSet]) [ColumnSet][org.jetbrains.kotlinx.dataframe.columns.ColumnSet] containing the columns that [firstCol] and [otherCols] point to. 
     */
    private interface ColumnsSelectionDslVarargColumnReferenceDocs

    /** ## Cols
     * Creates a subset of columns ([ColumnSet][org.jetbrains.kotlinx.dataframe.columns.ColumnSet]) from the current [ColumnsResolver][org.jetbrains.kotlinx.dataframe.columns.ColumnsResolver].
     *
     * If the current [ColumnsResolver][org.jetbrains.kotlinx.dataframe.columns.ColumnsResolver] is a [SingleColumn][org.jetbrains.kotlinx.dataframe.columns.SingleColumn] and consists of a [column group][org.jetbrains.kotlinx.dataframe.columns.ColumnGroup],
     * then `cols` will create a subset of its contained columns.
     *
     * You can use either a [ColumnFilter][org.jetbrains.kotlinx.dataframe.ColumnFilter], or any of the `vararg` overloads for any
     * [Access API][org.jetbrains.kotlinx.dataframe.documentation.AccessApi].
     *
     * Aside from calling [cols][org.jetbrains.kotlinx.dataframe.api.ColsColumnsSelectionDsl.cols] directly, you can also use the [get][org.jetbrains.kotlinx.dataframe.columns.ColumnSet.get] operator in most cases.
     *
     * #### For example:
     * `df.`[remove][org.jetbrains.kotlinx.dataframe.DataFrame.remove]` { `[cols][org.jetbrains.kotlinx.dataframe.api.ColumnsSelectionDsl.cols]` { it.`[hasNulls][org.jetbrains.kotlinx.dataframe.DataColumn.hasNulls]`() }.`[recursively][ColumnsSelectionDsl.recursively]`() }`
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { myGroupCol.`[cols][org.jetbrains.kotlinx.dataframe.columns.SingleColumn.cols]`(columnA, columnB) }`
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { `[colsOf][org.jetbrains.kotlinx.dataframe.api.ColumnsSelectionDsl.colsOf]`<`[String][String]`>()`[`[`][org.jetbrains.kotlinx.dataframe.columns.ColumnSet.cols]`1, 3, 5`[`]`][org.jetbrains.kotlinx.dataframe.columns.ColumnSet.cols]` }`
     *
     * #### Examples for this overload:
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { `[cols][org.jetbrains.kotlinx.dataframe.columns.SingleColumn.cols]`("columnA", "columnB") }`
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { this`[`[`][org.jetbrains.kotlinx.dataframe.columns.SingleColumn.cols]`"columnA", "columnB"`[`]`][org.jetbrains.kotlinx.dataframe.columns.SingleColumn.cols]` }`
     *
     *
     * @param [firstCol] A [String] that points to a column.
     * @param [otherCols] Optional additional [String]s that point to columns.
     * @return A ([transformable][org.jetbrains.kotlinx.dataframe.impl.columns.TransformableColumnSet]) [ColumnSet][org.jetbrains.kotlinx.dataframe.columns.ColumnSet] containing the columns that [firstCol] and [otherCols] point to. 
     */
    public fun ColumnsSelectionDsl<*>.cols(
        firstCol: String,
        vararg otherCols: String,
    ): ColumnSet<*> = this.asSingleColumn().cols(firstCol, *otherCols)

    /** ## Cols
     * Creates a subset of columns ([ColumnSet][org.jetbrains.kotlinx.dataframe.columns.ColumnSet]) from the current [ColumnsResolver][org.jetbrains.kotlinx.dataframe.columns.ColumnsResolver].
     *
     * If the current [ColumnsResolver][org.jetbrains.kotlinx.dataframe.columns.ColumnsResolver] is a [SingleColumn][org.jetbrains.kotlinx.dataframe.columns.SingleColumn] and consists of a [column group][org.jetbrains.kotlinx.dataframe.columns.ColumnGroup],
     * then `cols` will create a subset of its contained columns.
     *
     * You can use either a [ColumnFilter][org.jetbrains.kotlinx.dataframe.ColumnFilter], or any of the `vararg` overloads for any
     * [Access API][org.jetbrains.kotlinx.dataframe.documentation.AccessApi].
     *
     * Aside from calling [cols][org.jetbrains.kotlinx.dataframe.api.ColsColumnsSelectionDsl.cols] directly, you can also use the [get][org.jetbrains.kotlinx.dataframe.columns.ColumnSet.get] operator in most cases.
     *
     * #### For example:
     * `df.`[remove][org.jetbrains.kotlinx.dataframe.DataFrame.remove]` { `[cols][org.jetbrains.kotlinx.dataframe.api.ColumnsSelectionDsl.cols]` { it.`[hasNulls][org.jetbrains.kotlinx.dataframe.DataColumn.hasNulls]`() }.`[recursively][ColumnsSelectionDsl.recursively]`() }`
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { myGroupCol.`[cols][org.jetbrains.kotlinx.dataframe.columns.SingleColumn.cols]`(columnA, columnB) }`
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { `[colsOf][org.jetbrains.kotlinx.dataframe.api.ColumnsSelectionDsl.colsOf]`<`[String][String]`>()`[`[`][org.jetbrains.kotlinx.dataframe.columns.ColumnSet.cols]`1, 3, 5`[`]`][org.jetbrains.kotlinx.dataframe.columns.ColumnSet.cols]` }`
     *
     * #### Examples for this overload:
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { `[cols][org.jetbrains.kotlinx.dataframe.columns.SingleColumn.cols]`("columnA", "columnB") }`
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { this`[`[`][org.jetbrains.kotlinx.dataframe.columns.SingleColumn.cols]`"columnA", "columnB"`[`]`][org.jetbrains.kotlinx.dataframe.columns.SingleColumn.cols]` }`
     *
     *
     * @param [firstCol] A [String] that points to a column.
     * @param [otherCols] Optional additional [String]s that point to columns.
     * @return A ([transformable][org.jetbrains.kotlinx.dataframe.impl.columns.TransformableColumnSet]) [ColumnSet][org.jetbrains.kotlinx.dataframe.columns.ColumnSet] containing the columns that [firstCol] and [otherCols] point to. 
     */
    public operator fun ColumnsSelectionDsl<*>.get(
        firstCol: String,
        vararg otherCols: String,
    ): ColumnSet<*> = cols(firstCol, *otherCols)

    /**
     * ## Cols
     * Creates a subset of columns ([ColumnSet][org.jetbrains.kotlinx.dataframe.columns.ColumnSet]) from the current [ColumnsResolver][org.jetbrains.kotlinx.dataframe.columns.ColumnsResolver].
     *
     * If the current [ColumnsResolver][org.jetbrains.kotlinx.dataframe.columns.ColumnsResolver] is a [SingleColumn][org.jetbrains.kotlinx.dataframe.columns.SingleColumn] and consists of a [column group][org.jetbrains.kotlinx.dataframe.columns.ColumnGroup],
     * then `cols` will create a subset of its contained columns.
     *
     * You can use either a [ColumnFilter][org.jetbrains.kotlinx.dataframe.ColumnFilter], or any of the `vararg` overloads for any
     * [Access API][org.jetbrains.kotlinx.dataframe.documentation.AccessApi].
     *
     * Aside from calling [cols][org.jetbrains.kotlinx.dataframe.api.ColsColumnsSelectionDsl.cols] directly, you can also use the [get][org.jetbrains.kotlinx.dataframe.columns.ColumnSet.get] operator in most cases.
     *
     * #### For example:
     * `df.`[remove][org.jetbrains.kotlinx.dataframe.DataFrame.remove]` { `[cols][org.jetbrains.kotlinx.dataframe.api.ColumnsSelectionDsl.cols]` { it.`[hasNulls][org.jetbrains.kotlinx.dataframe.DataColumn.hasNulls]`() }.`[recursively][ColumnsSelectionDsl.recursively]`() }`
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { myGroupCol.`[cols][org.jetbrains.kotlinx.dataframe.columns.SingleColumn.cols]`(columnA, columnB) }`
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { `[colsOf][org.jetbrains.kotlinx.dataframe.api.ColumnsSelectionDsl.colsOf]`<`[String][String]`>()`[`[`][org.jetbrains.kotlinx.dataframe.columns.ColumnSet.cols]`1, 3, 5`[`]`][org.jetbrains.kotlinx.dataframe.columns.ColumnSet.cols]` }`
     *
     * #### Examples for this overload:
     *
     * `df.`[select][DataFrame.select]` { myColumnGroup.`[cols][SingleColumn.cols]`("columnA", "columnB") }`
     *
     * `df.`[select][DataFrame.select]` { myColumnGroup`[`[`][SingleColumn.cols]`"columnA", "columnB"`[`]`][SingleColumn.cols]` }`
     *
     *
     * @param [firstCol] A [String] that points to a column.
     * @param [otherCols] Optional additional [String]s that point to columns.
     * @return A ([transformable][org.jetbrains.kotlinx.dataframe.impl.columns.TransformableColumnSet]) [ColumnSet][org.jetbrains.kotlinx.dataframe.columns.ColumnSet] containing the columns that [firstCol] and [otherCols] point to. 
     */
    private interface SingleColumnColsVarargStringDocs

    /** ## Cols
     * Creates a subset of columns ([ColumnSet][org.jetbrains.kotlinx.dataframe.columns.ColumnSet]) from the current [ColumnsResolver][org.jetbrains.kotlinx.dataframe.columns.ColumnsResolver].
     *
     * If the current [ColumnsResolver][org.jetbrains.kotlinx.dataframe.columns.ColumnsResolver] is a [SingleColumn][org.jetbrains.kotlinx.dataframe.columns.SingleColumn] and consists of a [column group][org.jetbrains.kotlinx.dataframe.columns.ColumnGroup],
     * then `cols` will create a subset of its contained columns.
     *
     * You can use either a [ColumnFilter][org.jetbrains.kotlinx.dataframe.ColumnFilter], or any of the `vararg` overloads for any
     * [Access API][org.jetbrains.kotlinx.dataframe.documentation.AccessApi].
     *
     * Aside from calling [cols][org.jetbrains.kotlinx.dataframe.api.ColsColumnsSelectionDsl.cols] directly, you can also use the [get][org.jetbrains.kotlinx.dataframe.columns.ColumnSet.get] operator in most cases.
     *
     * #### For example:
     * `df.`[remove][org.jetbrains.kotlinx.dataframe.DataFrame.remove]` { `[cols][org.jetbrains.kotlinx.dataframe.api.ColumnsSelectionDsl.cols]` { it.`[hasNulls][org.jetbrains.kotlinx.dataframe.DataColumn.hasNulls]`() }.`[recursively][ColumnsSelectionDsl.recursively]`() }`
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { myGroupCol.`[cols][org.jetbrains.kotlinx.dataframe.columns.SingleColumn.cols]`(columnA, columnB) }`
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { `[colsOf][org.jetbrains.kotlinx.dataframe.api.ColumnsSelectionDsl.colsOf]`<`[String][String]`>()`[`[`][org.jetbrains.kotlinx.dataframe.columns.ColumnSet.cols]`1, 3, 5`[`]`][org.jetbrains.kotlinx.dataframe.columns.ColumnSet.cols]` }`
     *
     * #### Examples for this overload:
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { myColumnGroup.`[cols][org.jetbrains.kotlinx.dataframe.columns.SingleColumn.cols]`("columnA", "columnB") }`
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { myColumnGroup`[`[`][org.jetbrains.kotlinx.dataframe.columns.SingleColumn.cols]`"columnA", "columnB"`[`]`][org.jetbrains.kotlinx.dataframe.columns.SingleColumn.cols]` }`
     *
     *
     * @param [firstCol] A [String] that points to a column.
     * @param [otherCols] Optional additional [String]s that point to columns.
     * @return A ([transformable][org.jetbrains.kotlinx.dataframe.impl.columns.TransformableColumnSet]) [ColumnSet][org.jetbrains.kotlinx.dataframe.columns.ColumnSet] containing the columns that [firstCol] and [otherCols] point to. 
     */
    public fun SingleColumn<DataRow<*>>.cols(
        firstCol: String,
        vararg otherCols: String,
    ): ColumnSet<*> = headPlusArray(firstCol, otherCols).let { names ->
        ensureIsColGroup().asColumnSet().transform { it.flatMap { col -> names.mapNotNull { col.getChild(it) } } }
    }

    /**
     * ## Cols
     * Creates a subset of columns ([ColumnSet][org.jetbrains.kotlinx.dataframe.columns.ColumnSet]) from the current [ColumnsResolver][org.jetbrains.kotlinx.dataframe.columns.ColumnsResolver].
     *
     * If the current [ColumnsResolver][org.jetbrains.kotlinx.dataframe.columns.ColumnsResolver] is a [SingleColumn][org.jetbrains.kotlinx.dataframe.columns.SingleColumn] and consists of a [column group][org.jetbrains.kotlinx.dataframe.columns.ColumnGroup],
     * then `cols` will create a subset of its contained columns.
     *
     * You can use either a [ColumnFilter][org.jetbrains.kotlinx.dataframe.ColumnFilter], or any of the `vararg` overloads for any
     * [Access API][org.jetbrains.kotlinx.dataframe.documentation.AccessApi].
     *
     * Aside from calling [cols][org.jetbrains.kotlinx.dataframe.api.ColsColumnsSelectionDsl.cols] directly, you can also use the [get][org.jetbrains.kotlinx.dataframe.columns.ColumnSet.get] operator in most cases.
     *
     * #### For example:
     * `df.`[remove][org.jetbrains.kotlinx.dataframe.DataFrame.remove]` { `[cols][org.jetbrains.kotlinx.dataframe.api.ColumnsSelectionDsl.cols]` { it.`[hasNulls][org.jetbrains.kotlinx.dataframe.DataColumn.hasNulls]`() }.`[recursively][ColumnsSelectionDsl.recursively]`() }`
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { myGroupCol.`[cols][org.jetbrains.kotlinx.dataframe.columns.SingleColumn.cols]`(columnA, columnB) }`
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { `[colsOf][org.jetbrains.kotlinx.dataframe.api.ColumnsSelectionDsl.colsOf]`<`[String][String]`>()`[`[`][org.jetbrains.kotlinx.dataframe.columns.ColumnSet.cols]`1, 3, 5`[`]`][org.jetbrains.kotlinx.dataframe.columns.ColumnSet.cols]` }`
     *
     * #### Examples for this overload:
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { myColumnGroup.`[cols][org.jetbrains.kotlinx.dataframe.columns.SingleColumn.cols]`("columnA", "columnB") }`
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { myColumnGroup`[`[`][org.jetbrains.kotlinx.dataframe.columns.SingleColumn.cols]`"columnA", "columnB"`[`]`][org.jetbrains.kotlinx.dataframe.columns.SingleColumn.cols]` }`
     *
     *
     * @param [firstCol] A [String] that points to a column.
     * @param [otherCols] Optional additional [String]s that point to columns.
     * @return A ([transformable][org.jetbrains.kotlinx.dataframe.impl.columns.TransformableColumnSet]) [ColumnSet][org.jetbrains.kotlinx.dataframe.columns.ColumnSet] containing the columns that [firstCol] and [otherCols] point to. 
     */
    public operator fun SingleColumn<DataRow<*>>.get(
        firstCol: String,
        vararg otherCols: String,
    ): ColumnSet<*> = cols(firstCol, *otherCols)

    /**
     * ## Cols
     * Creates a subset of columns ([ColumnSet][org.jetbrains.kotlinx.dataframe.columns.ColumnSet]) from the current [ColumnsResolver][org.jetbrains.kotlinx.dataframe.columns.ColumnsResolver].
     *
     * If the current [ColumnsResolver][org.jetbrains.kotlinx.dataframe.columns.ColumnsResolver] is a [SingleColumn][org.jetbrains.kotlinx.dataframe.columns.SingleColumn] and consists of a [column group][org.jetbrains.kotlinx.dataframe.columns.ColumnGroup],
     * then `cols` will create a subset of its contained columns.
     *
     * You can use either a [ColumnFilter][org.jetbrains.kotlinx.dataframe.ColumnFilter], or any of the `vararg` overloads for any
     * [Access API][org.jetbrains.kotlinx.dataframe.documentation.AccessApi].
     *
     * Aside from calling [cols][org.jetbrains.kotlinx.dataframe.api.ColsColumnsSelectionDsl.cols] directly, you can also use the [get][org.jetbrains.kotlinx.dataframe.columns.ColumnSet.get] operator in most cases.
     *
     * #### For example:
     * `df.`[remove][org.jetbrains.kotlinx.dataframe.DataFrame.remove]` { `[cols][org.jetbrains.kotlinx.dataframe.api.ColumnsSelectionDsl.cols]` { it.`[hasNulls][org.jetbrains.kotlinx.dataframe.DataColumn.hasNulls]`() }.`[recursively][ColumnsSelectionDsl.recursively]`() }`
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { myGroupCol.`[cols][org.jetbrains.kotlinx.dataframe.columns.SingleColumn.cols]`(columnA, columnB) }`
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { `[colsOf][org.jetbrains.kotlinx.dataframe.api.ColumnsSelectionDsl.colsOf]`<`[String][String]`>()`[`[`][org.jetbrains.kotlinx.dataframe.columns.ColumnSet.cols]`1, 3, 5`[`]`][org.jetbrains.kotlinx.dataframe.columns.ColumnSet.cols]` }`
     *
     * #### Examples for this overload:
     *
     * `df.`[select][DataFrame.select]` { "columnGroup".`[cols][String.cols]`("columnA", "columnB") }`
     *
     * `df.`[select][DataFrame.select]` { "columnGroup"`[`[`][String.cols]`"columnA", "columnB"`[`]`][String.cols]` }`
     *
     *
     * @param [firstCol] A [String] that points to a column.
     * @param [otherCols] Optional additional [String]s that point to columns.
     * @return A ([transformable][org.jetbrains.kotlinx.dataframe.impl.columns.TransformableColumnSet]) [ColumnSet][org.jetbrains.kotlinx.dataframe.columns.ColumnSet] containing the columns that [firstCol] and [otherCols] point to. 
     */
    private interface StringColsVarargStringDocs

    /** ## Cols
     * Creates a subset of columns ([ColumnSet][org.jetbrains.kotlinx.dataframe.columns.ColumnSet]) from the current [ColumnsResolver][org.jetbrains.kotlinx.dataframe.columns.ColumnsResolver].
     *
     * If the current [ColumnsResolver][org.jetbrains.kotlinx.dataframe.columns.ColumnsResolver] is a [SingleColumn][org.jetbrains.kotlinx.dataframe.columns.SingleColumn] and consists of a [column group][org.jetbrains.kotlinx.dataframe.columns.ColumnGroup],
     * then `cols` will create a subset of its contained columns.
     *
     * You can use either a [ColumnFilter][org.jetbrains.kotlinx.dataframe.ColumnFilter], or any of the `vararg` overloads for any
     * [Access API][org.jetbrains.kotlinx.dataframe.documentation.AccessApi].
     *
     * Aside from calling [cols][org.jetbrains.kotlinx.dataframe.api.ColsColumnsSelectionDsl.cols] directly, you can also use the [get][org.jetbrains.kotlinx.dataframe.columns.ColumnSet.get] operator in most cases.
     *
     * #### For example:
     * `df.`[remove][org.jetbrains.kotlinx.dataframe.DataFrame.remove]` { `[cols][org.jetbrains.kotlinx.dataframe.api.ColumnsSelectionDsl.cols]` { it.`[hasNulls][org.jetbrains.kotlinx.dataframe.DataColumn.hasNulls]`() }.`[recursively][ColumnsSelectionDsl.recursively]`() }`
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { myGroupCol.`[cols][org.jetbrains.kotlinx.dataframe.columns.SingleColumn.cols]`(columnA, columnB) }`
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { `[colsOf][org.jetbrains.kotlinx.dataframe.api.ColumnsSelectionDsl.colsOf]`<`[String][String]`>()`[`[`][org.jetbrains.kotlinx.dataframe.columns.ColumnSet.cols]`1, 3, 5`[`]`][org.jetbrains.kotlinx.dataframe.columns.ColumnSet.cols]` }`
     *
     * #### Examples for this overload:
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { "columnGroup".`[cols][kotlin.String.cols]`("columnA", "columnB") }`
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { "columnGroup"`[`[`][kotlin.String.cols]`"columnA", "columnB"`[`]`][kotlin.String.cols]` }`
     *
     *
     * @param [firstCol] A [String] that points to a column.
     * @param [otherCols] Optional additional [String]s that point to columns.
     * @return A ([transformable][org.jetbrains.kotlinx.dataframe.impl.columns.TransformableColumnSet]) [ColumnSet][org.jetbrains.kotlinx.dataframe.columns.ColumnSet] containing the columns that [firstCol] and [otherCols] point to. 
     */
    public fun String.cols(
        firstCol: String,
        vararg otherCols: String,
    ): ColumnSet<*> = columnGroup(this).cols(firstCol, *otherCols)

    /** ## Cols
     * Creates a subset of columns ([ColumnSet][org.jetbrains.kotlinx.dataframe.columns.ColumnSet]) from the current [ColumnsResolver][org.jetbrains.kotlinx.dataframe.columns.ColumnsResolver].
     *
     * If the current [ColumnsResolver][org.jetbrains.kotlinx.dataframe.columns.ColumnsResolver] is a [SingleColumn][org.jetbrains.kotlinx.dataframe.columns.SingleColumn] and consists of a [column group][org.jetbrains.kotlinx.dataframe.columns.ColumnGroup],
     * then `cols` will create a subset of its contained columns.
     *
     * You can use either a [ColumnFilter][org.jetbrains.kotlinx.dataframe.ColumnFilter], or any of the `vararg` overloads for any
     * [Access API][org.jetbrains.kotlinx.dataframe.documentation.AccessApi].
     *
     * Aside from calling [cols][org.jetbrains.kotlinx.dataframe.api.ColsColumnsSelectionDsl.cols] directly, you can also use the [get][org.jetbrains.kotlinx.dataframe.columns.ColumnSet.get] operator in most cases.
     *
     * #### For example:
     * `df.`[remove][org.jetbrains.kotlinx.dataframe.DataFrame.remove]` { `[cols][org.jetbrains.kotlinx.dataframe.api.ColumnsSelectionDsl.cols]` { it.`[hasNulls][org.jetbrains.kotlinx.dataframe.DataColumn.hasNulls]`() }.`[recursively][ColumnsSelectionDsl.recursively]`() }`
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { myGroupCol.`[cols][org.jetbrains.kotlinx.dataframe.columns.SingleColumn.cols]`(columnA, columnB) }`
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { `[colsOf][org.jetbrains.kotlinx.dataframe.api.ColumnsSelectionDsl.colsOf]`<`[String][String]`>()`[`[`][org.jetbrains.kotlinx.dataframe.columns.ColumnSet.cols]`1, 3, 5`[`]`][org.jetbrains.kotlinx.dataframe.columns.ColumnSet.cols]` }`
     *
     * #### Examples for this overload:
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { "columnGroup".`[cols][kotlin.String.cols]`("columnA", "columnB") }`
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { "columnGroup"`[`[`][kotlin.String.cols]`"columnA", "columnB"`[`]`][kotlin.String.cols]` }`
     *
     *
     * @param [firstCol] A [String] that points to a column.
     * @param [otherCols] Optional additional [String]s that point to columns.
     * @return A ([transformable][org.jetbrains.kotlinx.dataframe.impl.columns.TransformableColumnSet]) [ColumnSet][org.jetbrains.kotlinx.dataframe.columns.ColumnSet] containing the columns that [firstCol] and [otherCols] point to. 
     */
    public operator fun String.get(
        firstCol: String,
        vararg otherCols: String,
    ): ColumnSet<*> = cols(firstCol, *otherCols)

    /**
     * ## Cols
     * Creates a subset of columns ([ColumnSet][org.jetbrains.kotlinx.dataframe.columns.ColumnSet]) from the current [ColumnsResolver][org.jetbrains.kotlinx.dataframe.columns.ColumnsResolver].
     *
     * If the current [ColumnsResolver][org.jetbrains.kotlinx.dataframe.columns.ColumnsResolver] is a [SingleColumn][org.jetbrains.kotlinx.dataframe.columns.SingleColumn] and consists of a [column group][org.jetbrains.kotlinx.dataframe.columns.ColumnGroup],
     * then `cols` will create a subset of its contained columns.
     *
     * You can use either a [ColumnFilter][org.jetbrains.kotlinx.dataframe.ColumnFilter], or any of the `vararg` overloads for any
     * [Access API][org.jetbrains.kotlinx.dataframe.documentation.AccessApi].
     *
     * Aside from calling [cols][org.jetbrains.kotlinx.dataframe.api.ColsColumnsSelectionDsl.cols] directly, you can also use the [get][org.jetbrains.kotlinx.dataframe.columns.ColumnSet.get] operator in most cases.
     *
     * #### For example:
     * `df.`[remove][org.jetbrains.kotlinx.dataframe.DataFrame.remove]` { `[cols][org.jetbrains.kotlinx.dataframe.api.ColumnsSelectionDsl.cols]` { it.`[hasNulls][org.jetbrains.kotlinx.dataframe.DataColumn.hasNulls]`() }.`[recursively][ColumnsSelectionDsl.recursively]`() }`
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { myGroupCol.`[cols][org.jetbrains.kotlinx.dataframe.columns.SingleColumn.cols]`(columnA, columnB) }`
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { `[colsOf][org.jetbrains.kotlinx.dataframe.api.ColumnsSelectionDsl.colsOf]`<`[String][String]`>()`[`[`][org.jetbrains.kotlinx.dataframe.columns.ColumnSet.cols]`1, 3, 5`[`]`][org.jetbrains.kotlinx.dataframe.columns.ColumnSet.cols]` }`
     *
     * #### Examples for this overload:
     *
     * `df.`[select][DataFrame.select]` { Type::myColumnGroup.`[cols][SingleColumn.cols]`("columnA", "columnB") }`
     *
     * `df.`[select][DataFrame.select]` { DataSchemaType::myColumnGroup`[`[`][KProperty.cols]`"columnA", "columnB"`[`]`][KProperty.cols]` }`
     *
     *
     * @param [firstCol] A [String] that points to a column.
     * @param [otherCols] Optional additional [String]s that point to columns.
     * @return A ([transformable][org.jetbrains.kotlinx.dataframe.impl.columns.TransformableColumnSet]) [ColumnSet][org.jetbrains.kotlinx.dataframe.columns.ColumnSet] containing the columns that [firstCol] and [otherCols] point to. 
     */
    private interface KPropertiesColsVarargStringDocs

    /** ## Cols
     * Creates a subset of columns ([ColumnSet][org.jetbrains.kotlinx.dataframe.columns.ColumnSet]) from the current [ColumnsResolver][org.jetbrains.kotlinx.dataframe.columns.ColumnsResolver].
     *
     * If the current [ColumnsResolver][org.jetbrains.kotlinx.dataframe.columns.ColumnsResolver] is a [SingleColumn][org.jetbrains.kotlinx.dataframe.columns.SingleColumn] and consists of a [column group][org.jetbrains.kotlinx.dataframe.columns.ColumnGroup],
     * then `cols` will create a subset of its contained columns.
     *
     * You can use either a [ColumnFilter][org.jetbrains.kotlinx.dataframe.ColumnFilter], or any of the `vararg` overloads for any
     * [Access API][org.jetbrains.kotlinx.dataframe.documentation.AccessApi].
     *
     * Aside from calling [cols][org.jetbrains.kotlinx.dataframe.api.ColsColumnsSelectionDsl.cols] directly, you can also use the [get][org.jetbrains.kotlinx.dataframe.columns.ColumnSet.get] operator in most cases.
     *
     * #### For example:
     * `df.`[remove][org.jetbrains.kotlinx.dataframe.DataFrame.remove]` { `[cols][org.jetbrains.kotlinx.dataframe.api.ColumnsSelectionDsl.cols]` { it.`[hasNulls][org.jetbrains.kotlinx.dataframe.DataColumn.hasNulls]`() }.`[recursively][ColumnsSelectionDsl.recursively]`() }`
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { myGroupCol.`[cols][org.jetbrains.kotlinx.dataframe.columns.SingleColumn.cols]`(columnA, columnB) }`
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { `[colsOf][org.jetbrains.kotlinx.dataframe.api.ColumnsSelectionDsl.colsOf]`<`[String][String]`>()`[`[`][org.jetbrains.kotlinx.dataframe.columns.ColumnSet.cols]`1, 3, 5`[`]`][org.jetbrains.kotlinx.dataframe.columns.ColumnSet.cols]` }`
     *
     * #### Examples for this overload:
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { Type::myColumnGroup.`[cols][org.jetbrains.kotlinx.dataframe.columns.SingleColumn.cols]`("columnA", "columnB") }`
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { DataSchemaType::myColumnGroup`[`[`][kotlin.reflect.KProperty.cols]`"columnA", "columnB"`[`]`][kotlin.reflect.KProperty.cols]` }`
     *
     *
     * @param [firstCol] A [String] that points to a column.
     * @param [otherCols] Optional additional [String]s that point to columns.
     * @return A ([transformable][org.jetbrains.kotlinx.dataframe.impl.columns.TransformableColumnSet]) [ColumnSet][org.jetbrains.kotlinx.dataframe.columns.ColumnSet] containing the columns that [firstCol] and [otherCols] point to. 
     */
    public fun KProperty<*>.cols(
        firstCol: String,
        vararg otherCols: String,
    ): ColumnSet<*> = columnGroup(this).cols(firstCol, *otherCols)

    /** ## Cols
     * Creates a subset of columns ([ColumnSet][org.jetbrains.kotlinx.dataframe.columns.ColumnSet]) from the current [ColumnsResolver][org.jetbrains.kotlinx.dataframe.columns.ColumnsResolver].
     *
     * If the current [ColumnsResolver][org.jetbrains.kotlinx.dataframe.columns.ColumnsResolver] is a [SingleColumn][org.jetbrains.kotlinx.dataframe.columns.SingleColumn] and consists of a [column group][org.jetbrains.kotlinx.dataframe.columns.ColumnGroup],
     * then `cols` will create a subset of its contained columns.
     *
     * You can use either a [ColumnFilter][org.jetbrains.kotlinx.dataframe.ColumnFilter], or any of the `vararg` overloads for any
     * [Access API][org.jetbrains.kotlinx.dataframe.documentation.AccessApi].
     *
     * Aside from calling [cols][org.jetbrains.kotlinx.dataframe.api.ColsColumnsSelectionDsl.cols] directly, you can also use the [get][org.jetbrains.kotlinx.dataframe.columns.ColumnSet.get] operator in most cases.
     *
     * #### For example:
     * `df.`[remove][org.jetbrains.kotlinx.dataframe.DataFrame.remove]` { `[cols][org.jetbrains.kotlinx.dataframe.api.ColumnsSelectionDsl.cols]` { it.`[hasNulls][org.jetbrains.kotlinx.dataframe.DataColumn.hasNulls]`() }.`[recursively][ColumnsSelectionDsl.recursively]`() }`
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { myGroupCol.`[cols][org.jetbrains.kotlinx.dataframe.columns.SingleColumn.cols]`(columnA, columnB) }`
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { `[colsOf][org.jetbrains.kotlinx.dataframe.api.ColumnsSelectionDsl.colsOf]`<`[String][String]`>()`[`[`][org.jetbrains.kotlinx.dataframe.columns.ColumnSet.cols]`1, 3, 5`[`]`][org.jetbrains.kotlinx.dataframe.columns.ColumnSet.cols]` }`
     *
     * #### Examples for this overload:
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { Type::myColumnGroup.`[cols][org.jetbrains.kotlinx.dataframe.columns.SingleColumn.cols]`("columnA", "columnB") }`
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { DataSchemaType::myColumnGroup`[`[`][kotlin.reflect.KProperty.cols]`"columnA", "columnB"`[`]`][kotlin.reflect.KProperty.cols]` }`
     *
     *
     * @param [firstCol] A [String] that points to a column.
     * @param [otherCols] Optional additional [String]s that point to columns.
     * @return A ([transformable][org.jetbrains.kotlinx.dataframe.impl.columns.TransformableColumnSet]) [ColumnSet][org.jetbrains.kotlinx.dataframe.columns.ColumnSet] containing the columns that [firstCol] and [otherCols] point to. 
     */
    public operator fun KProperty<*>.get(
        firstCol: String,
        vararg otherCols: String,
    ): ColumnSet<*> = cols(firstCol, *otherCols)

    /**
     * ## Cols
     * Creates a subset of columns ([ColumnSet][org.jetbrains.kotlinx.dataframe.columns.ColumnSet]) from the current [ColumnsResolver][org.jetbrains.kotlinx.dataframe.columns.ColumnsResolver].
     *
     * If the current [ColumnsResolver][org.jetbrains.kotlinx.dataframe.columns.ColumnsResolver] is a [SingleColumn][org.jetbrains.kotlinx.dataframe.columns.SingleColumn] and consists of a [column group][org.jetbrains.kotlinx.dataframe.columns.ColumnGroup],
     * then `cols` will create a subset of its contained columns.
     *
     * You can use either a [ColumnFilter][org.jetbrains.kotlinx.dataframe.ColumnFilter], or any of the `vararg` overloads for any
     * [Access API][org.jetbrains.kotlinx.dataframe.documentation.AccessApi].
     *
     * Aside from calling [cols][org.jetbrains.kotlinx.dataframe.api.ColsColumnsSelectionDsl.cols] directly, you can also use the [get][org.jetbrains.kotlinx.dataframe.columns.ColumnSet.get] operator in most cases.
     *
     * #### For example:
     * `df.`[remove][org.jetbrains.kotlinx.dataframe.DataFrame.remove]` { `[cols][org.jetbrains.kotlinx.dataframe.api.ColumnsSelectionDsl.cols]` { it.`[hasNulls][org.jetbrains.kotlinx.dataframe.DataColumn.hasNulls]`() }.`[recursively][ColumnsSelectionDsl.recursively]`() }`
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { myGroupCol.`[cols][org.jetbrains.kotlinx.dataframe.columns.SingleColumn.cols]`(columnA, columnB) }`
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { `[colsOf][org.jetbrains.kotlinx.dataframe.api.ColumnsSelectionDsl.colsOf]`<`[String][String]`>()`[`[`][org.jetbrains.kotlinx.dataframe.columns.ColumnSet.cols]`1, 3, 5`[`]`][org.jetbrains.kotlinx.dataframe.columns.ColumnSet.cols]` }`
     *
     * #### Examples for this overload:
     *
     * `df.`[select][DataFrame.select]` { "pathTo"["columnGroup"].`[cols][ColumnPath.cols]`("columnA", "columnB") }`
     *
     * `df.`[select][DataFrame.select]` { "pathTo"["columnGroup"]`[`[`][ColumnPath.cols]`"columnA", "columnB"`[`]`][ColumnPath.cols]` }`
     *
     *
     * @param [firstCol] A [String] that points to a column.
     * @param [otherCols] Optional additional [String]s that point to columns.
     * @return A ([transformable][org.jetbrains.kotlinx.dataframe.impl.columns.TransformableColumnSet]) [ColumnSet][org.jetbrains.kotlinx.dataframe.columns.ColumnSet] containing the columns that [firstCol] and [otherCols] point to. 
     */
    private interface ColumnPathColsVarargStringDocs

    /** ## Cols
     * Creates a subset of columns ([ColumnSet][org.jetbrains.kotlinx.dataframe.columns.ColumnSet]) from the current [ColumnsResolver][org.jetbrains.kotlinx.dataframe.columns.ColumnsResolver].
     *
     * If the current [ColumnsResolver][org.jetbrains.kotlinx.dataframe.columns.ColumnsResolver] is a [SingleColumn][org.jetbrains.kotlinx.dataframe.columns.SingleColumn] and consists of a [column group][org.jetbrains.kotlinx.dataframe.columns.ColumnGroup],
     * then `cols` will create a subset of its contained columns.
     *
     * You can use either a [ColumnFilter][org.jetbrains.kotlinx.dataframe.ColumnFilter], or any of the `vararg` overloads for any
     * [Access API][org.jetbrains.kotlinx.dataframe.documentation.AccessApi].
     *
     * Aside from calling [cols][org.jetbrains.kotlinx.dataframe.api.ColsColumnsSelectionDsl.cols] directly, you can also use the [get][org.jetbrains.kotlinx.dataframe.columns.ColumnSet.get] operator in most cases.
     *
     * #### For example:
     * `df.`[remove][org.jetbrains.kotlinx.dataframe.DataFrame.remove]` { `[cols][org.jetbrains.kotlinx.dataframe.api.ColumnsSelectionDsl.cols]` { it.`[hasNulls][org.jetbrains.kotlinx.dataframe.DataColumn.hasNulls]`() }.`[recursively][ColumnsSelectionDsl.recursively]`() }`
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { myGroupCol.`[cols][org.jetbrains.kotlinx.dataframe.columns.SingleColumn.cols]`(columnA, columnB) }`
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { `[colsOf][org.jetbrains.kotlinx.dataframe.api.ColumnsSelectionDsl.colsOf]`<`[String][String]`>()`[`[`][org.jetbrains.kotlinx.dataframe.columns.ColumnSet.cols]`1, 3, 5`[`]`][org.jetbrains.kotlinx.dataframe.columns.ColumnSet.cols]` }`
     *
     * #### Examples for this overload:
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { "pathTo"["columnGroup"].`[cols][org.jetbrains.kotlinx.dataframe.columns.ColumnPath.cols]`("columnA", "columnB") }`
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { "pathTo"["columnGroup"]`[`[`][org.jetbrains.kotlinx.dataframe.columns.ColumnPath.cols]`"columnA", "columnB"`[`]`][org.jetbrains.kotlinx.dataframe.columns.ColumnPath.cols]` }`
     *
     *
     * @param [firstCol] A [String] that points to a column.
     * @param [otherCols] Optional additional [String]s that point to columns.
     * @return A ([transformable][org.jetbrains.kotlinx.dataframe.impl.columns.TransformableColumnSet]) [ColumnSet][org.jetbrains.kotlinx.dataframe.columns.ColumnSet] containing the columns that [firstCol] and [otherCols] point to. 
     */
    public fun ColumnPath.cols(
        firstCol: String,
        vararg otherCols: String,
    ): ColumnSet<*> = columnGroup(this).cols(firstCol, *otherCols)

    /** ## Cols
     * Creates a subset of columns ([ColumnSet][org.jetbrains.kotlinx.dataframe.columns.ColumnSet]) from the current [ColumnsResolver][org.jetbrains.kotlinx.dataframe.columns.ColumnsResolver].
     *
     * If the current [ColumnsResolver][org.jetbrains.kotlinx.dataframe.columns.ColumnsResolver] is a [SingleColumn][org.jetbrains.kotlinx.dataframe.columns.SingleColumn] and consists of a [column group][org.jetbrains.kotlinx.dataframe.columns.ColumnGroup],
     * then `cols` will create a subset of its contained columns.
     *
     * You can use either a [ColumnFilter][org.jetbrains.kotlinx.dataframe.ColumnFilter], or any of the `vararg` overloads for any
     * [Access API][org.jetbrains.kotlinx.dataframe.documentation.AccessApi].
     *
     * Aside from calling [cols][org.jetbrains.kotlinx.dataframe.api.ColsColumnsSelectionDsl.cols] directly, you can also use the [get][org.jetbrains.kotlinx.dataframe.columns.ColumnSet.get] operator in most cases.
     *
     * #### For example:
     * `df.`[remove][org.jetbrains.kotlinx.dataframe.DataFrame.remove]` { `[cols][org.jetbrains.kotlinx.dataframe.api.ColumnsSelectionDsl.cols]` { it.`[hasNulls][org.jetbrains.kotlinx.dataframe.DataColumn.hasNulls]`() }.`[recursively][ColumnsSelectionDsl.recursively]`() }`
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { myGroupCol.`[cols][org.jetbrains.kotlinx.dataframe.columns.SingleColumn.cols]`(columnA, columnB) }`
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { `[colsOf][org.jetbrains.kotlinx.dataframe.api.ColumnsSelectionDsl.colsOf]`<`[String][String]`>()`[`[`][org.jetbrains.kotlinx.dataframe.columns.ColumnSet.cols]`1, 3, 5`[`]`][org.jetbrains.kotlinx.dataframe.columns.ColumnSet.cols]` }`
     *
     * #### Examples for this overload:
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { "pathTo"["columnGroup"].`[cols][org.jetbrains.kotlinx.dataframe.columns.ColumnPath.cols]`("columnA", "columnB") }`
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { "pathTo"["columnGroup"]`[`[`][org.jetbrains.kotlinx.dataframe.columns.ColumnPath.cols]`"columnA", "columnB"`[`]`][org.jetbrains.kotlinx.dataframe.columns.ColumnPath.cols]` }`
     *
     *
     * @param [firstCol] A [String] that points to a column.
     * @param [otherCols] Optional additional [String]s that point to columns.
     * @return A ([transformable][org.jetbrains.kotlinx.dataframe.impl.columns.TransformableColumnSet]) [ColumnSet][org.jetbrains.kotlinx.dataframe.columns.ColumnSet] containing the columns that [firstCol] and [otherCols] point to. 
     */
    public operator fun ColumnPath.get(
        firstCol: String,
        vararg otherCols: String,
    ): ColumnSet<*> = cols(firstCol, *otherCols)

    // endregion

    // region properties

    /**
     * ## Cols
     * Creates a subset of columns ([ColumnSet][org.jetbrains.kotlinx.dataframe.columns.ColumnSet]) from the current [ColumnsResolver][org.jetbrains.kotlinx.dataframe.columns.ColumnsResolver].
     *
     * If the current [ColumnsResolver][org.jetbrains.kotlinx.dataframe.columns.ColumnsResolver] is a [SingleColumn][org.jetbrains.kotlinx.dataframe.columns.SingleColumn] and consists of a [column group][org.jetbrains.kotlinx.dataframe.columns.ColumnGroup],
     * then `cols` will create a subset of its contained columns.
     *
     * You can use either a [ColumnFilter][org.jetbrains.kotlinx.dataframe.ColumnFilter], or any of the `vararg` overloads for any
     * [Access API][org.jetbrains.kotlinx.dataframe.documentation.AccessApi].
     *
     * Aside from calling [cols][org.jetbrains.kotlinx.dataframe.api.ColsColumnsSelectionDsl.cols] directly, you can also use the [get][org.jetbrains.kotlinx.dataframe.columns.ColumnSet.get] operator in most cases.
     *
     * #### For example:
     * `df.`[remove][org.jetbrains.kotlinx.dataframe.DataFrame.remove]` { `[cols][org.jetbrains.kotlinx.dataframe.api.ColumnsSelectionDsl.cols]` { it.`[hasNulls][org.jetbrains.kotlinx.dataframe.DataColumn.hasNulls]`() }.`[recursively][ColumnsSelectionDsl.recursively]`() }`
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { myGroupCol.`[cols][org.jetbrains.kotlinx.dataframe.columns.SingleColumn.cols]`(columnA, columnB) }`
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { `[colsOf][org.jetbrains.kotlinx.dataframe.api.ColumnsSelectionDsl.colsOf]`<`[String][String]`>()`[`[`][org.jetbrains.kotlinx.dataframe.columns.ColumnSet.cols]`1, 3, 5`[`]`][org.jetbrains.kotlinx.dataframe.columns.ColumnSet.cols]` }`
     *
     * #### Examples for this overload:
     *
     * `df.`[select][DataFrame.select]` { `[colsOf][SingleColumn.colsOf]`<`[String][String]`>().`[cols][ColumnSet.cols]`(Type::colA, Type::colB) }`
     *
     * `df.`[select][DataFrame.select]` { `[colsOf][SingleColumn.colsOf]`<`[String][String]`>()`[`[`][ColumnSet.cols]`Type::colA, Type::colB`[`]`][ColumnSet.cols]` }`
     *
     *
     * @param [firstCol] A [KProperty] that points to a column.
     * @param [otherCols] Optional additional [KProperty]s that point to columns.
     * @return A ([transformable][org.jetbrains.kotlinx.dataframe.impl.columns.TransformableColumnSet]) [ColumnSet][org.jetbrains.kotlinx.dataframe.columns.ColumnSet] containing the columns that [firstCol] and [otherCols] point to. 
     */
    private interface ColumnSetColsVarargKPropertyDocs

    /** ## Cols
     * Creates a subset of columns ([ColumnSet][org.jetbrains.kotlinx.dataframe.columns.ColumnSet]) from the current [ColumnsResolver][org.jetbrains.kotlinx.dataframe.columns.ColumnsResolver].
     *
     * If the current [ColumnsResolver][org.jetbrains.kotlinx.dataframe.columns.ColumnsResolver] is a [SingleColumn][org.jetbrains.kotlinx.dataframe.columns.SingleColumn] and consists of a [column group][org.jetbrains.kotlinx.dataframe.columns.ColumnGroup],
     * then `cols` will create a subset of its contained columns.
     *
     * You can use either a [ColumnFilter][org.jetbrains.kotlinx.dataframe.ColumnFilter], or any of the `vararg` overloads for any
     * [Access API][org.jetbrains.kotlinx.dataframe.documentation.AccessApi].
     *
     * Aside from calling [cols][org.jetbrains.kotlinx.dataframe.api.ColsColumnsSelectionDsl.cols] directly, you can also use the [get][org.jetbrains.kotlinx.dataframe.columns.ColumnSet.get] operator in most cases.
     *
     * #### For example:
     * `df.`[remove][org.jetbrains.kotlinx.dataframe.DataFrame.remove]` { `[cols][org.jetbrains.kotlinx.dataframe.api.ColumnsSelectionDsl.cols]` { it.`[hasNulls][org.jetbrains.kotlinx.dataframe.DataColumn.hasNulls]`() }.`[recursively][ColumnsSelectionDsl.recursively]`() }`
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { myGroupCol.`[cols][org.jetbrains.kotlinx.dataframe.columns.SingleColumn.cols]`(columnA, columnB) }`
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { `[colsOf][org.jetbrains.kotlinx.dataframe.api.ColumnsSelectionDsl.colsOf]`<`[String][String]`>()`[`[`][org.jetbrains.kotlinx.dataframe.columns.ColumnSet.cols]`1, 3, 5`[`]`][org.jetbrains.kotlinx.dataframe.columns.ColumnSet.cols]` }`
     *
     * #### Examples for this overload:
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { `[colsOf][org.jetbrains.kotlinx.dataframe.columns.SingleColumn.colsOf]`<`[String][String]`>().`[cols][org.jetbrains.kotlinx.dataframe.columns.ColumnSet.cols]`(Type::colA, Type::colB) }`
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { `[colsOf][org.jetbrains.kotlinx.dataframe.columns.SingleColumn.colsOf]`<`[String][String]`>()`[`[`][org.jetbrains.kotlinx.dataframe.columns.ColumnSet.cols]`Type::colA, Type::colB`[`]`][org.jetbrains.kotlinx.dataframe.columns.ColumnSet.cols]` }`
     *
     *
     * @param [firstCol] A [KProperty] that points to a column.
     * @param [otherCols] Optional additional [KProperty]s that point to columns.
     * @return A ([transformable][org.jetbrains.kotlinx.dataframe.impl.columns.TransformableColumnSet]) [ColumnSet][org.jetbrains.kotlinx.dataframe.columns.ColumnSet] containing the columns that [firstCol] and [otherCols] point to. 
     */
    @Suppress("UNCHECKED_CAST")
    public fun <C> ColumnSet<C>.cols(
        firstCol: KProperty<C>,
        vararg otherCols: KProperty<C>,
    ): ColumnSet<C> = headPlusArray(firstCol, otherCols).map { it.name }.let { names ->
        colsInternal { it.name in names } as ColumnSet<C>
    }

    /** ## Cols
     * Creates a subset of columns ([ColumnSet][org.jetbrains.kotlinx.dataframe.columns.ColumnSet]) from the current [ColumnsResolver][org.jetbrains.kotlinx.dataframe.columns.ColumnsResolver].
     *
     * If the current [ColumnsResolver][org.jetbrains.kotlinx.dataframe.columns.ColumnsResolver] is a [SingleColumn][org.jetbrains.kotlinx.dataframe.columns.SingleColumn] and consists of a [column group][org.jetbrains.kotlinx.dataframe.columns.ColumnGroup],
     * then `cols` will create a subset of its contained columns.
     *
     * You can use either a [ColumnFilter][org.jetbrains.kotlinx.dataframe.ColumnFilter], or any of the `vararg` overloads for any
     * [Access API][org.jetbrains.kotlinx.dataframe.documentation.AccessApi].
     *
     * Aside from calling [cols][org.jetbrains.kotlinx.dataframe.api.ColsColumnsSelectionDsl.cols] directly, you can also use the [get][org.jetbrains.kotlinx.dataframe.columns.ColumnSet.get] operator in most cases.
     *
     * #### For example:
     * `df.`[remove][org.jetbrains.kotlinx.dataframe.DataFrame.remove]` { `[cols][org.jetbrains.kotlinx.dataframe.api.ColumnsSelectionDsl.cols]` { it.`[hasNulls][org.jetbrains.kotlinx.dataframe.DataColumn.hasNulls]`() }.`[recursively][ColumnsSelectionDsl.recursively]`() }`
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { myGroupCol.`[cols][org.jetbrains.kotlinx.dataframe.columns.SingleColumn.cols]`(columnA, columnB) }`
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { `[colsOf][org.jetbrains.kotlinx.dataframe.api.ColumnsSelectionDsl.colsOf]`<`[String][String]`>()`[`[`][org.jetbrains.kotlinx.dataframe.columns.ColumnSet.cols]`1, 3, 5`[`]`][org.jetbrains.kotlinx.dataframe.columns.ColumnSet.cols]` }`
     *
     * #### Examples for this overload:
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { `[colsOf][org.jetbrains.kotlinx.dataframe.columns.SingleColumn.colsOf]`<`[String][String]`>().`[cols][org.jetbrains.kotlinx.dataframe.columns.ColumnSet.cols]`(Type::colA, Type::colB) }`
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { `[colsOf][org.jetbrains.kotlinx.dataframe.columns.SingleColumn.colsOf]`<`[String][String]`>()`[`[`][org.jetbrains.kotlinx.dataframe.columns.ColumnSet.cols]`Type::colA, Type::colB`[`]`][org.jetbrains.kotlinx.dataframe.columns.ColumnSet.cols]` }`
     *
     *
     * @param [firstCol] A [KProperty] that points to a column.
     * @param [otherCols] Optional additional [KProperty]s that point to columns.
     * @return A ([transformable][org.jetbrains.kotlinx.dataframe.impl.columns.TransformableColumnSet]) [ColumnSet][org.jetbrains.kotlinx.dataframe.columns.ColumnSet] containing the columns that [firstCol] and [otherCols] point to. 
     */
    public operator fun <C> ColumnSet<C>.get(
        firstCol: KProperty<C>,
        vararg otherCols: KProperty<C>,
    ): ColumnSet<C> = cols(firstCol, *otherCols)

    /**
     * ## Cols
     * Creates a subset of columns ([ColumnSet][org.jetbrains.kotlinx.dataframe.columns.ColumnSet]) from the current [ColumnsResolver][org.jetbrains.kotlinx.dataframe.columns.ColumnsResolver].
     *
     * If the current [ColumnsResolver][org.jetbrains.kotlinx.dataframe.columns.ColumnsResolver] is a [SingleColumn][org.jetbrains.kotlinx.dataframe.columns.SingleColumn] and consists of a [column group][org.jetbrains.kotlinx.dataframe.columns.ColumnGroup],
     * then `cols` will create a subset of its contained columns.
     *
     * You can use either a [ColumnFilter][org.jetbrains.kotlinx.dataframe.ColumnFilter], or any of the `vararg` overloads for any
     * [Access API][org.jetbrains.kotlinx.dataframe.documentation.AccessApi].
     *
     * Aside from calling [cols][org.jetbrains.kotlinx.dataframe.api.ColsColumnsSelectionDsl.cols] directly, you can also use the [get][org.jetbrains.kotlinx.dataframe.columns.ColumnSet.get] operator in most cases.
     *
     * #### For example:
     * `df.`[remove][org.jetbrains.kotlinx.dataframe.DataFrame.remove]` { `[cols][org.jetbrains.kotlinx.dataframe.api.ColumnsSelectionDsl.cols]` { it.`[hasNulls][org.jetbrains.kotlinx.dataframe.DataColumn.hasNulls]`() }.`[recursively][ColumnsSelectionDsl.recursively]`() }`
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { myGroupCol.`[cols][org.jetbrains.kotlinx.dataframe.columns.SingleColumn.cols]`(columnA, columnB) }`
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { `[colsOf][org.jetbrains.kotlinx.dataframe.api.ColumnsSelectionDsl.colsOf]`<`[String][String]`>()`[`[`][org.jetbrains.kotlinx.dataframe.columns.ColumnSet.cols]`1, 3, 5`[`]`][org.jetbrains.kotlinx.dataframe.columns.ColumnSet.cols]` }`
     *
     * #### Examples for this overload:
     *
     * `df.`[select][DataFrame.select]` { `[cols][ColumnsSelectionDsl.cols]`(Type::colA, Type::colB) }`
     *
     * `df.`[select][DataFrame.select]` { this`[`[`][ColumnsSelectionDsl.cols]`Type::colA, Type::colB`[`]`][ColumnsSelectionDsl.cols]` }`
     *
     *
     * @param [firstCol] A [KProperty] that points to a column.
     * @param [otherCols] Optional additional [KProperty]s that point to columns.
     * @return A ([transformable][org.jetbrains.kotlinx.dataframe.impl.columns.TransformableColumnSet]) [ColumnSet][org.jetbrains.kotlinx.dataframe.columns.ColumnSet] containing the columns that [firstCol] and [otherCols] point to. 
     */
    private interface ColumnsSelectionDslColsVarargKPropertyDocs

    /** ## Cols
     * Creates a subset of columns ([ColumnSet][org.jetbrains.kotlinx.dataframe.columns.ColumnSet]) from the current [ColumnsResolver][org.jetbrains.kotlinx.dataframe.columns.ColumnsResolver].
     *
     * If the current [ColumnsResolver][org.jetbrains.kotlinx.dataframe.columns.ColumnsResolver] is a [SingleColumn][org.jetbrains.kotlinx.dataframe.columns.SingleColumn] and consists of a [column group][org.jetbrains.kotlinx.dataframe.columns.ColumnGroup],
     * then `cols` will create a subset of its contained columns.
     *
     * You can use either a [ColumnFilter][org.jetbrains.kotlinx.dataframe.ColumnFilter], or any of the `vararg` overloads for any
     * [Access API][org.jetbrains.kotlinx.dataframe.documentation.AccessApi].
     *
     * Aside from calling [cols][org.jetbrains.kotlinx.dataframe.api.ColsColumnsSelectionDsl.cols] directly, you can also use the [get][org.jetbrains.kotlinx.dataframe.columns.ColumnSet.get] operator in most cases.
     *
     * #### For example:
     * `df.`[remove][org.jetbrains.kotlinx.dataframe.DataFrame.remove]` { `[cols][org.jetbrains.kotlinx.dataframe.api.ColumnsSelectionDsl.cols]` { it.`[hasNulls][org.jetbrains.kotlinx.dataframe.DataColumn.hasNulls]`() }.`[recursively][ColumnsSelectionDsl.recursively]`() }`
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { myGroupCol.`[cols][org.jetbrains.kotlinx.dataframe.columns.SingleColumn.cols]`(columnA, columnB) }`
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { `[colsOf][org.jetbrains.kotlinx.dataframe.api.ColumnsSelectionDsl.colsOf]`<`[String][String]`>()`[`[`][org.jetbrains.kotlinx.dataframe.columns.ColumnSet.cols]`1, 3, 5`[`]`][org.jetbrains.kotlinx.dataframe.columns.ColumnSet.cols]` }`
     *
     * #### Examples for this overload:
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { `[cols][org.jetbrains.kotlinx.dataframe.api.ColumnsSelectionDsl.cols]`(Type::colA, Type::colB) }`
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { this`[`[`][org.jetbrains.kotlinx.dataframe.api.ColumnsSelectionDsl.cols]`Type::colA, Type::colB`[`]`][org.jetbrains.kotlinx.dataframe.api.ColumnsSelectionDsl.cols]` }`
     *
     *
     * @param [firstCol] A [KProperty] that points to a column.
     * @param [otherCols] Optional additional [KProperty]s that point to columns.
     * @return A ([transformable][org.jetbrains.kotlinx.dataframe.impl.columns.TransformableColumnSet]) [ColumnSet][org.jetbrains.kotlinx.dataframe.columns.ColumnSet] containing the columns that [firstCol] and [otherCols] point to. 
     */
    public fun <C> ColumnsSelectionDsl<*>.cols(
        firstCol: KProperty<C>,
        vararg otherCols: KProperty<C>,
    ): ColumnSet<C> = this.asSingleColumn().cols(firstCol, *otherCols)

    /** ## Cols
     * Creates a subset of columns ([ColumnSet][org.jetbrains.kotlinx.dataframe.columns.ColumnSet]) from the current [ColumnsResolver][org.jetbrains.kotlinx.dataframe.columns.ColumnsResolver].
     *
     * If the current [ColumnsResolver][org.jetbrains.kotlinx.dataframe.columns.ColumnsResolver] is a [SingleColumn][org.jetbrains.kotlinx.dataframe.columns.SingleColumn] and consists of a [column group][org.jetbrains.kotlinx.dataframe.columns.ColumnGroup],
     * then `cols` will create a subset of its contained columns.
     *
     * You can use either a [ColumnFilter][org.jetbrains.kotlinx.dataframe.ColumnFilter], or any of the `vararg` overloads for any
     * [Access API][org.jetbrains.kotlinx.dataframe.documentation.AccessApi].
     *
     * Aside from calling [cols][org.jetbrains.kotlinx.dataframe.api.ColsColumnsSelectionDsl.cols] directly, you can also use the [get][org.jetbrains.kotlinx.dataframe.columns.ColumnSet.get] operator in most cases.
     *
     * #### For example:
     * `df.`[remove][org.jetbrains.kotlinx.dataframe.DataFrame.remove]` { `[cols][org.jetbrains.kotlinx.dataframe.api.ColumnsSelectionDsl.cols]` { it.`[hasNulls][org.jetbrains.kotlinx.dataframe.DataColumn.hasNulls]`() }.`[recursively][ColumnsSelectionDsl.recursively]`() }`
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { myGroupCol.`[cols][org.jetbrains.kotlinx.dataframe.columns.SingleColumn.cols]`(columnA, columnB) }`
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { `[colsOf][org.jetbrains.kotlinx.dataframe.api.ColumnsSelectionDsl.colsOf]`<`[String][String]`>()`[`[`][org.jetbrains.kotlinx.dataframe.columns.ColumnSet.cols]`1, 3, 5`[`]`][org.jetbrains.kotlinx.dataframe.columns.ColumnSet.cols]` }`
     *
     * #### Examples for this overload:
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { `[cols][org.jetbrains.kotlinx.dataframe.api.ColumnsSelectionDsl.cols]`(Type::colA, Type::colB) }`
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { this`[`[`][org.jetbrains.kotlinx.dataframe.api.ColumnsSelectionDsl.cols]`Type::colA, Type::colB`[`]`][org.jetbrains.kotlinx.dataframe.api.ColumnsSelectionDsl.cols]` }`
     *
     *
     * @param [firstCol] A [KProperty] that points to a column.
     * @param [otherCols] Optional additional [KProperty]s that point to columns.
     * @return A ([transformable][org.jetbrains.kotlinx.dataframe.impl.columns.TransformableColumnSet]) [ColumnSet][org.jetbrains.kotlinx.dataframe.columns.ColumnSet] containing the columns that [firstCol] and [otherCols] point to. 
     */
    public operator fun <C> ColumnsSelectionDsl<*>.get(
        firstCol: KProperty<C>,
        vararg otherCols: KProperty<C>,
    ): ColumnSet<C> = cols(firstCol, *otherCols)

    /**
     * ## Cols
     * Creates a subset of columns ([ColumnSet][org.jetbrains.kotlinx.dataframe.columns.ColumnSet]) from the current [ColumnsResolver][org.jetbrains.kotlinx.dataframe.columns.ColumnsResolver].
     *
     * If the current [ColumnsResolver][org.jetbrains.kotlinx.dataframe.columns.ColumnsResolver] is a [SingleColumn][org.jetbrains.kotlinx.dataframe.columns.SingleColumn] and consists of a [column group][org.jetbrains.kotlinx.dataframe.columns.ColumnGroup],
     * then `cols` will create a subset of its contained columns.
     *
     * You can use either a [ColumnFilter][org.jetbrains.kotlinx.dataframe.ColumnFilter], or any of the `vararg` overloads for any
     * [Access API][org.jetbrains.kotlinx.dataframe.documentation.AccessApi].
     *
     * Aside from calling [cols][org.jetbrains.kotlinx.dataframe.api.ColsColumnsSelectionDsl.cols] directly, you can also use the [get][org.jetbrains.kotlinx.dataframe.columns.ColumnSet.get] operator in most cases.
     *
     * #### For example:
     * `df.`[remove][org.jetbrains.kotlinx.dataframe.DataFrame.remove]` { `[cols][org.jetbrains.kotlinx.dataframe.api.ColumnsSelectionDsl.cols]` { it.`[hasNulls][org.jetbrains.kotlinx.dataframe.DataColumn.hasNulls]`() }.`[recursively][ColumnsSelectionDsl.recursively]`() }`
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { myGroupCol.`[cols][org.jetbrains.kotlinx.dataframe.columns.SingleColumn.cols]`(columnA, columnB) }`
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { `[colsOf][org.jetbrains.kotlinx.dataframe.api.ColumnsSelectionDsl.colsOf]`<`[String][String]`>()`[`[`][org.jetbrains.kotlinx.dataframe.columns.ColumnSet.cols]`1, 3, 5`[`]`][org.jetbrains.kotlinx.dataframe.columns.ColumnSet.cols]` }`
     *
     * #### Examples for this overload:
     *
     * `df.`[select][DataFrame.select]` { myColumnGroup.`[cols][SingleColumn.cols]`(Type::colA, Type::colB) }`
     *
     * `df.`[select][DataFrame.select]` { myColumnGroup`[`[`][SingleColumn.cols]`Type::colA, Type::colB`[`]`][SingleColumn.cols]` }`
     *
     *
     * @param [firstCol] A [KProperty] that points to a column.
     * @param [otherCols] Optional additional [KProperty]s that point to columns.
     * @return A ([transformable][org.jetbrains.kotlinx.dataframe.impl.columns.TransformableColumnSet]) [ColumnSet][org.jetbrains.kotlinx.dataframe.columns.ColumnSet] containing the columns that [firstCol] and [otherCols] point to. 
     */
    private interface SingleColumnColsVarargKPropertyDocs

    /** ## Cols
     * Creates a subset of columns ([ColumnSet][org.jetbrains.kotlinx.dataframe.columns.ColumnSet]) from the current [ColumnsResolver][org.jetbrains.kotlinx.dataframe.columns.ColumnsResolver].
     *
     * If the current [ColumnsResolver][org.jetbrains.kotlinx.dataframe.columns.ColumnsResolver] is a [SingleColumn][org.jetbrains.kotlinx.dataframe.columns.SingleColumn] and consists of a [column group][org.jetbrains.kotlinx.dataframe.columns.ColumnGroup],
     * then `cols` will create a subset of its contained columns.
     *
     * You can use either a [ColumnFilter][org.jetbrains.kotlinx.dataframe.ColumnFilter], or any of the `vararg` overloads for any
     * [Access API][org.jetbrains.kotlinx.dataframe.documentation.AccessApi].
     *
     * Aside from calling [cols][org.jetbrains.kotlinx.dataframe.api.ColsColumnsSelectionDsl.cols] directly, you can also use the [get][org.jetbrains.kotlinx.dataframe.columns.ColumnSet.get] operator in most cases.
     *
     * #### For example:
     * `df.`[remove][org.jetbrains.kotlinx.dataframe.DataFrame.remove]` { `[cols][org.jetbrains.kotlinx.dataframe.api.ColumnsSelectionDsl.cols]` { it.`[hasNulls][org.jetbrains.kotlinx.dataframe.DataColumn.hasNulls]`() }.`[recursively][ColumnsSelectionDsl.recursively]`() }`
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { myGroupCol.`[cols][org.jetbrains.kotlinx.dataframe.columns.SingleColumn.cols]`(columnA, columnB) }`
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { `[colsOf][org.jetbrains.kotlinx.dataframe.api.ColumnsSelectionDsl.colsOf]`<`[String][String]`>()`[`[`][org.jetbrains.kotlinx.dataframe.columns.ColumnSet.cols]`1, 3, 5`[`]`][org.jetbrains.kotlinx.dataframe.columns.ColumnSet.cols]` }`
     *
     * #### Examples for this overload:
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { myColumnGroup.`[cols][org.jetbrains.kotlinx.dataframe.columns.SingleColumn.cols]`(Type::colA, Type::colB) }`
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { myColumnGroup`[`[`][org.jetbrains.kotlinx.dataframe.columns.SingleColumn.cols]`Type::colA, Type::colB`[`]`][org.jetbrains.kotlinx.dataframe.columns.SingleColumn.cols]` }`
     *
     *
     * @param [firstCol] A [KProperty] that points to a column.
     * @param [otherCols] Optional additional [KProperty]s that point to columns.
     * @return A ([transformable][org.jetbrains.kotlinx.dataframe.impl.columns.TransformableColumnSet]) [ColumnSet][org.jetbrains.kotlinx.dataframe.columns.ColumnSet] containing the columns that [firstCol] and [otherCols] point to. 
     */
    public fun <C> SingleColumn<DataRow<*>>.cols(
        firstCol: KProperty<C>,
        vararg otherCols: KProperty<C>,
    ): ColumnSet<C> = headPlusArray(firstCol, otherCols).let { props ->
        ensureIsColGroup().asColumnSet().transform { it.flatMap { col -> props.mapNotNull { col.getChild(it) } } }
    }

    /** ## Cols
     * Creates a subset of columns ([ColumnSet][org.jetbrains.kotlinx.dataframe.columns.ColumnSet]) from the current [ColumnsResolver][org.jetbrains.kotlinx.dataframe.columns.ColumnsResolver].
     *
     * If the current [ColumnsResolver][org.jetbrains.kotlinx.dataframe.columns.ColumnsResolver] is a [SingleColumn][org.jetbrains.kotlinx.dataframe.columns.SingleColumn] and consists of a [column group][org.jetbrains.kotlinx.dataframe.columns.ColumnGroup],
     * then `cols` will create a subset of its contained columns.
     *
     * You can use either a [ColumnFilter][org.jetbrains.kotlinx.dataframe.ColumnFilter], or any of the `vararg` overloads for any
     * [Access API][org.jetbrains.kotlinx.dataframe.documentation.AccessApi].
     *
     * Aside from calling [cols][org.jetbrains.kotlinx.dataframe.api.ColsColumnsSelectionDsl.cols] directly, you can also use the [get][org.jetbrains.kotlinx.dataframe.columns.ColumnSet.get] operator in most cases.
     *
     * #### For example:
     * `df.`[remove][org.jetbrains.kotlinx.dataframe.DataFrame.remove]` { `[cols][org.jetbrains.kotlinx.dataframe.api.ColumnsSelectionDsl.cols]` { it.`[hasNulls][org.jetbrains.kotlinx.dataframe.DataColumn.hasNulls]`() }.`[recursively][ColumnsSelectionDsl.recursively]`() }`
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { myGroupCol.`[cols][org.jetbrains.kotlinx.dataframe.columns.SingleColumn.cols]`(columnA, columnB) }`
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { `[colsOf][org.jetbrains.kotlinx.dataframe.api.ColumnsSelectionDsl.colsOf]`<`[String][String]`>()`[`[`][org.jetbrains.kotlinx.dataframe.columns.ColumnSet.cols]`1, 3, 5`[`]`][org.jetbrains.kotlinx.dataframe.columns.ColumnSet.cols]` }`
     *
     * #### Examples for this overload:
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { myColumnGroup.`[cols][org.jetbrains.kotlinx.dataframe.columns.SingleColumn.cols]`(Type::colA, Type::colB) }`
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { myColumnGroup`[`[`][org.jetbrains.kotlinx.dataframe.columns.SingleColumn.cols]`Type::colA, Type::colB`[`]`][org.jetbrains.kotlinx.dataframe.columns.SingleColumn.cols]` }`
     *
     *
     * @param [firstCol] A [KProperty] that points to a column.
     * @param [otherCols] Optional additional [KProperty]s that point to columns.
     * @return A ([transformable][org.jetbrains.kotlinx.dataframe.impl.columns.TransformableColumnSet]) [ColumnSet][org.jetbrains.kotlinx.dataframe.columns.ColumnSet] containing the columns that [firstCol] and [otherCols] point to. 
     */
    public operator fun <C> SingleColumn<DataRow<*>>.get(
        firstCol: KProperty<C>,
        vararg otherCols: KProperty<C>,
    ): ColumnSet<C> = cols(firstCol, *otherCols)

    /**
     * ## Cols
     * Creates a subset of columns ([ColumnSet][org.jetbrains.kotlinx.dataframe.columns.ColumnSet]) from the current [ColumnsResolver][org.jetbrains.kotlinx.dataframe.columns.ColumnsResolver].
     *
     * If the current [ColumnsResolver][org.jetbrains.kotlinx.dataframe.columns.ColumnsResolver] is a [SingleColumn][org.jetbrains.kotlinx.dataframe.columns.SingleColumn] and consists of a [column group][org.jetbrains.kotlinx.dataframe.columns.ColumnGroup],
     * then `cols` will create a subset of its contained columns.
     *
     * You can use either a [ColumnFilter][org.jetbrains.kotlinx.dataframe.ColumnFilter], or any of the `vararg` overloads for any
     * [Access API][org.jetbrains.kotlinx.dataframe.documentation.AccessApi].
     *
     * Aside from calling [cols][org.jetbrains.kotlinx.dataframe.api.ColsColumnsSelectionDsl.cols] directly, you can also use the [get][org.jetbrains.kotlinx.dataframe.columns.ColumnSet.get] operator in most cases.
     *
     * #### For example:
     * `df.`[remove][org.jetbrains.kotlinx.dataframe.DataFrame.remove]` { `[cols][org.jetbrains.kotlinx.dataframe.api.ColumnsSelectionDsl.cols]` { it.`[hasNulls][org.jetbrains.kotlinx.dataframe.DataColumn.hasNulls]`() }.`[recursively][ColumnsSelectionDsl.recursively]`() }`
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { myGroupCol.`[cols][org.jetbrains.kotlinx.dataframe.columns.SingleColumn.cols]`(columnA, columnB) }`
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { `[colsOf][org.jetbrains.kotlinx.dataframe.api.ColumnsSelectionDsl.colsOf]`<`[String][String]`>()`[`[`][org.jetbrains.kotlinx.dataframe.columns.ColumnSet.cols]`1, 3, 5`[`]`][org.jetbrains.kotlinx.dataframe.columns.ColumnSet.cols]` }`
     *
     * #### Examples for this overload:
     *
     * `df.`[select][DataFrame.select]` { "myColumnGroup".`[cols][String.cols]`(Type::colA, Type::colB) }`
     *
     * `df.`[select][DataFrame.select]` { "myColumnGroup"`[`[`][String.cols]`Type::colA, Type::colB`[`]`][String.cols]` }`
     *
     *
     * @param [firstCol] A [KProperty] that points to a column.
     * @param [otherCols] Optional additional [KProperty]s that point to columns.
     * @return A ([transformable][org.jetbrains.kotlinx.dataframe.impl.columns.TransformableColumnSet]) [ColumnSet][org.jetbrains.kotlinx.dataframe.columns.ColumnSet] containing the columns that [firstCol] and [otherCols] point to. 
     */
    private interface StringColsVarargKPropertyDocs

    /** ## Cols
     * Creates a subset of columns ([ColumnSet][org.jetbrains.kotlinx.dataframe.columns.ColumnSet]) from the current [ColumnsResolver][org.jetbrains.kotlinx.dataframe.columns.ColumnsResolver].
     *
     * If the current [ColumnsResolver][org.jetbrains.kotlinx.dataframe.columns.ColumnsResolver] is a [SingleColumn][org.jetbrains.kotlinx.dataframe.columns.SingleColumn] and consists of a [column group][org.jetbrains.kotlinx.dataframe.columns.ColumnGroup],
     * then `cols` will create a subset of its contained columns.
     *
     * You can use either a [ColumnFilter][org.jetbrains.kotlinx.dataframe.ColumnFilter], or any of the `vararg` overloads for any
     * [Access API][org.jetbrains.kotlinx.dataframe.documentation.AccessApi].
     *
     * Aside from calling [cols][org.jetbrains.kotlinx.dataframe.api.ColsColumnsSelectionDsl.cols] directly, you can also use the [get][org.jetbrains.kotlinx.dataframe.columns.ColumnSet.get] operator in most cases.
     *
     * #### For example:
     * `df.`[remove][org.jetbrains.kotlinx.dataframe.DataFrame.remove]` { `[cols][org.jetbrains.kotlinx.dataframe.api.ColumnsSelectionDsl.cols]` { it.`[hasNulls][org.jetbrains.kotlinx.dataframe.DataColumn.hasNulls]`() }.`[recursively][ColumnsSelectionDsl.recursively]`() }`
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { myGroupCol.`[cols][org.jetbrains.kotlinx.dataframe.columns.SingleColumn.cols]`(columnA, columnB) }`
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { `[colsOf][org.jetbrains.kotlinx.dataframe.api.ColumnsSelectionDsl.colsOf]`<`[String][String]`>()`[`[`][org.jetbrains.kotlinx.dataframe.columns.ColumnSet.cols]`1, 3, 5`[`]`][org.jetbrains.kotlinx.dataframe.columns.ColumnSet.cols]` }`
     *
     * #### Examples for this overload:
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { "myColumnGroup".`[cols][kotlin.String.cols]`(Type::colA, Type::colB) }`
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { "myColumnGroup"`[`[`][kotlin.String.cols]`Type::colA, Type::colB`[`]`][kotlin.String.cols]` }`
     *
     *
     * @param [firstCol] A [KProperty] that points to a column.
     * @param [otherCols] Optional additional [KProperty]s that point to columns.
     * @return A ([transformable][org.jetbrains.kotlinx.dataframe.impl.columns.TransformableColumnSet]) [ColumnSet][org.jetbrains.kotlinx.dataframe.columns.ColumnSet] containing the columns that [firstCol] and [otherCols] point to. 
     */
    public fun <C> String.cols(
        firstCol: KProperty<C>,
        vararg otherCols: KProperty<C>,
    ): ColumnSet<C> = columnGroup(this).cols(firstCol, *otherCols)

    /** ## Cols
     * Creates a subset of columns ([ColumnSet][org.jetbrains.kotlinx.dataframe.columns.ColumnSet]) from the current [ColumnsResolver][org.jetbrains.kotlinx.dataframe.columns.ColumnsResolver].
     *
     * If the current [ColumnsResolver][org.jetbrains.kotlinx.dataframe.columns.ColumnsResolver] is a [SingleColumn][org.jetbrains.kotlinx.dataframe.columns.SingleColumn] and consists of a [column group][org.jetbrains.kotlinx.dataframe.columns.ColumnGroup],
     * then `cols` will create a subset of its contained columns.
     *
     * You can use either a [ColumnFilter][org.jetbrains.kotlinx.dataframe.ColumnFilter], or any of the `vararg` overloads for any
     * [Access API][org.jetbrains.kotlinx.dataframe.documentation.AccessApi].
     *
     * Aside from calling [cols][org.jetbrains.kotlinx.dataframe.api.ColsColumnsSelectionDsl.cols] directly, you can also use the [get][org.jetbrains.kotlinx.dataframe.columns.ColumnSet.get] operator in most cases.
     *
     * #### For example:
     * `df.`[remove][org.jetbrains.kotlinx.dataframe.DataFrame.remove]` { `[cols][org.jetbrains.kotlinx.dataframe.api.ColumnsSelectionDsl.cols]` { it.`[hasNulls][org.jetbrains.kotlinx.dataframe.DataColumn.hasNulls]`() }.`[recursively][ColumnsSelectionDsl.recursively]`() }`
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { myGroupCol.`[cols][org.jetbrains.kotlinx.dataframe.columns.SingleColumn.cols]`(columnA, columnB) }`
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { `[colsOf][org.jetbrains.kotlinx.dataframe.api.ColumnsSelectionDsl.colsOf]`<`[String][String]`>()`[`[`][org.jetbrains.kotlinx.dataframe.columns.ColumnSet.cols]`1, 3, 5`[`]`][org.jetbrains.kotlinx.dataframe.columns.ColumnSet.cols]` }`
     *
     * #### Examples for this overload:
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { "myColumnGroup".`[cols][kotlin.String.cols]`(Type::colA, Type::colB) }`
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { "myColumnGroup"`[`[`][kotlin.String.cols]`Type::colA, Type::colB`[`]`][kotlin.String.cols]` }`
     *
     *
     * @param [firstCol] A [KProperty] that points to a column.
     * @param [otherCols] Optional additional [KProperty]s that point to columns.
     * @return A ([transformable][org.jetbrains.kotlinx.dataframe.impl.columns.TransformableColumnSet]) [ColumnSet][org.jetbrains.kotlinx.dataframe.columns.ColumnSet] containing the columns that [firstCol] and [otherCols] point to. 
     */
    public operator fun <C> String.get(
        firstCol: KProperty<C>,
        vararg otherCols: KProperty<C>,
    ): ColumnSet<C> = cols(firstCol, *otherCols)

    /**
     * ## Cols
     * Creates a subset of columns ([ColumnSet][org.jetbrains.kotlinx.dataframe.columns.ColumnSet]) from the current [ColumnsResolver][org.jetbrains.kotlinx.dataframe.columns.ColumnsResolver].
     *
     * If the current [ColumnsResolver][org.jetbrains.kotlinx.dataframe.columns.ColumnsResolver] is a [SingleColumn][org.jetbrains.kotlinx.dataframe.columns.SingleColumn] and consists of a [column group][org.jetbrains.kotlinx.dataframe.columns.ColumnGroup],
     * then `cols` will create a subset of its contained columns.
     *
     * You can use either a [ColumnFilter][org.jetbrains.kotlinx.dataframe.ColumnFilter], or any of the `vararg` overloads for any
     * [Access API][org.jetbrains.kotlinx.dataframe.documentation.AccessApi].
     *
     * Aside from calling [cols][org.jetbrains.kotlinx.dataframe.api.ColsColumnsSelectionDsl.cols] directly, you can also use the [get][org.jetbrains.kotlinx.dataframe.columns.ColumnSet.get] operator in most cases.
     *
     * #### For example:
     * `df.`[remove][org.jetbrains.kotlinx.dataframe.DataFrame.remove]` { `[cols][org.jetbrains.kotlinx.dataframe.api.ColumnsSelectionDsl.cols]` { it.`[hasNulls][org.jetbrains.kotlinx.dataframe.DataColumn.hasNulls]`() }.`[recursively][ColumnsSelectionDsl.recursively]`() }`
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { myGroupCol.`[cols][org.jetbrains.kotlinx.dataframe.columns.SingleColumn.cols]`(columnA, columnB) }`
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { `[colsOf][org.jetbrains.kotlinx.dataframe.api.ColumnsSelectionDsl.colsOf]`<`[String][String]`>()`[`[`][org.jetbrains.kotlinx.dataframe.columns.ColumnSet.cols]`1, 3, 5`[`]`][org.jetbrains.kotlinx.dataframe.columns.ColumnSet.cols]` }`
     *
     * #### Examples for this overload:
     *
     * `df.`[select][DataFrame.select]` { Type::myColumnGroup.`[cols][SingleColumn.cols]`(Type::colA, Type::colB) }`
     *
     * `df.`[select][DataFrame.select]` { Type::myColumnGroup`[`[`][SingleColumn.cols]`Type::colA, Type::colB`[`]`][SingleColumn.cols]` }`
     *
     *
     * @param [firstCol] A [KProperty] that points to a column.
     * @param [otherCols] Optional additional [KProperty]s that point to columns.
     * @return A ([transformable][org.jetbrains.kotlinx.dataframe.impl.columns.TransformableColumnSet]) [ColumnSet][org.jetbrains.kotlinx.dataframe.columns.ColumnSet] containing the columns that [firstCol] and [otherCols] point to. 
     */
    private interface KPropertyColsVarargKPropertyDocs

    /** ## Cols
     * Creates a subset of columns ([ColumnSet][org.jetbrains.kotlinx.dataframe.columns.ColumnSet]) from the current [ColumnsResolver][org.jetbrains.kotlinx.dataframe.columns.ColumnsResolver].
     *
     * If the current [ColumnsResolver][org.jetbrains.kotlinx.dataframe.columns.ColumnsResolver] is a [SingleColumn][org.jetbrains.kotlinx.dataframe.columns.SingleColumn] and consists of a [column group][org.jetbrains.kotlinx.dataframe.columns.ColumnGroup],
     * then `cols` will create a subset of its contained columns.
     *
     * You can use either a [ColumnFilter][org.jetbrains.kotlinx.dataframe.ColumnFilter], or any of the `vararg` overloads for any
     * [Access API][org.jetbrains.kotlinx.dataframe.documentation.AccessApi].
     *
     * Aside from calling [cols][org.jetbrains.kotlinx.dataframe.api.ColsColumnsSelectionDsl.cols] directly, you can also use the [get][org.jetbrains.kotlinx.dataframe.columns.ColumnSet.get] operator in most cases.
     *
     * #### For example:
     * `df.`[remove][org.jetbrains.kotlinx.dataframe.DataFrame.remove]` { `[cols][org.jetbrains.kotlinx.dataframe.api.ColumnsSelectionDsl.cols]` { it.`[hasNulls][org.jetbrains.kotlinx.dataframe.DataColumn.hasNulls]`() }.`[recursively][ColumnsSelectionDsl.recursively]`() }`
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { myGroupCol.`[cols][org.jetbrains.kotlinx.dataframe.columns.SingleColumn.cols]`(columnA, columnB) }`
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { `[colsOf][org.jetbrains.kotlinx.dataframe.api.ColumnsSelectionDsl.colsOf]`<`[String][String]`>()`[`[`][org.jetbrains.kotlinx.dataframe.columns.ColumnSet.cols]`1, 3, 5`[`]`][org.jetbrains.kotlinx.dataframe.columns.ColumnSet.cols]` }`
     *
     * #### Examples for this overload:
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { Type::myColumnGroup.`[cols][org.jetbrains.kotlinx.dataframe.columns.SingleColumn.cols]`(Type::colA, Type::colB) }`
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { Type::myColumnGroup`[`[`][org.jetbrains.kotlinx.dataframe.columns.SingleColumn.cols]`Type::colA, Type::colB`[`]`][org.jetbrains.kotlinx.dataframe.columns.SingleColumn.cols]` }`
     *
     *
     * @param [firstCol] A [KProperty] that points to a column.
     * @param [otherCols] Optional additional [KProperty]s that point to columns.
     * @return A ([transformable][org.jetbrains.kotlinx.dataframe.impl.columns.TransformableColumnSet]) [ColumnSet][org.jetbrains.kotlinx.dataframe.columns.ColumnSet] containing the columns that [firstCol] and [otherCols] point to. 
     */
    public fun <C> KProperty<*>.cols(
        firstCol: KProperty<C>,
        vararg otherCols: KProperty<C>,
    ): ColumnSet<C> = columnGroup(this).cols(firstCol, *otherCols)

    /** ## Cols
     * Creates a subset of columns ([ColumnSet][org.jetbrains.kotlinx.dataframe.columns.ColumnSet]) from the current [ColumnsResolver][org.jetbrains.kotlinx.dataframe.columns.ColumnsResolver].
     *
     * If the current [ColumnsResolver][org.jetbrains.kotlinx.dataframe.columns.ColumnsResolver] is a [SingleColumn][org.jetbrains.kotlinx.dataframe.columns.SingleColumn] and consists of a [column group][org.jetbrains.kotlinx.dataframe.columns.ColumnGroup],
     * then `cols` will create a subset of its contained columns.
     *
     * You can use either a [ColumnFilter][org.jetbrains.kotlinx.dataframe.ColumnFilter], or any of the `vararg` overloads for any
     * [Access API][org.jetbrains.kotlinx.dataframe.documentation.AccessApi].
     *
     * Aside from calling [cols][org.jetbrains.kotlinx.dataframe.api.ColsColumnsSelectionDsl.cols] directly, you can also use the [get][org.jetbrains.kotlinx.dataframe.columns.ColumnSet.get] operator in most cases.
     *
     * #### For example:
     * `df.`[remove][org.jetbrains.kotlinx.dataframe.DataFrame.remove]` { `[cols][org.jetbrains.kotlinx.dataframe.api.ColumnsSelectionDsl.cols]` { it.`[hasNulls][org.jetbrains.kotlinx.dataframe.DataColumn.hasNulls]`() }.`[recursively][ColumnsSelectionDsl.recursively]`() }`
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { myGroupCol.`[cols][org.jetbrains.kotlinx.dataframe.columns.SingleColumn.cols]`(columnA, columnB) }`
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { `[colsOf][org.jetbrains.kotlinx.dataframe.api.ColumnsSelectionDsl.colsOf]`<`[String][String]`>()`[`[`][org.jetbrains.kotlinx.dataframe.columns.ColumnSet.cols]`1, 3, 5`[`]`][org.jetbrains.kotlinx.dataframe.columns.ColumnSet.cols]` }`
     *
     * #### Examples for this overload:
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { Type::myColumnGroup.`[cols][org.jetbrains.kotlinx.dataframe.columns.SingleColumn.cols]`(Type::colA, Type::colB) }`
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { Type::myColumnGroup`[`[`][org.jetbrains.kotlinx.dataframe.columns.SingleColumn.cols]`Type::colA, Type::colB`[`]`][org.jetbrains.kotlinx.dataframe.columns.SingleColumn.cols]` }`
     *
     *
     * @param [firstCol] A [KProperty] that points to a column.
     * @param [otherCols] Optional additional [KProperty]s that point to columns.
     * @return A ([transformable][org.jetbrains.kotlinx.dataframe.impl.columns.TransformableColumnSet]) [ColumnSet][org.jetbrains.kotlinx.dataframe.columns.ColumnSet] containing the columns that [firstCol] and [otherCols] point to. 
     */
    public operator fun <C> KProperty<*>.get(
        firstCol: KProperty<C>,
        vararg otherCols: KProperty<C>,
    ): ColumnSet<C> = cols(firstCol, *otherCols)

    /**
     * ## Cols
     * Creates a subset of columns ([ColumnSet][org.jetbrains.kotlinx.dataframe.columns.ColumnSet]) from the current [ColumnsResolver][org.jetbrains.kotlinx.dataframe.columns.ColumnsResolver].
     *
     * If the current [ColumnsResolver][org.jetbrains.kotlinx.dataframe.columns.ColumnsResolver] is a [SingleColumn][org.jetbrains.kotlinx.dataframe.columns.SingleColumn] and consists of a [column group][org.jetbrains.kotlinx.dataframe.columns.ColumnGroup],
     * then `cols` will create a subset of its contained columns.
     *
     * You can use either a [ColumnFilter][org.jetbrains.kotlinx.dataframe.ColumnFilter], or any of the `vararg` overloads for any
     * [Access API][org.jetbrains.kotlinx.dataframe.documentation.AccessApi].
     *
     * Aside from calling [cols][org.jetbrains.kotlinx.dataframe.api.ColsColumnsSelectionDsl.cols] directly, you can also use the [get][org.jetbrains.kotlinx.dataframe.columns.ColumnSet.get] operator in most cases.
     *
     * #### For example:
     * `df.`[remove][org.jetbrains.kotlinx.dataframe.DataFrame.remove]` { `[cols][org.jetbrains.kotlinx.dataframe.api.ColumnsSelectionDsl.cols]` { it.`[hasNulls][org.jetbrains.kotlinx.dataframe.DataColumn.hasNulls]`() }.`[recursively][ColumnsSelectionDsl.recursively]`() }`
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { myGroupCol.`[cols][org.jetbrains.kotlinx.dataframe.columns.SingleColumn.cols]`(columnA, columnB) }`
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { `[colsOf][org.jetbrains.kotlinx.dataframe.api.ColumnsSelectionDsl.colsOf]`<`[String][String]`>()`[`[`][org.jetbrains.kotlinx.dataframe.columns.ColumnSet.cols]`1, 3, 5`[`]`][org.jetbrains.kotlinx.dataframe.columns.ColumnSet.cols]` }`
     *
     * #### Examples for this overload:
     *
     * `df.`[select][DataFrame.select]` { "pathTo"["columnGroup"].`[cols][ColumnPath.cols]`(Type::colA, Type::colB) }`
     *
     * `df.`[select][DataFrame.select]` { "pathTo"["columnGroup"]`[`[`][ColumnPath.cols]`Type::colA, Type::colB`[`]`][ColumnPath.cols]` }`
     *
     *
     * @param [firstCol] A [KProperty] that points to a column.
     * @param [otherCols] Optional additional [KProperty]s that point to columns.
     * @return A ([transformable][org.jetbrains.kotlinx.dataframe.impl.columns.TransformableColumnSet]) [ColumnSet][org.jetbrains.kotlinx.dataframe.columns.ColumnSet] containing the columns that [firstCol] and [otherCols] point to. 
     */
    private interface ColumnPathColsVarargKPropertyDocs

    /** ## Cols
     * Creates a subset of columns ([ColumnSet][org.jetbrains.kotlinx.dataframe.columns.ColumnSet]) from the current [ColumnsResolver][org.jetbrains.kotlinx.dataframe.columns.ColumnsResolver].
     *
     * If the current [ColumnsResolver][org.jetbrains.kotlinx.dataframe.columns.ColumnsResolver] is a [SingleColumn][org.jetbrains.kotlinx.dataframe.columns.SingleColumn] and consists of a [column group][org.jetbrains.kotlinx.dataframe.columns.ColumnGroup],
     * then `cols` will create a subset of its contained columns.
     *
     * You can use either a [ColumnFilter][org.jetbrains.kotlinx.dataframe.ColumnFilter], or any of the `vararg` overloads for any
     * [Access API][org.jetbrains.kotlinx.dataframe.documentation.AccessApi].
     *
     * Aside from calling [cols][org.jetbrains.kotlinx.dataframe.api.ColsColumnsSelectionDsl.cols] directly, you can also use the [get][org.jetbrains.kotlinx.dataframe.columns.ColumnSet.get] operator in most cases.
     *
     * #### For example:
     * `df.`[remove][org.jetbrains.kotlinx.dataframe.DataFrame.remove]` { `[cols][org.jetbrains.kotlinx.dataframe.api.ColumnsSelectionDsl.cols]` { it.`[hasNulls][org.jetbrains.kotlinx.dataframe.DataColumn.hasNulls]`() }.`[recursively][ColumnsSelectionDsl.recursively]`() }`
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { myGroupCol.`[cols][org.jetbrains.kotlinx.dataframe.columns.SingleColumn.cols]`(columnA, columnB) }`
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { `[colsOf][org.jetbrains.kotlinx.dataframe.api.ColumnsSelectionDsl.colsOf]`<`[String][String]`>()`[`[`][org.jetbrains.kotlinx.dataframe.columns.ColumnSet.cols]`1, 3, 5`[`]`][org.jetbrains.kotlinx.dataframe.columns.ColumnSet.cols]` }`
     *
     * #### Examples for this overload:
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { "pathTo"["columnGroup"].`[cols][org.jetbrains.kotlinx.dataframe.columns.ColumnPath.cols]`(Type::colA, Type::colB) }`
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { "pathTo"["columnGroup"]`[`[`][org.jetbrains.kotlinx.dataframe.columns.ColumnPath.cols]`Type::colA, Type::colB`[`]`][org.jetbrains.kotlinx.dataframe.columns.ColumnPath.cols]` }`
     *
     *
     * @param [firstCol] A [KProperty] that points to a column.
     * @param [otherCols] Optional additional [KProperty]s that point to columns.
     * @return A ([transformable][org.jetbrains.kotlinx.dataframe.impl.columns.TransformableColumnSet]) [ColumnSet][org.jetbrains.kotlinx.dataframe.columns.ColumnSet] containing the columns that [firstCol] and [otherCols] point to. 
     */
    public fun <C> ColumnPath.cols(
        firstCol: KProperty<C>,
        vararg otherCols: KProperty<C>,
    ): ColumnSet<C> = columnGroup(this).cols(firstCol, *otherCols)

    /** ## Cols
     * Creates a subset of columns ([ColumnSet][org.jetbrains.kotlinx.dataframe.columns.ColumnSet]) from the current [ColumnsResolver][org.jetbrains.kotlinx.dataframe.columns.ColumnsResolver].
     *
     * If the current [ColumnsResolver][org.jetbrains.kotlinx.dataframe.columns.ColumnsResolver] is a [SingleColumn][org.jetbrains.kotlinx.dataframe.columns.SingleColumn] and consists of a [column group][org.jetbrains.kotlinx.dataframe.columns.ColumnGroup],
     * then `cols` will create a subset of its contained columns.
     *
     * You can use either a [ColumnFilter][org.jetbrains.kotlinx.dataframe.ColumnFilter], or any of the `vararg` overloads for any
     * [Access API][org.jetbrains.kotlinx.dataframe.documentation.AccessApi].
     *
     * Aside from calling [cols][org.jetbrains.kotlinx.dataframe.api.ColsColumnsSelectionDsl.cols] directly, you can also use the [get][org.jetbrains.kotlinx.dataframe.columns.ColumnSet.get] operator in most cases.
     *
     * #### For example:
     * `df.`[remove][org.jetbrains.kotlinx.dataframe.DataFrame.remove]` { `[cols][org.jetbrains.kotlinx.dataframe.api.ColumnsSelectionDsl.cols]` { it.`[hasNulls][org.jetbrains.kotlinx.dataframe.DataColumn.hasNulls]`() }.`[recursively][ColumnsSelectionDsl.recursively]`() }`
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { myGroupCol.`[cols][org.jetbrains.kotlinx.dataframe.columns.SingleColumn.cols]`(columnA, columnB) }`
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { `[colsOf][org.jetbrains.kotlinx.dataframe.api.ColumnsSelectionDsl.colsOf]`<`[String][String]`>()`[`[`][org.jetbrains.kotlinx.dataframe.columns.ColumnSet.cols]`1, 3, 5`[`]`][org.jetbrains.kotlinx.dataframe.columns.ColumnSet.cols]` }`
     *
     * #### Examples for this overload:
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { "pathTo"["columnGroup"].`[cols][org.jetbrains.kotlinx.dataframe.columns.ColumnPath.cols]`(Type::colA, Type::colB) }`
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { "pathTo"["columnGroup"]`[`[`][org.jetbrains.kotlinx.dataframe.columns.ColumnPath.cols]`Type::colA, Type::colB`[`]`][org.jetbrains.kotlinx.dataframe.columns.ColumnPath.cols]` }`
     *
     *
     * @param [firstCol] A [KProperty] that points to a column.
     * @param [otherCols] Optional additional [KProperty]s that point to columns.
     * @return A ([transformable][org.jetbrains.kotlinx.dataframe.impl.columns.TransformableColumnSet]) [ColumnSet][org.jetbrains.kotlinx.dataframe.columns.ColumnSet] containing the columns that [firstCol] and [otherCols] point to. 
     */
    public operator fun <C> ColumnPath.get(
        firstCol: KProperty<C>,
        vararg otherCols: KProperty<C>,
    ): ColumnSet<C> = cols(firstCol, *otherCols)

    // endregion

    // region indices

    /**
     * ## Cols: Columns by Indices
     *
     * Retrieves multiple columns in the form of a [ColumnSet] by their indices.
     * If any of the indices are out of bounds, an [IndexOutOfBoundsException] is thrown.
     *
     * If called on a [SingleColumn], [ColumnGroup], or [DataFrame], the function will take the columns found at the
     * given indices inside.
     * Else, if called on a normal [ColumnSet], the function will return a new [ColumnSet] with the columns found at
     * the given indices in the set.
     *
     * #### For example:
     *
     * `df.`[select][DataFrame.select]` { `[cols][SingleColumn.cols]`(1, 3, 2) }`
     *
     * `df.`[select][DataFrame.select]` { `[colsOf][ColumnsSelectionDsl.colsOf]`<`[Int][Int]`>()`[`[`][SingleColumn.get]`5, 1, 2`[`]`][SingleColumn.get]` }`
     *
     * `df.`[select][DataFrame.select]` { "myColumnGroup".`[cols][String.cols]`(0, 2) }`
     *
     * #### Examples for this overload:
     *
     * {@includeArg [CommonColsIndicesDocs.ExampleArg]}
     *
     * @throws [IndexOutOfBoundsException] If any index is out of bounds.
     * @param [firstIndex\] The index of the first column to retrieve.
     * @param [otherIndices\] The other indices of the columns to retrieve.
     * @return A [ColumnSet] containing the columns found at the given indices.
     */
    private interface CommonColsIndicesDocs {

        /** Example argument */
        interface ExampleArg
    }

    /**
     * ## Cols: Columns by Indices
     *
     * Retrieves multiple columns in the form of a [ColumnSet][org.jetbrains.kotlinx.dataframe.columns.ColumnSet] by their indices.
     * If any of the indices are out of bounds, an [IndexOutOfBoundsException] is thrown.
     *
     * If called on a [SingleColumn][org.jetbrains.kotlinx.dataframe.columns.SingleColumn], [ColumnGroup][org.jetbrains.kotlinx.dataframe.columns.ColumnGroup], or [DataFrame][org.jetbrains.kotlinx.dataframe.DataFrame], the function will take the columns found at the
     * given indices inside.
     * Else, if called on a normal [ColumnSet][org.jetbrains.kotlinx.dataframe.columns.ColumnSet], the function will return a new [ColumnSet][org.jetbrains.kotlinx.dataframe.columns.ColumnSet] with the columns found at
     * the given indices in the set.
     *
     * #### For example:
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { `[cols][org.jetbrains.kotlinx.dataframe.columns.SingleColumn.cols]`(1, 3, 2) }`
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { `[colsOf][org.jetbrains.kotlinx.dataframe.api.ColumnsSelectionDsl.colsOf]`<`[Int][Int]`>()`[`[`][org.jetbrains.kotlinx.dataframe.columns.SingleColumn.get]`5, 1, 2`[`]`][org.jetbrains.kotlinx.dataframe.columns.SingleColumn.get]` }`
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { "myColumnGroup".`[cols][kotlin.String.cols]`(0, 2) }`
     *
     * #### Examples for this overload:
     *
     * `df.`[select][DataFrame.select]` { `[colsOf][SingleColumn.colsOf]`<`[Int][Int]`>().`[cols][ColumnSet.cols]`(1, 3) }`
     *
     * `df.`[select][DataFrame.select]` { `[all][ColumnsSelectionDsl.all]`()`[`[`][ColumnSet.cols]`5, 1`[`]`][ColumnSet.cols]` }`
     *
     * @throws [IndexOutOfBoundsException] If any index is out of bounds.
     * @param [firstIndex] The index of the first column to retrieve.
     * @param [otherIndices] The other indices of the columns to retrieve.
     * @return A [ColumnSet][org.jetbrains.kotlinx.dataframe.columns.ColumnSet] containing the columns found at the given indices.
     */
    private interface ColumnSetColsIndicesDocs

    /** ## Cols: Columns by Indices
     *
     * Retrieves multiple columns in the form of a [ColumnSet][org.jetbrains.kotlinx.dataframe.columns.ColumnSet] by their indices.
     * If any of the indices are out of bounds, an [IndexOutOfBoundsException] is thrown.
     *
     * If called on a [SingleColumn][org.jetbrains.kotlinx.dataframe.columns.SingleColumn], [ColumnGroup][org.jetbrains.kotlinx.dataframe.columns.ColumnGroup], or [DataFrame][org.jetbrains.kotlinx.dataframe.DataFrame], the function will take the columns found at the
     * given indices inside.
     * Else, if called on a normal [ColumnSet][org.jetbrains.kotlinx.dataframe.columns.ColumnSet], the function will return a new [ColumnSet][org.jetbrains.kotlinx.dataframe.columns.ColumnSet] with the columns found at
     * the given indices in the set.
     *
     * #### For example:
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { `[cols][org.jetbrains.kotlinx.dataframe.columns.SingleColumn.cols]`(1, 3, 2) }`
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { `[colsOf][org.jetbrains.kotlinx.dataframe.api.ColumnsSelectionDsl.colsOf]`<`[Int][Int]`>()`[`[`][org.jetbrains.kotlinx.dataframe.columns.SingleColumn.get]`5, 1, 2`[`]`][org.jetbrains.kotlinx.dataframe.columns.SingleColumn.get]` }`
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { "myColumnGroup".`[cols][kotlin.String.cols]`(0, 2) }`
     *
     * #### Examples for this overload:
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { `[colsOf][org.jetbrains.kotlinx.dataframe.columns.SingleColumn.colsOf]`<`[Int][Int]`>().`[cols][org.jetbrains.kotlinx.dataframe.columns.ColumnSet.cols]`(1, 3) }`
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { `[all][org.jetbrains.kotlinx.dataframe.api.ColumnsSelectionDsl.all]`()`[`[`][org.jetbrains.kotlinx.dataframe.columns.ColumnSet.cols]`5, 1`[`]`][org.jetbrains.kotlinx.dataframe.columns.ColumnSet.cols]` }`
     *
     * @throws [IndexOutOfBoundsException] If any index is out of bounds.
     * @param [firstIndex] The index of the first column to retrieve.
     * @param [otherIndices] The other indices of the columns to retrieve.
     * @return A [ColumnSet][org.jetbrains.kotlinx.dataframe.columns.ColumnSet] containing the columns found at the given indices.
     */
    @Suppress("UNCHECKED_CAST")
    public fun <C> ColumnSet<C>.cols(
        firstIndex: Int,
        vararg otherIndices: Int,
    ): ColumnSet<C> = colsInternal(headPlusArray(firstIndex, otherIndices)) as ColumnSet<C>

    /** ## Cols: Columns by Indices
     *
     * Retrieves multiple columns in the form of a [ColumnSet][org.jetbrains.kotlinx.dataframe.columns.ColumnSet] by their indices.
     * If any of the indices are out of bounds, an [IndexOutOfBoundsException] is thrown.
     *
     * If called on a [SingleColumn][org.jetbrains.kotlinx.dataframe.columns.SingleColumn], [ColumnGroup][org.jetbrains.kotlinx.dataframe.columns.ColumnGroup], or [DataFrame][org.jetbrains.kotlinx.dataframe.DataFrame], the function will take the columns found at the
     * given indices inside.
     * Else, if called on a normal [ColumnSet][org.jetbrains.kotlinx.dataframe.columns.ColumnSet], the function will return a new [ColumnSet][org.jetbrains.kotlinx.dataframe.columns.ColumnSet] with the columns found at
     * the given indices in the set.
     *
     * #### For example:
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { `[cols][org.jetbrains.kotlinx.dataframe.columns.SingleColumn.cols]`(1, 3, 2) }`
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { `[colsOf][org.jetbrains.kotlinx.dataframe.api.ColumnsSelectionDsl.colsOf]`<`[Int][Int]`>()`[`[`][org.jetbrains.kotlinx.dataframe.columns.SingleColumn.get]`5, 1, 2`[`]`][org.jetbrains.kotlinx.dataframe.columns.SingleColumn.get]` }`
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { "myColumnGroup".`[cols][kotlin.String.cols]`(0, 2) }`
     *
     * #### Examples for this overload:
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { `[colsOf][org.jetbrains.kotlinx.dataframe.columns.SingleColumn.colsOf]`<`[Int][Int]`>().`[cols][org.jetbrains.kotlinx.dataframe.columns.ColumnSet.cols]`(1, 3) }`
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { `[all][org.jetbrains.kotlinx.dataframe.api.ColumnsSelectionDsl.all]`()`[`[`][org.jetbrains.kotlinx.dataframe.columns.ColumnSet.cols]`5, 1`[`]`][org.jetbrains.kotlinx.dataframe.columns.ColumnSet.cols]` }`
     *
     * @throws [IndexOutOfBoundsException] If any index is out of bounds.
     * @param [firstIndex] The index of the first column to retrieve.
     * @param [otherIndices] The other indices of the columns to retrieve.
     * @return A [ColumnSet][org.jetbrains.kotlinx.dataframe.columns.ColumnSet] containing the columns found at the given indices.
     */
    public operator fun <C> ColumnSet<C>.get(
        firstIndex: Int,
        vararg otherIndices: Int,
    ): ColumnSet<C> = cols(firstIndex, *otherIndices)

    /**
     * ## Cols: Columns by Indices
     *
     * Retrieves multiple columns in the form of a [ColumnSet][org.jetbrains.kotlinx.dataframe.columns.ColumnSet] by their indices.
     * If any of the indices are out of bounds, an [IndexOutOfBoundsException] is thrown.
     *
     * If called on a [SingleColumn][org.jetbrains.kotlinx.dataframe.columns.SingleColumn], [ColumnGroup][org.jetbrains.kotlinx.dataframe.columns.ColumnGroup], or [DataFrame][org.jetbrains.kotlinx.dataframe.DataFrame], the function will take the columns found at the
     * given indices inside.
     * Else, if called on a normal [ColumnSet][org.jetbrains.kotlinx.dataframe.columns.ColumnSet], the function will return a new [ColumnSet][org.jetbrains.kotlinx.dataframe.columns.ColumnSet] with the columns found at
     * the given indices in the set.
     *
     * #### For example:
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { `[cols][org.jetbrains.kotlinx.dataframe.columns.SingleColumn.cols]`(1, 3, 2) }`
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { `[colsOf][org.jetbrains.kotlinx.dataframe.api.ColumnsSelectionDsl.colsOf]`<`[Int][Int]`>()`[`[`][org.jetbrains.kotlinx.dataframe.columns.SingleColumn.get]`5, 1, 2`[`]`][org.jetbrains.kotlinx.dataframe.columns.SingleColumn.get]` }`
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { "myColumnGroup".`[cols][kotlin.String.cols]`(0, 2) }`
     *
     * #### Examples for this overload:
     *
     * `df.`[select][DataFrame.select]` { `[cols][ColumnsSelectionDsl.cols]`(1, 3) }`
     *
     * @throws [IndexOutOfBoundsException] If any index is out of bounds.
     * @param [firstIndex] The index of the first column to retrieve.
     * @param [otherIndices] The other indices of the columns to retrieve.
     * @return A [ColumnSet][org.jetbrains.kotlinx.dataframe.columns.ColumnSet] containing the columns found at the given indices.
     */
    private interface ColumnsSelectionDslColsIndicesDocs

    /** ## Cols: Columns by Indices
     *
     * Retrieves multiple columns in the form of a [ColumnSet][org.jetbrains.kotlinx.dataframe.columns.ColumnSet] by their indices.
     * If any of the indices are out of bounds, an [IndexOutOfBoundsException] is thrown.
     *
     * If called on a [SingleColumn][org.jetbrains.kotlinx.dataframe.columns.SingleColumn], [ColumnGroup][org.jetbrains.kotlinx.dataframe.columns.ColumnGroup], or [DataFrame][org.jetbrains.kotlinx.dataframe.DataFrame], the function will take the columns found at the
     * given indices inside.
     * Else, if called on a normal [ColumnSet][org.jetbrains.kotlinx.dataframe.columns.ColumnSet], the function will return a new [ColumnSet][org.jetbrains.kotlinx.dataframe.columns.ColumnSet] with the columns found at
     * the given indices in the set.
     *
     * #### For example:
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { `[cols][org.jetbrains.kotlinx.dataframe.columns.SingleColumn.cols]`(1, 3, 2) }`
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { `[colsOf][org.jetbrains.kotlinx.dataframe.api.ColumnsSelectionDsl.colsOf]`<`[Int][Int]`>()`[`[`][org.jetbrains.kotlinx.dataframe.columns.SingleColumn.get]`5, 1, 2`[`]`][org.jetbrains.kotlinx.dataframe.columns.SingleColumn.get]` }`
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { "myColumnGroup".`[cols][kotlin.String.cols]`(0, 2) }`
     *
     * #### Examples for this overload:
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { `[cols][org.jetbrains.kotlinx.dataframe.api.ColumnsSelectionDsl.cols]`(1, 3) }`
     *
     * @throws [IndexOutOfBoundsException] If any index is out of bounds.
     * @param [firstIndex] The index of the first column to retrieve.
     * @param [otherIndices] The other indices of the columns to retrieve.
     * @return A [ColumnSet][org.jetbrains.kotlinx.dataframe.columns.ColumnSet] containing the columns found at the given indices.
     */
    public fun ColumnsSelectionDsl<*>.cols(
        firstIndex: Int,
        vararg otherIndices: Int,
    ): ColumnSet<*> = this.asSingleColumn().colsInternal(headPlusArray(firstIndex, otherIndices))

    /**
     * ## Cols: Columns by Indices
     *
     * Retrieves multiple columns in the form of a [ColumnSet][org.jetbrains.kotlinx.dataframe.columns.ColumnSet] by their indices.
     * If any of the indices are out of bounds, an [IndexOutOfBoundsException] is thrown.
     *
     * If called on a [SingleColumn][org.jetbrains.kotlinx.dataframe.columns.SingleColumn], [ColumnGroup][org.jetbrains.kotlinx.dataframe.columns.ColumnGroup], or [DataFrame][org.jetbrains.kotlinx.dataframe.DataFrame], the function will take the columns found at the
     * given indices inside.
     * Else, if called on a normal [ColumnSet][org.jetbrains.kotlinx.dataframe.columns.ColumnSet], the function will return a new [ColumnSet][org.jetbrains.kotlinx.dataframe.columns.ColumnSet] with the columns found at
     * the given indices in the set.
     *
     * #### For example:
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { `[cols][org.jetbrains.kotlinx.dataframe.columns.SingleColumn.cols]`(1, 3, 2) }`
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { `[colsOf][org.jetbrains.kotlinx.dataframe.api.ColumnsSelectionDsl.colsOf]`<`[Int][Int]`>()`[`[`][org.jetbrains.kotlinx.dataframe.columns.SingleColumn.get]`5, 1, 2`[`]`][org.jetbrains.kotlinx.dataframe.columns.SingleColumn.get]` }`
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { "myColumnGroup".`[cols][kotlin.String.cols]`(0, 2) }`
     *
     * #### Examples for this overload:
     *
     * `df.`[select][DataFrame.select]` { myColumnGroup.`[cols][SingleColumn.cols]`(1, 3) }`
     *
     * @throws [IndexOutOfBoundsException] If any index is out of bounds.
     * @param [firstIndex] The index of the first column to retrieve.
     * @param [otherIndices] The other indices of the columns to retrieve.
     * @return A [ColumnSet][org.jetbrains.kotlinx.dataframe.columns.ColumnSet] containing the columns found at the given indices.
     */
    private interface SingleColumnColsIndicesDocs

    /** ## Cols: Columns by Indices
     *
     * Retrieves multiple columns in the form of a [ColumnSet][org.jetbrains.kotlinx.dataframe.columns.ColumnSet] by their indices.
     * If any of the indices are out of bounds, an [IndexOutOfBoundsException] is thrown.
     *
     * If called on a [SingleColumn][org.jetbrains.kotlinx.dataframe.columns.SingleColumn], [ColumnGroup][org.jetbrains.kotlinx.dataframe.columns.ColumnGroup], or [DataFrame][org.jetbrains.kotlinx.dataframe.DataFrame], the function will take the columns found at the
     * given indices inside.
     * Else, if called on a normal [ColumnSet][org.jetbrains.kotlinx.dataframe.columns.ColumnSet], the function will return a new [ColumnSet][org.jetbrains.kotlinx.dataframe.columns.ColumnSet] with the columns found at
     * the given indices in the set.
     *
     * #### For example:
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { `[cols][org.jetbrains.kotlinx.dataframe.columns.SingleColumn.cols]`(1, 3, 2) }`
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { `[colsOf][org.jetbrains.kotlinx.dataframe.api.ColumnsSelectionDsl.colsOf]`<`[Int][Int]`>()`[`[`][org.jetbrains.kotlinx.dataframe.columns.SingleColumn.get]`5, 1, 2`[`]`][org.jetbrains.kotlinx.dataframe.columns.SingleColumn.get]` }`
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { "myColumnGroup".`[cols][kotlin.String.cols]`(0, 2) }`
     *
     * #### Examples for this overload:
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { myColumnGroup.`[cols][org.jetbrains.kotlinx.dataframe.columns.SingleColumn.cols]`(1, 3) }`
     *
     * @throws [IndexOutOfBoundsException] If any index is out of bounds.
     * @param [firstIndex] The index of the first column to retrieve.
     * @param [otherIndices] The other indices of the columns to retrieve.
     * @return A [ColumnSet][org.jetbrains.kotlinx.dataframe.columns.ColumnSet] containing the columns found at the given indices.
     */
    public fun SingleColumn<DataRow<*>>.cols(
        firstIndex: Int,
        vararg otherIndices: Int,
    ): ColumnSet<*> = ensureIsColGroup().colsInternal(headPlusArray(firstIndex, otherIndices))

    /**
     * ## Cols: Columns by Indices
     *
     * Retrieves multiple columns in the form of a [ColumnSet][org.jetbrains.kotlinx.dataframe.columns.ColumnSet] by their indices.
     * If any of the indices are out of bounds, an [IndexOutOfBoundsException] is thrown.
     *
     * If called on a [SingleColumn][org.jetbrains.kotlinx.dataframe.columns.SingleColumn], [ColumnGroup][org.jetbrains.kotlinx.dataframe.columns.ColumnGroup], or [DataFrame][org.jetbrains.kotlinx.dataframe.DataFrame], the function will take the columns found at the
     * given indices inside.
     * Else, if called on a normal [ColumnSet][org.jetbrains.kotlinx.dataframe.columns.ColumnSet], the function will return a new [ColumnSet][org.jetbrains.kotlinx.dataframe.columns.ColumnSet] with the columns found at
     * the given indices in the set.
     *
     * #### For example:
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { `[cols][org.jetbrains.kotlinx.dataframe.columns.SingleColumn.cols]`(1, 3, 2) }`
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { `[colsOf][org.jetbrains.kotlinx.dataframe.api.ColumnsSelectionDsl.colsOf]`<`[Int][Int]`>()`[`[`][org.jetbrains.kotlinx.dataframe.columns.SingleColumn.get]`5, 1, 2`[`]`][org.jetbrains.kotlinx.dataframe.columns.SingleColumn.get]` }`
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { "myColumnGroup".`[cols][kotlin.String.cols]`(0, 2) }`
     *
     * #### Examples for this overload:
     *
     * `df.`[select][DataFrame.select]` { "myColumnGroup".`[cols][String.cols]`(5, 3, 1) }`
     *
     * @throws [IndexOutOfBoundsException] If any index is out of bounds.
     * @param [firstIndex] The index of the first column to retrieve.
     * @param [otherIndices] The other indices of the columns to retrieve.
     * @return A [ColumnSet][org.jetbrains.kotlinx.dataframe.columns.ColumnSet] containing the columns found at the given indices.
     */
    private interface StringColsIndicesDocs

    /** ## Cols: Columns by Indices
     *
     * Retrieves multiple columns in the form of a [ColumnSet][org.jetbrains.kotlinx.dataframe.columns.ColumnSet] by their indices.
     * If any of the indices are out of bounds, an [IndexOutOfBoundsException] is thrown.
     *
     * If called on a [SingleColumn][org.jetbrains.kotlinx.dataframe.columns.SingleColumn], [ColumnGroup][org.jetbrains.kotlinx.dataframe.columns.ColumnGroup], or [DataFrame][org.jetbrains.kotlinx.dataframe.DataFrame], the function will take the columns found at the
     * given indices inside.
     * Else, if called on a normal [ColumnSet][org.jetbrains.kotlinx.dataframe.columns.ColumnSet], the function will return a new [ColumnSet][org.jetbrains.kotlinx.dataframe.columns.ColumnSet] with the columns found at
     * the given indices in the set.
     *
     * #### For example:
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { `[cols][org.jetbrains.kotlinx.dataframe.columns.SingleColumn.cols]`(1, 3, 2) }`
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { `[colsOf][org.jetbrains.kotlinx.dataframe.api.ColumnsSelectionDsl.colsOf]`<`[Int][Int]`>()`[`[`][org.jetbrains.kotlinx.dataframe.columns.SingleColumn.get]`5, 1, 2`[`]`][org.jetbrains.kotlinx.dataframe.columns.SingleColumn.get]` }`
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { "myColumnGroup".`[cols][kotlin.String.cols]`(0, 2) }`
     *
     * #### Examples for this overload:
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { "myColumnGroup".`[cols][kotlin.String.cols]`(5, 3, 1) }`
     *
     * @throws [IndexOutOfBoundsException] If any index is out of bounds.
     * @param [firstIndex] The index of the first column to retrieve.
     * @param [otherIndices] The other indices of the columns to retrieve.
     * @return A [ColumnSet][org.jetbrains.kotlinx.dataframe.columns.ColumnSet] containing the columns found at the given indices.
     */
    public fun String.cols(
        firstIndex: Int,
        vararg otherIndices: Int,
    ): ColumnSet<*> = columnGroup(this).cols(firstIndex, *otherIndices)

    /**
     * ## Cols: Columns by Indices
     *
     * Retrieves multiple columns in the form of a [ColumnSet][org.jetbrains.kotlinx.dataframe.columns.ColumnSet] by their indices.
     * If any of the indices are out of bounds, an [IndexOutOfBoundsException] is thrown.
     *
     * If called on a [SingleColumn][org.jetbrains.kotlinx.dataframe.columns.SingleColumn], [ColumnGroup][org.jetbrains.kotlinx.dataframe.columns.ColumnGroup], or [DataFrame][org.jetbrains.kotlinx.dataframe.DataFrame], the function will take the columns found at the
     * given indices inside.
     * Else, if called on a normal [ColumnSet][org.jetbrains.kotlinx.dataframe.columns.ColumnSet], the function will return a new [ColumnSet][org.jetbrains.kotlinx.dataframe.columns.ColumnSet] with the columns found at
     * the given indices in the set.
     *
     * #### For example:
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { `[cols][org.jetbrains.kotlinx.dataframe.columns.SingleColumn.cols]`(1, 3, 2) }`
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { `[colsOf][org.jetbrains.kotlinx.dataframe.api.ColumnsSelectionDsl.colsOf]`<`[Int][Int]`>()`[`[`][org.jetbrains.kotlinx.dataframe.columns.SingleColumn.get]`5, 1, 2`[`]`][org.jetbrains.kotlinx.dataframe.columns.SingleColumn.get]` }`
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { "myColumnGroup".`[cols][kotlin.String.cols]`(0, 2) }`
     *
     * #### Examples for this overload:
     *
     * `df.`[select][DataFrame.select]` { Type::myColumnGroup.`[cols][SingleColumn.cols]`(5, 4) }`
     *
     * @throws [IndexOutOfBoundsException] If any index is out of bounds.
     * @param [firstIndex] The index of the first column to retrieve.
     * @param [otherIndices] The other indices of the columns to retrieve.
     * @return A [ColumnSet][org.jetbrains.kotlinx.dataframe.columns.ColumnSet] containing the columns found at the given indices.
     */
    private interface KPropertyColsIndicesDocs

    /** ## Cols: Columns by Indices
     *
     * Retrieves multiple columns in the form of a [ColumnSet][org.jetbrains.kotlinx.dataframe.columns.ColumnSet] by their indices.
     * If any of the indices are out of bounds, an [IndexOutOfBoundsException] is thrown.
     *
     * If called on a [SingleColumn][org.jetbrains.kotlinx.dataframe.columns.SingleColumn], [ColumnGroup][org.jetbrains.kotlinx.dataframe.columns.ColumnGroup], or [DataFrame][org.jetbrains.kotlinx.dataframe.DataFrame], the function will take the columns found at the
     * given indices inside.
     * Else, if called on a normal [ColumnSet][org.jetbrains.kotlinx.dataframe.columns.ColumnSet], the function will return a new [ColumnSet][org.jetbrains.kotlinx.dataframe.columns.ColumnSet] with the columns found at
     * the given indices in the set.
     *
     * #### For example:
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { `[cols][org.jetbrains.kotlinx.dataframe.columns.SingleColumn.cols]`(1, 3, 2) }`
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { `[colsOf][org.jetbrains.kotlinx.dataframe.api.ColumnsSelectionDsl.colsOf]`<`[Int][Int]`>()`[`[`][org.jetbrains.kotlinx.dataframe.columns.SingleColumn.get]`5, 1, 2`[`]`][org.jetbrains.kotlinx.dataframe.columns.SingleColumn.get]` }`
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { "myColumnGroup".`[cols][kotlin.String.cols]`(0, 2) }`
     *
     * #### Examples for this overload:
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { Type::myColumnGroup.`[cols][org.jetbrains.kotlinx.dataframe.columns.SingleColumn.cols]`(5, 4) }`
     *
     * @throws [IndexOutOfBoundsException] If any index is out of bounds.
     * @param [firstIndex] The index of the first column to retrieve.
     * @param [otherIndices] The other indices of the columns to retrieve.
     * @return A [ColumnSet][org.jetbrains.kotlinx.dataframe.columns.ColumnSet] containing the columns found at the given indices.
     */
    public fun KProperty<*>.cols(
        firstIndex: Int,
        vararg otherIndices: Int,
    ): ColumnSet<*> = columnGroup(this).cols(firstIndex, *otherIndices)

    /**
     * ## Cols: Columns by Indices
     *
     * Retrieves multiple columns in the form of a [ColumnSet][org.jetbrains.kotlinx.dataframe.columns.ColumnSet] by their indices.
     * If any of the indices are out of bounds, an [IndexOutOfBoundsException] is thrown.
     *
     * If called on a [SingleColumn][org.jetbrains.kotlinx.dataframe.columns.SingleColumn], [ColumnGroup][org.jetbrains.kotlinx.dataframe.columns.ColumnGroup], or [DataFrame][org.jetbrains.kotlinx.dataframe.DataFrame], the function will take the columns found at the
     * given indices inside.
     * Else, if called on a normal [ColumnSet][org.jetbrains.kotlinx.dataframe.columns.ColumnSet], the function will return a new [ColumnSet][org.jetbrains.kotlinx.dataframe.columns.ColumnSet] with the columns found at
     * the given indices in the set.
     *
     * #### For example:
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { `[cols][org.jetbrains.kotlinx.dataframe.columns.SingleColumn.cols]`(1, 3, 2) }`
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { `[colsOf][org.jetbrains.kotlinx.dataframe.api.ColumnsSelectionDsl.colsOf]`<`[Int][Int]`>()`[`[`][org.jetbrains.kotlinx.dataframe.columns.SingleColumn.get]`5, 1, 2`[`]`][org.jetbrains.kotlinx.dataframe.columns.SingleColumn.get]` }`
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { "myColumnGroup".`[cols][kotlin.String.cols]`(0, 2) }`
     *
     * #### Examples for this overload:
     *
     * `df.`[select][DataFrame.select]` { "pathTo"["myColGroup"].`[cols][ColumnPath.cols]`(0, 1) }`
     *
     * @throws [IndexOutOfBoundsException] If any index is out of bounds.
     * @param [firstIndex] The index of the first column to retrieve.
     * @param [otherIndices] The other indices of the columns to retrieve.
     * @return A [ColumnSet][org.jetbrains.kotlinx.dataframe.columns.ColumnSet] containing the columns found at the given indices.
     */
    private interface ColumnPathColsIndicesDocs

    /** ## Cols: Columns by Indices
     *
     * Retrieves multiple columns in the form of a [ColumnSet][org.jetbrains.kotlinx.dataframe.columns.ColumnSet] by their indices.
     * If any of the indices are out of bounds, an [IndexOutOfBoundsException] is thrown.
     *
     * If called on a [SingleColumn][org.jetbrains.kotlinx.dataframe.columns.SingleColumn], [ColumnGroup][org.jetbrains.kotlinx.dataframe.columns.ColumnGroup], or [DataFrame][org.jetbrains.kotlinx.dataframe.DataFrame], the function will take the columns found at the
     * given indices inside.
     * Else, if called on a normal [ColumnSet][org.jetbrains.kotlinx.dataframe.columns.ColumnSet], the function will return a new [ColumnSet][org.jetbrains.kotlinx.dataframe.columns.ColumnSet] with the columns found at
     * the given indices in the set.
     *
     * #### For example:
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { `[cols][org.jetbrains.kotlinx.dataframe.columns.SingleColumn.cols]`(1, 3, 2) }`
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { `[colsOf][org.jetbrains.kotlinx.dataframe.api.ColumnsSelectionDsl.colsOf]`<`[Int][Int]`>()`[`[`][org.jetbrains.kotlinx.dataframe.columns.SingleColumn.get]`5, 1, 2`[`]`][org.jetbrains.kotlinx.dataframe.columns.SingleColumn.get]` }`
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { "myColumnGroup".`[cols][kotlin.String.cols]`(0, 2) }`
     *
     * #### Examples for this overload:
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { "pathTo"["myColGroup"].`[cols][org.jetbrains.kotlinx.dataframe.columns.ColumnPath.cols]`(0, 1) }`
     *
     * @throws [IndexOutOfBoundsException] If any index is out of bounds.
     * @param [firstIndex] The index of the first column to retrieve.
     * @param [otherIndices] The other indices of the columns to retrieve.
     * @return A [ColumnSet][org.jetbrains.kotlinx.dataframe.columns.ColumnSet] containing the columns found at the given indices.
     */
    public fun ColumnPath.cols(
        firstIndex: Int,
        vararg otherIndices: Int,
    ): ColumnSet<*> = columnGroup(this).cols(firstIndex, *otherIndices)

    // endregion

    // region ranges

    /**
     * ## Cols: Columns by Index Range
     *
     * Retrieves multiple columns in the form of a [ColumnSet] by a [range\] of indices.
     * If any of the indices in the [range\] are out of bounds, an [IndexOutOfBoundsException] is thrown.
     *
     * If called on a [SingleColumn], [ColumnGroup], or [DataFrame], the function will take the columns found at the
     * given indices inside.
     * Else, if called on a normal [ColumnSet], the function will return a new [ColumnSet] with the columns found at
     * the given indices in the set.
     *
     * #### For example:
     *
     * `df.`[select][DataFrame.select]` { `[cols][SingleColumn.cols]`(1`[`..`][Int.rangeTo]`3) }`
     *
     * `df.`[select][DataFrame.select]` { `[colsOf][ColumnsSelectionDsl.colsOf]`<`[Int][Int]`>()`[`[`][ColumnSet.cols]`1`[`..`][Int.rangeTo]`5`[`]`][ColumnSet.cols]` }`
     *
     * `df.`[select][DataFrame.select]` { "myColGroup".`[cols][String.cols]`(0`[`..`][Int.rangeTo]`2) }`
     *
     * #### Examples for this overload:
     *
     * {@includeArg [CommonColsRangeDocs.ExampleArg]}
     *
     * @throws [IndexOutOfBoundsException\] if any of the indices in the [range\] are out of bounds.
     * @throws [IllegalArgumentException\] if the [range\] is empty.
     * @param [range\] The range of indices to retrieve in the form of an [IntRange].
     * @return A [ColumnSet] containing the columns found at the given indices.
     */
    private interface CommonColsRangeDocs {

        /** Example argument */
        interface ExampleArg
    }

    /**
     * ## Cols: Columns by Index Range
     *
     * Retrieves multiple columns in the form of a [ColumnSet][org.jetbrains.kotlinx.dataframe.columns.ColumnSet] by a [range] of indices.
     * If any of the indices in the [range] are out of bounds, an [IndexOutOfBoundsException] is thrown.
     *
     * If called on a [SingleColumn][org.jetbrains.kotlinx.dataframe.columns.SingleColumn], [ColumnGroup][org.jetbrains.kotlinx.dataframe.columns.ColumnGroup], or [DataFrame][org.jetbrains.kotlinx.dataframe.DataFrame], the function will take the columns found at the
     * given indices inside.
     * Else, if called on a normal [ColumnSet][org.jetbrains.kotlinx.dataframe.columns.ColumnSet], the function will return a new [ColumnSet][org.jetbrains.kotlinx.dataframe.columns.ColumnSet] with the columns found at
     * the given indices in the set.
     *
     * #### For example:
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { `[cols][org.jetbrains.kotlinx.dataframe.columns.SingleColumn.cols]`(1`[`..`][Int.rangeTo]`3) }`
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { `[colsOf][org.jetbrains.kotlinx.dataframe.api.ColumnsSelectionDsl.colsOf]`<`[Int][Int]`>()`[`[`][org.jetbrains.kotlinx.dataframe.columns.ColumnSet.cols]`1`[`..`][Int.rangeTo]`5`[`]`][org.jetbrains.kotlinx.dataframe.columns.ColumnSet.cols]` }`
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { "myColGroup".`[cols][kotlin.String.cols]`(0`[`..`][Int.rangeTo]`2) }`
     *
     * #### Examples for this overload:
     *
     * `df.`[select][DataFrame.select]` { `[colsOf][SingleColumn.colsOf]`<`[Int][Int]`>().`[cols][ColumnSet.cols]`(1`[..][Int.rangeTo]`3) }`
     *
     * `df.`[select][DataFrame.select]` { `[all][all]`()`[`[`][ColumnSet.cols]`1`[..][Int.rangeTo]`5`[`]`][ColumnSet.cols]` }`
     *
     * @throws [IndexOutOfBoundsException] if any of the indices in the [range] are out of bounds.
     * @throws [IllegalArgumentException] if the [range] is empty.
     * @param [range] The range of indices to retrieve in the form of an [IntRange].
     * @return A [ColumnSet][org.jetbrains.kotlinx.dataframe.columns.ColumnSet] containing the columns found at the given indices.
     */
    private interface ColumnSetColsRangeDocs

    /** ## Cols: Columns by Index Range
     *
     * Retrieves multiple columns in the form of a [ColumnSet][org.jetbrains.kotlinx.dataframe.columns.ColumnSet] by a [range] of indices.
     * If any of the indices in the [range] are out of bounds, an [IndexOutOfBoundsException] is thrown.
     *
     * If called on a [SingleColumn][org.jetbrains.kotlinx.dataframe.columns.SingleColumn], [ColumnGroup][org.jetbrains.kotlinx.dataframe.columns.ColumnGroup], or [DataFrame][org.jetbrains.kotlinx.dataframe.DataFrame], the function will take the columns found at the
     * given indices inside.
     * Else, if called on a normal [ColumnSet][org.jetbrains.kotlinx.dataframe.columns.ColumnSet], the function will return a new [ColumnSet][org.jetbrains.kotlinx.dataframe.columns.ColumnSet] with the columns found at
     * the given indices in the set.
     *
     * #### For example:
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { `[cols][org.jetbrains.kotlinx.dataframe.columns.SingleColumn.cols]`(1`[`..`][Int.rangeTo]`3) }`
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { `[colsOf][org.jetbrains.kotlinx.dataframe.api.ColumnsSelectionDsl.colsOf]`<`[Int][Int]`>()`[`[`][org.jetbrains.kotlinx.dataframe.columns.ColumnSet.cols]`1`[`..`][Int.rangeTo]`5`[`]`][org.jetbrains.kotlinx.dataframe.columns.ColumnSet.cols]` }`
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { "myColGroup".`[cols][kotlin.String.cols]`(0`[`..`][Int.rangeTo]`2) }`
     *
     * #### Examples for this overload:
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { `[colsOf][org.jetbrains.kotlinx.dataframe.columns.SingleColumn.colsOf]`<`[Int][Int]`>().`[cols][org.jetbrains.kotlinx.dataframe.columns.ColumnSet.cols]`(1`[..][Int.rangeTo]`3) }`
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { `[all][org.jetbrains.kotlinx.dataframe.api.all]`()`[`[`][org.jetbrains.kotlinx.dataframe.columns.ColumnSet.cols]`1`[..][Int.rangeTo]`5`[`]`][org.jetbrains.kotlinx.dataframe.columns.ColumnSet.cols]` }`
     *
     * @throws [IndexOutOfBoundsException] if any of the indices in the [range] are out of bounds.
     * @throws [IllegalArgumentException] if the [range] is empty.
     * @param [range] The range of indices to retrieve in the form of an [IntRange].
     * @return A [ColumnSet][org.jetbrains.kotlinx.dataframe.columns.ColumnSet] containing the columns found at the given indices.
     */
    @Suppress("UNCHECKED_CAST")
    public fun <C> ColumnSet<C>.cols(range: IntRange): ColumnSet<C> = colsInternal(range) as ColumnSet<C>

    /** ## Cols: Columns by Index Range
     *
     * Retrieves multiple columns in the form of a [ColumnSet][org.jetbrains.kotlinx.dataframe.columns.ColumnSet] by a [range] of indices.
     * If any of the indices in the [range] are out of bounds, an [IndexOutOfBoundsException] is thrown.
     *
     * If called on a [SingleColumn][org.jetbrains.kotlinx.dataframe.columns.SingleColumn], [ColumnGroup][org.jetbrains.kotlinx.dataframe.columns.ColumnGroup], or [DataFrame][org.jetbrains.kotlinx.dataframe.DataFrame], the function will take the columns found at the
     * given indices inside.
     * Else, if called on a normal [ColumnSet][org.jetbrains.kotlinx.dataframe.columns.ColumnSet], the function will return a new [ColumnSet][org.jetbrains.kotlinx.dataframe.columns.ColumnSet] with the columns found at
     * the given indices in the set.
     *
     * #### For example:
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { `[cols][org.jetbrains.kotlinx.dataframe.columns.SingleColumn.cols]`(1`[`..`][Int.rangeTo]`3) }`
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { `[colsOf][org.jetbrains.kotlinx.dataframe.api.ColumnsSelectionDsl.colsOf]`<`[Int][Int]`>()`[`[`][org.jetbrains.kotlinx.dataframe.columns.ColumnSet.cols]`1`[`..`][Int.rangeTo]`5`[`]`][org.jetbrains.kotlinx.dataframe.columns.ColumnSet.cols]` }`
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { "myColGroup".`[cols][kotlin.String.cols]`(0`[`..`][Int.rangeTo]`2) }`
     *
     * #### Examples for this overload:
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { `[colsOf][org.jetbrains.kotlinx.dataframe.columns.SingleColumn.colsOf]`<`[Int][Int]`>().`[cols][org.jetbrains.kotlinx.dataframe.columns.ColumnSet.cols]`(1`[..][Int.rangeTo]`3) }`
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { `[all][org.jetbrains.kotlinx.dataframe.api.all]`()`[`[`][org.jetbrains.kotlinx.dataframe.columns.ColumnSet.cols]`1`[..][Int.rangeTo]`5`[`]`][org.jetbrains.kotlinx.dataframe.columns.ColumnSet.cols]` }`
     *
     * @throws [IndexOutOfBoundsException] if any of the indices in the [range] are out of bounds.
     * @throws [IllegalArgumentException] if the [range] is empty.
     * @param [range] The range of indices to retrieve in the form of an [IntRange].
     * @return A [ColumnSet][org.jetbrains.kotlinx.dataframe.columns.ColumnSet] containing the columns found at the given indices.
     */
    public operator fun <C> ColumnSet<C>.get(range: IntRange): ColumnSet<C> = cols(range)

    /**
     * ## Cols: Columns by Index Range
     *
     * Retrieves multiple columns in the form of a [ColumnSet][org.jetbrains.kotlinx.dataframe.columns.ColumnSet] by a [range] of indices.
     * If any of the indices in the [range] are out of bounds, an [IndexOutOfBoundsException] is thrown.
     *
     * If called on a [SingleColumn][org.jetbrains.kotlinx.dataframe.columns.SingleColumn], [ColumnGroup][org.jetbrains.kotlinx.dataframe.columns.ColumnGroup], or [DataFrame][org.jetbrains.kotlinx.dataframe.DataFrame], the function will take the columns found at the
     * given indices inside.
     * Else, if called on a normal [ColumnSet][org.jetbrains.kotlinx.dataframe.columns.ColumnSet], the function will return a new [ColumnSet][org.jetbrains.kotlinx.dataframe.columns.ColumnSet] with the columns found at
     * the given indices in the set.
     *
     * #### For example:
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { `[cols][org.jetbrains.kotlinx.dataframe.columns.SingleColumn.cols]`(1`[`..`][Int.rangeTo]`3) }`
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { `[colsOf][org.jetbrains.kotlinx.dataframe.api.ColumnsSelectionDsl.colsOf]`<`[Int][Int]`>()`[`[`][org.jetbrains.kotlinx.dataframe.columns.ColumnSet.cols]`1`[`..`][Int.rangeTo]`5`[`]`][org.jetbrains.kotlinx.dataframe.columns.ColumnSet.cols]` }`
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { "myColGroup".`[cols][kotlin.String.cols]`(0`[`..`][Int.rangeTo]`2) }`
     *
     * #### Examples for this overload:
     *
     * `df.`[select][DataFrame.select]` { `[cols][ColumnsSelectionDsl.cols]`(1`[..][Int.rangeTo]`3) }`
     *
     * @throws [IndexOutOfBoundsException] if any of the indices in the [range] are out of bounds.
     * @throws [IllegalArgumentException] if the [range] is empty.
     * @param [range] The range of indices to retrieve in the form of an [IntRange].
     * @return A [ColumnSet][org.jetbrains.kotlinx.dataframe.columns.ColumnSet] containing the columns found at the given indices.
     */
    private interface ColumnsSelectionDslColsRangeDocs

    /** ## Cols: Columns by Index Range
     *
     * Retrieves multiple columns in the form of a [ColumnSet][org.jetbrains.kotlinx.dataframe.columns.ColumnSet] by a [range] of indices.
     * If any of the indices in the [range] are out of bounds, an [IndexOutOfBoundsException] is thrown.
     *
     * If called on a [SingleColumn][org.jetbrains.kotlinx.dataframe.columns.SingleColumn], [ColumnGroup][org.jetbrains.kotlinx.dataframe.columns.ColumnGroup], or [DataFrame][org.jetbrains.kotlinx.dataframe.DataFrame], the function will take the columns found at the
     * given indices inside.
     * Else, if called on a normal [ColumnSet][org.jetbrains.kotlinx.dataframe.columns.ColumnSet], the function will return a new [ColumnSet][org.jetbrains.kotlinx.dataframe.columns.ColumnSet] with the columns found at
     * the given indices in the set.
     *
     * #### For example:
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { `[cols][org.jetbrains.kotlinx.dataframe.columns.SingleColumn.cols]`(1`[`..`][Int.rangeTo]`3) }`
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { `[colsOf][org.jetbrains.kotlinx.dataframe.api.ColumnsSelectionDsl.colsOf]`<`[Int][Int]`>()`[`[`][org.jetbrains.kotlinx.dataframe.columns.ColumnSet.cols]`1`[`..`][Int.rangeTo]`5`[`]`][org.jetbrains.kotlinx.dataframe.columns.ColumnSet.cols]` }`
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { "myColGroup".`[cols][kotlin.String.cols]`(0`[`..`][Int.rangeTo]`2) }`
     *
     * #### Examples for this overload:
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { `[cols][org.jetbrains.kotlinx.dataframe.api.ColumnsSelectionDsl.cols]`(1`[..][Int.rangeTo]`3) }`
     *
     * @throws [IndexOutOfBoundsException] if any of the indices in the [range] are out of bounds.
     * @throws [IllegalArgumentException] if the [range] is empty.
     * @param [range] The range of indices to retrieve in the form of an [IntRange].
     * @return A [ColumnSet][org.jetbrains.kotlinx.dataframe.columns.ColumnSet] containing the columns found at the given indices.
     */
    public fun ColumnsSelectionDsl<*>.cols(range: IntRange): ColumnSet<*> = this.asSingleColumn().colsInternal(range)

    /**
     * ## Cols: Columns by Index Range
     *
     * Retrieves multiple columns in the form of a [ColumnSet][org.jetbrains.kotlinx.dataframe.columns.ColumnSet] by a [range] of indices.
     * If any of the indices in the [range] are out of bounds, an [IndexOutOfBoundsException] is thrown.
     *
     * If called on a [SingleColumn][org.jetbrains.kotlinx.dataframe.columns.SingleColumn], [ColumnGroup][org.jetbrains.kotlinx.dataframe.columns.ColumnGroup], or [DataFrame][org.jetbrains.kotlinx.dataframe.DataFrame], the function will take the columns found at the
     * given indices inside.
     * Else, if called on a normal [ColumnSet][org.jetbrains.kotlinx.dataframe.columns.ColumnSet], the function will return a new [ColumnSet][org.jetbrains.kotlinx.dataframe.columns.ColumnSet] with the columns found at
     * the given indices in the set.
     *
     * #### For example:
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { `[cols][org.jetbrains.kotlinx.dataframe.columns.SingleColumn.cols]`(1`[`..`][Int.rangeTo]`3) }`
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { `[colsOf][org.jetbrains.kotlinx.dataframe.api.ColumnsSelectionDsl.colsOf]`<`[Int][Int]`>()`[`[`][org.jetbrains.kotlinx.dataframe.columns.ColumnSet.cols]`1`[`..`][Int.rangeTo]`5`[`]`][org.jetbrains.kotlinx.dataframe.columns.ColumnSet.cols]` }`
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { "myColGroup".`[cols][kotlin.String.cols]`(0`[`..`][Int.rangeTo]`2) }`
     *
     * #### Examples for this overload:
     *
     * `df.`[select][DataFrame.select]` { myColumnGroup.`[cols][SingleColumn.cols]`(1`[..][Int.rangeTo]`3) }`
     *
     * @throws [IndexOutOfBoundsException] if any of the indices in the [range] are out of bounds.
     * @throws [IllegalArgumentException] if the [range] is empty.
     * @param [range] The range of indices to retrieve in the form of an [IntRange].
     * @return A [ColumnSet][org.jetbrains.kotlinx.dataframe.columns.ColumnSet] containing the columns found at the given indices.
     */
    private interface SingleColumnColsRangeDocs

    /** ## Cols: Columns by Index Range
     *
     * Retrieves multiple columns in the form of a [ColumnSet][org.jetbrains.kotlinx.dataframe.columns.ColumnSet] by a [range] of indices.
     * If any of the indices in the [range] are out of bounds, an [IndexOutOfBoundsException] is thrown.
     *
     * If called on a [SingleColumn][org.jetbrains.kotlinx.dataframe.columns.SingleColumn], [ColumnGroup][org.jetbrains.kotlinx.dataframe.columns.ColumnGroup], or [DataFrame][org.jetbrains.kotlinx.dataframe.DataFrame], the function will take the columns found at the
     * given indices inside.
     * Else, if called on a normal [ColumnSet][org.jetbrains.kotlinx.dataframe.columns.ColumnSet], the function will return a new [ColumnSet][org.jetbrains.kotlinx.dataframe.columns.ColumnSet] with the columns found at
     * the given indices in the set.
     *
     * #### For example:
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { `[cols][org.jetbrains.kotlinx.dataframe.columns.SingleColumn.cols]`(1`[`..`][Int.rangeTo]`3) }`
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { `[colsOf][org.jetbrains.kotlinx.dataframe.api.ColumnsSelectionDsl.colsOf]`<`[Int][Int]`>()`[`[`][org.jetbrains.kotlinx.dataframe.columns.ColumnSet.cols]`1`[`..`][Int.rangeTo]`5`[`]`][org.jetbrains.kotlinx.dataframe.columns.ColumnSet.cols]` }`
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { "myColGroup".`[cols][kotlin.String.cols]`(0`[`..`][Int.rangeTo]`2) }`
     *
     * #### Examples for this overload:
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { myColumnGroup.`[cols][org.jetbrains.kotlinx.dataframe.columns.SingleColumn.cols]`(1`[..][Int.rangeTo]`3) }`
     *
     * @throws [IndexOutOfBoundsException] if any of the indices in the [range] are out of bounds.
     * @throws [IllegalArgumentException] if the [range] is empty.
     * @param [range] The range of indices to retrieve in the form of an [IntRange].
     * @return A [ColumnSet][org.jetbrains.kotlinx.dataframe.columns.ColumnSet] containing the columns found at the given indices.
     */
    public fun SingleColumn<DataRow<*>>.cols(range: IntRange): ColumnSet<*> = ensureIsColGroup().colsInternal(range)

    /**
     * ## Cols: Columns by Index Range
     *
     * Retrieves multiple columns in the form of a [ColumnSet][org.jetbrains.kotlinx.dataframe.columns.ColumnSet] by a [range] of indices.
     * If any of the indices in the [range] are out of bounds, an [IndexOutOfBoundsException] is thrown.
     *
     * If called on a [SingleColumn][org.jetbrains.kotlinx.dataframe.columns.SingleColumn], [ColumnGroup][org.jetbrains.kotlinx.dataframe.columns.ColumnGroup], or [DataFrame][org.jetbrains.kotlinx.dataframe.DataFrame], the function will take the columns found at the
     * given indices inside.
     * Else, if called on a normal [ColumnSet][org.jetbrains.kotlinx.dataframe.columns.ColumnSet], the function will return a new [ColumnSet][org.jetbrains.kotlinx.dataframe.columns.ColumnSet] with the columns found at
     * the given indices in the set.
     *
     * #### For example:
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { `[cols][org.jetbrains.kotlinx.dataframe.columns.SingleColumn.cols]`(1`[`..`][Int.rangeTo]`3) }`
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { `[colsOf][org.jetbrains.kotlinx.dataframe.api.ColumnsSelectionDsl.colsOf]`<`[Int][Int]`>()`[`[`][org.jetbrains.kotlinx.dataframe.columns.ColumnSet.cols]`1`[`..`][Int.rangeTo]`5`[`]`][org.jetbrains.kotlinx.dataframe.columns.ColumnSet.cols]` }`
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { "myColGroup".`[cols][kotlin.String.cols]`(0`[`..`][Int.rangeTo]`2) }`
     *
     * #### Examples for this overload:
     *
     * `df.`[select][DataFrame.select]` { "myColGroup".`[cols][String.cols]`(1`[`..`][Int.rangeTo]`3) }`
     *
     * @throws [IndexOutOfBoundsException] if any of the indices in the [range] are out of bounds.
     * @throws [IllegalArgumentException] if the [range] is empty.
     * @param [range] The range of indices to retrieve in the form of an [IntRange].
     * @return A [ColumnSet][org.jetbrains.kotlinx.dataframe.columns.ColumnSet] containing the columns found at the given indices.
     */
    private interface StringColsRangeDocs

    /** ## Cols: Columns by Index Range
     *
     * Retrieves multiple columns in the form of a [ColumnSet][org.jetbrains.kotlinx.dataframe.columns.ColumnSet] by a [range] of indices.
     * If any of the indices in the [range] are out of bounds, an [IndexOutOfBoundsException] is thrown.
     *
     * If called on a [SingleColumn][org.jetbrains.kotlinx.dataframe.columns.SingleColumn], [ColumnGroup][org.jetbrains.kotlinx.dataframe.columns.ColumnGroup], or [DataFrame][org.jetbrains.kotlinx.dataframe.DataFrame], the function will take the columns found at the
     * given indices inside.
     * Else, if called on a normal [ColumnSet][org.jetbrains.kotlinx.dataframe.columns.ColumnSet], the function will return a new [ColumnSet][org.jetbrains.kotlinx.dataframe.columns.ColumnSet] with the columns found at
     * the given indices in the set.
     *
     * #### For example:
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { `[cols][org.jetbrains.kotlinx.dataframe.columns.SingleColumn.cols]`(1`[`..`][Int.rangeTo]`3) }`
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { `[colsOf][org.jetbrains.kotlinx.dataframe.api.ColumnsSelectionDsl.colsOf]`<`[Int][Int]`>()`[`[`][org.jetbrains.kotlinx.dataframe.columns.ColumnSet.cols]`1`[`..`][Int.rangeTo]`5`[`]`][org.jetbrains.kotlinx.dataframe.columns.ColumnSet.cols]` }`
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { "myColGroup".`[cols][kotlin.String.cols]`(0`[`..`][Int.rangeTo]`2) }`
     *
     * #### Examples for this overload:
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { "myColGroup".`[cols][kotlin.String.cols]`(1`[`..`][Int.rangeTo]`3) }`
     *
     * @throws [IndexOutOfBoundsException] if any of the indices in the [range] are out of bounds.
     * @throws [IllegalArgumentException] if the [range] is empty.
     * @param [range] The range of indices to retrieve in the form of an [IntRange].
     * @return A [ColumnSet][org.jetbrains.kotlinx.dataframe.columns.ColumnSet] containing the columns found at the given indices.
     */
    public fun String.cols(range: IntRange): ColumnSet<*> = columnGroup(this).cols(range)

    /**
     * ## Cols: Columns by Index Range
     *
     * Retrieves multiple columns in the form of a [ColumnSet][org.jetbrains.kotlinx.dataframe.columns.ColumnSet] by a [range] of indices.
     * If any of the indices in the [range] are out of bounds, an [IndexOutOfBoundsException] is thrown.
     *
     * If called on a [SingleColumn][org.jetbrains.kotlinx.dataframe.columns.SingleColumn], [ColumnGroup][org.jetbrains.kotlinx.dataframe.columns.ColumnGroup], or [DataFrame][org.jetbrains.kotlinx.dataframe.DataFrame], the function will take the columns found at the
     * given indices inside.
     * Else, if called on a normal [ColumnSet][org.jetbrains.kotlinx.dataframe.columns.ColumnSet], the function will return a new [ColumnSet][org.jetbrains.kotlinx.dataframe.columns.ColumnSet] with the columns found at
     * the given indices in the set.
     *
     * #### For example:
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { `[cols][org.jetbrains.kotlinx.dataframe.columns.SingleColumn.cols]`(1`[`..`][Int.rangeTo]`3) }`
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { `[colsOf][org.jetbrains.kotlinx.dataframe.api.ColumnsSelectionDsl.colsOf]`<`[Int][Int]`>()`[`[`][org.jetbrains.kotlinx.dataframe.columns.ColumnSet.cols]`1`[`..`][Int.rangeTo]`5`[`]`][org.jetbrains.kotlinx.dataframe.columns.ColumnSet.cols]` }`
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { "myColGroup".`[cols][kotlin.String.cols]`(0`[`..`][Int.rangeTo]`2) }`
     *
     * #### Examples for this overload:
     *
     * `df.`[select][DataFrame.select]` { Type::myColumnGroup.`[cols][SingleColumn.cols]`(1`[`..`][Int.rangeTo]`3) }`
     *
     *
     * @throws [IndexOutOfBoundsException] if any of the indices in the [range] are out of bounds.
     * @throws [IllegalArgumentException] if the [range] is empty.
     * @param [range] The range of indices to retrieve in the form of an [IntRange].
     * @return A [ColumnSet][org.jetbrains.kotlinx.dataframe.columns.ColumnSet] containing the columns found at the given indices.
     */
    private interface KPropertyColsRangeDocs

    /** ## Cols: Columns by Index Range
     *
     * Retrieves multiple columns in the form of a [ColumnSet][org.jetbrains.kotlinx.dataframe.columns.ColumnSet] by a [range] of indices.
     * If any of the indices in the [range] are out of bounds, an [IndexOutOfBoundsException] is thrown.
     *
     * If called on a [SingleColumn][org.jetbrains.kotlinx.dataframe.columns.SingleColumn], [ColumnGroup][org.jetbrains.kotlinx.dataframe.columns.ColumnGroup], or [DataFrame][org.jetbrains.kotlinx.dataframe.DataFrame], the function will take the columns found at the
     * given indices inside.
     * Else, if called on a normal [ColumnSet][org.jetbrains.kotlinx.dataframe.columns.ColumnSet], the function will return a new [ColumnSet][org.jetbrains.kotlinx.dataframe.columns.ColumnSet] with the columns found at
     * the given indices in the set.
     *
     * #### For example:
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { `[cols][org.jetbrains.kotlinx.dataframe.columns.SingleColumn.cols]`(1`[`..`][Int.rangeTo]`3) }`
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { `[colsOf][org.jetbrains.kotlinx.dataframe.api.ColumnsSelectionDsl.colsOf]`<`[Int][Int]`>()`[`[`][org.jetbrains.kotlinx.dataframe.columns.ColumnSet.cols]`1`[`..`][Int.rangeTo]`5`[`]`][org.jetbrains.kotlinx.dataframe.columns.ColumnSet.cols]` }`
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { "myColGroup".`[cols][kotlin.String.cols]`(0`[`..`][Int.rangeTo]`2) }`
     *
     * #### Examples for this overload:
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { Type::myColumnGroup.`[cols][org.jetbrains.kotlinx.dataframe.columns.SingleColumn.cols]`(1`[`..`][Int.rangeTo]`3) }`
     *
     * @throws [IndexOutOfBoundsException] if any of the indices in the [range] are out of bounds.
     * @throws [IllegalArgumentException] if the [range] is empty.
     * @param [range] The range of indices to retrieve in the form of an [IntRange].
     * @return A [ColumnSet][org.jetbrains.kotlinx.dataframe.columns.ColumnSet] containing the columns found at the given indices.
     */
    public fun KProperty<*>.cols(range: IntRange): ColumnSet<*> = columnGroup(this).cols(range)

    /**
     * ## Cols: Columns by Index Range
     *
     * Retrieves multiple columns in the form of a [ColumnSet][org.jetbrains.kotlinx.dataframe.columns.ColumnSet] by a [range] of indices.
     * If any of the indices in the [range] are out of bounds, an [IndexOutOfBoundsException] is thrown.
     *
     * If called on a [SingleColumn][org.jetbrains.kotlinx.dataframe.columns.SingleColumn], [ColumnGroup][org.jetbrains.kotlinx.dataframe.columns.ColumnGroup], or [DataFrame][org.jetbrains.kotlinx.dataframe.DataFrame], the function will take the columns found at the
     * given indices inside.
     * Else, if called on a normal [ColumnSet][org.jetbrains.kotlinx.dataframe.columns.ColumnSet], the function will return a new [ColumnSet][org.jetbrains.kotlinx.dataframe.columns.ColumnSet] with the columns found at
     * the given indices in the set.
     *
     * #### For example:
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { `[cols][org.jetbrains.kotlinx.dataframe.columns.SingleColumn.cols]`(1`[`..`][Int.rangeTo]`3) }`
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { `[colsOf][org.jetbrains.kotlinx.dataframe.api.ColumnsSelectionDsl.colsOf]`<`[Int][Int]`>()`[`[`][org.jetbrains.kotlinx.dataframe.columns.ColumnSet.cols]`1`[`..`][Int.rangeTo]`5`[`]`][org.jetbrains.kotlinx.dataframe.columns.ColumnSet.cols]` }`
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { "myColGroup".`[cols][kotlin.String.cols]`(0`[`..`][Int.rangeTo]`2) }`
     *
     * #### Examples for this overload:
     *
     * `df.`[select][DataFrame.select]` { "pathTo"["myColGroup"].`[cols][ColumnPath.cols]`(0`[..][Int.rangeTo]`1) }`
     *
     * @throws [IndexOutOfBoundsException] if any of the indices in the [range] are out of bounds.
     * @throws [IllegalArgumentException] if the [range] is empty.
     * @param [range] The range of indices to retrieve in the form of an [IntRange].
     * @return A [ColumnSet][org.jetbrains.kotlinx.dataframe.columns.ColumnSet] containing the columns found at the given indices.
     */
    private interface ColumnPathColsRangeDocs

    /** ## Cols: Columns by Index Range
     *
     * Retrieves multiple columns in the form of a [ColumnSet][org.jetbrains.kotlinx.dataframe.columns.ColumnSet] by a [range] of indices.
     * If any of the indices in the [range] are out of bounds, an [IndexOutOfBoundsException] is thrown.
     *
     * If called on a [SingleColumn][org.jetbrains.kotlinx.dataframe.columns.SingleColumn], [ColumnGroup][org.jetbrains.kotlinx.dataframe.columns.ColumnGroup], or [DataFrame][org.jetbrains.kotlinx.dataframe.DataFrame], the function will take the columns found at the
     * given indices inside.
     * Else, if called on a normal [ColumnSet][org.jetbrains.kotlinx.dataframe.columns.ColumnSet], the function will return a new [ColumnSet][org.jetbrains.kotlinx.dataframe.columns.ColumnSet] with the columns found at
     * the given indices in the set.
     *
     * #### For example:
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { `[cols][org.jetbrains.kotlinx.dataframe.columns.SingleColumn.cols]`(1`[`..`][Int.rangeTo]`3) }`
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { `[colsOf][org.jetbrains.kotlinx.dataframe.api.ColumnsSelectionDsl.colsOf]`<`[Int][Int]`>()`[`[`][org.jetbrains.kotlinx.dataframe.columns.ColumnSet.cols]`1`[`..`][Int.rangeTo]`5`[`]`][org.jetbrains.kotlinx.dataframe.columns.ColumnSet.cols]` }`
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { "myColGroup".`[cols][kotlin.String.cols]`(0`[`..`][Int.rangeTo]`2) }`
     *
     * #### Examples for this overload:
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { "pathTo"["myColGroup"].`[cols][org.jetbrains.kotlinx.dataframe.columns.ColumnPath.cols]`(0`[..][Int.rangeTo]`1) }`
     *
     * @throws [IndexOutOfBoundsException] if any of the indices in the [range] are out of bounds.
     * @throws [IllegalArgumentException] if the [range] is empty.
     * @param [range] The range of indices to retrieve in the form of an [IntRange].
     * @return A [ColumnSet][org.jetbrains.kotlinx.dataframe.columns.ColumnSet] containing the columns found at the given indices.
     */
    public fun ColumnPath.cols(range: IntRange): ColumnSet<*> = columnGroup(this).cols(range)

    /**
     * ## Columns by Index Range from List of Columns
     * Helper function to create a [ColumnSet] from a list of columns by specifying a range of indices.
     *
     *
     */
    public operator fun <C> List<DataColumn<C>>.get(range: IntRange): ColumnSet<C> =
        ColumnsList(subList(range.first, range.last + 1))

    // endregion
}

/**
 * If this [ColumnsResolver] is a [SingleColumn], it
 * returns a new [ColumnSet] containing the columns inside of this [SingleColumn] that
 * match the given [predicate].
 *
 * Else, it returns a new [ColumnSet] containing all columns in this [ColumnsResolver] that
 * match the given [predicate].
 */
internal fun ColumnsResolver<*>.colsInternal(predicate: ColumnFilter<*>): TransformableColumnSet<*> =
    allColumnsInternal().transform { it.filter(predicate) }

internal fun ColumnsResolver<*>.colsInternal(indices: IntArray): TransformableColumnSet<*> =
    allColumnsInternal().transform { cols ->
        indices.map {
            try {
                cols[it]
            } catch (e: IndexOutOfBoundsException) {
                throw IndexOutOfBoundsException("Index $it is out of bounds for column set of size ${cols.size}")
            }
        }
    }

internal fun ColumnsResolver<*>.colsInternal(range: IntRange): TransformableColumnSet<*> =
    allColumnsInternal().transform {
        try {
            it.subList(range.first, range.last + 1)
        } catch (e: IndexOutOfBoundsException) {
            throw IndexOutOfBoundsException("Range $range is out of bounds for column set of size ${it.size}")
        }
    }
