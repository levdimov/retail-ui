import { toKebabCase } from '../../lib/toKebabCase';
import type { Nullable } from '../../typings/utility-types';

export type VisualStateDataAttributesResultType = Record<string, string>;

const prefix = `data-visual-state-`;

function fillResult(result: VisualStateDataAttributesResultType, key: string, value: unknown) {
  if (value !== null && value !== undefined) {
    result[`${prefix}${toKebabCase(key)}`] = String(value);
  }

  return result;
}

export function getVisualStateDataAttributes<T extends Record<string, Nullable<boolean>>>(
  attributes: T,
): VisualStateDataAttributesResultType {
  return Object.entries(attributes).reduce(
    (previousValue, currentValue) => fillResult(previousValue, currentValue[0], currentValue[1]),
    {},
  );
}