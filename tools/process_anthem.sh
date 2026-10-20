#!/usr/bin/env bash
# Optional compatibility shortcut. Windows users run process_anthem.py directly.
set -euo pipefail
exec python3 "$(dirname "$0")/process_anthem.py" "$@"
